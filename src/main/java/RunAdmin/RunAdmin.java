package RunAdmin;

import Forms.AdminLogin;
import Forms.Components.SetThemFlatLaf;
import Forms.Components.ThemeFlatLaf;

public class RunAdmin {
    public static void main(String[] args) {
        runApp();
    }
    public static void runApp(){
        SetThemFlatLaf.setThem(ThemeFlatLaf.Light);
        new AdminLogin().setVisible(true);
    }
}
