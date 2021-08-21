package frontend.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel implements ActionListener {

    private static JLabel usernameLabel;
    private static JLabel passwordLabel;
    private static JTextField usernameField;
    private static JTextField passwordField;
    private static JButton loginButton;
    private static JButton registerButton;


    public static Component loginFrame(){
        Font customFont = new Font(Font.SERIF, Font.ITALIC, 15);

        JFrame loginFrame = new JFrame("Smart Banking");
        JPanel loginPanel = new JPanel();
        loginFrame.setSize(330, 200);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.add(loginPanel);
        loginPanel.setLayout(null);
        loginPanel.setBackground(new Color(146, 207, 242));


        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(20, 25, 80, 50);
        usernameLabel.setFont(customFont);
        loginPanel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(100, 40, 165, 25);
        loginPanel.add(usernameField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 60, 80, 50);
        passwordLabel.setFont(customFont);
        loginPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 75, 165, 25);
        loginPanel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(200, 110, 100, 25);
        loginButton.setBackground(new Color(212, 212, 212));
        loginButton.setFont(customFont);
        loginButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String user = usernameField.getText();
                        String pass = passwordField.getText();

                        if(user.equals("login") && pass.equals("login")){
                            loginFrame.setVisible(false);
                            BankingPanel.BankingPanel();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "You have entered an invalid username or password","Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
        );
        loginPanel.add(loginButton);

        registerButton = new JButton("New Registration");
        registerButton.setBounds(20, 110, 150, 25);
        registerButton.setBackground(new Color(212, 212, 212));
        registerButton.setFont(customFont);
        registerButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        RegisterPanel.RegisterButtonControl();
                    }
                });
        loginPanel.add(registerButton);


        loginFrame.setVisible(true);
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

