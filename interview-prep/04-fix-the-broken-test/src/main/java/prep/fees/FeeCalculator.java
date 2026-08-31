package prep.fees;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FeeCalculator {

    private static final BigDecimal PERCENTAGE_RATE = new BigDecimal("0.029");
    private static final long FIXED_FEE_CENTS = 30;
    private static final long MIN_FEE_CENTS = 50;
    private static final long MAX_FEE_CENTS = 1000;

    public long calculateFeeCents(long amountCents) {
        BigDecimal percentageFee = new BigDecimal(amountCents)
                .multiply(PERCENTAGE_RATE)
                .setScale(0, RoundingMode.HALF_UP);

        long totalFee = percentageFee.longValueExact() + FIXED_FEE_CENTS;

        if (totalFee < MIN_FEE_CENTS) {
            totalFee = MIN_FEE_CENTS;
        }
        if (totalFee > MAX_FEE_CENTS) {
            totalFee = MAX_FEE_CENTS;
        }
        return totalFee;
    }
}
