package Model;

import FormLogin.FormLoginUser;
import Main.Running;
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class HomePage extends javax.swing.JFrame {

    public HomePage() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("FOOTWEAR  ,  SHOP FOR YOU ");
        String iconPath = "D:\\DownLoad\\IconFootWear\\LogoShop.png"; 
        setIconImage(Toolkit.getDefaultToolkit().getImage(new File(iconPath).getAbsolutePath()));
//     try {
//            // Thiết lập FlatDarkLaf làm Look and Feel chính
//            javax.swing.UIManager.setLookAndFeel(new FlatDarkLaf());
//        } catch (UnsupportedLookAndFeelException e) {
//            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, e);
//        }
//        // Nếu muốn đổi màu nền của MenuPanel
//        MenuPanel.setBackground(java.awt.Color.LIGHT_GRAY);

    }

    //Chỉnh kích thước ảnh theo với Jlaybel
//    public void scaleImage(){
//        ImageIcon icon = new ImageIcon(getClass().getResource("/Com/Icon/ANh Em Quán.png"));
//        Image img = icon.getImage();
//        Image imgScale = img.getScaledInstance(jLabel6.getWidth(), jLabel6.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon acalledIcon = new ImageIcon(imgScale );
//        jLabel6.setIcon(acalledIcon);
//    }
//       public final void gr (){
//           Graphics2D g2d = (Graphics2D)MenuPanel.getGraphics(); 
//           g2d.drawLine(10000, 10000, 10000, 10000);
//           MenuPanel.paintComponents(g2d);
//           g2d.setColor(Color.WHITE);
//       }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MenuPanel.setBackground(new java.awt.Color(102, 102, 102));
        MenuPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/LogoShop.png"))); // NOI18N
        MenuPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 70));

        jButton1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/HomeShop.png"))); // NOI18N
        jButton1.setText("Home");
        MenuPanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 90, 140, 40));

        jButton2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/result_result_image-removebg-preview.png"))); // NOI18N
        jButton2.setText("LogOut");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        MenuPanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 660, 150, 40));

        getContentPane().add(MenuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 703));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Screenshot_26-3-2025_114459_chatgpt.com.jpeg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(271, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 1240, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        Running.runApp();
        new HomePage().setVisible(false);
        dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
