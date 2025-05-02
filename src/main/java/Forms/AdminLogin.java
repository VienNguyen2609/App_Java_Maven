package Forms;

import Controllers.AccountController;
import Forms.Components.EffectComponents;
import Model.Account;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AdminLogin extends javax.swing.JFrame {

    public AdminLogin() {
        initComponents();
        setTitle("Admin Login");
        String iconPath = "D:\\DownLoad\\IconFootWear\\result_social.png";
        setIconImage(Toolkit.getDefaultToolkit().getImage(new File(iconPath).getAbsolutePath()));
        setLocationRelativeTo(null);
        setResizable(false);
        EffectComponents.init();
        txtPassword.setOpaque(false);
        txtPassword.setBackground(null);
        StraightLine3.setVisible(false);
        AccountController.init();
        EffectComponents.instance.focusPointer1(txtName, jLabel8, Color.GREEN, Color.WHITE);
        EffectComponents.instance.focusPointer1(txtPassword, jLabel7, Color.GREEN, Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtName = new Forms.Components.TextFieldController();
        txtPassword = new Forms.Components.PasswordField();
        headerButton1 = new Forms.Components.HeaderButton();
        CheckPass = new javax.swing.JCheckBox();
        StraightLine3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        LabelMessage = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/LogoShopImage.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 110));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("_______________________________________________");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, 240, 20));

        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtName.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/result_setting.png"))); // NOI18N
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 230, 30));

        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setEchoChar('\u002A');
        txtPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPassword.setOpaque(true);
        txtPassword.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/result_padlock.png"))); // NOI18N
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 230, 40));

        headerButton1.setBackground(new java.awt.Color(204, 255, 204));
        headerButton1.setText("Login");
        headerButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        headerButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                headerButton1MouseClicked(evt);
            }
        });
        jPanel1.add(headerButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, 220, -1));

        CheckPass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckPass.setForeground(new java.awt.Color(255, 255, 255));
        CheckPass.setText("Show Password");
        CheckPass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        CheckPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CheckPassMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CheckPassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CheckPassMouseExited(evt);
            }
        });
        jPanel1.add(CheckPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, -1, 30));

        StraightLine3.setForeground(new java.awt.Color(255, 255, 255));
        StraightLine3.setText("__________________________");
        jPanel1.add(StraightLine3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 140, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("SHOPEEKY");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 110, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("SHOP MANAGER ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 160, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("© SHOPEEKY 2025. Redistribution or reproduction is strictly prohibited. ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 580, 520, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Password");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 70, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Name");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, -1, -1));

        LabelMessage.setBackground(new java.awt.Color(255, 51, 51));
        LabelMessage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelMessage.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.add(LabelMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 300, 20));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("_______________________________________________");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 240, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(" Login For Admin");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/BackgroundLoginAdmin.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 636));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/BackgroundLoginAdmin.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 636));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void headerButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerButton1MouseClicked

        String name = this.txtName.getText().trim();
        String password = this.txtPassword.getText().trim();
        AccountController.instance.loadDataAccounts();
        if (name.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
            try {
                UIManager.setLookAndFeel(new FlatDarkLaf());
            } catch (UnsupportedLookAndFeelException e) {
                Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, e);
            }
            Account user = AccountController.instance.getAccountByUsername(name);
            new HomePage(user).setVisible(true);
            dispose();
        } else if (name.isEmpty() || password.isEmpty()) {
            LabelMessage.setText("erroe: Information not blank ");
        } else {
            LabelMessage.setText("error: Name or password false!");
        }

    }//GEN-LAST:event_headerButton1MouseClicked

    private void CheckPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CheckPassMouseClicked

        if (CheckPass.isSelected()) {
            txtPassword.setEchoChar((char) 0);
        } else {
            txtPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_CheckPassMouseClicked

    private void CheckPassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CheckPassMouseEntered
         StraightLine3.setVisible(true);
    }//GEN-LAST:event_CheckPassMouseEntered

    private void CheckPassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CheckPassMouseExited
         StraightLine3.setVisible(false);
    }//GEN-LAST:event_CheckPassMouseExited

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new AdminLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckPass;
    private javax.swing.JLabel LabelMessage;
    private javax.swing.JLabel StraightLine3;
    private Forms.Components.HeaderButton headerButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private Forms.Components.TextFieldController txtName;
    private Forms.Components.PasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
