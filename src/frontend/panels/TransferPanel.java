package frontend.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferPanel {

    private static JLabel titleLabel;

    private static JLabel ibanLabel;
    private static JLabel fromCardLabel;
    private static JLabel transferSum;

    private static JTextField ibanField;
    private static JTextField transferSumField;

    private static JButton commenceTransferButton;

    private static JComboBox cardsBox;

    public static Component Transfer(){

        Font customFont = new Font(Font.SERIF, Font.BOLD, 18);

        JPanel transferPanel = new JPanel();
        transferPanel.setLayout(null);
        transferPanel.setBackground(new Color(238, 247, 255));

        titleLabel = new JLabel("Паричен превод");
        titleLabel.setBounds(130, 10 , 800, 50);
        titleLabel.setFont(customFont);
        transferPanel.add(titleLabel);

        ibanLabel = new JLabel("IBAN на получател:");
        ibanLabel.setBounds(115,80, 190, 30);
        ibanLabel.setFont(customFont);
        transferPanel.add(ibanLabel);

        fromCardLabel = new JLabel("От сметка");
        fromCardLabel.setBounds(150,150, 190, 30);
        fromCardLabel.setFont(customFont);
        transferPanel.add(fromCardLabel);

        transferSum = new JLabel("Сума за изпращане:");
        transferSum.setBounds(110,230, 190, 30);
        transferSum.setFont(customFont);
        transferPanel.add(transferSum);

        ibanField = new JTextField();
        ibanField.setBounds(110, 110, 175, 30);
        ibanField.setFont(customFont);
        transferPanel.add(ibanField);

        String cards[] = {" ", "MasterCard", "VisaClassic", "CreditCard"};
        cardsBox = new JComboBox(cards);
        cardsBox.setBounds(110, 180,175, 30);
        cardsBox.setFont(customFont);
        transferPanel.add(cardsBox);

        transferSumField = new JTextField();
        transferSumField.setBounds(110, 260, 175, 30);
        transferSumField.setFont(customFont);
        transferPanel.add(transferSumField);

        commenceTransferButton = new JButton("Преведи");
        commenceTransferButton.setBounds(100, 350, 200, 40);
        commenceTransferButton.setBackground(new Color(212, 212, 212));
        commenceTransferButton.setFont(customFont);
        transferPanel.add(commenceTransferButton);
        commenceTransferButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String ibanNumber = ibanField.getText();
                        String sumNumber = transferSumField.getText();
                        String card = cardsBox.getSelectedItem().toString();

                        if(ibanNumber.equals("BGN1234") && sumNumber.equals("1000") & card.equals("MasterCard")){
                            commenceTransferButton.setBackground(new Color(124, 252, 0));
                            JOptionPane.showMessageDialog(null, "Успешен паричен трансфер","Успешно",JOptionPane.INFORMATION_MESSAGE);
                            ibanField.setText("");
                            transferSumField.setText("");
                            cardsBox.setSelectedIndex(0);
                        }
                        else{
                            commenceTransferButton.setBackground(new Color(220, 20, 60));
                            JOptionPane.showMessageDialog(null, "Неуспешен паричен трансфер","Грешка",JOptionPane.ERROR_MESSAGE);
                        }

                       System.out.println("Done!");
                    }
                }
        );

        return transferPanel;
    }
}
