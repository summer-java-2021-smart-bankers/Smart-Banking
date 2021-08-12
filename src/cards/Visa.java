package cards;

import java.math.BigDecimal;

public class Visa extends BankCard {

    public Visa(BigDecimal balance, BigDecimal paymentLimit, BigDecimal withdrawalLimit) {
        super(balance, paymentLimit, withdrawalLimit);
    }

}
