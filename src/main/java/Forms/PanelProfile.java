/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Forms;

import Forms.Components.SetThemFlatLaf;
import Forms.Components.ThemeFlatLaf;
import java.awt.Color;

/**
 *
 * @author VIEN
 */
public class PanelProfile extends javax.swing.JPanel {

    public PanelProfile() {
        initComponents();
        btnUploadAvatar.setBackgroundColor(Color.lightGray);
       
        btnEditProfile.setBackgroundColor(Color.lightGray);
        btnCancelProfile.setBackgroundColor(Color.lightGray);
        btnSaveEditProfile.setBackgroundColor(Color.lightGray);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelProfile = new javax.swing.JPanel();
        LabelAvatar = new Forms.Components.ProfilePhoto();
        btnUploadAvatar = new Forms.Components.HeaderButton();
        btnEditProfile = new Forms.Components.HeaderButton();
        jLabel1 = new javax.swing.JLabel();
        TextNameProfile = new Forms.Components.TextFieldController();
        TextGmailProfile = new Forms.Components.TextFieldController();
        TextPasswordProfile = new Forms.Components.PasswordField();
        btnSaveEditProfile = new Forms.Components.HeaderButton();
        btnCancelProfile = new Forms.Components.HeaderButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CheckPassword = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        PanelProfile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PanelProfile.add(LabelAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 170, 130));

        btnUploadAvatar.setBackground(new java.awt.Color(153, 153, 255));
        btnUploadAvatar.setForeground(new java.awt.Color(255, 255, 255));
        btnUploadAvatar.setText("Upload Avatar");
        btnUploadAvatar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUploadAvatarMouseClicked(evt);
            }
        });
        PanelProfile.add(btnUploadAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 150, -1));

        btnEditProfile.setForeground(new java.awt.Color(255, 255, 255));
        btnEditProfile.setText("Edit Profile");
        btnEditProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditProfileMouseClicked(evt);
            }
        });
        PanelProfile.add(btnEditProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 390, 150, -1));

        jLabel1.setText("________________________________________________________________");
        PanelProfile.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 370, -1));

        TextNameProfile.setEditable(false);
        TextNameProfile.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        PanelProfile.add(TextNameProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, 260, -1));

        TextGmailProfile.setEditable(false);
        TextGmailProfile.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        PanelProfile.add(TextGmailProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 270, -1));

        TextPasswordProfile.setEditable(false);
        TextPasswordProfile.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        TextPasswordProfile.setEchoChar('\u002A'
        );
        TextPasswordProfile.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        PanelProfile.add(TextPasswordProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, 230, 30));

        btnSaveEditProfile.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveEditProfile.setText("Save");
        btnSaveEditProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveEditProfileMouseClicked(evt);
            }
        });
        PanelProfile.add(btnSaveEditProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 430, 100, -1));

        btnCancelProfile.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelProfile.setText("Cancel");
        btnCancelProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelProfileMouseClicked(evt);
            }
        });
        PanelProfile.add(btnCancelProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 390, 110, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/result_account.png"))); // NOI18N
        jLabel2.setText("Name:");
        PanelProfile.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 80, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/result_padlock.png"))); // NOI18N
        jLabel4.setText("Password:");
        PanelProfile.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 290, 110, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/GmailIcon.png"))); // NOI18N
        jLabel5.setText("Gmail:");
        PanelProfile.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, 90, -1));

        CheckPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckPassword.setText("Show Password");
        CheckPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CheckPasswordMouseClicked(evt);
            }
        });
        PanelProfile.add(CheckPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 300, -1, -1));

        jLabel6.setText("_________________________________________________________________");
        PanelProfile.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, 370, -1));

        jLabel7.setText("_________________________________________________________________");
        PanelProfile.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 370, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1040, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PanelProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 632, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PanelProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUploadAvatarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUploadAvatarMouseClicked

//        JFileChooser chooser = new JFileChooser();
//        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
//
//        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
//            selectedFile = chooser.getSelectedFile();
//            icon = new ImageIcon(new ImageIcon(selectedFile.getAbsolutePath())
//                .getImage().getScaledInstance(LabelAvatar.getWidth(), LabelAvatar.getHeight(), Image.SCALE_SMOOTH));
//            LabelAvatar.setIcon(icon);
//        }
//
//        if (selectedFile == null) {
//            JOptionPane.showMessageDialog(this, "PHOTO NOT UPDATE YET!");
//            return;
//        }
//
//        AccountController.instance.saveAvatarToDatabase(selectedFile, currentAccount.getUserName());
    }//GEN-LAST:event_btnUploadAvatarMouseClicked

    private void btnEditProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditProfileMouseClicked

//        TextNameProfile.setEditable(true);
//        TextPasswordProfile.setEditable(true);
//        TextGmailProfile.setEditable(true);
//        TextNameProfile.requestFocus();
//        btnSaveEditProfile.setVisible(true);
    }//GEN-LAST:event_btnEditProfileMouseClicked

    private void btnSaveEditProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveEditProfileMouseClicked

//        AccountController.instance.loadAccount();
//        try {
//
//            String name = TextNameProfile.getText();
//            String password = String.valueOf(TextPasswordProfile.getPassword());
//            String gmail = TextGmailProfile.getText();
//            Account UpdateAccount = AccountController.instance.updateUser(name, password, gmail, currentAccount.getUserName());
//            if (UpdateAccount != null) {
//                currentAccount = UpdateAccount;
//                JOptionPane.showMessageDialog(this, "Profile Updated Successfully");
//                btnSaveEditProfile.setVisible(false);
//                TextNameProfile.setEditable(false);
//                TextPasswordProfile.setEditable(false);
//                TextGmailProfile.setEditable(false);
//                return;
//
//            } else {
//                JOptionPane.showMessageDialog(this, "Update name false");
//                return;
//            }
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
//        }
    }//GEN-LAST:event_btnSaveEditProfileMouseClicked

    private void btnCancelProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelProfileMouseClicked

//        TextNameProfile.setEditable(false);
//        TextPasswordProfile.setEditable(false);
//        TextGmailProfile.setEditable(false);
//        TextNameProfile.setText(currentAccount.getUserName());
//        TextPasswordProfile.setText(currentAccount.getUserPassword());
//        TextGmailProfile.setText(currentAccount.getUserGmail());
//        btnSaveEditProfile.setVisible(false);
    }//GEN-LAST:event_btnCancelProfileMouseClicked

    private void CheckPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CheckPasswordMouseClicked

        if (CheckPassword.isSelected()) {
            TextPasswordProfile.setEchoChar((char) 0);
        } else {
            TextPasswordProfile.setEchoChar('*');
        }
    }//GEN-LAST:event_CheckPasswordMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckPassword;
    private Forms.Components.ProfilePhoto LabelAvatar;
    private javax.swing.JPanel PanelProfile;
    private Forms.Components.TextFieldController TextGmailProfile;
    private Forms.Components.TextFieldController TextNameProfile;
    private Forms.Components.PasswordField TextPasswordProfile;
    private Forms.Components.HeaderButton btnCancelProfile;
    private Forms.Components.HeaderButton btnEditProfile;
    private Forms.Components.HeaderButton btnSaveEditProfile;
    private Forms.Components.HeaderButton btnUploadAvatar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
