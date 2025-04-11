package Forms;

import Forms.Components.RoundedBorder;
import Main.Run;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;

public class HomePage extends javax.swing.JFrame {

    private File selectedFile;
    private String name, password, gmail;

    public String getName() {
        return name;
    }

    public HomePage() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HomePage(String name, String password) {
        this.name = name;
        this.password = password;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("FOOTWEAR  ,  SHOP FOR YOU ");
        String iconPath = "D:\\DownLoad\\IconFootWear\\result_social.png";
        setIconImage(Toolkit.getDefaultToolkit().getImage(new File(iconPath).getAbsolutePath()));

        //jLabel1.setText("<html>Our sales app is a powerful and user-friendly platform designed to help businesses manage their products, orders, and customers efficiently. With an intuitive interface and advanced features like real-time inventory tracking, secure payment integration, and automated order processing, our app makes selling easier than ever. Whether you're a small business or a large enterprise, our solution is tailored to boost your sales and streamline your operations.</html>");
        btnUploadAvatar.setBackgroundColor(Color.GREEN);
        btnProfle.setBackgroundColor(Color.GRAY);
        btnHomePage.setBackgroundColor(Color.GRAY);
        btnLogOut.setBackgroundColor(Color.GRAY);
        PanelProfile.setVisible(false);
        PanelHomePage.setVisible(false);
        btnEditProfile.setBackgroundColor(Color.GREEN);
        LabelNameProfile.setText("Name: " + name);
        LabelPasswordProfile.setText("Password: " + password);
        LabelGmailProfile.setText("Gmail: " + gmail);

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
        LabelLogo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        PanelMenu = new javax.swing.JPanel();
        btnProfle = new Forms.Components.HeaderButton();
        btnHomePage = new Forms.Components.HeaderButton();
        btnLogOut = new Forms.Components.HeaderButton();
        PanelContents = new javax.swing.JPanel();
        PanelHomePage = new javax.swing.JPanel();
        PanelProfile = new javax.swing.JPanel();
        LabelAvatar = new Forms.Components.ProfilePhoto();
        btnUploadAvatar = new Forms.Components.HeaderButton();
        LabelGmailProfile = new javax.swing.JLabel();
        LabelNameProfile = new javax.swing.JLabel();
        LabelPasswordProfile = new javax.swing.JLabel();
        btnEditProfile = new Forms.Components.HeaderButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel4.setMinimumSize(new java.awt.Dimension(562, 120));
        jPanel4.setPreferredSize(new java.awt.Dimension(1293, 90));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        LabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/LogoShopImage.png"))); // NOI18N
        LabelLogo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 0, 51)));
        LabelLogo.setMaximumSize(new java.awt.Dimension(150, 150));
        LabelLogo.setMinimumSize(new java.awt.Dimension(130, 130));
        LabelLogo.setOpaque(true);
        LabelLogo.setPreferredSize(new java.awt.Dimension(130, 125));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(LabelLogo, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Viner Hand ITC", 1, 30)); // NOI18N
        jLabel3.setText("NGUYỄN BÁ VIÊN");
        jLabel3.setVerifyInputWhenFocusTarget(false);
        jLabel3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jLabel3, gridBagConstraints);

        jPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        PanelMenu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        PanelMenu.setOpaque(false);
        PanelMenu.setPreferredSize(new java.awt.Dimension(137, 720));
        PanelMenu.setRequestFocusEnabled(false);

        btnProfle.setForeground(new java.awt.Color(204, 255, 255));
        btnProfle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/result_account.png"))); // NOI18N
        btnProfle.setText("Profile");
        btnProfle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProfleMouseClicked(evt);
            }
        });

        btnHomePage.setForeground(new java.awt.Color(204, 255, 255));
        btnHomePage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/homeIcon.png"))); // NOI18N
        btnHomePage.setText("Home");
        btnHomePage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomePageMouseClicked(evt);
            }
        });
        btnHomePage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomePageActionPerformed(evt);
            }
        });

        btnLogOut.setForeground(new java.awt.Color(204, 255, 255));
        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logoutIcon.png"))); // NOI18N
        btnLogOut.setText("Sign Out");
        btnLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogOutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelMenuLayout.createSequentialGroup()
                        .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnProfle, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHomePage, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenuLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnHomePage, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 415, Short.MAX_VALUE)
                .addComponent(btnProfle, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(PanelMenu, java.awt.BorderLayout.LINE_START);

        PanelContents.setOpaque(false);
        PanelContents.setPreferredSize(new java.awt.Dimension(1200, 634));

        javax.swing.GroupLayout PanelHomePageLayout = new javax.swing.GroupLayout(PanelHomePage);
        PanelHomePage.setLayout(PanelHomePageLayout);
        PanelHomePageLayout.setHorizontalGroup(
            PanelHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1167, Short.MAX_VALUE)
        );
        PanelHomePageLayout.setVerticalGroup(
            PanelHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 628, Short.MAX_VALUE)
        );

        PanelProfile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelAvatar.setIcon(new javax.swing.ImageIcon("D:\\DownLoad\\bear.png")); // NOI18N
        PanelProfile.add(LabelAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 170, 130));

        btnUploadAvatar.setBackground(new java.awt.Color(153, 153, 255));
        btnUploadAvatar.setForeground(new java.awt.Color(255, 255, 255));
        btnUploadAvatar.setText("Upload Avatar");
        btnUploadAvatar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUploadAvatarMouseClicked(evt);
            }
        });
        PanelProfile.add(btnUploadAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 150, -1));

        LabelGmailProfile.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        LabelGmailProfile.setText("Gmail:");
        PanelProfile.add(LabelGmailProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, 350, 30));

        LabelNameProfile.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        LabelNameProfile.setText("Name:");
        PanelProfile.add(LabelNameProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, 310, 30));

        LabelPasswordProfile.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        LabelPasswordProfile.setText("Password:");
        PanelProfile.add(LabelPasswordProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 310, 30));

        btnEditProfile.setForeground(new java.awt.Color(255, 255, 255));
        btnEditProfile.setText("Edit Profile");
        PanelProfile.add(btnEditProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 410, 150, -1));

        javax.swing.GroupLayout PanelContentsLayout = new javax.swing.GroupLayout(PanelContents);
        PanelContents.setLayout(PanelContentsLayout);
        PanelContentsLayout.setHorizontalGroup(
            PanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelProfile, javax.swing.GroupLayout.DEFAULT_SIZE, 1173, Short.MAX_VALUE)
            .addGroup(PanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelContentsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PanelHomePage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        PanelContentsLayout.setVerticalGroup(
            PanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelProfile, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
            .addGroup(PanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelContentsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PanelHomePage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel1.add(PanelContents, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1310, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUploadAvatarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUploadAvatarMouseClicked
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile();
            ImageIcon icon = new ImageIcon(new ImageIcon(selectedFile.getAbsolutePath())
                    .getImage().getScaledInstance(LabelAvatar.getWidth(), LabelAvatar.getHeight(), Image.SCALE_SMOOTH));
            LabelAvatar.setIcon(icon);
        }
    }//GEN-LAST:event_btnUploadAvatarMouseClicked

    private void btnProfleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfleMouseClicked
        PanelProfile.setVisible(true);
    }//GEN-LAST:event_btnProfleMouseClicked

    private void btnHomePageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomePageMouseClicked
        PanelProfile.setVisible(false);
        PanelHomePage.setVisible(true);
    }//GEN-LAST:event_btnHomePageMouseClicked

    private void btnLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogOutMouseClicked
        Run.runApp();
        dispose();
    }//GEN-LAST:event_btnLogOutMouseClicked

    private void btnHomePageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomePageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHomePageActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Forms.Components.ProfilePhoto LabelAvatar;
    private javax.swing.JLabel LabelGmailProfile;
    private javax.swing.JLabel LabelLogo;
    private javax.swing.JLabel LabelNameProfile;
    private javax.swing.JLabel LabelPasswordProfile;
    private javax.swing.JPanel PanelContents;
    private javax.swing.JPanel PanelHomePage;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JPanel PanelProfile;
    private Forms.Components.HeaderButton btnEditProfile;
    private Forms.Components.HeaderButton btnHomePage;
    private Forms.Components.HeaderButton btnLogOut;
    private Forms.Components.HeaderButton btnProfle;
    private Forms.Components.HeaderButton btnUploadAvatar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
