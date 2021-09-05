package frontend.panels;

import backend.JDBC.ChangeLimit;
import backend.JDBC.Login;
import backend.users.User;
import backend.users.UserController;
import frontend.controls.FrontEndControl;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;

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

    private static UserController user = new UserController();

    public static Component CreditLimit(){

        Font customFontOne = new Font(Font.SERIF, Font.BOLD, 20);
        Font customFontTwo = new Font(Font.SERIF, Font.BOLD, 16);
        Font customFontButton = new Font(Font.SERIF, Font.BOLD, 18);

        JPanel creditLimitPanel = new JPanel();
        creditLimitPanel.setLayout(null);
        creditLimitPanel.setBackground(new Color(238, 247, 255));

        creditCard = new JLabel("Credit Card");
        creditCard.setBounds(150, 0 , 800, 50);
        creditCard.setFont(customFontOne);
        creditLimitPanel.add(creditCard);

        limitWithdraw = new JLabel("Лимит на теглене");
        limitWithdraw.setBounds(20,40, 160, 30);
        limitWithdraw.setFont(customFontTwo);
        creditLimitPanel.add(limitWithdraw);

        limitPay = new JLabel("Лимит на плащане");
        limitPay.setBounds(20,70, 160, 30);
        limitPay.setFont(customFontTwo);
        creditLimitPanel.add(limitPay);

        limitWithdrawValue = new JLabel(String.valueOf(user.getUser().getCredit().getWithdrawalLimit()));
        limitWithdrawValue.setBounds(190, 40, 100, 30);
        limitWithdrawValue.setFont(customFontTwo);
        creditLimitPanel.add(limitWithdrawValue);

        limitPayValue = new JLabel(String.valueOf(user.getUser().getCredit().getPaymentLimit()));
        limitPayValue.setBounds(190, 70, 100, 30);
        limitPayValue.setFont(customFontTwo);
        creditLimitPanel.add(limitPayValue);

        newWithdrawLimit = new JTextField();
        newWithdrawLimit.setBounds(240, 45, 85, 20);
        newWithdrawLimit.setFont(customFontTwo);
        creditLimitPanel.add(newWithdrawLimit);

        newPayLimit = new JTextField();
        newPayLimit.setBounds(240, 75, 85, 20);
        newPayLimit.setFont(customFontTwo);
        creditLimitPanel.add(newPayLimit);

        limitWithdrawCurrency = new JLabel("BGN");
        limitWithdrawCurrency.setBounds(330, 42, 100, 25);
        limitWithdrawCurrency.setFont(customFontTwo);
        creditLimitPanel.add(limitWithdrawCurrency);

        limitPayCurrency = new JLabel("BGN");
        limitPayCurrency.setBounds(330, 72, 100, 25);
        limitPayCurrency.setFont(customFontTwo);
        creditLimitPanel.add(limitPayCurrency);

        updateLimit = new JButton("Обнови лимита");
        updateLimit.setBounds(110, 110, 190, 25);
        updateLimit.setBackground(new Color(212, 212, 212));
        updateLimit.setFont(customFontButton);
        creditLimitPanel.add(updateLimit);
        updateLimit.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String newWithdrawValue = newWithdrawLimit.getText();
                        String newPayValue = newPayLimit.getText();

                        BigDecimal withdrawBigDecimal = new BigDecimal((Integer.parseInt(newWithdrawValue)));
                        BigDecimal payBigDecimal = new BigDecimal((Integer.parseInt(newPayValue)));

                        BigDecimal currentWithdrawBigDecimal = new BigDecimal((Integer.parseInt(String.valueOf(user.getUser().getCredit().getWithdrawalLimit()))));
                        BigDecimal currentPayBigDecimal = new BigDecimal((Integer.parseInt(String.valueOf(user.getUser().getCredit().getPaymentLimit()))));

                        boolean flagWithdraw = true;
                        boolean flagPay = true;

                        int withdraw = 0;
                        int pay = 0;

                        if(newWithdrawValue.equals("")){
                            flagWithdraw = false;
                        }
                        if(newPayValue.equals("")){
                            flagPay = false;
                        }

                        if(flagWithdraw){
                            withdraw = Integer.parseInt(newWithdrawValue);
                        }
                        if(flagPay){
                            pay = Integer.parseInt(newPayValue);
                        }

                        if(withdraw != 0 && pay != 0){
                            try {
                                FrontEndControl.changeWithdrawalLimits("Credit card",withdrawBigDecimal,user.getUser().getId());
                                FrontEndControl.changePaymentLimits("Credit card",payBigDecimal,user.getUser().getId());
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        }
                        if(withdraw != 0){
                            try {
                                FrontEndControl.changeWithdrawalLimits("Credit card",withdrawBigDecimal,user.getUser().getId());
                                FrontEndControl.changePaymentLimits("Credit card",currentPayBigDecimal,user.getUser().getId());
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        }
                        if(pay != 0){
                            try {
                                FrontEndControl.changeWithdrawalLimits("Credit card",currentWithdrawBigDecimal,user.getUser().getId());
                                FrontEndControl.changePaymentLimits("Credit card",payBigDecimal,user.getUser().getId());
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        }
                    }
                }
        );
        return creditLimitPanel;
    }
}