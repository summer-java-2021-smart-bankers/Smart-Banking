package backend.JDBC;

import backend.users.UserController;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class TransferMoney {

    private static final String DATABASE_URL = "jdbc:mysql://smart-banking.cqjpytyw3ekv.us-east-2.rds.amazonaws.com:3306/smart_banking";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "SqlAdmin";

    private Connection connection;
    private static UserController user = new UserController();

    public void setConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", DATABASE_USERNAME);
        properties.setProperty("password", DATABASE_PASSWORD);

        connection = DriverManager.getConnection(DATABASE_URL, properties);
    }

    public void transferMoney(String iban, int currentUserId, String fromCard, BigDecimal money) throws SQLException {
        if (fromCard.equals("MasterCard")) {
            //current user - money
            String queryForUpdateUserBalance = "UPDATE master_cards\n" +
                    "SET balance = balance - ?\n" +
                    "WHERE id = ?;";

            PreparedStatement preparedStatementForUpdateUserBalance = connection.prepareStatement(queryForUpdateUserBalance);

            preparedStatementForUpdateUserBalance.setBigDecimal(1, money);
            preparedStatementForUpdateUserBalance.setInt(2, currentUserId);

//            preparedStatementForUpdateUserBalance.execute();

            //receiver user + money
            String queryForUpdateReceiverBalance = "UPDATE master_cards\n" +
                    "INNER JOIN users ON master_cards.id = users.id\n" +
                    "SET balance = balance + ?\n" +
                    "WHERE users.iban = ?;";

            PreparedStatement preparedStatementForUpdateReceiverBalance = connection.prepareStatement(queryForUpdateReceiverBalance);

            preparedStatementForUpdateReceiverBalance.setBigDecimal(1, money);
            preparedStatementForUpdateReceiverBalance.setString(2, iban);

            if (preparedStatementForUpdateReceiverBalance.execute()) {
                preparedStatementForUpdateUserBalance.execute();
            }


        }else if (fromCard.equals("VisaClassic")) {
            //current user - money
            String queryForUpdateUserBalance = "UPDATE visa_classic\n" +
                    "SET balance = balance - ?\n" +
                    "WHERE id = ?;";

            PreparedStatement preparedStatementForUpdateUserBalance = connection.prepareStatement(queryForUpdateUserBalance);

            preparedStatementForUpdateUserBalance.setBigDecimal(1, money);
            preparedStatementForUpdateUserBalance.setInt(2, currentUserId);

//            preparedStatementForUpdateUserBalance.execute();

            //receiver user + money
            String queryForUpdateReceiverBalance = "UPDATE master_cards\n" +
                    "INNER JOIN users ON master_cards.id = users.id\n" +
                    "SET balance = balance + ?\n" +
                    "WHERE users.iban = ?;";

            PreparedStatement preparedStatementForUpdateReceiverBalance = connection.prepareStatement(queryForUpdateReceiverBalance);

            preparedStatementForUpdateReceiverBalance.setBigDecimal(1, money);
            preparedStatementForUpdateReceiverBalance.setString(2, iban);

//            preparedStatementForUpdateReceiverBalance.execute();

            if (preparedStatementForUpdateReceiverBalance.execute()) {
                preparedStatementForUpdateUserBalance.execute();
            }
        }else if (fromCard.equals("CreditCard")) {
            //current user - money
            String queryForUpdateUserBalance = "UPDATE credit_cards\n" +
                    "SET balance = balance - ?\n" +
                    "WHERE id = ?;";

            PreparedStatement preparedStatementForUpdateUserBalance = connection.prepareStatement(queryForUpdateUserBalance);

            preparedStatementForUpdateUserBalance.setBigDecimal(1, money);
            preparedStatementForUpdateUserBalance.setInt(2, currentUserId);

//            preparedStatementForUpdateUserBalance.execute();

            //receiver user + money
            String queryForUpdateReceiverBalance = "UPDATE master_cards\n" +
                    "INNER JOIN users ON master_cards.id = users.id\n" +
                    "SET balance = balance + ?\n" +
                    "WHERE users.iban = ?;";

            PreparedStatement preparedStatementForUpdateReceiverBalance = connection.prepareStatement(queryForUpdateReceiverBalance);

            preparedStatementForUpdateReceiverBalance.setBigDecimal(1, money);
            preparedStatementForUpdateReceiverBalance.setString(2, iban);

//            preparedStatementForUpdateReceiverBalance.execute();

            if (preparedStatementForUpdateReceiverBalance.execute()) {
                preparedStatementForUpdateUserBalance.execute();
            }
        }

    }

}
