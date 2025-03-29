package Main;

import FormLogin.FormLoginUser;
import Model.HomePage;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Run {

    public static void main(String[] args) {
        runApp();
    }

    public static void runApp() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, e);
        }
        new FormLoginUser().setVisible(true);
    }
}
