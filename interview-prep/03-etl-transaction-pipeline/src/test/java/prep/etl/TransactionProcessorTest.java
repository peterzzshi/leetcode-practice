package prep.etl;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TransactionProcessorTest {

    private final TransactionProcessor processor = new TransactionProcessor();

    private long epoch(int year, int month, int day) {
        return OffsetDateTime.of(year, month, day, 12, 0, 0, 0, ZoneOffset.UTC).toEpochSecond();
    }

    @Test
    void dedupeKeepsFirstOccurrenceOfEachIdempotencyKey() {
        List<Transaction> raw = List.of(
                new Transaction("t1", "key-a", "Amazon", "shopping", 1000, "USD", epoch(2026, 1, 5)),
                new Transaction("t2", "key-a", "Amazon", "shopping", 1000, "USD", epoch(2026, 1, 5)), // retry
                new Transaction("t3", "key-b", "Starbucks", "food", 500, "USD", epoch(2026, 1, 6))
        );

        List<Transaction> result = processor.dedupe(raw);

        assertEquals(2, result.size());
        assertEquals("t1", result.get(0).id());
        assertEquals("t3", result.get(1).id());
    }

    @Test
    void toUsdCentsConvertsAndRounds() {
        Transaction t = new Transaction("t1", "key-a", "Merchant", "misc", 10_000, "HKD", epoch(2026, 1, 1));
        Map<String, Double> rates = Map.of("HKD", 0.128, "USD", 1.0);

        // 10000 HKD-cents * 0.128 = 1280 USD-cents
        assertEquals(1280, processor.toUsdCents(t, rates));
    }

    @Test
    void toUsdCentsThrowsForMissingRate() {
        Transaction t = new Transaction("t1", "key-a", "Merchant", "misc", 1000, "EUR", epoch(2026, 1, 1));
        Map<String, Double> rates = Map.of("USD", 1.0);

        assertThrows(IllegalArgumentException.class, () -> processor.toUsdCents(t, rates));
    }

    @Test
    void totalSpendByCategorySumsAcrossMerchantsAfterDedupe() {
        List<Transaction> transactions = List.of(
                new Transaction("t1", "key-a", "Amazon", "shopping", 1000, "USD", epoch(2026, 1, 5)),
                new Transaction("t2", "key-a", "Amazon", "shopping", 1000, "USD", epoch(2026, 1, 5)), // retry
                new Transaction("t3", "key-b", "Walmart", "shopping", 500, "USD", epoch(2026, 1, 6)),
                new Transaction("t4", "key-c", "Starbucks", "food", 300, "USD", epoch(2026, 1, 7))
        );
        Map<String, Double> rates = Map.of("USD", 1.0);

        Map<String, Long> result = processor.totalSpendByCategory(transactions, rates);

        assertEquals(1500L, result.get("shopping"));
        assertEquals(300L, result.get("food"));
        assertEquals(2, result.size());
    }

    @Test
    void totalSpendByMerchantForMonthFiltersToThatMonthOnly() {
        List<Transaction> transactions = List.of(
                new Transaction("t1", "key-a", "Amazon", "shopping", 1000, "USD", epoch(2026, 1, 15)),
                new Transaction("t2", "key-b", "Amazon", "shopping", 2000, "USD", epoch(2026, 2, 1)), // different month
                new Transaction("t3", "key-c", "Amazon", "shopping", 500, "USD", epoch(2026, 1, 20))
        );
        Map<String, Double> rates = Map.of("USD", 1.0);

        Map<String, Long> result = processor.totalSpendByMerchantForMonth(transactions, rates, 2026, 1);

        assertEquals(1500L, result.get("Amazon"));
        assertEquals(1, result.size());
    }
}
