package Controllers;

import Forms.CreateAccount;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    
    public void BufferedImage(String c, JLabel label) throws IOException {
        BufferedImage image = ImageIO.read(new File(c));
        LoginController.instance.makeTransparent(image, 0.2f, label);
    }

    
    public void FocusPointer(JTextField textField, JLabel label, JLabel label1, Color colorFirst, Color colorLast) {

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                label.setForeground(colorFirst);
                openMenuBar(label1);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().length() != 0) {
                    label.setForeground(colorFirst);

                } else {
                    label.setForeground(colorLast);

                }

            }
        });
    }

    
    //animation label 
    public void openMenuBar(JLabel label) {
        int targetWidth = 260;
        int height = 30;
        // Tính điểm trung tâm ban đầu
        int centerX = label.getX() + label.getWidth() / 2;
        int centerY = label.getY();

        new Thread(() -> {
            for (int i = 0; i <= targetWidth / 2; i++) {
                int newWidth = i * 2;
                int newX = centerX - i;

                label.setBounds(newX, centerY, newWidth, height);

                try {
                    Thread.sleep(2);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CreateAccount.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    
    // bắt lổi tiếng việt
    public static boolean containsVietnameseCharacters(String text) {
        String vietnamesePattern = ".*[àáảãạăắằẳẵặâấầẩẫậèéẻẽẹêếềểễệìíỉĩịòóỏõọôốồổỗộơớờởỡợùúủũụưứừửữựỳýỷỹỵđ].*";
        return text.matches(vietnamesePattern);
    }
}
