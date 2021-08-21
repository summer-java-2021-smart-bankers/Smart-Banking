package frontend.controls;

import backend.JDBC.Register;
import frontend.panels.LoginPanel;

import java.sql.SQLException;

public class FrontEndControl {

    public static void FrontEndControl(){
        LoginPanel.loginFrame();
    }

    public static void RegisterDataBaseControl(String username, String password, String email, String city, String firstName, String lastName) throws SQLException {
                Register register = new Register();
                register.setConnection();
                register.register(username, password, email, city, firstName, lastName);
                LoginPanel.loginFrame();
    }



}
