
package Forms;

import Controllers.AccountController;
import Controllers.LoginController;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;



public class CreateAccount extends javax.swing.JFrame {

    
    public CreateAccount() {
        initComponents();
        setTitle("Create Account");
        setLocationRelativeTo(null);
        setResizable(false);
         String iconPath = "D:\\DownLoad\\IconFootWear\\result_social.png";
        setIconImage(Toolkit.getDefaultToolkit().getImage(new File(iconPath).getAbsolutePath()));
        LoginController.Init();
        AccountController.Init();
        try {
            LoginController.instance.BufferedImage("D:\\DownLoad\\IconFootWear\\BackGroundLogin1.png", Label);
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        jLabel6.setVisible(false);
        LoginController.instance.FocusPointer(txtName, LabelNameUser, jLabel9, Color.GREEN, Color.WHITE);
        LoginController.instance.FocusPointer(txtPassword, LabelPasswordUser, jLabel8, Color.GREEN, Color.WHITE);
        LoginController.instance.FocusPointer(txtGmail, LabelGmailUser, jLabel7, Color.GREEN, Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtName = new Forms.Components.TextFieldController();
        txtPassword = new Forms.Components.TextFieldController();
        txtGmail = new Forms.Components.TextFieldController();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        LabelGmailUser = new javax.swing.JLabel();
        LabelPasswordUser = new javax.swing.JLabel();
        LabelNameUser = new javax.swing.JLabel();
        headerButton1 = new Forms.Components.HeaderButton();
        CreateMessage = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Label = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/LogoShopImage.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 130));

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtName.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/NameIcon.png"))); // NOI18N
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 300, -1));

        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPassword.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PassIcon.png"))); // NOI18N
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 270, -1));

        txtGmail.setForeground(new java.awt.Color(255, 255, 255));
        txtGmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtGmail.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/GmailIcon.png"))); // NOI18N
        jPanel1.add(txtGmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 300, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Sign Up");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("__________________________________________________");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 260, 30));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("__________________________________________________");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 260, 30));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("__________________________________________________");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 260, 30));

        LabelGmailUser.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        LabelGmailUser.setForeground(new java.awt.Color(255, 255, 255));
        LabelGmailUser.setText("UserGmail");
        jPanel1.add(LabelGmailUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 80, -1));

        LabelPasswordUser.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        LabelPasswordUser.setForeground(new java.awt.Color(255, 255, 255));
        LabelPasswordUser.setText("UserPassword");
        jPanel1.add(LabelPasswordUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 100, -1));

        LabelNameUser.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        LabelNameUser.setForeground(new java.awt.Color(255, 255, 255));
        LabelNameUser.setText("UserName");
        jPanel1.add(LabelNameUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 80, -1));

        headerButton1.setBackground(new java.awt.Color(204, 255, 204));
        headerButton1.setText("Sign Up");
        headerButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        headerButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                headerButton1MouseClicked(evt);
            }
        });
        jPanel1.add(headerButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 170, -1));

        CreateMessage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CreateMessage.setForeground(new java.awt.Color(255, 51, 51));
        CreateMessage.setToolTipText("");
        jPanel1.add(CreateMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 286, 320, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Go to sign in ==>");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 130, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 255, 255));
        jLabel5.setText("Sign In");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, 60, 30));

        jLabel6.setText("_____________");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, 70, 40));
        jPanel1.add(Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 420));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 360, 420));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("© ShopFootWear 2025. Redistribution or reproduction is strictly prohibited. ");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 530, 520, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/BackgroundLogin.png"))); // NOI18N
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void headerButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerButton1MouseClicked
        AccountController.instance.LoadAccount();
        try {
            String name = this.txtName.getText().trim();
            String pass = this.txtPassword.getText().trim();
            String gmail = this.txtGmail.getText().trim();
            String inputText = name;
            if (name.equalsIgnoreCase("EnterName....") || pass.equalsIgnoreCase("EnterPassword...") || gmail.equalsIgnoreCase("EnterGmail.....")) {
                CreateMessage.setText("error: INFORMATION CAN NOT  BE EMPTY");
                return;
            } else if (name.equalsIgnoreCase("") || pass.equalsIgnoreCase("") || gmail.equalsIgnoreCase("")) {
                CreateMessage.setText("error:: INFORMATION CAN NOT  BE EMPTY");
                return;
            } else if (!gmail.contains("@gmail.com")) {
                CreateMessage.setText("error: GMAIL FALSE");
                return;
            } else if (LoginController.instance.containsVietnameseCharacters(inputText)) {
                CreateMessage.setText("error: USER NAME FALSE!");
                return;
            } else if (pass.length() < 7 || name.length() < 4) {
                CreateMessage.setText("error: LENGTH PASSWORD >= 7 AND NAME >=4");
                return;
            } else if (AccountController.instance.addAccount(name, pass, gmail)) {
                CreateMessage.setText("Create Account Successfully");

            } else {
                CreateMessage.setText("error: name is exist");
                return;
            }
        } catch (Exception e) {
            //  JOptionPane.showMessageDialog(this, "error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_headerButton1MouseClicked

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        jLabel6.setVisible(true);
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        jLabel6.setVisible(false);
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        new LoginUser().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

  
    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CreateMessage;
    private javax.swing.JLabel Label;
    private javax.swing.JLabel LabelGmailUser;
    private javax.swing.JLabel LabelNameUser;
    private javax.swing.JLabel LabelPasswordUser;
    private Forms.Components.HeaderButton headerButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private Forms.Components.TextFieldController txtGmail;
    private Forms.Components.TextFieldController txtName;
    private Forms.Components.TextFieldController txtPassword;
    // End of variables declaration//GEN-END:variables
}
