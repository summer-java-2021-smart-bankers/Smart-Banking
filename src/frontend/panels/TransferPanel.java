package frontend.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferPanel {

    private static JLabel titleLabel;

    private static JLabel firstNameLabel;
    private static JLabel lastNameLabel;
    private static JLabel transferSum;

    private static JTextField firstNameFill;
    private static JTextField lastNameFill;
    private static JTextField transferSumFill;

    private static JButton commenceTransfer;

//    private static JDialog invalidFirstName;
//    private static JDialog invalidLastName;
//    private static JDialog insufficientFunds;
//    private static JDialog blankField;
//    private static JButton closeDialog;


    public static void Transfer(){
        Font customFont = new Font(Font.SERIF, Font.ITALIC, 18);

        JFrame transferFrame = new JFrame("Smart Banking — Funds Transfer");
        JPanel transferPanel = new JPanel();
        transferFrame.setSize(580, 330);
        transferFrame.add(transferPanel);
        transferPanel.setLayout(null);
        transferPanel.setBackground(new Color(146, 207, 242));

        titleLabel = new JLabel("Превод на финанси");
        titleLabel.setBounds(200, 10 , 800, 50);
        titleLabel.setFont(customFont);
        transferPanel.add(titleLabel);

        firstNameLabel = new JLabel("Име на получател:");
        firstNameLabel.setBounds(50,80, 190, 30);
        firstNameLabel.setFont(customFont);
        transferPanel.add(firstNameLabel);

        lastNameLabel = new JLabel("Фамилия на получател:");
        lastNameLabel.setBounds(50,130, 190, 30);
        lastNameLabel.setFont(customFont);
        transferPanel.add(lastNameLabel);

        transferSum = new JLabel("Сума за Изпращане:");
        transferSum.setBounds(50,180, 190, 30);
        transferSum.setFont(customFont);
        transferPanel.add(transferSum);

        firstNameFill = new JTextField();
        firstNameFill.setBounds(300, 80, 170, 30);
        firstNameFill.setFont(customFont);
        transferPanel.add(firstNameFill);

        lastNameFill = new JTextField();
        lastNameFill.setBounds(300, 130, 170, 30);
        lastNameFill.setFont(customFont);
        transferPanel.add(lastNameFill);

        transferSumFill = new JTextField();
        transferSumFill.setBounds(300, 180, 170, 30);
        transferSumFill.setFont(customFont);
        transferPanel.add(transferSumFill);

        commenceTransfer = new JButton("Преведи");
        commenceTransfer.setBounds(180, 230, 200, 40);
        commenceTransfer.setFont(customFont);
        transferPanel.add(commenceTransfer);
        commenceTransfer.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       System.out.println("Done!");
                    }
                }
        );


        transferFrame.setVisible(true);
    }
}
