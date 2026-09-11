package prep.etl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionProcessor {

    public List<Transaction> dedupe(final List<Transaction> rawTransactions) {

        final Map<String, Transaction> transactionMap = new HashMap<>();
        for (final Transaction transaction : rawTransactions) {
            if (!transactionMap.containsKey(transaction.idempotencyKey())) {
                transactionMap.put(transaction.idempotencyKey(), transaction);
            } else {
                final Transaction existingTransaction = transactionMap.get(transaction.idempotencyKey());

                if (transaction.timestampEpochSeconds() < existingTransaction.timestampEpochSeconds()) {
                    transactionMap.put(transaction.idempotencyKey(), transaction);
                }
            }

        }

        return transactionMap.values().stream().toList();

    }

    public long toUsdCents(final Transaction t, final Map<String, Double> ratesToUsd) {

        if (!ratesToUsd.containsKey(t.currency())) {
            throw new IllegalArgumentException("Missing rate for currency " + t.currency());
        }

        return (long) (ratesToUsd.get(t.currency()) * t.amountMinorUnits());

    }

    public Map<String, Long> totalSpendByCategory(final List<Transaction> transactions, final Map<String, Double> ratesToUsd) {

        final List<Transaction> distinctTransactions = this.dedupe(transactions);

        final Map<String, Long> result = new HashMap<>();
        for (final Transaction distinctTransaction : distinctTransactions) {
            if (!result.containsKey(distinctTransaction.category())) {
                result.put(distinctTransaction.category(), this.toUsdCents(distinctTransaction, ratesToUsd));
            } else {
                result.put(distinctTransaction.category(), result.get(distinctTransaction.category()) + this.toUsdCents(distinctTransaction, ratesToUsd));
            }
        }

        return result;
    }

    public Map<String, Long> totalSpendByMerchantForMonth(
            final List<Transaction> transactions, final Map<String, Double> ratesToUsd, final int year, final int month) {

        final Map<String, Long> result = new HashMap<>();


        for (final Transaction transaction : transactions) {
            final LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(transaction.timestampEpochSeconds()), ZoneId.systemDefault());
            if (localDateTime.getYear() == year && localDateTime.getMonthValue() == month) {
                if (!result.containsKey(transaction.merchant())) {
                    result.put(transaction.merchant(), this.toUsdCents(transaction, ratesToUsd));
                } else {
                    result.put(transaction.merchant(), result.get(transaction.merchant()) + this.toUsdCents(transaction, ratesToUsd));
                }
            }
        }

        return result;
    }
}
