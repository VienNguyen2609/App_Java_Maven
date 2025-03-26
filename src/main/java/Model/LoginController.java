
package Model;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class LoginController {
   
    public static LoginController instance;
    private static boolean isInitiallized = false;
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

    public static BufferedImage makeTransparent(BufferedImage img, float alpha ,JLabel label ) {
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

    // bắt lổi tiếng việt 

    public static boolean containsVietnameseCharacters(String text) {
        String vietnamesePattern = ".*[àáảãạăắằẳẵặâấầẩẫậèéẻẽẹêếềểễệìíỉĩịòóỏõọôốồổỗộơớờởỡợùúủũụưứừửữựỳýỷỹỵđ].*";
        return text.matches(vietnamesePattern);
    }
}
