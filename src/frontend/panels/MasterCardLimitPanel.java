package frontend.panels;

import backend.JDBC.Login;
import backend.users.User;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class MasterCardLimitPanel {

    private static JLabel masterCard;
    private static JLabel limitWithdraw;
    private static JLabel limitPay;
    private static JLabel limitWithdrawValue;
    private static JLabel limitPayValue;
    private static JTextField newWithdrawLimit;
    private static JTextField newPayLimit;
    private static JLabel limitWithdrawCurrency;
    private static JLabel limitPayCurrency;
    private static JButton updateLimit;

    private static User user = new User();

    public static void MasterCardLimit(){

        user = Login.getUser();

        Font customFont = new Font(Font.SERIF, Font.ITALIC, 18);

        JFrame mastercardLimitFrame = new JFrame("Smart Banking — MasterCard Control");
        JPanel mastercardLimitPanel = new JPanel();
        mastercardLimitFrame.setSize(580, 330);
        mastercardLimitFrame.add(mastercardLimitPanel);
        mastercardLimitPanel.setLayout(null);
        mastercardLimitPanel.setBackground(new Color(146, 207, 242));


        masterCard = new JLabel("MasterCard");
        masterCard.setBounds(250, 10 , 800, 50);
        masterCard.setFont(customFont);
        mastercardLimitPanel.add(masterCard);

        limitWithdraw = new JLabel("Лимит на теглене");
        limitWithdraw.setBounds(50,100, 180, 30);
        limitWithdraw.setFont(customFont);
        mastercardLimitPanel.add(limitWithdraw);

        limitPay = new JLabel("Лимит на плащане");
        limitPay.setBounds(50,150, 180, 30);
        limitPay.setFont(customFont);
        mastercardLimitPanel.add(limitPay);

        limitWithdrawValue = new JLabel(String.valueOf(user.getMasterCard().getWithdrawalLimit()));
        limitWithdrawValue.setBounds(230, 100, 100, 30);
        limitWithdrawValue.setFont(customFont);
        mastercardLimitPanel.add(limitWithdrawValue);

        limitPayValue = new JLabel(String.valueOf(user.getMasterCard().getPaymentLimit()));
        limitPayValue.setBounds(230, 150, 100, 30);
        limitPayValue.setFont(customFont);
        mastercardLimitPanel.add(limitPayValue);

        newWithdrawLimit = new JTextField();
        newWithdrawLimit.setBounds(310, 100, 150, 30);
        newWithdrawLimit.setFont(customFont);
        mastercardLimitPanel.add(newWithdrawLimit);

        newPayLimit = new JTextField();
        newPayLimit.setBounds(310, 150, 150, 30);
        newPayLimit.setFont(customFont);
        mastercardLimitPanel.add(newPayLimit);

        limitWithdrawCurrency = new JLabel("BGN");
        limitWithdrawCurrency.setBounds(480, 100, 100, 30);
        limitWithdrawCurrency.setFont(customFont);
        mastercardLimitPanel.add(limitWithdrawCurrency);

        limitPayCurrency = new JLabel("BGN");
        limitPayCurrency.setBounds(480, 150, 100, 30);
        limitPayCurrency.setFont(customFont);
        mastercardLimitPanel.add(limitPayCurrency);

        updateLimit = new JButton("Обнови лимита");
        updateLimit.setBounds(180, 220, 200, 40);
        updateLimit.setFont(customFont);
        mastercardLimitPanel.add(updateLimit);
        updateLimit.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String newWithdrawValue = newWithdrawLimit.getText();
                        String newPayValue = newPayLimit.getText();
                        BigDecimal withdrawBigDecimal = new BigDecimal((Integer.parseInt(newWithdrawValue)));
                        BigDecimal payBigDecimal = new BigDecimal((Integer.parseInt(newPayValue)));
                        user.getMasterCard().setWithdrawalLimit(withdrawBigDecimal);
                        user.getMasterCard().setPaymentLimit(payBigDecimal);
                        mastercardLimitFrame.setVisible(false);
                    }
                }
        );

        mastercardLimitFrame.setVisible(true);

    }
}
