package Forms;

import Forms.Components.RoundedBorder;
import Main.Run;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.SwingConstants;

public class HomePage extends javax.swing.JFrame {

    public HomePage() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("FOOTWEAR  ,  SHOP FOR YOU ");
        String iconPath = "D:\\DownLoad\\IconFootWear\\result_social.png";
        setIconImage(Toolkit.getDefaultToolkit().getImage(new File(iconPath).getAbsolutePath()));

         jLabel1.setText("<html>Our sales app is a powerful and user-friendly platform designed to help businesses manage their products, orders, and customers efficiently. With an intuitive interface and advanced features like real-time inventory tracking, secure payment integration, and automated order processing, our app makes selling easier than ever. Whether you're a small business or a large enterprise, our solution is tailored to boost your sales and streamline your operations.</html>");
        // setSize(UIScale.scale(new Dimension(1320, 770) ));
        Border();
         
    }
    public void Border(){
         btnHomePage.setHorizontalAlignment(SwingConstants.CENTER);
         jButton1.setBorder(new RoundedBorder(18));
         jButton2.setBorder(new RoundedBorder(18));
         jButton3.setBorder(new RoundedBorder(18));
         btnHomePage.setBorder(new RoundedBorder(18));
         btnLogOut.setBorder(new RoundedBorder(18));
         
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
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnHomePage = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel4.setMinimumSize(new java.awt.Dimension(562, 120));
        jPanel4.setPreferredSize(new java.awt.Dimension(1293, 90));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        LabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/result_social.png"))); // NOI18N
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

        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel5.setOpaque(false);
        jPanel5.setPreferredSize(new java.awt.Dimension(135, 720));
        jPanel5.setRequestFocusEnabled(false);

        jButton1.setText("Bill");
        jButton1.setBorder(null);

        jButton2.setText("About");
        jButton2.setBorder(null);

        jButton3.setText("Your Profile");
        jButton3.setBorder(null);

        btnHomePage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHomePage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/result_home.png"))); // NOI18N
        btnHomePage.setText("Home");
        btnHomePage.setBorder(null);
        btnHomePage.setMaximumSize(new java.awt.Dimension(150, 42));
        btnHomePage.setMinimumSize(new java.awt.Dimension(120, 42));
        btnHomePage.setPreferredSize(new java.awt.Dimension(123, 42));
        btnHomePage.setRequestFocusEnabled(false);
        btnHomePage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHomePageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHomePageMouseExited(evt);
            }
        });

        btnLogOut.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/result_logout.png"))); // NOI18N
        btnLogOut.setText("Sign Out");
        btnLogOut.setBorder(null);
        btnLogOut.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLogOut.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnHomePage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogOut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnHomePage, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 309, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addContainerGap(336, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(230, Short.MAX_VALUE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomePageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomePageMouseEntered
        btnHomePage.setBackground(Color.DARK_GRAY);
    }//GEN-LAST:event_btnHomePageMouseEntered

    private void btnHomePageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomePageMouseExited
        btnHomePage.setBackground(null);
    }//GEN-LAST:event_btnHomePageMouseExited

    private void btnLogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogOutMouseEntered
       btnLogOut.setBackground(Color.red);
    }//GEN-LAST:event_btnLogOutMouseEntered

    private void btnLogOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogOutMouseExited
        btnLogOut.setBackground(null);
    }//GEN-LAST:event_btnLogOutMouseExited

    private void btnLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogOutMouseClicked
       Run.runApp(); 
       dispose();
    }//GEN-LAST:event_btnLogOutMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelLogo;
    private javax.swing.JButton btnHomePage;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
