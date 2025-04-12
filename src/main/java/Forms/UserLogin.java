package Forms;

import Controllers.AccountController;
import Controllers.LoginController;
import Model.Account;
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class UserLogin extends javax.swing.JFrame {

    private Color color;

    public UserLogin() {
        initComponents();
        setTitle("Login");

        // icon window
        String iconPath = "D:\\DownLoad\\IconFootWear\\result_social.png";
        setIconImage(Toolkit.getDefaultToolkit().getImage(new File(iconPath).getAbsolutePath()));
        setLocationRelativeTo(null);
        LoginController.Init();
        AccountController.Init();

        setResizable(false);
        txtName.setOpaque(false);
        txtName.setBackground(null);
        // txtName.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        LabelLogin.setOpaque(false);
        LabelLogin.setBackground(null);
        LabelLogin.setBorder(BorderFactory.createBevelBorder(0));
        txtPassword.setOpaque(false);
        txtPassword.setBackground(null);
        //  txtPassword.setBorder(BorderFactory.createBevelBorder(0));
        CheckPass.setOpaque(false);
        CheckPass.setBackground(null);
        CheckPass.setBorder(BorderFactory.createBevelBorder(0));

        try {
            LoginController.instance.BufferedImage("D:\\DownLoad\\IconFootWear\\BackGroundLogin1.png", LabelLogin);
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }

        StraightLine.setVisible(false);
        StraightLine3.setVisible(false);
        LoginController.instance.FocusPointer(txtName, LabelNameUser, jLabel7, Color.GREEN, Color.WHITE);
        LoginController.instance.FocusPointer(txtPassword, LabelPasswordUser, jLabel6, Color.GREEN, Color.WHITE);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtName = new Forms.Components.TextFieldController();
        LabelNameUser = new javax.swing.JLabel();
        txtPassword = new Forms.Components.PasswordField();
        jLabel6 = new javax.swing.JLabel();
        LabelPasswordUser = new javax.swing.JLabel();
        CheckPass = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        StraightLine = new javax.swing.JLabel();
        LoginMessage = new javax.swing.JLabel();
        headerButton1 = new Forms.Components.HeaderButton();
        StraightLine3 = new javax.swing.JLabel();
        LabelLogin = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        BackgroupFormCreate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/LogoShopImage.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 130));

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Login To Your Account");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 210, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("______________________________________________");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 260, 30));

        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.setToolTipText("");
        txtName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtName.setOpaque(true);
        txtName.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/NameIcon.png"))); // NOI18N
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 220, -1));

        LabelNameUser.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        LabelNameUser.setForeground(new java.awt.Color(255, 255, 255));
        LabelNameUser.setText("UserName");
        jPanel1.add(LabelNameUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 80, -1));

        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setToolTipText("");
        txtPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPassword.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PasswordIcon.png"))); // NOI18N
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 220, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("______________________________________________");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 260, 30));

        LabelPasswordUser.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        LabelPasswordUser.setForeground(new java.awt.Color(255, 255, 255));
        LabelPasswordUser.setText("UserPassword");
        jPanel1.add(LabelPasswordUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 100, -1));

        CheckPass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CheckPass.setForeground(new java.awt.Color(255, 255, 255));
        CheckPass.setText("Show Password");
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
        jPanel1.add(CheckPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Don't have an account ?");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 170, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 255, 204));
        jLabel4.setText("Register?");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, -1, 30));

        StraightLine.setText("________________");
        jPanel1.add(StraightLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, 110, 20));

        LoginMessage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LoginMessage.setForeground(new java.awt.Color(255, 102, 102));
        jPanel1.add(LoginMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 310, 20));

        headerButton1.setBackground(new java.awt.Color(255, 204, 51));
        headerButton1.setText("Sign In");
        headerButton1.setToolTipText("");
        headerButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        headerButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                headerButton1MouseClicked(evt);
            }
        });
        jPanel1.add(headerButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 240, -1));

        StraightLine3.setText("___________________");
        jPanel1.add(StraightLine3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 110, 25));
        jPanel1.add(LabelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 390, 400));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 370, 410));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("© FootWearShop 2025. Redistribution or reproduction is strictly prohibited. ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 530, 520, -1));

        jLabel8.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 255, 204));
        jLabel8.setText("WELCOME TO SHOP , LOGIN NOW  TO SHOPPING");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        BackgroupFormCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/BackgroundLogin.png"))); // NOI18N
        getContentPane().add(BackgroupFormCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        this.requestFocusInWindow();
    }//GEN-LAST:event_formWindowGainedFocus

    private void CheckPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CheckPassMouseClicked
        if (CheckPass.isSelected()) {
            txtPassword.setEchoChar((char) 0);
        } else {
            txtPassword.setEchoChar('*');
        }

    }//GEN-LAST:event_CheckPassMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        new CreateAccount().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        StraightLine.setVisible(true);
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        StraightLine.setVisible(false);
    }//GEN-LAST:event_jLabel4MouseExited

    private void CheckPassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CheckPassMouseEntered
        StraightLine3.setVisible(true);
    }//GEN-LAST:event_CheckPassMouseEntered

    private void CheckPassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CheckPassMouseExited
        StraightLine3.setVisible(false);
    }//GEN-LAST:event_CheckPassMouseExited

    private void headerButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerButton1MouseClicked
        AccountController.instance.LoadAccount();
//        try {
//
//            name = this.txtName.getText().trim();
//            password = this.txtPassword.getText().trim();
//
//            if (name.length() == 0 || password.length() == 0) {
//                LoginMessage.setText("error: INFORMATION CAN NOT EMPTY");
//            } else if (AccountController.instance.LoginUser(name, password)) {
//                try {
//                    UIManager.setLookAndFeel(new FlatDarkLaf());
//                } catch (UnsupportedLookAndFeelException e) {
//                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, e);
//                }
//                new HomePage(name, password).setVisible(true);
//                this.dispose();
//            } else {
//                LoginMessage.setText("error: NAME OR PASSWORD FALSE!");
//            }
//
//        } catch (Exception e) {
//            System.out.println("error: " + e.getMessage());
//        }
        AccountController.instance.LoadAccount();
        String username = txtName.getText();
        String password = String.valueOf(txtPassword.getPassword());

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, e);
        }
        if (AccountController.instance.CheckLogin(username, password)) {
            Account user = AccountController.instance.getAccountByUsername(username);
            new HomePage(user).setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_headerButton1MouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroupFormCreate;
    private javax.swing.JCheckBox CheckPass;
    private javax.swing.JLabel LabelLogin;
    private javax.swing.JLabel LabelNameUser;
    private javax.swing.JLabel LabelPasswordUser;
    private javax.swing.JLabel LoginMessage;
    private javax.swing.JLabel StraightLine;
    private javax.swing.JLabel StraightLine3;
    private Forms.Components.HeaderButton headerButton1;
    private javax.swing.JLabel jLabel1;
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
