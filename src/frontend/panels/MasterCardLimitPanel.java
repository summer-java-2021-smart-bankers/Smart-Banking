package frontend.panels;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Objects;

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

    public static Component MasterCardLimit(){

        Font customFontOne = new Font(Font.SERIF, Font.BOLD, 20);
        Font customFontTwo = new Font(Font.SERIF, Font.BOLD, 16);
        Font customFontButton = new Font(Font.SERIF, Font.BOLD, 18);

        String currentLimitWithdraw = "3000";
        String currentLimitPay = "3000";

        JPanel mastercardLimitPanel = new JPanel();
        mastercardLimitPanel.setLayout(null);
        mastercardLimitPanel.setBackground(new Color(238, 247, 255));


        masterCard = new JLabel("MasterCard");
        masterCard.setBounds(150, 0 , 800, 50);
        masterCard.setFont(customFontOne);
        mastercardLimitPanel.add(masterCard);

        limitWithdraw = new JLabel("Лимит на теглене");
        limitWithdraw.setBounds(20,40, 160, 30);
        limitWithdraw.setFont(customFontTwo);
        mastercardLimitPanel.add(limitWithdraw);

        limitPay = new JLabel("Лимит на плащане");
        limitPay.setBounds(20,70, 160, 30);
        limitPay.setFont(customFontTwo);
        mastercardLimitPanel.add(limitPay);

        limitWithdrawValue = new JLabel(currentLimitWithdraw);
        limitWithdrawValue.setBounds(190, 40, 100, 30);
        limitWithdrawValue.setFont(customFontTwo);
        mastercardLimitPanel.add(limitWithdrawValue);

        limitPayValue = new JLabel(currentLimitPay);
        limitPayValue.setBounds(190, 70, 100, 30);
        limitPayValue.setFont(customFontTwo);
        mastercardLimitPanel.add(limitPayValue);

        newWithdrawLimit = new JTextField();
        newWithdrawLimit.setBounds(240, 45, 85, 20);
        newWithdrawLimit.setFont(customFontTwo);
        mastercardLimitPanel.add(newWithdrawLimit);

        newPayLimit = new JTextField();
        newPayLimit.setBounds(240, 75, 85, 20);
        newPayLimit.setFont(customFontTwo);
        mastercardLimitPanel.add(newPayLimit);

        limitWithdrawCurrency = new JLabel("BGN");
        limitWithdrawCurrency.setBounds(330, 42, 100, 25);
        limitWithdrawCurrency.setFont(customFontTwo);
        mastercardLimitPanel.add(limitWithdrawCurrency);

        limitPayCurrency = new JLabel("BGN");
        limitPayCurrency.setBounds(330, 72, 100, 25);
        limitPayCurrency.setFont(customFontTwo);
        mastercardLimitPanel.add(limitPayCurrency);

        updateLimit = new JButton("Обнови лимита");
        updateLimit.setBounds(110, 110, 190, 25);
        updateLimit.setBackground(new Color(212, 212, 212));
        updateLimit.setFont(customFontButton);
        mastercardLimitPanel.add(updateLimit);
        updateLimit.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String newWithdrawValue = newWithdrawLimit.getText();
                        String newPayValue = newPayLimit.getText();
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

                        if(withdraw != 0){
                            limitWithdrawValue.setText(newWithdrawValue);
                            limitPayValue.setText(currentLimitPay);
                        }
                        if(pay != 0){
                            limitWithdrawValue.setText(currentLimitWithdraw);
                            limitPayValue.setText(newPayValue);
                        }
                    }
                }
        );



        return mastercardLimitPanel;
    }
}
