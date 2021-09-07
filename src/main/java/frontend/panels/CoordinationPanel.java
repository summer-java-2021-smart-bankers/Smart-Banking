package frontend.panels;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.view.swing.BrowserView;
import backend.users.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;


public class CoordinationPanel{

    private static UserController user = new UserController();

    public static Component CoordinationPanel(){

        JButton billButton;
        JButton creditButton;
        JButton objectsButton;
        JButton contactsButton;
        JButton currencyCalculatorButton;

        //Main JFrame
        Font customFont = new Font(Font.SERIF, Font.BOLD, 18);
        JFrame mainFrame = new JFrame("SmartBanking — " + user.getUser().getFirstName()+ " " + user.getUser().getLastName());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(650,200,400, 500);

        //Coordination Panel
        JPanel coordinationPanel = new JPanel();
        coordinationPanel.setLayout(null);
        coordinationPanel.setBackground(new Color(238, 247, 255));

        //TabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Начало", coordinationPanel);
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_0);

        tabbedPane.addTab("Нов превод",TransferPanel.Transfer());
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        tabbedPane.addTab("Карти", CardsPanel.CardsPanel());
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

        tabbedPane.addTab("Валутен калкулатор", CurrencyCalculatorPanel.CurrencyCalculatorPanel());
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_3);

        mainFrame.getContentPane().add(tabbedPane, BorderLayout.CENTER);


        billButton = new JButton("Сметки");
        billButton.setBounds(80, 75, 220, 35);
        billButton.setBackground(new Color(255, 255, 255));
        billButton.setFont(customFont);
        billButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mainFrame.setVisible(false);
                        MainBillsPanel.MainBillsPanel();
                    }
                });
        coordinationPanel.add(billButton);

        creditButton = new JButton("Кредитно състояние");
        creditButton.setBounds(80, 130, 220, 35);
        creditButton.setBackground(new Color(255, 255, 255));
        creditButton.setFont(customFont);
        creditButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mainFrame.setVisible(false);
                        CreditBillsPanel.CreditBillsPanel();

                    }
                });
        coordinationPanel.add(creditButton);

        objectsButton = new JButton("Обекти");
        objectsButton.setBounds(80, 185, 220, 35);
        objectsButton.setBackground(new Color(255, 255, 255));
        objectsButton.setFont(customFont);
        objectsButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                            EngineOptions options = EngineOptions.newBuilder(HARDWARE_ACCELERATED).build();
                            Engine engine = Engine.newInstance(options);
                            Browser browser = engine.newBrowser();

                            SwingUtilities.invokeLater(() -> {
                            BrowserView view = BrowserView.newInstance(browser);

                            JFrame frame = new JFrame("Обекти");
                            frame.add(view, BorderLayout.CENTER);
                            frame.setSize(800, 500);
                            frame.setBounds(650,200,800, 500);
                            frame.setVisible(true);

                            browser.navigation().loadUrl("file:///C://Users//Rado//Downloads/map.html");
                        });
                    }
                });
        coordinationPanel.add(objectsButton);


        contactsButton = new JButton("Контакти");
        contactsButton.setBounds(80, 240, 220, 35);
        contactsButton.setBackground(new Color(255, 255, 255));
        contactsButton.setFont(customFont);
        contactsButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mainFrame.setVisible(false);
                        ContactsPanel.Contacts();
                    }
                });
        coordinationPanel.add(contactsButton);


        currencyCalculatorButton = new JButton("Изход");
        currencyCalculatorButton.setBounds(260, 390, 100, 30);
        currencyCalculatorButton.setBackground(new Color(212, 212, 212));
        currencyCalculatorButton.setFont(customFont);
        currencyCalculatorButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mainFrame.setVisible(false);
                        LoginPanel.loginFrame();
                    }
                });
        coordinationPanel.add(currencyCalculatorButton);

        mainFrame.setVisible(true);
        return coordinationPanel;
    }
}
