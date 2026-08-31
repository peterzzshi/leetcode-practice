package prep.wallet;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String accountId, long requestedCents, long availableCents) {
        super("Account " + accountId + " has " + availableCents
                + " cents, cannot withdraw " + requestedCents);
    }
}
