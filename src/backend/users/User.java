package backend.users;

import backend.cards.BankCard;
import backend.cards.Credit;
import backend.cards.MasterCard;
import backend.cards.Visa;

import java.math.BigDecimal;
import java.util.ArrayList;

public class User {

    private String username;
    private String password;
    private String email;
    private String city;
    private String firstName;
    private String lastName;
    private MasterCard masterCard;
    private Visa visa;
    private Credit credit;

    public void logUser(String username, String password, String email, String city, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.city = city;
        this.firstName = firstName;
        this.lastName = lastName;
        this.masterCard = new MasterCard(new BigDecimal("500"), new BigDecimal("3000")
                , new BigDecimal("3000"));
        this.visa = new Visa(new BigDecimal("3000"), new BigDecimal("3000")
                , new BigDecimal("3000"));
        this.credit = new Credit(new BigDecimal("1000"), new BigDecimal("3000")
                , new BigDecimal("3000"));
    }

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

    public MasterCard getMasterCard() {
        return masterCard;
    }

    public void setMasterCard(MasterCard masterCard) {
        this.masterCard = masterCard;
    }

    public Visa getVisa() {
        return visa;
    }

    public void setVisa(Visa visa) {
        this.visa = visa;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    private ArrayList<BankCard> bankCards;

    public User() {
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
