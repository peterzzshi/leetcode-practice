package prep.wallet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class InMemoryLedger implements Ledger {

  private final Map<String, Account> accounts = new HashMap<>();
  private final Map<String, List<LedgerEntry>> history = new HashMap<>();
  private final Map<String, TransferResult> completedTransfers = new HashMap<>();

  @Override
  public void openAccount(final String accountId, final long initialBalanceCents) {
    if (this.accounts.containsKey(accountId)) {
      throw new IllegalArgumentException("Account already exists");
    }

    if (initialBalanceCents < 0) {
      throw new IllegalArgumentException("Initial balance cannot be negative");
    }
    final LedgerEntry ledgerEntry = new LedgerEntry(ActionType.OPEN_ACCOUNT, accountId,
        initialBalanceCents, initialBalanceCents);

    this.accounts.put(accountId, new Account(accountId, initialBalanceCents));

    final List<LedgerEntry> ledgers = new ArrayList<>();
    ledgers.add(ledgerEntry);

    this.history.put(accountId, ledgers);
  }

  @Override
  public void deposit(final String accountId, final long amountCents) {

    if (!this.accounts.containsKey(accountId)) {
      throw new NoSuchElementException("Account does not exist");
    }

    if (amountCents < 0) {
      throw new IllegalArgumentException("Amount cannot be negative");
    }

    final Account account = this.accounts.get(accountId);

    final long newAmountCents = account.getBalanceCents() + amountCents;
    account.setBalanceCents(newAmountCents);

    this.accounts.put(accountId, account);

    final LedgerEntry ledgerEntry = new LedgerEntry(ActionType.DEPOSIT, accountId, amountCents,
        newAmountCents);
    this.history.get(accountId).add(ledgerEntry);
  }

  @Override
  public void withdraw(final String accountId, final long amountCents) {
    if (amountCents < 0) {
      throw new IllegalArgumentException("Amount cannot be negative");
    }

    final Account account = this.accounts.get(accountId);

    if (account.getBalanceCents() < amountCents) {
      throw new InsufficientFundsException(accountId, amountCents, account.getBalanceCents());
    }

    final long newAmountCents = account.getBalanceCents() - amountCents;

    account.setBalanceCents(newAmountCents);

    this.accounts.put(accountId, account);

    final LedgerEntry ledgerEntry = new LedgerEntry(ActionType.WITHDRAW, accountId, amountCents,
        newAmountCents);
    this.history.get(accountId).add(ledgerEntry);
  }

  @Override
  public TransferResult transfer(final String fromAccountId, final String toAccountId,
      final long amountCents, final String idempotencyKey) {

    if (!this.accounts.containsKey(fromAccountId) || !this.accounts.containsKey(toAccountId)) {
      throw new NoSuchElementException("Account does not exist");
    }

    if (amountCents < 0) {
      throw new IllegalArgumentException("Amount cannot be negative");
    }

    if (this.completedTransfers.containsKey(idempotencyKey)) {
      return this.completedTransfers.get(idempotencyKey);
    }

    final Account fromAccount = this.accounts.get(fromAccountId);
    final Account toAccount = this.accounts.get(toAccountId);

    if (fromAccount.getBalanceCents() < amountCents) {
      throw new InsufficientFundsException(fromAccountId, amountCents,
          fromAccount.getBalanceCents());
    }

    fromAccount.setBalanceCents(fromAccount.getBalanceCents() - amountCents);
    toAccount.setBalanceCents(toAccount.getBalanceCents() + amountCents);

    final LedgerEntry outLedgerEntry = new LedgerEntry(ActionType.TRANSFER_OUT, fromAccountId,
        amountCents, fromAccount.getBalanceCents());
    final LedgerEntry inLedgerEntry = new LedgerEntry(ActionType.TRANSFER_IN, toAccountId,
        amountCents, toAccount.getBalanceCents());

    final List<LedgerEntry> ledgerEntries = new ArrayList<>();
    ledgerEntries.add(outLedgerEntry);
    ledgerEntries.add(inLedgerEntry);

    final TransferResult transferResult = new TransferResult(idempotencyKey, true);

    this.completedTransfers.put(idempotencyKey, transferResult);

    return transferResult;
  }

  @Override
  public long getBalance(final String accountId) {

    if (!this.accounts.containsKey(accountId)) {
      throw new IllegalArgumentException("Account does not exist");
    }

    return this.accounts.get(accountId).getBalanceCents();
  }

  @Override
  public List<LedgerEntry> getHistory(final String accountId) {

    if (!this.history.containsKey(accountId)) {
      throw new IllegalArgumentException("Account does not exist");
    }

    return this.history.get(accountId);
  }
}
