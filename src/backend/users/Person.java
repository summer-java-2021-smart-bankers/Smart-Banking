package backend.users;

import backend.cards.BankCard;

import java.util.ArrayList;

public class Person {

    private String username;
    private String password;
    private String email;
    private String city;
    private String firstName;
    private String lastName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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
