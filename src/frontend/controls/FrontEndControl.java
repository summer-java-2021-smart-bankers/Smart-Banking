package frontend.controls;

import backend.JDBC.Login;
import backend.JDBC.Register;
import frontend.panels.LoginPanel;

import java.sql.SQLException;

public class FrontEndControl {

    public static void FrontEndControl() {
        LoginPanel.loginFrame();
    }

    public static void registerDataBaseControl(String username, String password, String email, String city, String firstName, String lastName) throws SQLException {
        Register register = new Register();
        register.setConnection();
        register.register(username, password, email, city, firstName, lastName);
    }

    public static boolean loginDataBaseControl(String username, String password) throws SQLException {
        Login login = new Login();
        login.setConnection();
        login.login(username, password);
        boolean correctLogin = login.isCorrectInfo();

        return correctLogin;
    }


}
