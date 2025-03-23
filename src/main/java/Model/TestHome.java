
package Model;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestHome {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf() );
        } catch (UnsupportedLookAndFeelException e) {
            Logger.getLogger(TestHome.class.getName()).log(Level.SEVERE, null, e);
        }
        new HomePage().setVisible(true);
    }
}
