package Forms;

import Controller.HeaderButton;
import Main.Run;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.util.UIScale;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class HomePage extends javax.swing.JFrame {

    public HomePage() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("FOOTWEAR  ,  SHOP FOR YOU ");
        String iconPath = "D:\\DownLoad\\IconFootWear\\LogoShop.png";
        setIconImage(Toolkit.getDefaultToolkit().getImage(new File(iconPath).getAbsolutePath()));
//        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
//        menuPanel.setPreferredSize(new Dimension(100, getHeight()));
//        JPanel contentPanel = new JPanel(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        contentPanel.add(new JButton("Content 1"), gbc);
//        gbc.gridx = 1;
//        contentPanel.add(new JButton("Content 2"), gbc);
//        gbc.gridy = 1;
//        gbc.gridx = 0;
//        contentPanel.add(new JButton("Content 3"), gbc);
//        gbc.gridx = 1;
//        contentPanel.add(new JButton("Content 4"), gbc);
//        mainPanel.add(jPanel1, BorderLayout.WEST);
//        mainPanel.add(jPanel2, BorderLayout.CENTER);
//         contentJPanel1 = new JPanel(); 
//         contentJPanel1.setVisible(true);
//         JButton a= new JButton("nfgsdkg"); 
//         contentJPanel1.add(a); 
//         mainPanel.add(contentJPanel1);
//         add(mainPanel);
        // jPanel1.setVisible(false);
        // scaleImage();
         jLabel1.setText("<html>Our sales app is a powerful and user-friendly platform designed to help businesses manage their products, orders, and customers efficiently. With an intuitive interface and advanced features like real-time inventory tracking, secure payment integration, and automated order processing, our app makes selling easier than ever. Whether you're a small business or a large enterprise, our solution is tailored to boost your sales and streamline your operations.</html>");
        // setSize(UIScale.scale(new Dimension(1320, 770) ));
        
    }
//   public  void scaleImage(){
//        ImageIcon icon = new ImageIcon(getClass().getResource("/Image/Slogan.jpeg"));
//        Image img = icon.getImage();
//        Image imgScale = img.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon acalledIcon = new ImageIcon(imgScale );
//        jLabel1.setIcon(acalledIcon);
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnLogOut = new javax.swing.JButton();
        btnHomePage = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(255, 51, 51)));
        jPanel4.setPreferredSize(new java.awt.Dimension(1293, 70));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/LogoShop.png"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(255, 0, 51)));
        jLabel2.setMaximumSize(new java.awt.Dimension(115, 110));
        jLabel2.setMinimumSize(new java.awt.Dimension(120, 110));
        jLabel2.setOpaque(true);
        jLabel2.setPreferredSize(new java.awt.Dimension(115, 110));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Viner Hand ITC", 1, 30)); // NOI18N
        jLabel3.setText("WELCOME TO SHOP FOR YOU");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanel4.add(jLabel3, gridBagConstraints);

        jPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(255, 51, 51)));
        jPanel5.setPreferredSize(new java.awt.Dimension(120, 720));

        btnLogOut.setBackground(new java.awt.Color(204, 204, 204));
        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/.png"))); // NOI18N
        btnLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogOutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogOutMouseExited(evt);
            }
        });

        btnHomePage.setBackground(new java.awt.Color(204, 204, 204));
        btnHomePage.setForeground(new java.awt.Color(255, 255, 255));
        btnHomePage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/HomeShop.png"))); // NOI18N
        btnHomePage.setText("HOME");
        btnHomePage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHomePageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHomePageMouseExited(evt);
            }
        });

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        jButton3.setText("Your Profile");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
            .addComponent(btnHomePage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnHomePage, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jButton1)
                .addGap(32, 32, 32)
                .addComponent(jButton2)
                .addGap(28, 28, 28)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 354, Short.MAX_VALUE)
                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel5, java.awt.BorderLayout.LINE_START);

        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(1200, 634));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(351, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(240, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1310, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogOutMouseClicked
       Run.runApp();
       dispose();
    }//GEN-LAST:event_btnLogOutMouseClicked

    private void btnLogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogOutMouseEntered
        btnLogOut.setBackground(Color.RED);
    }//GEN-LAST:event_btnLogOutMouseEntered

    private void btnLogOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogOutMouseExited
        btnLogOut.setBackground(Color.lightGray);
    }//GEN-LAST:event_btnLogOutMouseExited

    private void btnHomePageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomePageMouseEntered
       btnHomePage.setBackground(Color.red);
    }//GEN-LAST:event_btnHomePageMouseEntered

    private void btnHomePageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomePageMouseExited
        btnHomePage.setBackground(Color.lightGray);
    }//GEN-LAST:event_btnHomePageMouseExited

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHomePage;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
