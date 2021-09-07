package backend.cards;

import java.math.BigDecimal;

public class Credit extends BankCard {

    public Credit(BigDecimal balance, BigDecimal paymentLimit, BigDecimal withdrawalLimit) {
        super(balance, paymentLimit, withdrawalLimit);
    }
}
