import backend.JDBC.Login;
import frontend.controls.FrontEndControl;

import backend.App;

import backend.API.CurrencyCalculator;
import frontend.panels.*;

public class Main {

    public static void main(String[] args) {

        /*BackEnd control component*/
//        Scanner scanner = new Scanner(System.in);
//        App app = new App();
//        app.app(args);

        /*FrontEnd control component*/
        FrontEndControl.FrontEndControl();
        //CurrencyCalculator.currencyConverter();
//        BankingPanel.BankingPanel();
        //MasterCardLimitPanel.MasterCardLimit();
        //CreditLimitPanel.CreditLimit();
        //VisaLimitPanel.VisaLimit();
        //TransferPanel.Transfer();


    }
}
