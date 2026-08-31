# Practice: ETL — Transaction Pipeline

Simulates a data-processing/ETL round. Time-box: 45 minutes.

## Input

A `Transaction` (already implemented, don't modify) with fields: `id`, `idempotencyKey`, `merchant`,
`category`, `amountMinorUnits` (e.g. cents), `currency` (`"USD"`, `"HKD"`, `"EUR"`, ...),
`timestampEpochSeconds`.

## Requirements

Implement `TransactionProcessor`:

1. `dedupe(raw)` — some transactions in the raw feed are retries sharing the same `idempotencyKey`.
   Keep only the first occurrence (by original order), drop the rest.
2. `toUsdCents(t, ratesToUsd)` — convert `amountMinorUnits` to USD cents using
   `ratesToUsd.get(currency)` (rate = value of 1 unit of that currency in USD). Round to the nearest
   cent. Reject (throw) if there's no rate for the currency.
3. `totalSpendByCategory(transactions, ratesToUsd)` — after deduping, sum `toUsdCents` per category.
   A category key should only appear in the result if at least one transaction has that category.
4. `totalSpendByMerchantForMonth(transactions, ratesToUsd, year, month)` — same idea, grouped by
   merchant, filtered to a single calendar month (UTC), deduped first.

## What's provided

- `Transaction.java` — complete record, don't modify.
- `TransactionProcessor.java` — skeleton, all methods throw `UnsupportedOperationException`.
