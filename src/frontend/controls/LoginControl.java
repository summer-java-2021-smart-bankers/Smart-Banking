package frontend.controls;

import frontend.panels.BankingPanel;
import frontend.panels.ErrorPanel;

public class LoginControl {

    public static void LoginButtonControl(String user, String pass){
        if(user.equals("login") && pass.equals("login")){
            BankingPanel.BankingPanel();
        }
        else{
            ErrorPanel.ErrorPanel();
        }
    }
}
