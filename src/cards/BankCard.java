package cards;

import java.math.BigDecimal;

public abstract class BankCard implements CardFunctions {

    private BigDecimal balance;
    private BigDecimal paymentLimit;
    private BigDecimal withdrawalLimit;

    public BankCard(BigDecimal balance, BigDecimal paymentLimit, BigDecimal withdrawalLimit) {
        this.balance = new BigDecimal(String.valueOf(balance));
        this.paymentLimit = new BigDecimal(String.valueOf(paymentLimit));
        this.withdrawalLimit = new BigDecimal(String.valueOf(withdrawalLimit));
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getPaymentLimit() {
        return paymentLimit;
    }

    public void setPaymentLimit(BigDecimal paymentLimit) {
        this.paymentLimit = paymentLimit;
    }

    public BigDecimal getWithdrawalLimit() {
        return withdrawalLimit;
    }

    public void setWithdrawalLimit(BigDecimal withdrawalLimit) {
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "balance=" + balance +
                ", paymentLimit=" + paymentLimit +
                ", withdrawalLimit=" + withdrawalLimit +
                '}';
    }

    @Override
    public void changePaymentLimit(BigDecimal paymentLimit) {
        this.paymentLimit =new BigDecimal(String.valueOf(paymentLimit));
    }

    @Override
    public void changeWithdrawalLimit(BigDecimal withdrawalLimit) {
        this.withdrawalLimit =new BigDecimal(String.valueOf(withdrawalLimit));
    }
}
