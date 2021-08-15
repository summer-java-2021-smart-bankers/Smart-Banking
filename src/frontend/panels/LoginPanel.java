package frontend.panels;

import frontend.controls.LoginControl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel implements ActionListener {

    private static JLabel usernameLabel;
    private static JLabel passwordLabel;
    private static JTextField usernameField;
    private static JTextField passwordField;
    private static JButton login;
    private static JButton register;
    private static JLabel loginStatus;

    public static void loginFrame(){
        JPanel loginPanel = new JPanel();
        JFrame loginFrame = new JFrame();
        loginFrame.setSize(400, 250);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.add(loginPanel);
        loginPanel.setLayout(null);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(20, 25, 80, 50);
        loginPanel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(100, 40, 165, 25);
        loginPanel.add(usernameField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 60, 80, 50);
        loginPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 75, 165, 25);
        loginPanel.add(passwordField);


        login = new JButton("Login");
        login.setBounds(185, 110, 100, 25);
        login.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String user = usernameField.getText();
                        String pass = passwordField.getText();
                        LoginControl.LoginButtonControl(user, pass);
                    }
                }
        );
        loginPanel.add(login);

        register = new JButton("Register");
        register.setBounds(40, 110, 100, 25);
        register.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        RegisterPanel.RegisterButtonControl();
                    }
                });
        loginPanel.add(register);

        loginStatus = new JLabel("");
        loginStatus.setBounds(20, 130, 300, 25);
        loginPanel.add(loginStatus);

        loginFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

