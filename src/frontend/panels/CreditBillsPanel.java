package frontend.panels;

import backend.JDBC.Login;
import backend.users.User;
import backend.users.UserController;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditBillsPanel {

    private static JLabel totalFundsLabel;

    private static JLabel allBalanceLabel;
    private static JLabel mCBalanceLabel;
    private static JLabel allCurrencyLabel;

    private static JButton logoutButton;

    private static UserController user = new UserController();

    public static void CreditBillsPanel(){

        Font customFont = new Font(Font.SERIF, Font.BOLD, 18);
        Border blackLine = BorderFactory.createLineBorder(Color.BLACK);

        JFrame mainProgramFrame = new JFrame("SmartBanking — Кредитно състояние");
        JPanel mainProgramPanel = new JPanel();
        mainProgramFrame.setSize(670, 555);
        mainProgramFrame.setBounds(500,200,670, 290);
        mainProgramFrame.add(mainProgramPanel);
        mainProgramPanel.setLayout(null);
        mainProgramPanel.setBackground(new Color(238, 247, 255));


        totalFundsLabel = new JLabel("Credit Card");
        totalFundsLabel.setBounds(70, 40, 250, 30);
        totalFundsLabel.setFont(customFont);
        mainProgramPanel.add(totalFundsLabel);

        totalFundsLabel = new JLabel("Вашите кредити");
        totalFundsLabel.setBounds(70, 120, 180, 30);
        totalFundsLabel.setFont(customFont);
        mainProgramPanel.add(totalFundsLabel);


        allBalanceLabel = new JLabel(String.valueOf(user.getUser().getCredit().getBalance()), SwingConstants.CENTER);
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


        mCBalanceLabel = new JLabel("Няма наличен изтеглен кредит", SwingConstants.CENTER);
        mCBalanceLabel.setBounds(290, 120, 300, 30);
        mCBalanceLabel.setBorder(blackLine);
        mCBalanceLabel.setOpaque(true);
        mCBalanceLabel.setBackground(Color.white);
        mCBalanceLabel.setFont(customFont);
        mainProgramPanel.add(mCBalanceLabel);


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