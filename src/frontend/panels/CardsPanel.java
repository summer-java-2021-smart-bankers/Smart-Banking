package frontend.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardsPanel {

    public static Component CardsPanel(){

        Font customFont = new Font(Font.SERIF, Font.BOLD, 18);

        JPanel allCardsPanel = new JPanel();
        allCardsPanel.setLayout(new GridLayout(3,1));
        allCardsPanel.setBackground(new Color(238, 247, 255));

        allCardsPanel.add(MasterCardLimitPanel.MasterCardLimit());
        allCardsPanel.add(VisaLimitPanel.VisaLimit());
        allCardsPanel.add(CreditLimitPanel.CreditLimit());

        return allCardsPanel;
    }
}
