package Forms;

import Controllers.AccountController;
import Controllers.LoginController;
import Forms.Components.HeaderButton;
import Forms.HomePage;
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LoginUser extends javax.swing.JFrame {

    private Color color;

    public LoginUser() {
        initComponents();
        setTitle("Login");
        // icon window
        String iconPath = "D:\\DownLoad\\IconFootWear\\LogoShop.png";
        setIconImage(Toolkit.getDefaultToolkit().getImage(new File(iconPath).getAbsolutePath()));
        setLocationRelativeTo(null);
        LoginController.Init();
        AccountController.Init();
        setResizable(false);
        txtName.setOpaque(false);
        txtName.setBackground(null);
        // txtName.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        FormCreate.setLocation(300, 200);
        FormCreate.setLocationRelativeTo(BackgroupFormCreate);
        LabelLogin.setOpaque(false);
        LabelLogin.setBackground(null);
        LabelLogin.setBorder(BorderFactory.createBevelBorder(0));
        txtPassword.setOpaque(false);
        txtPassword.setBackground(null);
        //  txtPassword.setBorder(BorderFactory.createBevelBorder(0));
        CheckPass.setOpaque(false);
        CheckPass.setBackground(null);
        CheckPass.setBorder(BorderFactory.createBevelBorder(0));
        txtPasswordCreate.setOpaque(false);
        txtPasswordCreate.setBackground(null);
        txtPasswordCreate.setBorder(BorderFactory.createBevelBorder(0));
        txtNameCreate.setOpaque(false);
        txtNameCreate.setBackground(null);
        txtNameCreate.setBorder(BorderFactory.createBevelBorder(0));
        txtGmail.setOpaque(false);
        txtGmail.setBackground(null);
        txtGmail.setBorder(BorderFactory.createBevelBorder(0));
        FormCreate.setUndecorated(true);
        try {
            LoginController.instance.BufferedImage(LabelRegister);
            LoginController.instance.BufferedImage1(LabelLogin);
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        StraightLine.setVisible(false);
        StraightLine2.setVisible(false);
        FormCreate.setLocation(300, 200);
        LoginController.instance.FocusPointer(txtName, LabelNameUser, Color.GREEN, Color.WHITE);
        LoginController.instance.FocusPointer(txtPassword, LabelPasswordUser, Color.GREEN, Color.WHITE);
        LoginController.instance.FocusPointer(txtNameCreate, LabelNameCreate, Color.DARK_GRAY, Color.lightGray);
        LoginController.instance.FocusPointer(txtPasswordCreate, LabelPasswordCreate, Color.DARK_GRAY, Color.lightGray);
        LoginController.instance.FocusPointer(txtGmail, LabelGmail, Color.DARK_GRAY, Color.lightGray);
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FormCreate = new javax.swing.JDialog();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtGmail = new javax.swing.JTextField();
        txtNameCreate = new javax.swing.JTextField();
        txtPasswordCreate = new javax.swing.JPasswordField();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        LabelPasswordCreate = new javax.swing.JLabel();
        LabelGmail = new javax.swing.JLabel();
        CreateMessage = new javax.swing.JLabel();
        LabelNameCreate = new javax.swing.JLabel();
        LabelRegister = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtName = new Forms.Components.TextFieldController();
        LabelNameUser = new javax.swing.JLabel();
        txtPassword = new Forms.Components.PasswordField();
        jLabel6 = new javax.swing.JLabel();
        LabelPasswordUser = new javax.swing.JLabel();
        bntLogin = new javax.swing.JButton();
        CheckPass = new javax.swing.JCheckBox();
        StraightLine2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        StraightLine = new javax.swing.JLabel();
        LoginMessage = new javax.swing.JLabel();
        LabelLogin = new javax.swing.JLabel();
        BackgroupFormCreate = new javax.swing.JLabel();

        FormCreate.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        FormCreate.setModal(true);
        FormCreate.setSize(new java.awt.Dimension(340, 360));
        FormCreate.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setBackground(new java.awt.Color(255, 204, 204));
        jButton4.setText("Cancel!");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        FormCreate.getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Register");
        FormCreate.getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 90, -1));

        txtGmail.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        txtGmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtGmailMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtGmailMouseExited(evt);
            }
        });
        FormCreate.getContentPane().add(txtGmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 180, 30));

        txtNameCreate.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        txtNameCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameCreateActionPerformed(evt);
            }
        });
        FormCreate.getContentPane().add(txtNameCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 180, 30));

        txtPasswordCreate.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        txtPasswordCreate.setEchoChar('\u0000');
        txtPasswordCreate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPasswordCreateMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtPasswordCreateMouseExited(evt);
            }
        });
        FormCreate.getContentPane().add(txtPasswordCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 180, -1));

        jButton3.setBackground(new java.awt.Color(255, 204, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Register Account!");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        FormCreate.getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 200, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/AvatarLogin.png"))); // NOI18N
        FormCreate.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 40, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/LockLogin.png"))); // NOI18N
        FormCreate.getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/GmailIcon.png"))); // NOI18N
        FormCreate.getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        LabelPasswordCreate.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        LabelPasswordCreate.setForeground(new java.awt.Color(204, 204, 204));
        LabelPasswordCreate.setText("EnterPassword");
        FormCreate.getContentPane().add(LabelPasswordCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        LabelGmail.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        LabelGmail.setForeground(new java.awt.Color(204, 204, 204));
        LabelGmail.setText("EnterGmail");
        FormCreate.getContentPane().add(LabelGmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        CreateMessage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CreateMessage.setForeground(new java.awt.Color(255, 0, 51));
        FormCreate.getContentPane().add(CreateMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 300, 20));

        LabelNameCreate.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        LabelNameCreate.setForeground(new java.awt.Color(204, 204, 204));
        LabelNameCreate.setText("EnterName");
        FormCreate.getContentPane().add(LabelNameCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        LabelRegister.setBackground(new java.awt.Color(255, 204, 204));
        FormCreate.getContentPane().add(LabelRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 390));

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

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/result_social.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 130));

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Login To Your Account");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 210, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("______________________________________________");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 240, 20));

        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.setToolTipText("");
        txtName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtName.setOpaque(true);
        txtName.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/AvatarLogin.png"))); // NOI18N
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 220, -1));

        LabelNameUser.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        LabelNameUser.setForeground(new java.awt.Color(255, 255, 255));
        LabelNameUser.setText("UserName");
        jPanel1.add(LabelNameUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 80, -1));

        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setToolTipText("");
        txtPassword.setEchoChar('*');
        txtPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPassword.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PassIcon.png"))); // NOI18N
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 220, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("______________________________________________");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 240, 20));

        LabelPasswordUser.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        LabelPasswordUser.setForeground(new java.awt.Color(255, 255, 255));
        LabelPasswordUser.setText("UserPassword");
        jPanel1.add(LabelPasswordUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 100, -1));

        bntLogin.setBackground(new java.awt.Color(255, 204, 204));
        bntLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bntLogin.setText("Login");
        bntLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntLoginMouseClicked(evt);
            }
        });
        jPanel1.add(bntLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 180, -1));

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
        jPanel1.add(CheckPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        StraightLine2.setText("___________________");
        jPanel1.add(StraightLine2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 226, 140, 20));

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
        jPanel1.add(LabelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 440));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 370, 440));

        BackgroupFormCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ChatGPT Image 20_09_49 10 thg 4, 2025.png"))); // NOI18N
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
        //PanelCreate.setVisible(true);
        FormCreate.setVisible(true);
