package backend.JDBC;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Login {

    private boolean isCorrectInfo = false;

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

        String queryForNameAndPass = "SELECT u.username, u.password FROM users_info AS u";

        PreparedStatement StatementGetName = connection.prepareStatement(queryForNameAndPass);

        ResultSet resultSetNames = StatementGetName.executeQuery();

        while (resultSetNames.next()) {
            if (resultSetNames.getString("username").equals(username)
                    && resultSetNames.getString("password").equals(password)) {
                setCorrectInfo(true);
            }
        }
    }

}
