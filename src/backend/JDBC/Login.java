package backend.JDBC;

import backend.users.UserController;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Properties;

public class Login {

    private boolean isCorrectInfo = false;
    private boolean successfulLogin = false;
    UserController user = new UserController();

    public UserController getUser() {
        return user;
    }

    public void setUser(UserController user) {
        this.user = user;
    }

    public boolean isSuccessfulLogin() {
        return successfulLogin;
    }

    public void setSuccessfulLogin(boolean successfulLogin) {
        this.successfulLogin = successfulLogin;
    }

    public boolean isCorrectInfo() {
        return isCorrectInfo;
    }

    public void setCorrectInfo(boolean correctInfo) {
        isCorrectInfo = correctInfo;
    }

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/smart-banking";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "0000";

    private Connection connection;

    public void setConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", DATABASE_USERNAME);
        properties.setProperty("password", DATABASE_PASSWORD);

        connection = DriverManager.getConnection(DATABASE_URL, properties);
    }

    public void login(String username, String password) throws SQLException {

        String queryForNameAndPass = "SELECT u.username, u.password FROM users AS u";

        PreparedStatement StatementGetName = connection.prepareStatement(queryForNameAndPass);

        ResultSet resultSetNames = StatementGetName.executeQuery();

        while (resultSetNames.next()) {
            if (resultSetNames.getString("username").equals(username)
                    && resultSetNames.getString("password").equals(password)) {
                setCorrectInfo(true);
            }
        }
        loginUser(username, password);
    }

    public void loginUser(String username, String password) throws SQLException {

        if (isCorrectInfo) {
            //user
            String queryForInfo = "SELECT * FROM users WHERE username = ?";

            PreparedStatement statementGetInfo = connection.prepareStatement(queryForInfo);

            statementGetInfo.setString(1, username);

            ResultSet resultGetInfo = statementGetInfo.executeQuery();
            String userMail = null;
            String userCity = null;
            String userFirstName = null;
            String userLastName = null;
            while (resultGetInfo.next()) {
                userMail = resultGetInfo.getString("e-mail");
                userCity = resultGetInfo.getString("city");
                userFirstName = resultGetInfo.getString("first name");
                userLastName = resultGetInfo.getString("last name");
            }

            //master card
            String queryForMasterCard = "SELECT master_cards.*, users.id\n" +
                    "FROM master_cards\n" +
                    "INNER JOIN users ON master_cards.id = users.id";

            PreparedStatement statementForMasterCard = connection.prepareStatement(queryForMasterCard);

            ResultSet resultForMasterCard = statementForMasterCard.executeQuery();
            BigDecimal masterCardBalance = new BigDecimal("0.00");
            BigDecimal masterCardPaymentLimit = new BigDecimal("0.00");
            BigDecimal masterCardWithdrawalLimit = new BigDecimal("0.00");
            while (resultForMasterCard.next()) {
                masterCardBalance = resultForMasterCard.getBigDecimal("balance");
                masterCardPaymentLimit = resultForMasterCard.getBigDecimal("payment_limit");
                masterCardWithdrawalLimit = resultForMasterCard.getBigDecimal("withdrawal_limit");

            }

            //visa classic
            String queryForVisaClassic = "SELECT visa_classic.*, users.id\n" +
                    "FROM visa_classic\n" +
                    "INNER JOIN users ON visa_classic.id = users.id";

            PreparedStatement statementForVisaClassic = connection.prepareStatement(queryForVisaClassic);

            ResultSet resultForVisaClassic = statementForVisaClassic.executeQuery();
            BigDecimal visaClassicBalance = new BigDecimal("0.00");
            BigDecimal visaClassicPaymentLimit = new BigDecimal("0.00");
            BigDecimal visaClassicWithdrawalLimit = new BigDecimal("0.00");
            while (resultForVisaClassic.next()) {
                visaClassicBalance = resultForVisaClassic.getBigDecimal("balance");
                visaClassicPaymentLimit = resultForVisaClassic.getBigDecimal("payment_limit");
                visaClassicWithdrawalLimit = resultForVisaClassic.getBigDecimal("withdrawal_limit");

            }

            //credit card
            String queryForCreditCard = "SELECT credit_cards.*, users.id\n" +
                    "FROM credit_cards\n" +
                    "INNER JOIN users ON credit_cards.id = users.id";

            PreparedStatement statementForCreditCard = connection.prepareStatement(queryForCreditCard);

            ResultSet resultForCreditCard = statementForCreditCard.executeQuery();
            BigDecimal creditCardBalance = new BigDecimal("0.00");
            BigDecimal creditCardPaymentLimit = new BigDecimal("0.00");
            BigDecimal creditCardWithdrawalLimit = new BigDecimal("0.00");
            while (resultForCreditCard.next()) {
                creditCardBalance = resultForCreditCard.getBigDecimal("balance");
                creditCardPaymentLimit = resultForCreditCard.getBigDecimal("payment_limit");
                creditCardWithdrawalLimit = resultForCreditCard.getBigDecimal("withdrawal_limit");

            }

            user.getUser().logUser(username, password, userMail, userCity, userFirstName, userLastName
                    , masterCardBalance, masterCardPaymentLimit, masterCardWithdrawalLimit
                    , visaClassicBalance, visaClassicPaymentLimit, visaClassicWithdrawalLimit
                    , creditCardBalance, creditCardPaymentLimit, creditCardWithdrawalLimit);

            setSuccessfulLogin(true);
        }
    }

}
