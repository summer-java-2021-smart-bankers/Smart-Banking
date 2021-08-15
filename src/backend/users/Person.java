package backend.users;

import backend.cards.BankCard;

import java.util.ArrayList;

public class Person {

    private ArrayList<BankCard> bankCards;

    public Person() {
        this.bankCards = new ArrayList<>();
    }

    public void addBankCard(BankCard bankCard) {
        this.bankCards.add(bankCard);
    }

    public ArrayList<BankCard> getBankCard() {
        return this.bankCards;
    }

    public void setBankCard(ArrayList<BankCard> bankCards) {
        this.bankCards = bankCards;
    }
}
