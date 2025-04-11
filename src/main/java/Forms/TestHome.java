
package Forms;
import com.formdev.flatlaf.FlatDarkLaf;

import java.util.logging.Level;
import java.util.logging.Logger;
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
