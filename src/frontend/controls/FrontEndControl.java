package frontend.controls;

import backend.JDBC.Login;
import backend.JDBC.Register;
import backend.JDBC.TransferMoney;
import frontend.panels.*;

import backend.JDBC.ChangeLimit;
import frontend.panels.LoginPanel;

import java.math.BigDecimal;
import java.sql.SQLException;

public class FrontEndControl {

    public static void run(){
        LoginPanel.loginFrame();
    }

    public static void RegisterDataBaseControl(String username, String password, String email, String city, String firstName, String lastName) throws SQLException {
        System.out.println("YES");
        Register register = new Register();
        register.setConnection();
        register.register(username, password, email, city, firstName, lastName);
        LoginPanel.loginFrame();
    }

//    public static void registerDataBaseControl(String username, String password, String email, String city, String firstName, String lastName) throws SQLException {
//        Register register = new Register();
//        register.setConnection();
//        register.register(username, password, email, city, firstName, lastName);
//    }

    public static boolean loginDataBaseControl(String username, String password) throws SQLException {
        Login login = new Login();
        login.setConnection();
        login.login(username, password);
        boolean correctLogin = login.isCorrectInfo();

        return correctLogin;
    }

    public static void changePaymentLimits(String cardName,BigDecimal paymentLimit, int id) throws SQLException {
        ChangeLimit changeLimit = new ChangeLimit();
        changeLimit.setConnection();
        if (cardName.equals("Master card")) {
            changeLimit.changeMasterCardPaymentLimit(paymentLimit,id);
        }else if (cardName.equals("Visa classic")) {
            changeLimit.changeVisaClassicPaymentLimit(paymentLimit,id);
        }else if (cardName.equals("Credit card")) {
            changeLimit.changeCreditCardPaymentLimit(paymentLimit,id);
        }
    }

    public static void changeWithdrawalLimits(String cardName,BigDecimal withdrawalLimit, int id) throws SQLException {
        ChangeLimit changeLimit = new ChangeLimit();
        changeLimit.setConnection();
        if (cardName.equals("Master card")) {
            changeLimit.changeMasterCardWithdrawalLimit(withdrawalLimit,id);
        }else if (cardName.equals("Visa classic")) {
            changeLimit.changeVisaClassicWithdrawalLimit(withdrawalLimit,id);
        }else if (cardName.equals("Credit card")) {
            changeLimit.changeCreditCardWithdrawalLimit(withdrawalLimit,id);
        }
    }

    public static void transferMoney(String iban, int currentUserId, String fromCard, BigDecimal money) throws SQLException {
        TransferMoney transferMoney = new TransferMoney();
        transferMoney.setConnection();
        transferMoney.transferMoney(iban,currentUserId,fromCard,money);
    }
}
