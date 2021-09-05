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

public class VisaLimitPanel {

    private static JLabel visaClassic;
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

    public static Component VisaLimit(){

        Font customFontOne = new Font(Font.SERIF, Font.BOLD, 20);
        Font customFontTwo = new Font(Font.SERIF, Font.BOLD, 16);
        Font customFontButton = new Font(Font.SERIF, Font.BOLD, 18);

        JPanel visaLimitPanel = new JPanel();
        visaLimitPanel.setLayout(null);
        visaLimitPanel.setBackground(new Color(238, 247, 255));

        visaClassic = new JLabel("Visa Classic");
        visaClassic.setBounds(150, 0 , 800, 50);
        visaClassic.setFont(customFontOne);
        visaLimitPanel.add(visaClassic);

        limitWithdraw = new JLabel("Лимит на теглене");
        limitWithdraw.setBounds(20,40, 160, 30);
        limitWithdraw.setFont(customFontTwo);
        visaLimitPanel.add(limitWithdraw);

        limitPay = new JLabel("Лимит на плащане");
        limitPay.setBounds(20,70, 160, 30);
        limitPay.setFont(customFontTwo);
        visaLimitPanel.add(limitPay);

        limitWithdrawValue = new JLabel(String.valueOf(user.getUser().getVisa().getWithdrawalLimit()));
        limitWithdrawValue.setBounds(190, 40, 100, 30);
        limitWithdrawValue.setFont(customFontTwo);
        visaLimitPanel.add(limitWithdrawValue);

        limitPayValue = new JLabel(String.valueOf(user.getUser().getVisa().getPaymentLimit()));
        limitPayValue.setBounds(190, 70, 100, 30);
        limitPayValue.setFont(customFontTwo);
        visaLimitPanel.add(limitPayValue);

        newWithdrawLimit = new JTextField();
        newWithdrawLimit.setBounds(240, 45, 85, 20);
        newWithdrawLimit.setFont(customFontTwo);
        visaLimitPanel.add(newWithdrawLimit);

        newPayLimit = new JTextField();
        newPayLimit.setBounds(240, 75, 85, 20);
        newPayLimit.setFont(customFontTwo);
        visaLimitPanel.add(newPayLimit);

        limitWithdrawCurrency = new JLabel("BGN");
        limitWithdrawCurrency.setBounds(330, 42, 100, 25);
        limitWithdrawCurrency.setFont(customFontTwo);
        visaLimitPanel.add(limitWithdrawCurrency);

        limitPayCurrency = new JLabel("BGN");
        limitPayCurrency.setBounds(330, 72, 100, 25);
        limitPayCurrency.setFont(customFontTwo);
        visaLimitPanel.add(limitPayCurrency);

        updateLimit = new JButton("Обнови лимита");
        updateLimit.setBounds(110, 110, 190, 25);
        updateLimit.setBackground(new Color(212, 212, 212));
        updateLimit.setFont(customFontButton);
        visaLimitPanel.add(updateLimit);
        updateLimit.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String newWithdrawValue = newWithdrawLimit.getText();
                        String newPayValue = newPayLimit.getText();

                        BigDecimal withdrawBigDecimal = new BigDecimal((Integer.parseInt(newWithdrawValue)));
                        BigDecimal payBigDecimal = new BigDecimal((Integer.parseInt(newPayValue)));

                        BigDecimal currentWithdrawBigDecimal = new BigDecimal((Integer.parseInt(String.valueOf(user.getUser().getVisa().getWithdrawalLimit()))));
                        BigDecimal currentPayBigDecimal = new BigDecimal((Integer.parseInt(String.valueOf(user.getUser().getVisa().getPaymentLimit()))));

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
                                FrontEndControl.changeWithdrawalLimits("Visa classic", withdrawBigDecimal, user.getUser().getId());
                                FrontEndControl.changePaymentLimits("Visa classic", payBigDecimal, user.getUser().getId());
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        }
                        if(withdraw != 0){
                            try {
                                FrontEndControl.changeWithdrawalLimits("Visa classic", withdrawBigDecimal, user.getUser().getId());
                                FrontEndControl.changePaymentLimits("Visa classic", currentPayBigDecimal, user.getUser().getId());
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        }
                        if(pay != 0){
                            try {
                                FrontEndControl.changeWithdrawalLimits("Visa classic", currentWithdrawBigDecimal, user.getUser().getId());
                                FrontEndControl.changePaymentLimits("Visa classic", payBigDecimal, user.getUser().getId());
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        }
                    }
                }
        );
        return visaLimitPanel;
    }
}
