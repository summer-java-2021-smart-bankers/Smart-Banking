package backend;

import backend.cards.BankCard;
import backend.cards.Credit;
import backend.cards.MasterCard;
import backend.cards.Visa;

import java.math.BigDecimal;
import java.util.Scanner;

public class App {

    public void app(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Изберете потребител:" +
                "Иван Петров " +
                "Георги Шипков" +
                "Вероника Калъчева");

        String person = scanner.nextLine();

        if (person.equals("Иван Петров")) {

        }else if (person.equals("Георги Шипков")) {

        }else if (person.equals("Вероника Калъчева")) {

        }


        System.out.println("Изберете една от следните карти:" +
                "Master card, " +
                "Visa, " +
                "Credit");

        String choice = scanner.nextLine();

        switch (choice) {
            case "Master card" -> {
                BankCard masterCard = new MasterCard(new BigDecimal("505.50"), new BigDecimal("50")
                        , new BigDecimal("100"));
                printOptions();
                choice = scanner.nextLine();
                if (choice.equals("Проверка на баланса")) {
                    System.out.println(masterCard);
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
                BankCard visa = new Visa(new BigDecimal("4369.53"), new BigDecimal("500")
                        , new BigDecimal("1000"));
                printOptions();
                choice = scanner.nextLine();
                if (choice.equals("Проверка на баланса")) {
                    System.out.println(visa);
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
                BankCard credit = new Credit(new BigDecimal("100000"), new BigDecimal("50")
                        , new BigDecimal("10000"));
                printOptions();
                choice = scanner.nextLine();
                if (choice.equals("Проверка на баланса")) {
                    System.out.println(credit);
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

    public void printOptions() {
        System.out.println("Изберете една от следните опции:" +
                "Проверка на баланса, " +
                "Обновяване на лимита на плащане, " +
                "Обновяване на лимита на теглене");
    }

}
