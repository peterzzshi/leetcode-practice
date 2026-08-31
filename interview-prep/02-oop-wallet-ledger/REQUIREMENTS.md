# Practice: OOP Design — Wallet Ledger

Simulates an OOP-modeling round (design and implement a small payments component). Time-box: 60 minutes.

## Requirements

Design and implement an in-memory ledger that supports multiple accounts.

1. `openAccount(accountId, initialBalanceCents)` — creates a new account. Reject (throw) if the account
   already exists, or if `initialBalanceCents` is negative.
2. `deposit(accountId, amountCents)` — increases the balance. Reject if `amountCents <= 0`, or if the
   account doesn't exist.
3. `withdraw(accountId, amountCents)` — decreases the balance. Reject with a dedicated
   "insufficient funds" error if the withdrawal would make the balance negative. Reject if
   `amountCents <= 0`.
4. `transfer(fromAccountId, toAccountId, amountCents, idempotencyKey)` — moves money from one account
   to another as a single atomic operation: if either account is missing, or the sender has
   insufficient funds, **neither** balance changes.
   - **Idempotency**: calling `transfer` again with an `idempotencyKey` that was already used for a
     *successful* transfer must be a no-op — it must not move the money a second time.
5. `getBalance(accountId)` — returns the current balance in cents.
6. `getHistory(accountId)` — returns the list of entries affecting that account, oldest first.

Money is represented in integer cents (not floating point) to avoid rounding bugs — don't introduce
`double`/decimal arithmetic into the core balance logic.

You don't need to validate currency or handle multiple currencies here.

## What's provided

- `Account.java` — simple data holder, complete, don't modify.
- `Ledger.java` — the interface described above, complete, don't modify.
- `InsufficientFundsException.java` — complete.
- `InMemoryLedger.java` — skeleton implementing `Ledger`, all methods throw
  `UnsupportedOperationException`. Implement this class.

Think out loud about thread-safety even though the tests are single-threaded — mention what you'd
change for concurrent access if asked.
