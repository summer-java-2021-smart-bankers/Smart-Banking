import backend.JDBC.Login;
import frontend.controls.FrontEndControl;

import backend.App;

import java.sql.SQLException;
import java.util.Scanner;
import backend.API.CurrencyCalculator;

public class Main {

    public static void main(String[] args) throws SQLException {

        /*BackEnd control component*/
//        Scanner scanner = new Scanner(System.in);
//        App app = new App();
//        app.app(args);

        /*FrontEnd control component*/
//        FrontEndControl.FrontEndControl();
        CurrencyCalculator.currencyConverter();


    }
}