//      Register.setLocationRelativeTo(this);

    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        StraightLine.setVisible(true);
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        StraightLine.setVisible(false);
    }//GEN-LAST:event_jLabel4MouseExited

    private void CheckPassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CheckPassMouseEntered
        StraightLine2.setVisible(true);
    }//GEN-LAST:event_CheckPassMouseEntered

    private void CheckPassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CheckPassMouseExited
        StraightLine2.setVisible(false);
    }//GEN-LAST:event_CheckPassMouseExited

    private void bntLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntLoginMouseClicked
        AccountController.instance.LoadAccount();
        try {
            String name = this.txtName.getText().trim();
            String pass = this.txtPassword.getText().trim();
            if (name.length() == 0 || pass.length() == 0) {
                LoginMessage.setText("error: INFORMATION CAN NOT EMPTY");
            } else if (AccountController.instance.LoginUser(name, pass)) {
                try {
                    UIManager.setLookAndFeel(new FlatDarkLaf());
                } catch (UnsupportedLookAndFeelException e) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, e);
                }
                new HomePage().setVisible(true);
                this.dispose();
            } else {
                LoginMessage.setText("error: NAME OR PASSWORD FALSE!");
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_bntLoginMouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        FormCreate.setVisible(false);
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        AccountController.instance.LoadAccount();
        try {
            String name = this.txtNameCreate.getText().trim();
            String pass = this.txtPasswordCreate.getText().trim();
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
                FormCreate.setVisible(false);
            }
            else{
                CreateMessage.setText("error: name is exist");
                return ;
            }

        } catch (Exception e) {
            //  JOptionPane.showMessageDialog(this, "error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void txtNameCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameCreateActionPerformed
        txtNameCreate.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtPasswordCreate.requestFocus();
                    txtGmail.requestFocus();

                }
            }
        });
        txtNameCreate.addActionListener(e -> txtPasswordCreate.requestFocus());
        txtPasswordCreate.addActionListener(e -> txtGmail.requestFocus());
    }//GEN-LAST:event_txtNameCreateActionPerformed

    private void txtPasswordCreateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordCreateMouseClicked
        LabelPasswordCreate.setForeground(Color.darkGray);
    }//GEN-LAST:event_txtPasswordCreateMouseClicked

    private void txtPasswordCreateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordCreateMouseExited
        if (txtPasswordCreate.getText().length() == 0) {
            LabelPasswordCreate.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_txtPasswordCreateMouseExited

    private void txtGmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGmailMouseClicked
        LabelGmail.setForeground(Color.DARK_GRAY);
    }//GEN-LAST:event_txtGmailMouseClicked

    private void txtGmailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGmailMouseExited
        if (txtGmail.getText().length() == 0) {
            LabelGmail.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_txtGmailMouseExited

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroupFormCreate;
    private javax.swing.JCheckBox CheckPass;
    private javax.swing.JLabel CreateMessage;
    private javax.swing.JDialog FormCreate;
    private javax.swing.JLabel LabelGmail;
    private javax.swing.JLabel LabelLogin;
    private javax.swing.JLabel LabelNameCreate;
    private javax.swing.JLabel LabelNameUser;
    private javax.swing.JLabel LabelPasswordCreate;
    private javax.swing.JLabel LabelPasswordUser;
    private javax.swing.JLabel LabelRegister;
    private javax.swing.JLabel LoginMessage;
    private javax.swing.JLabel StraightLine;
    private javax.swing.JLabel StraightLine2;
    private javax.swing.JButton bntLogin;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JTextField txtGmail;
    private Forms.Components.TextFieldController txtName;
    private javax.swing.JTextField txtNameCreate;
    private Forms.Components.PasswordField txtPassword;
    private javax.swing.JPasswordField txtPasswordCreate;
    // End of variables declaration//GEN-END:variables
}
