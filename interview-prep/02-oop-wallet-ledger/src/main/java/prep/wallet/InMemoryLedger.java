package prep.wallet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryLedger implements Ledger {

    private final Map<String, Account> accounts = new HashMap<>();
    private final Map<String, List<LedgerEntry>> history = new HashMap<>();
    private final Map<String, TransferResult> completedTransfers = new HashMap<>();

    @Override
    public void openAccount(String accountId, long initialBalanceCents) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void deposit(String accountId, long amountCents) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void withdraw(String accountId, long amountCents) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public TransferResult transfer(String fromAccountId, String toAccountId, long amountCents, String idempotencyKey) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public long getBalance(String accountId) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public List<LedgerEntry> getHistory(String accountId) {
        throw new UnsupportedOperationException("TODO");
    }
}
