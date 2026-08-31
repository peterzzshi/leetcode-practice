package prep.fees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FeeCalculatorTest {

    private final FeeCalculator calculator = new FeeCalculator();

    @Test
    void typicalTransactionChargesPercentagePlusFixedFee() {
        // $10.00 -> 2.9% = 29c, + 30c fixed = 59c
        assertEquals(59, calculator.calculateFeeCents(1000));
    }

    @Test
    void smallTransactionIsChargedTheMinimumFee() {
        // $1.00 -> 2.9% rounds to 3c, + 30c fixed = 33c, below the 50c minimum
        assertEquals(50, calculator.calculateFeeCents(100));
    }

    @Test
    void largeTransactionIsCappedAtMaximumFee() {
        // $5,000.00 -> way past the $10 cap
        assertEquals(1000, calculator.calculateFeeCents(500_000));
    }

    @Test
    void midSizedTransactionRoundsPercentageDown() {
        // $8.00 -> 2.9% = 23.2c, rounds down to 23c, + 30c fixed = 53c
        assertEquals(53, calculator.calculateFeeCents(800));
    }

    @Test
    void midSizedTransactionRoundsPercentageUp() {
        // $7.50 -> 2.9% = 21.75c, rounds up to 22c, + 30c fixed = 52c
        assertEquals(51, calculator.calculateFeeCents(750));
    }

    @Test
    void mediumTransactionBetweenMinimumAndCap() {
        // $100.00 -> 2.9% = 290c, + 30c fixed = 320c
        assertEquals(320, calculator.calculateFeeCents(10_000));
    }
}
