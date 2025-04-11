/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Forms;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;

public class AvatarUploader extends JFrame {
    private JLabel avatarLabel;
    private JButton uploadButton, saveButton;
    private File selectedFile;

    public AvatarUploader() {
        setTitle("Upload Ảnh Đại Diện");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        avatarLabel = new JLabel("Chưa có ảnh", SwingConstants.CENTER);
        avatarLabel.setPreferredSize(new Dimension(200, 200));
        avatarLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        uploadButton = new JButton("Chọn ảnh");
        saveButton = new JButton("Lưu lên SQL Server");

        uploadButton.addActionListener(e -> chooseImage());
        saveButton.addActionListener(e -> saveToDatabase());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(uploadButton);
        buttonPanel.add(saveButton);

        add(avatarLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void chooseImage() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile();
            ImageIcon icon = new ImageIcon(new ImageIcon(selectedFile.getAbsolutePath())
                    .getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
            avatarLabel.setIcon(icon);
            avatarLabel.setText("");
        }
    }

    private void saveToDatabase() {
        if (selectedFile == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ảnh trước.");
            return;
        }

        try (Connection con = DriverManager.getConnection(
                "jdbc:sqlserver://localhost:1433;databaseName=USERLOGIN;user=sa;password=26092005;encrypt= false;");
             FileInputStream fis = new FileInputStream(selectedFile)) {

            String sql = "INSERT INTO Users(Name, Avatar) VALUES (?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, "Người dùng mẫu");
            pst.setBinaryStream(2, fis, (int) selectedFile.length());

            int rows = pst.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Lưu ảnh thành công!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi lưu ảnh: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new AvatarUploader();
    }
}
