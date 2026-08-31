package prep.etl;

public record Transaction(
        String id,
        String idempotencyKey,
        String merchant,
        String category,
        long amountMinorUnits,
        String currency,
        long timestampEpochSeconds
) {
}
