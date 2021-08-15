package frontend.panels;

import javax.swing.*;

public class BankingPanel {

    public static void BankingPanel(){
        JPanel mainProgramPanel = new JPanel();
        JFrame mainProgramFrame = new JFrame();
        mainProgramFrame.setSize(400, 250);
        mainProgramFrame.add(mainProgramPanel);
        mainProgramPanel.setLayout(null);
        mainProgramFrame.setVisible(true);

        JLabel welcomeMessage = new JLabel("Welcome to SmartBanking!");
        welcomeMessage.setBounds(80, 10, 250, 50);
        mainProgramPanel.add(welcomeMessage);
    }
}
