
package Forms;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public class LoginAdmin extends javax.swing.JFrame {

    
    public LoginAdmin() {
        initComponents();
       JPanel  header = new JPanel(new MigLayout("fill", "[]push[][][]"));
        txtName.setOpaque(false);
        txtName.setBackground(null);
 
//        txtPassword.setOpaque(false);
//        txtPassword.setBackground(null);
       
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        headerButton2 = new Forms.Components.HeaderButton();
        txtName = new Forms.Components.TextFieldController();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headerButton2.setBackground(new java.awt.Color(102, 102, 255));
        headerButton2.setText("Login");
        headerButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel1.add(headerButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 410, 250, -1));

        txtName.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        txtName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 210, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/result_social.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 110));

        jLabel7.setText("_______________________________________________");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 240, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\DownLoad\\result_ChatGPT Image 17_27_11 10 thg 4, 2025 (1).png")); // NOI18N
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

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Forms.Components.HeaderButton headerButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private Forms.Components.TextFieldController txtName;
    // End of variables declaration//GEN-END:variables
}
