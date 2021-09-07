package frontend.panels;

import backend.API.CurrencyCalculator;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyCalculatorPanel implements ActionListener{

    private static JTextField userAmountField;

    private static JLabel userAmountLabel;
    private static JLabel conventedAmountDataLabel;
    private static JLabel resultAmountLabel;

    private static JLabel currencyOneLabel;
    private static JLabel currencyTwoLabel;

    private static JButton convertButton;

    private static JComboBox currencyOneBox;
    private static JComboBox currencyTwoBox;

    public static Component CurrencyCalculatorPanel(){


        Font customFont = new Font(Font.SERIF, Font.BOLD, 18);
        Font textCustomFont = new Font(Font.SERIF, Font.PLAIN, 18);
        Border blackLine = BorderFactory.createLineBorder(Color.BLACK);

        JPanel currencyCalculatorPanel = new JPanel();
        currencyCalculatorPanel.setLayout(null);
        currencyCalculatorPanel.setBackground(new Color(238, 247, 255));

        userAmountLabel = new JLabel("Количество");
        userAmountLabel.setBounds(65, 60, 100, 25);
        userAmountLabel.setFont(customFont);
        currencyCalculatorPanel.add(userAmountLabel);

        userAmountField = new JTextField();
        userAmountField.setBounds(180, 60, 150, 30);
        userAmountField.setFont(textCustomFont);
        currencyCalculatorPanel.add(userAmountField);

        currencyOneLabel = new JLabel("От валута");
        currencyOneLabel.setBounds(65, 100, 100, 25);
        currencyOneLabel.setFont(customFont);
        currencyCalculatorPanel.add(currencyOneLabel);

        currencyTwoLabel = new JLabel("Към валута");
        currencyTwoLabel.setBounds(65, 140, 100, 30);
        currencyTwoLabel.setFont(customFont);
        currencyCalculatorPanel.add(currencyTwoLabel);

        String currencies[] = {"", "BGN", "EUR", "USD", "AUD", "RUB", "JPY"};

        currencyOneBox = new JComboBox(currencies);
        currencyOneBox.setFont(textCustomFont);
        currencyOneBox.setBounds(180, 100,150, 30);
        currencyCalculatorPanel.add(currencyOneBox);

        currencyTwoBox = new JComboBox(currencies);
        currencyTwoBox.setFont(textCustomFont);
        currencyTwoBox.setBounds(180, 140,150, 30);
        currencyCalculatorPanel.add(currencyTwoBox);

        conventedAmountDataLabel = new JLabel("Резултат");
        conventedAmountDataLabel.setBounds(65, 180, 100, 25);
        conventedAmountDataLabel.setFont(customFont);
        currencyCalculatorPanel.add(conventedAmountDataLabel);

        resultAmountLabel = new JLabel("0.00", SwingConstants.CENTER);
        resultAmountLabel.setBounds(180, 180, 150, 30);
        resultAmountLabel.setBorder(blackLine);
        resultAmountLabel.setOpaque(true);
        resultAmountLabel.setBackground(Color.white);
        resultAmountLabel.setFont(customFont);
        currencyCalculatorPanel.add(resultAmountLabel);


        convertButton = new JButton("Пресметни");
        convertButton.setBounds(140, 250, 140, 30);
        convertButton.setBackground(new Color(212, 212, 212));
        convertButton.setFont(customFont);
        convertButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String userAmount = userAmountField.getText();
                        String currencyOne = currencyOneBox.getSelectedItem().toString();
                        String currencyTwo = currencyTwoBox.getSelectedItem().toString();

                        try {
                            String convertedUserAmount = CurrencyCalculator.currencyConverter(currencyOne, currencyTwo, userAmount);
                            resultAmountLabel.setText(convertedUserAmount);
                        }
                        catch (Exception t){
                            JOptionPane.showMessageDialog(null, "You have missed information","Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
        );
        currencyCalculatorPanel.add(convertButton);

        return currencyCalculatorPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
