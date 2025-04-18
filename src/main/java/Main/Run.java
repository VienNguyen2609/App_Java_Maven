package Main;

import Forms.Components.SetThemFlatLaf;
import Forms.Components.ThemeFlatLaf;

import Forms.UserLogin;


public class Run {
    
    public static void main(String[] args) {
        runApp();       
    }   
    
    public static void runApp() {
        SetThemFlatLaf.setThem(ThemeFlatLaf.Light);          
        new UserLogin().setVisible(true);
    }

}
