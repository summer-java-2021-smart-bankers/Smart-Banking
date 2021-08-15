package frontend.panels;

import javax.swing.*;

public class RegisterPanel {

    public static void RegisterButtonControl(){
        JLabel newUsername;
        JLabel newPassword;
        JLabel emailText;
        JLabel cityText;
        JLabel firstName;
        JLabel lastName;
        JTextField newUsernameField;
        JPasswordField newPassField;
        JTextField emailField;
        JTextField cityField;
        JTextField firstNameField;
        JTextField lastNameField;
        JButton completeRegister;

        JPanel secondPanel = new JPanel();
        JFrame secondFrame = new JFrame();
        secondFrame.setSize(600, 400);
        secondFrame.add(secondPanel);
        secondPanel.setLayout(null);

        newUsername = new JLabel("Username:");
        newUsername.setBounds(20, 20,80,50);
        secondPanel.add(newUsername);

        newPassword = new JLabel("Password:");
        newPassword.setBounds(20, 55,80,50);
        secondPanel.add(newPassword);

        emailText = new JLabel("E-mail:");
        emailText.setBounds(20, 90, 80, 50);
        secondPanel.add(emailText);

        cityText = new JLabel("City: ");
        cityText.setBounds(20, 125, 80, 50);
        secondPanel.add(cityText);

        firstName = new JLabel("First Name:");
        firstName.setBounds(20, 160, 80, 50);
        secondPanel.add(firstName);

        lastName = new JLabel("Last Name:");
        lastName.setBounds(20, 195, 80, 50);
        secondPanel.add(lastName);

        newUsernameField = new JTextField();
        newUsernameField.setBounds(150, 35, 165, 25);
        secondPanel.add(newUsernameField);

        newPassField = new JPasswordField();
        newPassField.setBounds(150, 70, 165, 25);
        secondPanel.add(newPassField);

        emailField = new JTextField();
        emailField.setBounds(150, 105, 165, 25);
        secondPanel.add(emailField);

        cityField = new JTextField();
        cityField.setBounds(150, 140, 165, 25);
        secondPanel.add(cityField);

        firstNameField = new JTextField();
        firstNameField.setBounds(150, 175, 165, 25);
        secondPanel.add(firstNameField);

        lastNameField = new JTextField();
        lastNameField.setBounds(150, 210, 165,25);
        secondPanel.add(lastNameField);

        completeRegister = new JButton("Register");
        completeRegister.setBounds(200, 275, 165, 25);
        secondPanel.add(completeRegister);

        secondFrame.setVisible(true);


    }

}
