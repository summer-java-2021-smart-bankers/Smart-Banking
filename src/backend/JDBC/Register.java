package backend.JDBC;

import java.sql.*;
import java.util.Properties;

public class Register {

    private static final String DATABASE_URL = "jdbc:mysql://smart-banking.cqjpytyw3ekv.us-east-2.rds.amazonaws.com:3306/smart_banking";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "SqlAdmin";

    private Connection connection;

    public void setConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", DATABASE_USERNAME);
        properties.setProperty("password", DATABASE_PASSWORD);

        connection = DriverManager.getConnection(DATABASE_URL, properties);
    }

    public void register(String username, String password, String email, String city, String firstName, String lastName) throws SQLException {
        //master_cards
        String queryForMasterCard = "INSERT INTO master_cards(balance, payment_limit, withdrawal_limit)\n" +
                "VALUES (?,?,?)";

        PreparedStatement preparedStatementForMasterCard = connection.prepareStatement(queryForMasterCard);

        preparedStatementForMasterCard.setInt(1, 4500);
        preparedStatementForMasterCard.setInt(2, 100);
        preparedStatementForMasterCard.setInt(3, 150);

        preparedStatementForMasterCard.execute();

        //visa_classic
        String queryForVisaClassic = "INSERT INTO visa_classic(balance, payment_limit, withdrawal_limit)\n" +
                "VALUES (?,?,?)";

        PreparedStatement preparedStatementForVisaClassic = connection.prepareStatement(queryForVisaClassic);

        preparedStatementForVisaClassic.setInt(1, 2000);
        preparedStatementForVisaClassic.setInt(2, 50);
        preparedStatementForVisaClassic.setInt(3, 100);

        preparedStatementForVisaClassic.execute();

        //credit_cards
        String queryForCreditCard = "INSERT INTO credit_cards(balance, payment_limit, withdrawal_limit)\n" +
                "VALUES (?,?,?)";

        PreparedStatement preparedStatementForCreditCard = connection.prepareStatement(queryForCreditCard);

        preparedStatementForCreditCard.setInt(1, 5000);
        preparedStatementForCreditCard.setInt(2, 200);
        preparedStatementForCreditCard.setInt(3, 300);

        preparedStatementForCreditCard.execute();


        //id
        int countForCards = 0;
        String queryForId = "SELECT MAX(id)\n" +
                "FROM master_cards;";

        PreparedStatement preparedStatementForId = connection.prepareStatement(queryForId);

        ResultSet resultSetId = preparedStatementForId.executeQuery();
        while (resultSetId.next()) {
            countForCards = resultSetId.getInt("MAX(id)");
        }

        //cards
        String queryForMoney = "INSERT INTO cards(master_card, visa_classic, credit_card)\n" +
                "VALUES (?,?,?)";

        PreparedStatement preparedStatementForMoney = connection.prepareStatement(queryForMoney);

        preparedStatementForMoney.setInt(1, countForCards);
        preparedStatementForMoney.setInt(2, countForCards);
        preparedStatementForMoney.setInt(3, countForCards);

        preparedStatementForMoney.execute();

        //user
        String query = "INSERT INTO users (username, password, `e-mail`, city, `first name`, `last name`, `id_cards`)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, city);
        preparedStatement.setString(5, firstName);
        preparedStatement.setString(6, lastName);
        preparedStatement.setInt(7, countForCards);

        preparedStatement.execute();


    }

}