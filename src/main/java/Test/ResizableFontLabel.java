/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import Model.HomePage;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResizableFontLabel extends JFrame {

    private JLabel label;

    public ResizableFontLabel() {
        setTitle("Resizable Font Label");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        label = new JLabel("Resizable Label", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));

        add(label, BorderLayout.CENTER);

        // Lắng nghe sự kiện thay đổi kích thước cửa sổ
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int newSize = getWidth() / 20; // Điều chỉnh font size theo chiều rộng cửa sổ
                label.setFont(new Font("Arial", Font.BOLD, newSize));
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
         try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, e);
        }
        SwingUtilities.invokeLater(ResizableFontLabel::new);
    }
}
