package frontend.panels;

import javax.swing.*;
import java.awt.*;

public class ContactsPanel {

    private static JLabel contacts;
    private static JLabel timeShift;
    private static JLabel shiftHours;
    private static JLabel contactNumber;
    private static JLabel contactNumA1;
    private static JLabel cNumDataA1;
    private static JLabel contactNumTelenor;
    private static JLabel cNumDataTelenor;
    private static JLabel contactNumViva;
    private static JLabel cNumDataViva;
    private static JLabel contactNumRoaming;
    private static JLabel cNumDataRoaming;
    private static JLabel contactEmailLabel;
    private static JLabel contactEmail;
    private static JLabel centralOfficeLabel;
    private static JLabel centralOfficeAddress;


    public static void Contacts(){

        Font customFont = new Font(Font.SERIF, Font.ITALIC, 18);

        JFrame contactsFrame = new JFrame("Smart Banking — Contacts");
        JPanel contactsPanel = new JPanel();
        contactsFrame.setSize(580, 400);
        contactsFrame.add(contactsPanel);
        contactsPanel.setLayout(null);
        contactsPanel.setBackground(new Color(146, 207, 242));

        contacts = new JLabel("Контакти");
        contacts.setBounds(245, 10 , 800, 50);
        contacts.setFont(customFont);
        contactsPanel.add(contacts);

        timeShift = new JLabel("Работно Време:");
        timeShift.setBounds(65, 50, 250, 50);
        timeShift.setFont(customFont);
        contactsPanel.add(timeShift);

        contactEmailLabel = new JLabel("E-mail:");
        contactEmailLabel.setBounds(65, 80, 250, 50);
        contactEmailLabel.setFont(customFont);
        contactsPanel.add(contactEmailLabel);

        centralOfficeLabel = new JLabel("Адрес на централен офис:");
        centralOfficeLabel.setBounds(65, 110, 250, 50);
        centralOfficeLabel.setFont(customFont);
        contactsPanel.add(centralOfficeLabel);

        contactNumber = new JLabel("Номера за контакт");
        contactNumber.setBounds(200, 170, 250, 50);
        contactNumber.setFont(customFont);
        contactsPanel.add(contactNumber);

        contactNumA1 = new JLabel("През оператор на А1:");
        contactNumA1.setBounds(65, 200, 250, 50);
        contactNumA1.setFont(customFont);
        contactsPanel.add(contactNumA1);

        contactNumTelenor = new JLabel("През оператор на Теленор:");
        contactNumTelenor.setBounds(65, 230, 250, 50);
        contactNumTelenor.setFont(customFont);
        contactsPanel.add(contactNumTelenor);

        contactNumViva = new JLabel("През оператор на Виваком:");
        contactNumViva.setBounds(65, 260, 250, 50);
        contactNumViva.setFont(customFont);
        contactsPanel.add(contactNumViva);

        contactNumRoaming = new JLabel("Международен номер:");
        contactNumRoaming.setBounds(65, 290, 250, 50);
        contactNumRoaming.setFont(customFont);
        contactsPanel.add(contactNumRoaming);

        shiftHours = new JLabel("9:00 - 18:30");
        shiftHours.setBounds(340, 50, 250, 50);
        shiftHours.setFont(customFont);
        contactsPanel.add(shiftHours);

        contactEmail = new JLabel("smartbankers@smb.com");
        contactEmail.setBounds(340, 80, 250, 50);
        contactEmail.setFont(customFont);
        contactsPanel.add(contactEmail);

        centralOfficeAddress = new JLabel("гр. София, ул. Раковска 63");
        centralOfficeAddress.setBounds(340, 110, 250, 50);
        centralOfficeAddress.setFont(customFont);
        contactsPanel.add(centralOfficeAddress);

        cNumDataA1 = new JLabel("+359882465882");
        cNumDataA1.setBounds(340, 200, 250, 50);
        cNumDataA1.setFont(customFont);
        contactsPanel.add(cNumDataA1);

        cNumDataTelenor = new JLabel("+359892465882");
        cNumDataTelenor.setBounds(340, 230, 250, 50);
        cNumDataTelenor.setFont(customFont);
        contactsPanel.add(cNumDataTelenor);

        cNumDataViva = new JLabel("+359872465882");
        cNumDataViva.setBounds(340, 260, 250, 50);
        cNumDataViva.setFont(customFont);
        contactsPanel.add(cNumDataViva);

        cNumDataRoaming = new JLabel("+02666042");
        cNumDataRoaming.setBounds(340, 290, 250, 50);
        cNumDataRoaming.setFont(customFont);
        contactsPanel.add(cNumDataRoaming);


        contactsFrame.setVisible(true);
    }
}
