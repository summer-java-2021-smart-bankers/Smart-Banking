package frontend.panels;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditLimitPanel {

    private static JLabel creditCard;
    private static JLabel limitWithdraw;
    private static JLabel limitPay;
    private static JLabel limitWithdrawValue;
    private static JLabel limitPayValue;
    private static JTextField newWithdrawLimit;
    private static JTextField newPayLimit;
    private static JLabel limitWithdrawCurrency;
    private static JLabel limitPayCurrency;
    private static JButton updateLimit;

    public static void CreditLimit(){

        Font customFont = new Font(Font.SERIF, Font.ITALIC, 18);

        JFrame creditLimitFrame = new JFrame("Smart Banking — Credit Card Control");
        JPanel creditLimitPanel = new JPanel();
        creditLimitFrame.setSize(580, 330);
        creditLimitFrame.add(creditLimitPanel);
        creditLimitPanel.setLayout(null);
        creditLimitPanel.setBackground(new Color(146, 207, 242));


        creditCard = new JLabel("Credit Card");
        creditCard.setBounds(250, 10 , 800, 50);
        creditCard.setFont(customFont);
        creditLimitPanel.add(creditCard);

        limitWithdraw = new JLabel("Лимит на теглене");
        limitWithdraw.setBounds(50,100, 180, 30);
        limitWithdraw.setFont(customFont);
        creditLimitPanel.add(limitWithdraw);

        limitPay = new JLabel("Лимит на плащане");
        limitPay.setBounds(50,150, 180, 30);
        limitPay.setFont(customFont);
        creditLimitPanel.add(limitPay);

        limitWithdrawValue = new JLabel("3000");
        limitWithdrawValue.setBounds(230, 100, 100, 30);
        limitWithdrawValue.setFont(customFont);
        creditLimitPanel.add(limitWithdrawValue);

        limitPayValue = new JLabel("3000");
        limitPayValue.setBounds(230, 150, 100, 30);
        limitPayValue.setFont(customFont);
        creditLimitPanel.add(limitPayValue);

        newWithdrawLimit = new JTextField();
        newWithdrawLimit.setBounds(310, 100, 150, 30);
        newWithdrawLimit.setFont(customFont);
        creditLimitPanel.add(newWithdrawLimit);

        newPayLimit = new JTextField();
        newPayLimit.setBounds(310, 150, 150, 30);
        newPayLimit.setFont(customFont);
        creditLimitPanel.add(newPayLimit);

        limitWithdrawCurrency = new JLabel("BGN");
        limitWithdrawCurrency.setBounds(480, 100, 100, 30);
        limitWithdrawCurrency.setFont(customFont);
        creditLimitPanel.add(limitWithdrawCurrency);

        limitPayCurrency = new JLabel("BGN");
        limitPayCurrency.setBounds(480, 150, 100, 30);
        limitPayCurrency.setFont(customFont);
        creditLimitPanel.add(limitPayCurrency);

        updateLimit = new JButton("Обнови лимита");
        updateLimit.setBounds(180, 220, 200, 40);
        updateLimit.setFont(customFont);
        creditLimitPanel.add(updateLimit);

        creditLimitFrame.setVisible(true);

    }
}
