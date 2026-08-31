package prep.wallet;

import java.util.List;

public interface Ledger {

    void openAccount(String accountId, long initialBalanceCents);

    void deposit(String accountId, long amountCents);

    void withdraw(String accountId, long amountCents);

    TransferResult transfer(String fromAccountId, String toAccountId, long amountCents, String idempotencyKey);

    long getBalance(String accountId);

    List<LedgerEntry> getHistory(String accountId);

    record TransferResult(String idempotencyKey, boolean appliedNow) {
    }

    record LedgerEntry(String type, String counterpartyAccountId, long amountCents, long resultingBalanceCents) {
    }
}
