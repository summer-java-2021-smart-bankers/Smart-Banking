package frontend.panels;

import javax.swing.*;

public class ErrorPanel {

    public static void ErrorPanel(){
        JPanel ErrorProgramPanel = new JPanel();
        JFrame ErrorProgramFrame = new JFrame();
        ErrorProgramFrame.setSize(400, 100);
        ErrorProgramFrame.add(ErrorProgramPanel);
        ErrorProgramPanel.setLayout(null);
        ErrorProgramFrame.setVisible(true);

        JLabel errorMessage = new JLabel("ERROR! Wrong user name or password!");
        errorMessage.setBounds(80, 10, 250, 50);
        ErrorProgramPanel.add(errorMessage);
    }
}
