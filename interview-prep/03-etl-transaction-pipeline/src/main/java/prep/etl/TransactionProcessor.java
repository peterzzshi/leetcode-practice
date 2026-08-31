package prep.etl;

import java.util.List;
import java.util.Map;

public class TransactionProcessor {

    public List<Transaction> dedupe(List<Transaction> raw) {
        throw new UnsupportedOperationException("TODO");
    }

    public long toUsdCents(Transaction t, Map<String, Double> ratesToUsd) {
        throw new UnsupportedOperationException("TODO");
    }

    public Map<String, Long> totalSpendByCategory(List<Transaction> transactions, Map<String, Double> ratesToUsd) {
        throw new UnsupportedOperationException("TODO");
    }

    public Map<String, Long> totalSpendByMerchantForMonth(
            List<Transaction> transactions, Map<String, Double> ratesToUsd, int year, int month) {
        throw new UnsupportedOperationException("TODO");
    }
}
