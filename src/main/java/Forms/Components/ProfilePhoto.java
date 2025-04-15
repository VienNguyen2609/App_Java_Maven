package Forms.Components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class ProfilePhoto extends JComponent {

    private Icon icon;
    private int borderSize;

    public Icon getIcon() {
        return icon;
    }


    public int getBorderSize() {
        return borderSize;
    }

    public void setBorderSize(int borderSize) {
        this.borderSize = borderSize;
    }

    public ProfilePhoto() {
        setPreferredSize(new Dimension(50, 50));
        setBorderSize(3);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (getIcon() != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            int diameter = Math.min(getWidth(), getHeight());
            int x = (getWidth() - diameter) / 2;
            int y = (getHeight() - diameter) / 2;

            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            Ellipse2D clip = new Ellipse2D.Double(x, y, diameter, diameter);
            g2d.setClip(clip);
            g2d.drawImage(((ImageIcon) getIcon()).getImage(), x, y, diameter, diameter, Color.YELLOW, this);
            g2d.setClip(null);

            g2d.draw(clip);
            g2d.dispose();
        }
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
        repaint();  // Thêm dòng này để cập nhật lại giao diện khi gán ảnh
    }
}
