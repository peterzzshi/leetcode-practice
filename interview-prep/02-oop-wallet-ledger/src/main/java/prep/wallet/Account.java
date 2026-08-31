package prep.wallet;

public final class Account {
    private final String id;
    private long balanceCents;

    public Account(String id, long initialBalanceCents) {
        this.id = id;
        this.balanceCents = initialBalanceCents;
    }

    public String getId() {
        return id;
    }

    public long getBalanceCents() {
        return balanceCents;
    }

    void setBalanceCents(long balanceCents) {
        this.balanceCents = balanceCents;
    }
}
