package Forms.Components;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.UIScale;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javafx.scene.layout.Background;

public class HeaderButton extends JButton {
     
    private Background color;
    
    private RippleEffect rippleEffect;

    public HeaderButton(String text) {
        super(text);
        init();

    }

    public HeaderButton() {
        this("Header");
        init();
    }

    private void init() {
        rippleEffect = new RippleEffect(this);
        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        putClientProperty(FlatClientProperties.STYLE, "" + "font:bold +3");
        
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int arc = UIScale.scale(20);
        rippleEffect.reder(g, new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arc, arc));
    }
}
