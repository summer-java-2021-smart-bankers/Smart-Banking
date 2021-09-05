package frontend.controls;

import backend.JDBC.Login;
import backend.JDBC.Register;
import frontend.panels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

public class FrontEndControl {

    public static void run(){
        //CoordinationPanel.CoordinationPanel();
        LoginPanel.loginFrame();

    }

    public static void RegisterDataBaseControl(String username, String password, String email, String city, String firstName, String lastName) throws SQLException {
        System.out.println("YES");
        Register register = new Register();
        register.setConnection();
        register.register(username, password, email, city, firstName, lastName);
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
