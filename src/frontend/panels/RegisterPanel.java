package frontend.panels;

import frontend.controls.FrontEndControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RegisterPanel{

    public static void RegisterButtonControl(){
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

        Font customFont = new Font(Font.SERIF, Font.BOLD, 18);
        Font textCustomFont = new Font(Font.SERIF, Font.PLAIN, 16);

        JFrame registerFrame = new JFrame("SmartBanking — Нова регистрация");
        JPanel registerPanel = new JPanel();
        registerFrame.setBounds(600,300,390, 350);
        registerFrame.add(registerPanel);
        registerPanel.setLayout(null);
        registerPanel.setBackground(new Color(238, 247, 255));

        newUsernameLabel = new JLabel("Потребителско име");
        newUsernameLabel.setBounds(20, 20,165,50);
        newUsernameLabel.setFont(customFont);
        registerPanel.add(newUsernameLabel);

        newPasswordLabel = new JLabel("Парола");
        newPasswordLabel.setBounds(20, 55,120,50);
        newPasswordLabel.setFont(customFont);
        registerPanel.add(newPasswordLabel);

        emailTextLabel = new JLabel("E-mail");
        emailTextLabel.setBounds(20, 90, 120, 50);
        emailTextLabel.setFont(customFont);
        registerPanel.add(emailTextLabel);

        cityTextLabel = new JLabel("Град");
        cityTextLabel.setBounds(20, 125, 120, 50);
        cityTextLabel.setFont(customFont);
        registerPanel.add(cityTextLabel);

        firstNameLabel = new JLabel("Име");
        firstNameLabel.setBounds(20, 160, 120, 50);
        firstNameLabel.setFont(customFont);
        registerPanel.add(firstNameLabel);

        lastNameLabel = new JLabel("Фамилия");
        lastNameLabel.setBounds(20, 195, 120, 50);
        lastNameLabel.setFont(customFont);
        registerPanel.add(lastNameLabel);

        newUsernameField = new JTextField();
        newUsernameField.setFont(textCustomFont);
        newUsernameField.setBounds(200, 35, 165, 25);
        registerPanel.add(newUsernameField);

        newPasswordField = new JPasswordField();
        newPasswordField.setFont(textCustomFont);
        newPasswordField.setBounds(200, 70, 165, 25);
        registerPanel.add(newPasswordField);

        emailField = new JTextField();
        emailField.setFont(textCustomFont);
        emailField.setBounds(200, 105, 165, 25);
        registerPanel.add(emailField);

        String[] city = { "","София", "Пловдив", "Варна", "Бургас", "Плевен", "Ловеч", "Стара Загора", "Видин",
                "Сандански", "Пазарджик", "Русе"};
        JComboBox cityBox = new JComboBox(city);
        cityBox.setFont(textCustomFont);
        cityBox.setBounds(200, 140, 165, 25);
        registerPanel.add(cityBox);

        firstNameField = new JTextField();
        firstNameField.setFont(textCustomFont);
        firstNameField.setBounds(200, 175, 165, 25);
        registerPanel.add(firstNameField);

        lastNameField = new JTextField();
        lastNameField.setFont(textCustomFont);
        lastNameField.setBounds(200, 210, 165,25);
        registerPanel.add(lastNameField);

        completeRegisterButton = new JButton("Регистрация");
        completeRegisterButton.setBounds(100, 260, 150, 30);
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
                            JOptionPane.showMessageDialog(null, "Имате непопълнени полета!","Внимание",JOptionPane.WARNING_MESSAGE);
                        }
                        else{
                            try {
                                FrontEndControl.RegisterDataBaseControl(username, password, email, city, firstName, lastName);
                                registerFrame.setVisible(false);
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        }
                    }
                });
        registerPanel.add(completeRegisterButton);

        registerFrame.setVisible(true);

    }
}