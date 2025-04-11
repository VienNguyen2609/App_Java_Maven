package Forms.Components;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.UIScale;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javafx.scene.layout.Background;

public class HeaderButton extends JButton {

    private RippleEffect rippleEffect;

    public HeaderButton(String text) {
        super(text);
        init();

    }

    public HeaderButton() {
        init();
    }

    private void init() {
        rippleEffect = new RippleEffect(this);
        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        putClientProperty(FlatClientProperties.STYLE, "" + "font:bold +3");

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Vẽ nền với bo góc
        int arc = UIScale.scale(20);
        Color bgColor = getModel().isPressed()
                ? new Color(204, 255, 204)
                : getModel().isRollover()
                ? new Color(204, 255, 204)
                : new Color(204, 255, 204);

        g2.setColor(bgColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);

        // Vẽ hiệu ứng ripple
        rippleEffect.reder(g2, new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arc, arc));

        g2.dispose();

        // Gọi super để vẽ text & icon
        super.paintComponent(g);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int arc = UIScale.scale(20);
        rippleEffect.reder(g, new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arc, arc));
    }
}
