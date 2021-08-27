package frontend.panels;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public static void VisaLimit(){

        Font customFont = new Font(Font.SERIF, Font.ITALIC, 18);

        JFrame visaLimitFrame = new JFrame("Smart Banking — Visa Classic Control");
        JPanel visaLimitPanel = new JPanel();
        visaLimitFrame.setSize(580, 330);
        visaLimitFrame.add(visaLimitPanel);
        visaLimitPanel.setLayout(null);
        visaLimitPanel.setBackground(new Color(146, 207, 242));


        visaClassic = new JLabel("Visa Classic");
        visaClassic.setBounds(250, 10 , 800, 50);
        visaClassic.setFont(customFont);
        visaLimitPanel.add(visaClassic);

        limitWithdraw = new JLabel("Лимит на теглене");
        limitWithdraw.setBounds(50,100, 180, 30);
        limitWithdraw.setFont(customFont);
        visaLimitPanel.add(limitWithdraw);

        limitPay = new JLabel("Лимит на плащане");
        limitPay.setBounds(50,150, 180, 30);
        limitPay.setFont(customFont);
        visaLimitPanel.add(limitPay);

        limitWithdrawValue = new JLabel("3000");
        limitWithdrawValue.setBounds(230, 100, 100, 30);
        limitWithdrawValue.setFont(customFont);
        visaLimitPanel.add(limitWithdrawValue);

        limitPayValue = new JLabel("3000");
        limitPayValue.setBounds(230, 150, 100, 30);
        limitPayValue.setFont(customFont);
        visaLimitPanel.add(limitPayValue);

        newWithdrawLimit = new JTextField();
        newWithdrawLimit.setBounds(310, 100, 150, 30);
        newWithdrawLimit.setFont(customFont);
        visaLimitPanel.add(newWithdrawLimit);

        newPayLimit = new JTextField();
        newPayLimit.setBounds(310, 150, 150, 30);
        newPayLimit.setFont(customFont);
        visaLimitPanel.add(newPayLimit);

        limitWithdrawCurrency = new JLabel("BGN");
        limitWithdrawCurrency.setBounds(480, 100, 100, 30);
        limitWithdrawCurrency.setFont(customFont);
        visaLimitPanel.add(limitWithdrawCurrency);

        limitPayCurrency = new JLabel("BGN");
        limitPayCurrency.setBounds(480, 150, 100, 30);
        limitPayCurrency.setFont(customFont);
        visaLimitPanel.add(limitPayCurrency);

        updateLimit = new JButton("Обнови лимита");
        updateLimit.setBounds(180, 220, 200, 40);
        updateLimit.setFont(customFont);
        visaLimitPanel.add(updateLimit);

        visaLimitFrame.setVisible(true);

    }
}