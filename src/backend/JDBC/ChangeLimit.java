package backend.JDBC;

import backend.users.UserController;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class ChangeLimit {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/smart-banking";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "0000";

    private Connection connection;
    private static UserController user = new UserController();

    public void setConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", DATABASE_USERNAME);
        properties.setProperty("password", DATABASE_PASSWORD);

        connection = DriverManager.getConnection(DATABASE_URL, properties);
    }

    //master card change limits
    public void changeMasterCardPaymentLimit(BigDecimal paymentLimit, int id) throws SQLException {
        String queryForChangePaymentLimit = "UPDATE master_cards\n" +
                "INNER JOIN users ON master_cards.id = users.id\n" +
                "SET payment_limit = ?\n" +
                "WHERE users.id = ?";

        PreparedStatement preparedStatementForChangePaymentLimit = connection.prepareStatement(queryForChangePaymentLimit);

        preparedStatementForChangePaymentLimit.setBigDecimal(1, paymentLimit);
        preparedStatementForChangePaymentLimit.setInt(2, id);

        preparedStatementForChangePaymentLimit.execute();
    }

    public void changeMasterCardWithdrawalLimit(BigDecimal withdrawalLimit, int id) throws SQLException {
        String queryForChangeWithdrawalLimit = "UPDATE master_cards\n" +
                "INNER JOIN users ON master_cards.id = users.id\n" +
                "SET withdrawal_limit = ?\n" +
                "WHERE users.id = ?";

        PreparedStatement preparedStatementForChangeWithdrawalLimit = connection.prepareStatement(queryForChangeWithdrawalLimit);

        preparedStatementForChangeWithdrawalLimit.setBigDecimal(1, withdrawalLimit);
        preparedStatementForChangeWithdrawalLimit.setInt(2, id);

        preparedStatementForChangeWithdrawalLimit.execute();
    }

    //visa classic change limits
    public void changeVisaClassicPaymentLimit(BigDecimal paymentLimit, int id) throws SQLException {
        String queryForChangePaymentLimit = "UPDATE visa_classic\n" +
                "INNER JOIN users ON visa_classic.id = users.id\n" +
                "SET payment_limit = ?\n" +
                "WHERE users.id = ?";

        PreparedStatement preparedStatementForChangePaymentLimit = connection.prepareStatement(queryForChangePaymentLimit);

        preparedStatementForChangePaymentLimit.setBigDecimal(1, paymentLimit);
        preparedStatementForChangePaymentLimit.setInt(2, id);

        preparedStatementForChangePaymentLimit.execute();
    }

    public void changeVisaClassicWithdrawalLimit(BigDecimal withdrawalLimit, int id) throws SQLException {
        String queryForChangeWithdrawalLimit = "UPDATE visa_classic\n" +
                "INNER JOIN users ON visa_classic.id = users.id\n" +
                "SET withdrawal_limit = ?\n" +
                "WHERE users.id = ?";

        PreparedStatement preparedStatementForChangeWithdrawalLimit = connection.prepareStatement(queryForChangeWithdrawalLimit);

        preparedStatementForChangeWithdrawalLimit.setBigDecimal(1, withdrawalLimit);
        preparedStatementForChangeWithdrawalLimit.setInt(2, id);

        preparedStatementForChangeWithdrawalLimit.execute();
    }

    //credit card change limits
    public void changeCreditCardPaymentLimit(BigDecimal paymentLimit, int id) throws SQLException {
        String queryForChangePaymentLimit = "UPDATE credit_cards\n" +
                "INNER JOIN users ON credit_cards.id = users.id\n" +
                "SET payment_limit = ?\n" +
                "WHERE users.id = ?";

        PreparedStatement preparedStatementForChangePaymentLimit = connection.prepareStatement(queryForChangePaymentLimit);

        preparedStatementForChangePaymentLimit.setBigDecimal(1, paymentLimit);
        preparedStatementForChangePaymentLimit.setInt(2, id);

        preparedStatementForChangePaymentLimit.execute();
    }

    public void changeCreditCardWithdrawalLimit(BigDecimal withdrawalLimit, int id) throws SQLException {
        String queryForChangeWithdrawalLimit = "UPDATE credit_cards\n" +
                "INNER JOIN users ON credit_cards.id = users.id\n" +
                "SET withdrawal_limit = ?\n" +
                "WHERE users.id = ?";

        PreparedStatement preparedStatementForChangeWithdrawalLimit = connection.prepareStatement(queryForChangeWithdrawalLimit);

        preparedStatementForChangeWithdrawalLimit.setBigDecimal(1, withdrawalLimit);
        preparedStatementForChangeWithdrawalLimit.setInt(2, id);

        preparedStatementForChangeWithdrawalLimit.execute();
    }
}
