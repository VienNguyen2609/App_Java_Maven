package FormLogin;

import Model.ControllerAccount;
import Model.LoginController;
import Model.HomePage;
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FormLoginUser extends javax.swing.JFrame {

    // private Point fixedLocation;
    public FormLoginUser() throws IOException {
        initComponents();
        setTitle("Login");
        setLocationRelativeTo(null);
        LoginController.Init();
        setResizable(false);
        this.Register.setLocation(300, 200);
        txtName.setOpaque(false);
        txtName.setBackground(null);
        txtName.setBorder(BorderFactory.createBevelBorder(0));
        txtPassword.setOpaque(false);
        txtPassword.setBackground(null);
        txtPassword.setBorder(BorderFactory.createBevelBorder(0));
        CheckPass.setOpaque(false);
        CheckPass.setBackground(null);
        CheckPass.setBorder(BorderFactory.createBevelBorder(0));
        txtPassword1.setOpaque(false);
        txtPassword1.setBackground(null);
        txtPassword1.setBorder(BorderFactory.createBevelBorder(0));
        txtNameUser.setOpaque(false);
        txtNameUser.setBackground(null);
        txtNameUser.setBorder(BorderFactory.createBevelBorder(0));
        txtGmail.setOpaque(false);
        txtGmail.setBackground(null);
        txtGmail.setBorder(BorderFactory.createBevelBorder(0));
        //bntLogin.setOpaque(false);
        LoginController.instance.addPlaceHolderStyle(txtName, Color.WHITE);
        LoginController.instance.addPlaceHolderStyle(txtPassword, Color.WHITE);
        LoginController.instance.addPlaceHolderStyle(txtNameUser, Color.DARK_GRAY);
        LoginController.instance.addPlaceHolderStyle(txtPassword1, Color.DARK_GRAY);
        LoginController.instance.addPlaceHolderStyle(txtGmail, Color.DARK_GRAY);
        //  Register.setVisible(false);
        Register.setUndecorated(true);
        //fixedLocation = getLocation(); 
        BufferedImage image = ImageIO.read(new File("D:\\DownLoad\\IconFootWear\\BackGrounds.jpg"));
        LoginController.instance.makeTransparent(image, 0.5f, LabelRegister);
        StraightLine.setVisible(false);
        StraightLine2.setVisible(false);
        LabelNameUser.setVisible(false);
        LabelPasswordUser.setVisible(false);
        LabelNameRegister.setVisible(false);
        //LoginPanel.setOpaque(false);       
        BufferedImage imageLabelLogin = ImageIO.read(new File("D:\\DownLoad\\IconFootWear\\BackGroundLogin1.png"));
        LoginController.instance.makeTransparent(imageLabelLogin, 0.4f, LoginLabel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Register = new javax.swing.JDialog();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtGmail = new javax.swing.JTextField();
        txtNameUser = new javax.swing.JTextField();
        txtPassword1 = new javax.swing.JPasswordField();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        LabelNameRegister = new javax.swing.JLabel();
        CreateMessage = new javax.swing.JLabel();
        LabelRegister = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        bntLogin = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        CheckPass = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        StraightLine = new javax.swing.JLabel();
        StraightLine2 = new javax.swing.JLabel();
        LabelNameUser = new javax.swing.JLabel();
        LabelPasswordUser = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        LoginMessage = new javax.swing.JLabel();
        LoginLabel = new javax.swing.JLabel();
        BackgroupFormCreate = new javax.swing.JLabel();

        Register.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Register.setModal(true);
        Register.setSize(new java.awt.Dimension(340, 360));
        Register.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setBackground(new java.awt.Color(255, 204, 204));
        jButton4.setText("Cancel!");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        Register.getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Register");
        Register.getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 90, -1));

        txtGmail.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        txtGmail.setText("EnterGmail.....");
        txtGmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtGmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtGmailFocusLost(evt);
            }
        });
        Register.getContentPane().add(txtGmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 180, 30));

        txtNameUser.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        txtNameUser.setText("EnterName....");
        txtNameUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNameUserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameUserFocusLost(evt);
            }
        });
        Register.getContentPane().add(txtNameUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 180, 30));

        txtPassword1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        txtPassword1.setText("EnterPassword...");
        txtPassword1.setEchoChar('\u0000');
        txtPassword1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPassword1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPassword1FocusLost(evt);
            }
        });
        Register.getContentPane().add(txtPassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 180, -1));

        jButton3.setBackground(new java.awt.Color(255, 204, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Register Account!");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        Register.getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 200, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/AvatarLogin.png"))); // NOI18N
        Register.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 40, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/LockLogin.png"))); // NOI18N
        Register.getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 30, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/GmailIcon.png"))); // NOI18N
        Register.getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        LabelNameRegister.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        LabelNameRegister.setText("EnterName...");
        Register.getContentPane().add(LabelNameRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        CreateMessage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CreateMessage.setForeground(new java.awt.Color(255, 0, 51));
        Register.getContentPane().add(CreateMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 300, 20));
        Register.getContentPane().add(LabelRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 360));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtName.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        txtName.setText("EnterName.....");
        txtName.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txtName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameFocusLost(evt);
            }
        });
        txtName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNameMouseClicked(evt);
            }
        });
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 180, 210, 30));

        bntLogin.setBackground(new java.awt.Color(255, 204, 204));
        bntLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bntLogin.setText("Login");
        bntLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntLoginMouseClicked(evt);
            }
        });
        getContentPane().add(bntLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 340, 180, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/result_1174963c-634d-4bc2-8eda-afad0fa3d96b.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, -1, 70));

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
        getContentPane().add(CheckPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 280, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Don't have an account ?");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 370, 170, 30));

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
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 370, -1, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Login To Your Account");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 130, 230, -1));

        txtPassword.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        txtPassword.setText("EnterPass....");
        txtPassword.setEchoChar('\u0000');
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPasswordMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtPasswordMouseExited(evt);
            }
        });
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 240, 210, 30));

        StraightLine.setText("____________");
        getContentPane().add(StraightLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 380, 120, 20));

        StraightLine2.setText("________________");
        getContentPane().add(StraightLine2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 290, 140, -1));

        LabelNameUser.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        LabelNameUser.setForeground(new java.awt.Color(255, 255, 255));
        LabelNameUser.setText("UserName");
        getContentPane().add(LabelNameUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 160, 80, -1));

        LabelPasswordUser.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        LabelPasswordUser.setForeground(new java.awt.Color(255, 255, 255));
        LabelPasswordUser.setText("UserPassword");
        getContentPane().add(LabelPasswordUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 220, 100, 20));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/LockLogin.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 230, -1, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/AvatarLogin.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, -1, -1));

        LoginMessage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LoginMessage.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(LoginMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 310, 270, 20));

        LoginLabel.setBackground(new java.awt.Color(255, 204, 204));
        LoginLabel.setName(""); // NOI18N
        getContentPane().add(LoginLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 330, 400));

        BackgroupFormCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/result_chika-fujiwara-3840x2160-16148.jpg"))); // NOI18N
        getContentPane().add(BackgroupFormCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 535));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusGained
        if (txtName.getText().equals("EnterName.....")) {
            txtName.setText(null);
            txtName.requestFocus();
            LoginController.instance.removePlaceHolderStyle(txtName, Color.WHITE);
            //  LabelNameUser.setVisible(false);
        }
    }//GEN-LAST:event_txtNameFocusGained

    private void txtNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusLost
        if (txtName.getText().length() == 0) {
            LoginController.instance.addPlaceHolderStyle(txtName, Color.WHITE);
            txtName.setText("EnterName.....");
            //  LabelNameUser.setVisible(false);
        }
    }//GEN-LAST:event_txtNameFocusLost

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        this.requestFocusInWindow();
    }//GEN-LAST:event_formWindowGainedFocus

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        if (txtPassword.getText().equals("EnterPass....")) {
            txtPassword.setText(null);
            txtPassword.requestFocus();
            //txtpass.setEchoChar();
            LoginController.instance.removePlaceHolderStyle(txtPassword, Color.WHITE);
        }
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        if (txtPassword.getText().length() == 0) {
            LoginController.instance.addPlaceHolderStyle(txtPassword, Color.WHITE);
            txtPassword.setText("EnterPass....");
            txtPassword.setEchoChar('\u0000');
        }
    }//GEN-LAST:event_txtPasswordFocusLost

    private void CheckPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CheckPassMouseClicked
        if (CheckPass.isSelected()) {
            txtPassword.setEchoChar((char) 0);
        } else {
            txtPassword.setEchoChar('*');
        }
        if (txtPassword.getText().length() != 0) {
            LabelPasswordUser.setVisible(true);
        }
        if (txtPassword.getText().equalsIgnoreCase("EnterPass....")) {
            LabelPasswordUser.setVisible(false);
        }
        if (txtPassword.getText().length() == 0) {
            LabelPasswordUser.setVisible(true);
        }

    }//GEN-LAST:event_CheckPassMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        //PanelCreate.setVisible(true);
        Register.setVisible(true);
