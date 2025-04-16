package Forms;

import Forms.Components.EffectComponents;
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
        EffectComponents.Init();
      //  EffectComponents.instance.FocusPointer(txtName, null, jLabel8, null, null);
    }
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPassword = new Forms.Components.TextFieldController();
        txtName = new Forms.Components.TextFieldController();
        headerButton1 = new Forms.Components.HeaderButton();
        LabelMessage = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/LogoShopImage.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 110));

        jLabel7.setText("_______________________________________________");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, 240, 20));

        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtPassword.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/result_padlock.png"))); // NOI18N
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 230, 40));

        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtName.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/result_setting.png"))); // NOI18N
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 230, 30));

        headerButton1.setBackground(new java.awt.Color(204, 255, 204));
        headerButton1.setText("Login");
        headerButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        headerButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                headerButton1MouseClicked(evt);
            }
        });
        jPanel1.add(headerButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, 220, -1));

        LabelMessage.setBackground(new java.awt.Color(255, 51, 51));
        LabelMessage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelMessage.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.add(LabelMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, 300, 20));

        jLabel8.setText("_______________________________________________");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 240, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(" Login For Admin");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/BackgroundLoginAdmin.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 636));

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
        
        if (name.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
            try {
                UIManager.setLookAndFeel(new FlatDarkLaf());
            } catch (UnsupportedLookAndFeelException e) {
                Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, e);
            }
            new HomePage().setVisible(true);
            dispose();
        }
        
        else if (name.isEmpty() || password.isEmpty()) {           
            LabelMessage.setText("erroe: Information not blank ");          
        }
        
        else {           
            LabelMessage.setText("error: Name or password false!");       
        }
    }//GEN-LAST:event_headerButton1MouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(new FlatLightLaf());
                } catch (UnsupportedLookAndFeelException e) {
                    Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, e);
                }
                new AdminLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelMessage;
    private Forms.Components.HeaderButton headerButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private Forms.Components.TextFieldController txtName;
    private Forms.Components.TextFieldController txtPassword;
    // End of variables declaration//GEN-END:variables
}
