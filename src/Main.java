import backend.JDBC.Login;
import frontend.controls.FrontEndControl;

import backend.App;

import backend.API.CurrencyCalculator;
import frontend.panels.*;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        /*BackEnd control component*/
//        Scanner scanner = new Scanner(System.in);
//        App app = new App();
//        app.app(args);

        /*FrontEnd control component*/
          FrontEndControl.run();
          //CoordinationPanel.CoordinationPanel();
    }
}