//      Register.setLocationRelativeTo(this);
        Register.setLocation(300, 200);
        if (txtName.getText().length() != 0) {
            LabelNameUser.setVisible(true);
        }
        if (txtName.getText().equalsIgnoreCase("EnterName.....")) {
            LabelNameUser.setVisible(false);
        }
        LabelNameUser.setVisible(false);
        if (txtPassword.getText().length() != 0) {
            LabelPasswordUser.setVisible(true);
        }
        if (txtPassword.getText().equalsIgnoreCase("EnterPass....")) {
            LabelPasswordUser.setVisible(false);
        }
        if (txtPassword.getText().length() == 0) {
            LabelPasswordUser.setVisible(true);
        }
        // setLocation(fixedLocation);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        txtName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtPassword.requestFocus();

                }
            }
        });
        txtName.addActionListener(e -> txtPassword.requestFocus());

    }//GEN-LAST:event_txtNameActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        Register.setVisible(false);
    }//GEN-LAST:event_jButton4MouseClicked

    private void txtNameUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameUserFocusGained
        if (txtNameUser.getText().equals("EnterName....")) {
            txtNameUser.setText(null);
            txtNameUser.requestFocus();
            LoginController.instance.removePlaceHolderStyle(txtNameUser, Color.DARK_GRAY);
        }
    }//GEN-LAST:event_txtNameUserFocusGained

    private void txtNameUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameUserFocusLost
        if (txtNameUser.getText().length() == 0) {
            LoginController.instance.addPlaceHolderStyle(txtNameUser, Color.DARK_GRAY);
            txtNameUser.setText("EnterName....");
        }
    }//GEN-LAST:event_txtNameUserFocusLost

    private void txtPassword1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassword1FocusGained
        if (txtPassword1.getText().equals("EnterPassword...")) {
            txtPassword1.setText(null);
            txtPassword1.requestFocus();
            //txtpass.setEchoChar();
            LoginController.instance.removePlaceHolderStyle(txtPassword1, Color.DARK_GRAY);
        }
    }//GEN-LAST:event_txtPassword1FocusGained

    private void txtPassword1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassword1FocusLost
        if (txtPassword1.getText().length() == 0) {
            LoginController.instance.addPlaceHolderStyle(txtPassword1, Color.DARK_GRAY);
            txtPassword1.setText("EnterPassword...");
            txtPassword1.setEchoChar('\u0000');
        }
    }//GEN-LAST:event_txtPassword1FocusLost

    private void txtGmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGmailFocusGained
        if (txtGmail.getText().equals("EnterGmail.....")) {
            txtGmail.setText(null);
            txtGmail.requestFocus();
            LoginController.instance.removePlaceHolderStyle(txtGmail, Color.DARK_GRAY);
        }
    }//GEN-LAST:event_txtGmailFocusGained

    private void txtGmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGmailFocusLost
        if (txtGmail.getText().length() == 0) {
            LoginController.instance.addPlaceHolderStyle(txtGmail, Color.DARK_GRAY);
            txtGmail.setText("EnterGmail.....");
        }
    }//GEN-LAST:event_txtGmailFocusLost

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

    private void txtNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNameMouseClicked
        LabelNameUser.setVisible(true);
        if (txtPassword.getText().length() != 0) {
            LabelPasswordUser.setVisible(true);
        }
        if (txtPassword.getText().equalsIgnoreCase("EnterPass....")) {
            LabelPasswordUser.setVisible(false);
        }
        if (txtPassword.getText().length() == 0) {
            LabelPasswordUser.setVisible(true);
        }
    }//GEN-LAST:event_txtNameMouseClicked

    private void txtPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMouseClicked
        //LabelPasswordUser.setVisible(true);
        //LabelNameUser.setVisible(false);
        if (txtName.getText().length() != 0) {
            LabelNameUser.setVisible(true);
        }
        if (txtName.getText().equalsIgnoreCase("EnterName.....")) {
            LabelNameUser.setVisible(false);
        }
        if (txtPassword.getText().length() != 0) {
            LabelPasswordUser.setVisible(true);
        }
        if (txtPassword.getText().equalsIgnoreCase("EnterPass....")) {
            LabelPasswordUser.setVisible(false);
        }
        if (txtPassword.getText().length() == 0) {
            LabelPasswordUser.setVisible(true);
        }
    }//GEN-LAST:event_txtPasswordMouseClicked

    private void txtPasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMouseExited
        if (txtPassword.getText().length() != 0) {
            LabelPasswordUser.setVisible(true);
        }
        if (txtPassword.getText().equalsIgnoreCase("EnterPass....")) {
            LabelPasswordUser.setVisible(false);
        }
        if (txtPassword.getText().length() == 0) {
            LabelPasswordUser.setVisible(true);
        }
    }//GEN-LAST:event_txtPasswordMouseExited

    private void bntLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntLoginMouseClicked
        if (txtPassword.getText().length() != 0) {
            LabelPasswordUser.setVisible(true);
        }
        if (txtPassword.getText().equalsIgnoreCase("EnterPass....")) {
            LabelPasswordUser.setVisible(false);
        }
        if (txtPassword.getText().length() == 0) {
            LabelPasswordUser.setVisible(true);
        }
        ControllerAccount.Init();
        ControllerAccount.instance.LoadAccount();
        try {
            String name = this.txtName.getText().trim();
            String pass = this.txtPassword.getText().trim();
            if (name.equalsIgnoreCase("EnterName.....") || pass.equalsIgnoreCase("EnterPass....") || name.isEmpty() || pass.isEmpty()) {
                LoginMessage.setText("error: INFORMATION CAN NOT EMPTY");
            }
            if (ControllerAccount.instance.LoginUser(name, pass)) {
                try {
                    UIManager.setLookAndFeel(new FlatDarkLaf());
                } catch (UnsupportedLookAndFeelException e) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, e);
                }
                new HomePage().setVisible(true);
                this.dispose();
            } else {
//                JOptionPane.showMessageDialog(this, "LOGIN FAILD!\n"
//                        + "CHECK PASSWORD OR NAME");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unexpected error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bntLoginMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        ControllerAccount.Init();
        ControllerAccount.instance.LoadAccount();
        try {
            String name = this.txtNameUser.getText().trim();
            String pass = this.txtPassword1.getText().trim();
            String gmail = this.txtGmail.getText().trim();
            if (name.equalsIgnoreCase("EnterName....") || pass.equalsIgnoreCase("EnterPassword...") || gmail.equalsIgnoreCase("EnterGmail.....")) {
                CreateMessage.setText("error: INFORMATION CAN NOT  BE EMPTY");
                return;
            }
            if (name.equalsIgnoreCase("") || pass.equalsIgnoreCase("") || gmail.equalsIgnoreCase("")) {
                CreateMessage.setText("error:: INFORMATION CAN NOT  BE EMPTY");
                return;
            }

            if (!gmail.contains("@gmail.com")) {
                CreateMessage.setText("error: GMAIL FALSE");
                return;
            }
            String inputText = name;
            if (LoginController.instance.containsVietnameseCharacters(inputText)) {
                CreateMessage.setText("error: USER NAME FALSE!");
                return;
            }
            if (pass.length() < 7 || name.length() < 4) {
                CreateMessage.setText("error: LENGTH PASSWORD >= 7 AND NAME >=4");
                return;
            }
            if (ControllerAccount.instance.addAccount(name, pass, gmail)) {
                Register.setVisible(false);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3MouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FormLoginUser().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(FormLoginUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroupFormCreate;
    private javax.swing.JCheckBox CheckPass;
    private javax.swing.JLabel CreateMessage;
    private javax.swing.JLabel LabelNameRegister;
    private javax.swing.JLabel LabelNameUser;
    private javax.swing.JLabel LabelPasswordUser;
    private javax.swing.JLabel LabelRegister;
    private javax.swing.JLabel LoginLabel;
    private javax.swing.JLabel LoginMessage;
    private javax.swing.JDialog Register;
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
    private javax.swing.JTextField txtGmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNameUser;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPassword1;
    // End of variables declaration//GEN-END:variables
}
