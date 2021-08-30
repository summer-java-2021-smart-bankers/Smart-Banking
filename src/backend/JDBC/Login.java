package backend.JDBC;

import backend.users.User;

import java.sql.*;
import java.util.Properties;

public class Login {

    private boolean isCorrectInfo = false;
    private boolean successfulLogin = false;
    private static User user;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Login.user = user;
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

            String queryForInfo = "SELECT * FROM users WHERE username = ?";

            PreparedStatement statementGetInfo = connection.prepareStatement(queryForInfo);

            statementGetInfo.setString(1,username);

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

            user = new User();

            user.logUser(username, password, userMail, userCity, userFirstName, userLastName);

            setSuccessfulLogin(true);
        }
    }

}
