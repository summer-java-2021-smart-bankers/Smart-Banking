package backend.JDBC;

import java.sql.*;
import java.util.Properties;

public class Register {

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

    public void register(String username, String password, String email, String city, String firstName, String lastName) throws SQLException {
        String query = "INSERT INTO users_info (username, password, `e-mail`, city, `first name`, `last name`)\n" +
                "values (?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement =connection.prepareStatement(query);

        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);
        preparedStatement.setString(3,email);
        preparedStatement.setString(4,city);
        preparedStatement.setString(5,firstName);
        preparedStatement.setString(6,lastName);

        preparedStatement.execute();

    }




}
