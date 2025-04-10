package Controllers;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.TextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginController {

    public static LoginController instance;
    private static boolean isInitiallized = false;
    private JTextField textField;
    private JLabel label;

    public static void Init() {
        if (isInitiallized == true) {
            return;
        }
        instance = new LoginController();
        isInitiallized = true;

    }

    public void addPlaceHolderStyle(JTextField textField, Color color) {
        Font font = textField.getFont();
        font = font.deriveFont(Font.ITALIC | Font.BOLD);
        textField.setFont(font);
        textField.setForeground(color);
    }

    public void removePlaceHolderStyle(JTextField textField, Color color) {
        Font font = textField.getFont();
        font = font.deriveFont(Font.ITALIC | Font.BOLD);
        textField.setFont(font);
        textField.setForeground(color);
    }

    public static BufferedImage makeTransparent(BufferedImage img, float alpha, JLabel label) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage transparentImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = transparentImage.createGraphics();
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2d.drawImage(img, 0, 0, null);
        g2d.dispose();
        label.setIcon(new ImageIcon(transparentImage));
        return transparentImage;
    }

    public void BufferedImage(JLabel label) throws IOException {
        BufferedImage image = ImageIO.read(new File("D:\\DownLoad\\IconFootWear\\BackGrounds.jpg"));
        LoginController.instance.makeTransparent(image, 0.2f, label);
    }

    public void BufferedImage1(JLabel label) throws IOException {
        BufferedImage image = ImageIO.read(new File("D:\\DownLoad\\IconFootWear\\BackGroundLogin1.png"));
        LoginController.instance.makeTransparent(image, 0.2f, label);
    }

    public void FocusPointer(JTextField textField, JLabel label, Color colorFirst, Color colorLast) {

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                label.setForeground(colorFirst); // Đổi màu khi focus
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().length() != 0) {
                    label.setForeground(colorFirst);
                }
                else{
                    label.setForeground(colorLast);
                }
                
            }
        });
    }
    // bắt lổi tiếng việt

    public static boolean containsVietnameseCharacters(String text) {
        String vietnamesePattern = ".*[àáảãạăắằẳẵặâấầẩẫậèéẻẽẹêếềểễệìíỉĩịòóỏõọôốồổỗộơớờởỡợùúủũụưứừửữựỳýỷỹỵđ].*";
        return text.matches(vietnamesePattern);
    }
}
