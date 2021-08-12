package cards;

import java.math.BigDecimal;

public interface CardFunctions {

    void changePaymentLimit(BigDecimal paymentLimit);

    void changeWithdrawalLimit(BigDecimal withdrawalLimit);
}
