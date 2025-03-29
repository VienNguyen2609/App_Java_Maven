package Model;

import FormLogin.FormLoginUser;
import Main.Run;
import com.formdev.flatlaf.FlatDarkLaf;
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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ButtonHomePage = new javax.swing.JButton();
        ButtonLogOut = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        mainPanel.setMinimumSize(new java.awt.Dimension(410, 40));
        mainPanel.setLayout(new java.awt.BorderLayout());

        menuPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(255, 51, 51)));
        menuPanel.setPreferredSize(new java.awt.Dimension(102, 704));

        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\DownLoad\\result_AVATA.jpeg")); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel2.setFocusable(false);
        jLabel2.setPreferredSize(new java.awt.Dimension(99, 98));

        ButtonHomePage.setBackground(new java.awt.Color(153, 153, 153));
        ButtonHomePage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ButtonHomePage.setForeground(new java.awt.Color(255, 255, 255));
        ButtonHomePage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/HomeShop.png"))); // NOI18N
        ButtonHomePage.setText("HOME");
        ButtonHomePage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonHomePageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonHomePageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonHomePageMouseExited(evt);
            }
        });

        ButtonLogOut.setBackground(new java.awt.Color(153, 153, 153));
        ButtonLogOut.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonLogOut.setForeground(new java.awt.Color(255, 255, 255));
        ButtonLogOut.setText("LogOut");
        ButtonLogOut.setMaximumSize(new java.awt.Dimension(96, 27));
        ButtonLogOut.setMinimumSize(new java.awt.Dimension(96, 27));
        ButtonLogOut.setPreferredSize(new java.awt.Dimension(96, 27));
        ButtonLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonLogOutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonLogOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonLogOutMouseExited(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ButtonLogOut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonHomePage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(ButtonHomePage, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 447, Short.MAX_VALUE)
                .addComponent(ButtonLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mainPanel.add(menuPanel, java.awt.BorderLayout.LINE_START);

        contentPanel.setMinimumSize(new java.awt.Dimension(410, 400));
        contentPanel.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel1.setText("WELCOME TO SHOP FOR YOU!");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 1.0;
        contentPanel.add(jLabel1, gridBagConstraints);

        mainPanel.add(contentPanel, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonLogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLogOutMouseEntered
        ButtonLogOut.setBackground(Color.red);
    }//GEN-LAST:event_ButtonLogOutMouseEntered

    private void ButtonLogOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLogOutMouseExited
        ButtonLogOut.setBackground(Color.lightGray);
    }//GEN-LAST:event_ButtonLogOutMouseExited

    private void ButtonHomePageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonHomePageMouseEntered
        ButtonHomePage.setBackground(Color.red);
    }//GEN-LAST:event_ButtonHomePageMouseEntered

    private void ButtonHomePageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonHomePageMouseExited
        ButtonHomePage.setBackground(Color.lightGray);
    }//GEN-LAST:event_ButtonHomePageMouseExited

    private void ButtonLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLogOutMouseClicked
        Run.runApp();
        dispose();
    }//GEN-LAST:event_ButtonLogOutMouseClicked

    private void ButtonHomePageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonHomePageMouseClicked
//    jPanel1.setVisible(true);
//    contentPanel.setVisible(false);
    }//GEN-LAST:event_ButtonHomePageMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
//       jPanel1.setVisible(false);
//    contentPanel.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonHomePage;
    private javax.swing.JButton ButtonLogOut;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel menuPanel;
    // End of variables declaration//GEN-END:variables
}
