package frontend.panels;

import frontend.controls.FrontEndControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginPanel{

    private static JLabel usernameLabel;
    private static JLabel passwordLabel;
    private static JTextField usernameField;
    private static JTextField passwordField;
    private static JButton loginButton;
    private static JButton registerButton;


    public static void loginFrame(){
        Font customFont = new Font(Font.SERIF, Font.BOLD, 18);
        Font textCustomFont = new Font(Font.SERIF, Font.PLAIN, 16);

        JFrame loginFrame = new JFrame("SmartBanking — Вход");
        JPanel loginPanel = new JPanel();
        loginFrame.setBounds(600,300,400, 250);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.add(loginPanel);
        loginPanel.setLayout(null);
        loginPanel.setBackground(new Color(238, 247, 255));

        usernameLabel = new JLabel("Потребителско име");
        usernameLabel.setBounds(20, 25, 165, 50);
        usernameLabel.setFont(customFont);
        loginPanel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setFont(textCustomFont);
        usernameField.setBounds(200, 40, 165, 30);
        loginPanel.add(usernameField);

        passwordLabel = new JLabel("Парола");
        passwordLabel.setBounds(20, 65, 120, 50);
        passwordLabel.setFont(customFont);
        loginPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(textCustomFont);
        passwordField.setBounds(200, 80, 165, 30);
        loginPanel.add(passwordField);

        loginButton = new JButton("Вход");
        loginButton.setBounds(260, 140, 100, 30);
        loginButton.setBackground(new Color(212, 212, 212));
        loginButton.setFont(customFont);
        loginButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String username = usernameField.getText();
                        String password = passwordField.getText();
                        try {
                            boolean correct = FrontEndControl.loginDataBaseControl(username, password);
                            if(correct){
                                loginFrame.setVisible(false);
                                CoordinationPanel.CoordinationPanel();
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Въвели сте грешно потребителско име или парола!","Грешка",JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }
        );
        loginPanel.add(loginButton);

        registerButton = new JButton("Нова Регистрация");
        registerButton.setBounds(40, 140, 190, 30);
        registerButton.setBackground(new Color(212, 212, 212));
        registerButton.setFont(customFont);
        registerButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        loginFrame.setVisible(false);
                        RegisterPanel.RegisterButtonControl();
                    }
                });
        loginPanel.add(registerButton);

        loginFrame.setVisible(true);
    }
}