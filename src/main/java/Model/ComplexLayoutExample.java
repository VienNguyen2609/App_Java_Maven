
package Model;

import javax.swing.*;
import java.awt.*;

public class ComplexLayoutExample extends JFrame {
    public ComplexLayoutExample() {
        setTitle("Complex Layout Example");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // Giao diện chính dùng BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
         
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.add(new JButton("Home"));
        menuPanel.add(new JButton("Products"));
        menuPanel.add(new JButton("Contact"));
        menuPanel.setBackground(Color.DARK_GRAY);
        menuPanel.setPreferredSize(new Dimension(200, getHeight()));

        // Nội dung chính dùng GridBagLayout
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(Color.red);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPanel.add(new JButton("Content 1"), gbc);
        gbc.gridx = 1;
        contentPanel.add(new JButton("Content 2"), gbc);
        gbc.gridy = 1; gbc.gridx = 0;
        contentPanel.add(new JButton("Content 3"), gbc);
        gbc.gridx = 1;
        contentPanel.add(new JButton("Content 4"), gbc);
        
        // Footer dùng FlowLayout (các nút dưới cùng)
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        footerPanel.add(new JLabel("© 2025 MyShop"));

        // Thêm vào mainPanel
        mainPanel.add(menuPanel, BorderLayout.WEST);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        // Set vào frame
        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        ComplexLayoutExample complexLayoutExample = new ComplexLayoutExample();
    }
}

