# Practice: Fix the Broken Test

This simulates the format one Reap candidate described: you're handed working code plus a test
suite, and one test encodes an assumption that's inconsistent with the spec below. Your job is to
find it and fix it correctly — which might mean fixing the test, but don't assume that in advance;
reason from the spec each time.

## Spec: transaction fee calculator

Processing fee for a card transaction, given the amount in cents:
- Base fee: 2.9% of the transaction amount, rounded to the nearest cent (round-half-up).
- Plus a fixed fee of 30 cents per transaction.
- The total (percentage + fixed) is then capped at a maximum of 1000 cents ($10.00) — if the computed
  fee exceeds the cap, charge exactly the cap.
- The total has a minimum of 50 cents — if the computed fee (before the cap check) is less than
  50 cents, charge exactly 50 cents.
- Amounts are always positive cents (`long`). You don't need to validate input.

## What to do

1. Run the tests in `FeeCalculatorTest`.
2. At least one test does not match the spec above. Read the spec carefully — treat it as the fixed,
   correct reference. Find the test (or tests) that disagree with it.
3. Decide: is the test wrong (spec was misread when the test was written), or is
   `FeeCalculator.java` wrong (a real bug that the test correctly caught)? Fix whichever is actually
   wrong so that all tests pass **and** the implementation matches the spec above.
4. Be ready to explain your reasoning out loud — that's the part actually being evaluated, not just
   getting to green.

Time-box: 30-40 minutes. Don't ask for the answer until you've formed your own hypothesis and either
fixed it or gotten stuck for a while — say what you tried first.
