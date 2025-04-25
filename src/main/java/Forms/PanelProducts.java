package Forms;

import Model.Shoes;
import java.awt.Dimension;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class PanelProducts extends javax.swing.JPanel {

    public PanelProducts(Shoes shoes) {

        initComponents();
        txtName.setText(shoes.getProductName());
        txtPrice.setText(String.valueOf(shoes.getProductPrice()) + "$");
        txtColor.setText(shoes.getProductColor());
        byte[] imageBytes = shoes.getProductAvatar();
        int defaultWidth = 201;
        int defaultHeight = 129;

        if (imageBytes != null && imageBytes.length > 0) {
            try {
                ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                BufferedImage bufferedImage = ImageIO.read(bais);
                if (bufferedImage != null) {
                    Image scaledImage = bufferedImage.getScaledInstance(defaultWidth, defaultHeight, Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(scaledImage);
                    LabelImage.setIcon(icon);
                } else {
                    System.out.println("CAN NOT UPLOAD IMAGE PRODUCTS");

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            jLabel1.setText("NOT UPDATED IMAGE");
        }
        this.jLabel1.repaint();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel16 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        txtName = new Forms.Components.TextFieldController();
        jCheckBox2 = new javax.swing.JCheckBox();
        txtPrice = new Forms.Components.TextFieldController();
        txtColor = new Forms.Components.TextFieldController();
        jLabel1 = new javax.swing.JLabel();
        LabelImage = new javax.swing.JLabel();

        jPanel16.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel69.setText("Price:");
        jPanel16.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 224, 43, -1));

        jLabel70.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel70.setText("Color:");
        jPanel16.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 280, 43, -1));

        txtName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtName.setToolTipText("");
        txtName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jPanel16.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 7, 130, -1));

        jCheckBox2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jCheckBox2.setText("Purchase");
        jPanel16.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 329, -1, -1));

        txtPrice.setForeground(new java.awt.Color(204, 255, 255));
        txtPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPrice.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PriceIcon.png"))); // NOI18N
        jPanel16.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 219, 189, -1));

        txtColor.setForeground(new java.awt.Color(255, 255, 255));
        txtColor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtColor.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ColorIcon.png"))); // NOI18N
        jPanel16.add(txtColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 275, 189, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel16.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 190, 20));

        LabelImage.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 0)));
        jPanel16.add(LabelImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 45, 201, 129));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelImage;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JPanel jPanel16;
    private Forms.Components.TextFieldController txtColor;
    private Forms.Components.TextFieldController txtName;
    private Forms.Components.TextFieldController txtPrice;
    // End of variables declaration//GEN-END:variables
}
