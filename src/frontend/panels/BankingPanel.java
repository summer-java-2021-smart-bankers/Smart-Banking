package frontend.panels;

import backend.JDBC.Login;
import backend.users.User;
import backend.users.UserController;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankingPanel {

    private static JLabel totalFundsLabel;
    private static JButton masterCardButton;
    private static JButton visaCardButton;
    private static JButton creditCardButton;

    private static JLabel totalBalanceLabel;
    private static JLabel mCBalanceLabel;
    private static JLabel vBalanceLabel;
    private static JLabel cCBalanceLabel;
    private static JLabel totalCurrencyLabel;
    private static JLabel mCCurrencyLabel;
    private static JLabel vCurrencyLabel;
    private static JLabel cCCurrencyLabel;

    private static JButton transferButton;
    private static JButton currencyCalculatorButton;

    private static JLabel addressTextLabel;
    private static JComboBox bankAddressBox;

    private static JButton logoutButton;

    private static UserController user = new UserController();

    public static void BankingPanel(){

        //Font welcomeMessageFont = new Font(Font.SERIF, Font.ITALIC, 18);
        Font customFont = new Font(Font.SERIF, Font.ITALIC, 18);
        Border blackLine = BorderFactory.createLineBorder(Color.BLACK);

        JFrame mainProgramFrame = new JFrame("Smart Banking — User Interface");
        JPanel mainProgramPanel = new JPanel();
        mainProgramFrame.setSize(670, 555);
        mainProgramFrame.add(mainProgramPanel);
        mainProgramPanel.setLayout(null);
        mainProgramPanel.setBackground(new Color(146, 207, 242));

        JLabel welcomeMessage = new JLabel("Welcome to Smart Banking", SwingConstants.LEFT);
        welcomeMessage.setBounds(10, 10, 250, 30);
        welcomeMessage.setFont(customFont);
        mainProgramPanel.add(welcomeMessage);

        JLabel clientName = new JLabel( user.getUser().getFirstName()+ " " + user.getUser().getLastName() , SwingConstants.RIGHT);
        clientName.setBounds(390, 10, 250, 30);
        clientName.setFont(customFont);
        mainProgramPanel.add(clientName);

        totalFundsLabel = new JLabel("Обща разполагаемост");
        totalFundsLabel.setBounds(70, 80, 250, 30);
        totalFundsLabel.setFont(customFont);
        mainProgramPanel.add(totalFundsLabel);

        masterCardButton = new JButton("MasterCard");
        masterCardButton.setBounds(70, 130, 180, 30);
        masterCardButton.setFont(customFont);
        mainProgramPanel.add(masterCardButton);
        masterCardButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        MasterCardLimitPanel.MasterCardLimit();
                    }
                }
        );

        visaCardButton = new JButton("Visa Classic");
        visaCardButton.setBounds(70, 180, 180, 30);
        visaCardButton.setFont(customFont);
        mainProgramPanel.add(visaCardButton);
        visaCardButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        VisaLimitPanel.VisaLimit();
                    }
                }
        );

        creditCardButton = new JButton("Credit Card");
        creditCardButton.setBounds(70, 230, 180, 30);
        creditCardButton.setFont(customFont);
        mainProgramPanel.add(creditCardButton);
        creditCardButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CreditLimitPanel.CreditLimit();
                    }
                }
        );


        mCBalanceLabel = new JLabel(String.valueOf(user.getUser().getMasterCard().getBalance()), SwingConstants.CENTER);
        mCBalanceLabel.setBounds(290, 130, 180, 30);
        mCBalanceLabel.setBorder(blackLine);
        mCBalanceLabel.setOpaque(true);
        mCBalanceLabel.setBackground(Color.white);
        mCBalanceLabel.setFont(customFont);
        mainProgramPanel.add(mCBalanceLabel);

        mCCurrencyLabel = new JLabel("BGN", SwingConstants.CENTER);
        mCCurrencyLabel.setBounds(490, 130, 100, 30);
        mCCurrencyLabel.setBorder(blackLine);
        mCCurrencyLabel.setOpaque(true);
        mCCurrencyLabel.setBackground(Color.white);
        mCCurrencyLabel.setFont(customFont);
        mainProgramPanel.add(mCCurrencyLabel);

        vBalanceLabel = new JLabel(String.valueOf(user.getUser().getVisa().getBalance()), SwingConstants.CENTER);
        vBalanceLabel.setBounds(290, 180, 180, 30);
        vBalanceLabel.setBorder(blackLine);
        vBalanceLabel.setOpaque(true);
        vBalanceLabel.setBackground(Color.white);
        vBalanceLabel.setFont(customFont);
        mainProgramPanel.add(vBalanceLabel);

        vCurrencyLabel = new JLabel("BGN", SwingConstants.CENTER);
        vCurrencyLabel.setBounds(490, 180, 100, 30);
        vCurrencyLabel.setBorder(blackLine);
        vCurrencyLabel.setOpaque(true);
        vCurrencyLabel.setBackground(Color.white);
        vCurrencyLabel.setFont(customFont);
        mainProgramPanel.add(vCurrencyLabel);

        cCBalanceLabel = new JLabel(String.valueOf(user.getUser().getCredit().getBalance()), SwingConstants.CENTER);
        cCBalanceLabel.setBounds(290, 230, 180, 30);
        cCBalanceLabel.setBorder(blackLine);
        cCBalanceLabel.setOpaque(true);
        cCBalanceLabel.setBackground(Color.white);
        cCBalanceLabel.setFont(customFont);
        mainProgramPanel.add(cCBalanceLabel);

        cCCurrencyLabel = new JLabel("BGN", SwingConstants.CENTER);
        cCCurrencyLabel.setBounds(490, 230, 100, 30);
        cCCurrencyLabel.setBorder(blackLine);
        cCCurrencyLabel.setOpaque(true);
        cCCurrencyLabel.setBackground(Color.white);
        cCCurrencyLabel.setFont(customFont);
        mainProgramPanel.add(cCCurrencyLabel);


        String mc = mCBalanceLabel.getText();
        String visaClassic = vBalanceLabel.getText();
        String cc = cCBalanceLabel.getText();

        int masterCardCurrency = Integer.parseInt(mc);
        int visaCurrency = Integer.parseInt(visaClassic);
        int creditCardCurrency = Integer.parseInt(cc);
        int total = masterCardCurrency + visaCurrency + creditCardCurrency;

        totalBalanceLabel = new JLabel(String.valueOf(total), SwingConstants.CENTER);
        totalBalanceLabel.setBounds(290, 80, 180, 30);
        totalBalanceLabel.setBorder(blackLine);
        totalBalanceLabel.setOpaque(true);
        totalBalanceLabel.setBackground(Color.white);
        totalBalanceLabel.setFont(customFont);
        mainProgramPanel.add(totalBalanceLabel);

        totalCurrencyLabel = new JLabel("BGN", SwingConstants.CENTER);
        totalCurrencyLabel.setBounds(490, 80, 100, 30);
        totalCurrencyLabel.setBorder(blackLine);
        totalCurrencyLabel.setOpaque(true);
        totalCurrencyLabel.setBackground(Color.white);
        totalCurrencyLabel.setFont(customFont);
        mainProgramPanel.add(totalCurrencyLabel);

        transferButton = new JButton("Нов превод");
        transferButton.setBounds(70, 300, 200, 40);
        transferButton.setFont(customFont);
        mainProgramPanel.add(transferButton);
        transferButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        TransferPanel.Transfer();
                    }
                }
        );


        currencyCalculatorButton = new JButton("Валутен калкулатор");
        currencyCalculatorButton.setBounds(390, 300, 200, 40);
        currencyCalculatorButton.setFont(customFont);
        mainProgramPanel.add(currencyCalculatorButton);
        currencyCalculatorButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CurrencyCalculatorPanel.CurrencyCalculatorFrame();
                    }
                }
        );


        addressTextLabel = new JLabel("Адреси на клонове на банката");
        addressTextLabel.setBounds(200, 370, 300, 30);
        addressTextLabel.setFont(customFont);
        mainProgramPanel.add(addressTextLabel);

        String cities[] = {" ", "Бургас", "Варна", "Пловдив", "Русе", "София", "Стара Загора"};
        bankAddressBox = new JComboBox(cities);
        bankAddressBox.setBounds(200, 400,240, 30);
        mainProgramPanel.add(bankAddressBox);

        logoutButton = new JButton("Log out");
        logoutButton.setBounds(510, 470, 125, 30);
        logoutButton.setFont(customFont);
        mainProgramPanel.add(logoutButton);
        logoutButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        LoginPanel.loginFrame();
                        mainProgramFrame.setVisible(false);
                    }
                }
        );

        mainProgramFrame.setVisible(true);

    }
}
