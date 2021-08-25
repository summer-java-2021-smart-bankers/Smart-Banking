package frontend.panels;

import frontend.controls.FrontEndControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RegisterPanel implements ActionListener {

    public static Component RegisterButtonControl(){
        JLabel newUsernameLabel;
        JLabel newPasswordLabel;
        JLabel emailTextLabel;
        JLabel cityTextLabel;
        JLabel firstNameLabel;
        JLabel lastNameLabel;

        JTextField newUsernameField;
        JPasswordField newPasswordField;
        JTextField emailField;
        JTextField firstNameField;
        JTextField lastNameField;

        JButton completeRegisterButton;

        Font customFont = new Font(Font.SERIF, Font.ITALIC, 15);

        JFrame registerFrame = new JFrame("Smart Banking — Register");
        JPanel registerPanel = new JPanel();
        registerFrame.setSize(350, 350);
        registerFrame.add(registerPanel);
        registerPanel.setLayout(null);
        registerPanel.setBackground(new Color(146, 207, 242));

        newUsernameLabel = new JLabel("Username:");
        newUsernameLabel.setBounds(20, 20,80,50);
        newUsernameLabel.setFont(customFont);
        registerPanel.add(newUsernameLabel);

        newPasswordLabel = new JLabel("Password:");
        newPasswordLabel.setBounds(20, 55,80,50);
        newPasswordLabel.setFont(customFont);
        registerPanel.add(newPasswordLabel);

        emailTextLabel = new JLabel("E-mail:");
        emailTextLabel.setBounds(20, 90, 80, 50);
        emailTextLabel.setFont(customFont);
        registerPanel.add(emailTextLabel);

        cityTextLabel = new JLabel("City: ");
        cityTextLabel.setBounds(20, 125, 80, 50);
        cityTextLabel.setFont(customFont);
        registerPanel.add(cityTextLabel);

        firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(20, 160, 80, 50);
        firstNameLabel.setFont(customFont);
        registerPanel.add(firstNameLabel);

        lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(20, 195, 80, 50);
        lastNameLabel.setFont(customFont);
        registerPanel.add(lastNameLabel);

        newUsernameField = new JTextField();
        newUsernameField.setBounds(150, 35, 165, 25);
        registerPanel.add(newUsernameField);

        newPasswordField = new JPasswordField();
        newPasswordField.setBounds(150, 70, 165, 25);
        registerPanel.add(newPasswordField);

        emailField = new JTextField();
        emailField.setBounds(150, 105, 165, 25);
        registerPanel.add(emailField);

        String[] city = { "","София", "Пловдив", "Варна", "Бургас", "Плевен", "Ловеч", "Стара Загора", "Видин",
                                "Сандански", "Пазарджик", "Русе"};
        JComboBox cityBox = new JComboBox(city);
        cityBox.setBounds(150, 140, 165, 25);
        registerPanel.add(cityBox);

        firstNameField = new JTextField();
        firstNameField.setBounds(150, 175, 165, 25);
        registerPanel.add(firstNameField);

        lastNameField = new JTextField();
        lastNameField.setBounds(150, 210, 165,25);
        registerPanel.add(lastNameField);

        completeRegisterButton = new JButton("Register");
        completeRegisterButton.setBounds(100, 260, 150, 25);
        completeRegisterButton.setBackground(new Color(212, 212, 212));
        completeRegisterButton.setFont(customFont);
        completeRegisterButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String username = newUsernameField.getText();
                        String password = String.valueOf(newPasswordField.getPassword());
                        String email = emailField.getText();
                        String city = cityBox.getSelectedItem().toString();
                        String firstName = firstNameField.getText();
                        String lastName = lastNameField.getText();

                        if(username.equals("") || password.equals("") || email.equals("") || city.equals("") || firstName.equals("") || lastName.equals("")){
                            JOptionPane.showMessageDialog(null, "You have missed information","Warning",JOptionPane.WARNING_MESSAGE);
                        }
                        else{
                            try {
                                FrontEndControl.RegisterDataBaseControl(username, password, email, city, firstName, lastName);
                                FrontEndControl.registerDataBaseControl(username, password, email, city, firstName, lastName);
                                registerFrame.setVisible(false);
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        }
                    }
                });
        registerPanel.add(completeRegisterButton);

        registerFrame.setVisible(true);


        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
