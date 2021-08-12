package cards;

import java.math.BigDecimal;

public class MasterCard extends BankCard {

    public MasterCard(BigDecimal balance, BigDecimal paymentLimit, BigDecimal withdrawalLimit) {
        super(balance, paymentLimit, withdrawalLimit);
    }

}
