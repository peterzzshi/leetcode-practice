package prep.wallet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InMemoryLedgerTest {

    private Ledger ledger;

    @BeforeEach
    void setUp() {
        ledger = new InMemoryLedger();
        ledger.openAccount("alice", 10_000); // $100.00
        ledger.openAccount("bob", 0);
    }

    @Test
    void cannotOpenDuplicateAccount() {
        assertThrows(IllegalArgumentException.class, () -> ledger.openAccount("alice", 0));
    }

    @Test
    void cannotOpenWithNegativeBalance() {
        assertThrows(IllegalArgumentException.class, () -> ledger.openAccount("carol", -1));
    }

    @Test
    void depositIncreasesBalance() {
        ledger.deposit("alice", 500);
        assertEquals(10_500, ledger.getBalance("alice"));
    }

    @Test
    void depositOnUnknownAccountThrows() {
        assertThrows(NoSuchElementException.class, () -> ledger.deposit("ghost", 100));
    }

    @Test
    void withdrawDecreasesBalance() {
        ledger.withdraw("alice", 500);
        assertEquals(9_500, ledger.getBalance("alice"));
    }

    @Test
    void withdrawBeyondBalanceThrows() {
        assertThrows(InsufficientFundsException.class, () -> ledger.withdraw("alice", 1_000_000));
        assertEquals(10_000, ledger.getBalance("alice"), "balance must be unchanged after a failed withdrawal");
    }

    @Test
    void transferMovesMoneyBetweenAccounts() {
        ledger.transfer("alice", "bob", 2_000, "key-1");
        assertEquals(8_000, ledger.getBalance("alice"));
        assertEquals(2_000, ledger.getBalance("bob"));
    }

    @Test
    void transferToUnknownAccountLeavesSenderUnchanged() {
        assertThrows(NoSuchElementException.class, () -> ledger.transfer("alice", "ghost", 2_000, "key-2"));
        assertEquals(10_000, ledger.getBalance("alice"), "sender must not be debited if the transfer fails");
    }

    @Test
    void repeatingSameIdempotencyKeyDoesNotDoubleMoveMoney() {
        ledger.transfer("alice", "bob", 2_000, "key-3");
        ledger.transfer("alice", "bob", 2_000, "key-3"); // retry with the same key

        assertEquals(8_000, ledger.getBalance("alice"));
        assertEquals(2_000, ledger.getBalance("bob"));
    }

    @Test
    void historyRecordsEntriesOldestFirst() {
        ledger.deposit("alice", 100);
        ledger.withdraw("alice", 50);

        List<Ledger.LedgerEntry> history = ledger.getHistory("alice");
        assertEquals(3, history.size(), "open + deposit + withdraw");
        assertEquals("OPEN", history.get(0).type());
        assertEquals("DEPOSIT", history.get(1).type());
        assertEquals("WITHDRAW", history.get(2).type());
    }
}
