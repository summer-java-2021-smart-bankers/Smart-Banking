package backend.JDBC;

import backend.users.UserController;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Properties;

public class TransferMoney {

    private static final String DATABASE_URL = "jdbc:mysql://smart-banking.cqjpytyw3ekv.us-east-2.rds.amazonaws.com:3306/smart_banking";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "SqlAdmin";

    private Connection connection;
    private static UserController user = new UserController();

    private boolean isOtherUser = false;
    private boolean isCorrectIban = false;
    private boolean haveMoney = false;

    public boolean isOtherUser() {
        return isOtherUser;
    }

    public void setOtherUser(boolean otherUser) {
        isOtherUser = otherUser;
    }

    public boolean isCorrectIban() {
        return isCorrectIban;
    }

    public void setCorrectIban(boolean correctIban) {
        isCorrectIban = correctIban;
    }

    public boolean isHaveMoney() {
        return haveMoney;
    }

    public void setHaveMoney(boolean haveMoney) {
        this.haveMoney = haveMoney;
    }

    public void setConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", DATABASE_USERNAME);
        properties.setProperty("password", DATABASE_PASSWORD);

        connection = DriverManager.getConnection(DATABASE_URL, properties);
    }

    public void transferMoney(String iban, int currentUserId, String fromCard, BigDecimal money) throws SQLException {

        //check for transfer to him
        String queryForSameUser = "SELECT * FROM users\n" +
                "WHERE users.id = ?";

        PreparedStatement preparedStatementForSameUser = connection.prepareStatement(queryForSameUser);

        preparedStatementForSameUser.setInt(1, currentUserId);

        ResultSet resultSetForSameUser = preparedStatementForSameUser.executeQuery();

        isOtherUser = false;
        String currentUserIban;

        while (resultSetForSameUser.next()) {
            currentUserIban = resultSetForSameUser.getString("iban");
            if (!currentUserIban.equals(iban)) {
                isOtherUser = true;
                break;
            }
        }

        //check iban is correct
        String queryForIban = "SELECT * FROM users\n" +
                "WHERE iban = ?";

        PreparedStatement preparedStatementForIban = connection.prepareStatement(queryForIban);

        preparedStatementForIban.setString(1, iban);

        ResultSet resultSetForIban = preparedStatementForIban.executeQuery();

        isCorrectIban = false;
        String ibanFromDb;

        while (resultSetForIban.next()) {
            ibanFromDb = resultSetForIban.getString("iban");
            if (ibanFromDb.equals(iban)) {
                isCorrectIban = true;
                break;
            }
        }

        if (isOtherUser) {
            if (isCorrectIban) {
                if (fromCard.equals("MasterCard")) {

                    //check user have this money
                    String queryForMoney = "SELECT master_cards.*, users.id\n" +
                            "FROM master_cards\n" +
                            "INNER JOIN users ON master_cards.id = users.id\n" +
                            "WHERE master_cards.id = ?";

                    PreparedStatement preparedStatementForMoney = connection.prepareStatement(queryForMoney);

                    preparedStatementForMoney.setInt(1, currentUserId);

                    ResultSet resultSetForMoney = preparedStatementForMoney.executeQuery();

                    haveMoney = false;
                    BigDecimal userMoney;

                    while (resultSetForMoney.next()) {
                        userMoney = resultSetForMoney.getBigDecimal("balance");
                        if (userMoney.compareTo(money) >= 0) {
                            haveMoney = true;
                        }
                    }

                    if (haveMoney) {
                        //current user - money
                        String queryForUpdateUserBalance = "UPDATE master_cards\n" +
                                "SET balance = balance - ?\n" +
                                "WHERE id = ?;";

                        PreparedStatement preparedStatementForUpdateUserBalance = connection.prepareStatement(queryForUpdateUserBalance);

                        preparedStatementForUpdateUserBalance.setBigDecimal(1, money);
                        preparedStatementForUpdateUserBalance.setInt(2, currentUserId);

                        preparedStatementForUpdateUserBalance.execute();

                        //receiver user + money
                        String queryForUpdateReceiverBalance = "UPDATE master_cards\n" +
                                "INNER JOIN users ON master_cards.id = users.id\n" +
                                "SET balance = balance + ?\n" +
                                "WHERE users.iban = ?;";

                        PreparedStatement preparedStatementForUpdateReceiverBalance = connection.prepareStatement(queryForUpdateReceiverBalance);

                        preparedStatementForUpdateReceiverBalance.setBigDecimal(1, money);
                        preparedStatementForUpdateReceiverBalance.setString(2, iban);

                        preparedStatementForUpdateReceiverBalance.execute();
                    }
                } else if (fromCard.equals("VisaClassic")) {
                    //check user have this money
                    String queryForMoney = "SELECT visa_classic.*, users.id\n" +
                            "FROM visa_classic\n" +
                            "INNER JOIN users ON visa_classic.id = users.id\n" +
                            "WHERE visa_classic.id = ?";

                    PreparedStatement preparedStatementForMoney = connection.prepareStatement(queryForMoney);

                    preparedStatementForMoney.setInt(1, currentUserId);

                    ResultSet resultSetForMoney = preparedStatementForMoney.executeQuery();

                    haveMoney = false;
                    BigDecimal userMoney = BigDecimal.valueOf(0);

                    while (resultSetForMoney.next()) {
                        userMoney = resultSetForMoney.getBigDecimal("balance");
                        if (userMoney.compareTo(money) >= 0) {
                            haveMoney = true;
                        }
                    }

                    if (haveMoney) {
                        //current user - money
                        String queryForUpdateUserBalance = "UPDATE visa_classic\n" +
                                "SET balance = balance - ?\n" +
                                "WHERE id = ?;";

                        PreparedStatement preparedStatementForUpdateUserBalance = connection.prepareStatement(queryForUpdateUserBalance);

                        preparedStatementForUpdateUserBalance.setBigDecimal(1, money);
                        preparedStatementForUpdateUserBalance.setInt(2, currentUserId);

                        preparedStatementForUpdateUserBalance.execute();
                        //receiver user + money
                        String queryForUpdateReceiverBalance = "UPDATE master_cards\n" +
                                "INNER JOIN users ON master_cards.id = users.id\n" +
                                "SET balance = balance + ?\n" +
                                "WHERE users.iban = ?;";

                        PreparedStatement preparedStatementForUpdateReceiverBalance = connection.prepareStatement(queryForUpdateReceiverBalance);

                        preparedStatementForUpdateReceiverBalance.setBigDecimal(1, money);
                        preparedStatementForUpdateReceiverBalance.setString(2, iban);

                        preparedStatementForUpdateReceiverBalance.execute();
                    }
                } else if (fromCard.equals("CreditCard")) {
                    //check user have this money
                    String queryForMoney = "SELECT credit_cards.*, users.id\n" +
                            "FROM credit_cards\n" +
                            "INNER JOIN users ON credit_cards.id = users.id\n" +
                            "WHERE credit_cards.id = ?";

                    PreparedStatement preparedStatementForMoney = connection.prepareStatement(queryForMoney);

                    preparedStatementForMoney.setInt(1, currentUserId);

                    ResultSet resultSetForMoney = preparedStatementForMoney.executeQuery();

                    haveMoney = false;
                    BigDecimal userMoney = BigDecimal.valueOf(0);

                    while (resultSetForMoney.next()) {
                        userMoney = resultSetForMoney.getBigDecimal("balance");
                        if (userMoney.compareTo(money) >= 0) {
                            haveMoney = true;
                        }
                    }

                    if (haveMoney) {
                        //current user - money
                        String queryForUpdateUserBalance = "UPDATE credit_cards\n" +
                                "SET balance = balance - ?\n" +
                                "WHERE id = ?;";

                        PreparedStatement preparedStatementForUpdateUserBalance = connection.prepareStatement(queryForUpdateUserBalance);

                        preparedStatementForUpdateUserBalance.setBigDecimal(1, money);
                        preparedStatementForUpdateUserBalance.setInt(2, currentUserId);

                        preparedStatementForUpdateUserBalance.execute();
                        //receiver user + money
                        String queryForUpdateReceiverBalance = "UPDATE master_cards\n" +
                                "INNER JOIN users ON master_cards.id = users.id\n" +
                                "SET balance = balance + ?\n" +
                                "WHERE users.iban = ?;";

                        PreparedStatement preparedStatementForUpdateReceiverBalance = connection.prepareStatement(queryForUpdateReceiverBalance);

                        preparedStatementForUpdateReceiverBalance.setBigDecimal(1, money);
                        preparedStatementForUpdateReceiverBalance.setString(2, iban);

                        preparedStatementForUpdateReceiverBalance.execute();
                    }
                }
            }
        }
    }
}