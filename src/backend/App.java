package backend;

import backend.JDBC.Login;
import backend.cards.BankCard;
import backend.cards.Credit;
import backend.cards.MasterCard;
import backend.cards.Visa;
import backend.users.User;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

public class App {

    Login login = new Login();
    User user = new User();

    public void app(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Въведете име и парола:");

        String username = scanner.nextLine();
        String password = scanner.nextLine();

        login.setConnection();
        login.login(username, password);

        if (login.isSuccessfulLogin()) {

            System.out.println("Изберете една от следните карти:" +
                    "Master card, " +
                    "Visa, " +
                    "Credit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "Master card" -> {
                    MasterCard masterCard = new MasterCard(user.getMasterCard().getBalance()
                            , user.getMasterCard().getPaymentLimit(), user.getMasterCard().getWithdrawalLimit());
                    printOptions();
                    choice = scanner.nextLine();
                    if (choice.equals("Проверка на баланса")) {
                        System.out.println(masterCard.getBalance());
                    } else if (choice.equals("Обновяване на лимита на плащане")) {
                        System.out.println("Въведете новия лимит на плащане");
                        BigDecimal paymentLimit = scanner.nextBigDecimal();
                        masterCard.changePaymentLimit(paymentLimit);
                        System.out.println(masterCard.getPaymentLimit());

                    } else if (choice.equals("Обновяване на лимита на теглене")) {
                        System.out.println("Въведете новия лимит на теглене");
                        BigDecimal withdrawalLimit = scanner.nextBigDecimal();
                        masterCard.changeWithdrawalLimit(withdrawalLimit);
                        System.out.println(masterCard.getWithdrawalLimit());
                    }
                }
                case "Visa" -> {
                    BankCard visa = new Visa(user.getVisa().getBalance()
                            , user.getVisa().getPaymentLimit(), user.getVisa().getWithdrawalLimit());
                    printOptions();
                    choice = scanner.nextLine();
                    if (choice.equals("Проверка на баланса")) {
                        System.out.println(visa.getBalance());
                    } else if (choice.equals("Обновяване на лимита на плащане")) {
                        System.out.println("Въведете новия лимит на плащане");
                        BigDecimal paymentLimit = scanner.nextBigDecimal();
                        visa.changePaymentLimit(paymentLimit);
                        System.out.println(visa.getPaymentLimit());

                    } else if (choice.equals("Обновяване на лимита на теглене")) {
                        System.out.println("Въведете новия лимит на теглене");
                        BigDecimal withdrawalLimit = scanner.nextBigDecimal();
                        visa.changeWithdrawalLimit(withdrawalLimit);
                        System.out.println(visa.getWithdrawalLimit());
                    }

                }
                case "Credit" -> {
                    BankCard credit = new Credit(user.getCredit().getBalance()
                            , user.getCredit().getPaymentLimit(), user.getCredit().getWithdrawalLimit());
                    printOptions();
                    choice = scanner.nextLine();
                    if (choice.equals("Проверка на баланса")) {
                        System.out.println(credit.getBalance());
                    } else if (choice.equals("Обновяване на лимита на плащане")) {
                        System.out.println("Въведете новия лимит на плащане");
                        BigDecimal paymentLimit = scanner.nextBigDecimal();
                        credit.changePaymentLimit(paymentLimit);
                        System.out.println(credit.getPaymentLimit());

                    } else if (choice.equals("Обновяване на лимита на теглене")) {
                        System.out.println("Въведете новия лимит на теглене");
                        BigDecimal withdrawalLimit = scanner.nextBigDecimal();
                        credit.changeWithdrawalLimit(withdrawalLimit);
                        System.out.println(credit.getWithdrawalLimit());
                    }
                }
            }
        }


    }

    public void printOptions() {
        System.out.println("Изберете една от следните опции:" +
                "Проверка на баланса, " +
                "Обновяване на лимита на плащане, " +
                "Обновяване на лимита на теглене");
    }

}
