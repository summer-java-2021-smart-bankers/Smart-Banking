package frontend.panels;


import backend.users.UserController;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainBillsPanel {

    private static JLabel totalFundsLabel;

    private static JLabel allBalanceLabel;
    private static JLabel mCBalanceLabel;
    private static JLabel vBalanceLabel;


    private static JLabel allCurrencyLabel;
    private static JLabel mCCurrencyLabel;
    private static JLabel vCurrencyLabel;

    private static JButton logoutButton;

    private static UserController user = new UserController();

    public static void MainBillsPanel(){

        Font customFont = new Font(Font.SERIF, Font.BOLD, 18);
        Border blackLine = BorderFactory.createLineBorder(Color.BLACK);

        JFrame mainProgramFrame = new JFrame("SmartBanking — Наличност по сметка");
        JPanel mainProgramPanel = new JPanel();
        mainProgramFrame.setSize(670, 555);
        mainProgramFrame.setBounds(500,200,670, 290);
        mainProgramFrame.add(mainProgramPanel);
        mainProgramPanel.setLayout(null);
        mainProgramPanel.setBackground(new Color(238, 247, 255));


        totalFundsLabel = new JLabel("Обща разполагаемост");
        totalFundsLabel.setBounds(70, 40, 250, 30);
        totalFundsLabel.setFont(customFont);
        mainProgramPanel.add(totalFundsLabel);

        totalFundsLabel = new JLabel("MasterCard");
        totalFundsLabel.setBounds(70, 90, 180, 30);
        totalFundsLabel.setFont(customFont);
        mainProgramPanel.add(totalFundsLabel);

        totalFundsLabel = new JLabel("Visa Classic");
        totalFundsLabel.setBounds(70, 140, 180, 30);
        totalFundsLabel.setFont(customFont);
        mainProgramPanel.add(totalFundsLabel);

        mCBalanceLabel = new JLabel(String.valueOf(user.getUser().getMasterCard().getBalance()), SwingConstants.CENTER);
        mCBalanceLabel.setBounds(290, 90, 180, 30);
        mCBalanceLabel.setBorder(blackLine);
        mCBalanceLabel.setOpaque(true);
        mCBalanceLabel.setBackground(Color.white);
        mCBalanceLabel.setFont(customFont);
        mainProgramPanel.add(mCBalanceLabel);

        mCCurrencyLabel = new JLabel("BGN", SwingConstants.CENTER);
        mCCurrencyLabel.setBounds(490, 90, 100, 30);
        mCCurrencyLabel.setBorder(blackLine);
        mCCurrencyLabel.setOpaque(true);
        mCCurrencyLabel.setBackground(Color.white);
        mCCurrencyLabel.setFont(customFont);
        mainProgramPanel.add(mCCurrencyLabel);

        vBalanceLabel = new JLabel(String.valueOf(user.getUser().getVisa().getBalance()), SwingConstants.CENTER);
        vBalanceLabel.setBounds(290, 140, 180, 30);
        vBalanceLabel.setBorder(blackLine);
        vBalanceLabel.setOpaque(true);
        vBalanceLabel.setBackground(Color.white);
        vBalanceLabel.setFont(customFont);
        mainProgramPanel.add(vBalanceLabel);

        vCurrencyLabel = new JLabel("BGN", SwingConstants.CENTER);
        vCurrencyLabel.setBounds(490, 140, 100, 30);
        vCurrencyLabel.setBorder(blackLine);
        vCurrencyLabel.setOpaque(true);
        vCurrencyLabel.setBackground(Color.white);
        vCurrencyLabel.setFont(customFont);
        mainProgramPanel.add(vCurrencyLabel);

        String mc = mCBalanceLabel.getText();
        String visaClassic = vBalanceLabel.getText();

        int masterCardCurrency = Integer.parseInt(mc);
        int visaCurrency = Integer.parseInt(visaClassic);
        int total = masterCardCurrency + visaCurrency;

        allBalanceLabel = new JLabel(String.valueOf(total), SwingConstants.CENTER);
        allBalanceLabel.setBounds(290, 40, 180, 30);
        allBalanceLabel.setBorder(blackLine);
        allBalanceLabel.setOpaque(true);
        allBalanceLabel.setBackground(Color.white);
        allBalanceLabel.setFont(customFont);
        mainProgramPanel.add(allBalanceLabel);

        allCurrencyLabel = new JLabel("BGN", SwingConstants.CENTER);
        allCurrencyLabel.setBounds(490, 40, 100, 30);
        allCurrencyLabel.setBorder(blackLine);
        allCurrencyLabel.setOpaque(true);
        allCurrencyLabel.setBackground(Color.white);
        allCurrencyLabel.setFont(customFont);
        mainProgramPanel.add(allCurrencyLabel);

        logoutButton = new JButton("Изход");
        logoutButton.setBounds(540, 210, 100, 30);
        logoutButton.setBackground(new Color(212, 212, 212));
        logoutButton.setFont(customFont);
        mainProgramPanel.add(logoutButton);
        logoutButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mainProgramFrame.setVisible(false);
                        CoordinationPanel.CoordinationPanel();
                    }
                }
        );
        mainProgramFrame.setVisible(true);
    }
}