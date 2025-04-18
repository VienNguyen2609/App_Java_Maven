package Forms;

import Controllers.AccountController;
import Controllers.ProductController;
import Forms.Components.EffectComponents;
import Main.Run;
import Model.Account;
import Model.Shoes;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.File;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class HomePage extends javax.swing.JFrame {

    private File selectedFile;
    private Icon icon;
    private Account currentAccount;
    //private boolean status = false;

    public HomePage() {
        initForAmin();
    }

    public HomePage(Account account) {
        this.currentAccount = account;
        initForUser(account);
    }

    private void initForUser(Account account) {

        initComponents();
        setupWindow();
        txtNameProfile.setText(account.getUserName());
        txtPasswordProfile.setText(account.getUserPassword());
        txtGmailProfile.setText(account.getUserGmail());
        setAvatar(account.getAvatarUser());
        editComponents();

    }

    private void initForAmin() {

        initComponents();
        setupWindow();
        editComponents();
        Account account = new Account("admin", "admin", "admin@gmail.com");
        txtNameProfile.setText(account.getUserName());
        txtPasswordProfile.setText(account.getUserPassword());
        txtGmailProfile.setText(account.getUserGmail());
        setAvatar(account.getAvatarUser());
    }

    private void editComponents() {
        ProductController.init();
        AccountController.Init();
        EffectComponents.Init();
        PanelProfile.setVisible(false);
        PanelHomePage.setVisible(true);
        PanelProducts.setVisible(false);
        PanelBill.setVisible(false);
        styleButton();
        setTime();
        scaleImage();
        addPanelProducts();
        try {
            ViewProduct();
        } catch (SQLException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassCastException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        EffectComponents.instance.FocusPointer1(txtNameProducts, LabelNameProduct, Color.GREEN, Color.WHITE);
        EffectComponents.instance.FocusPointer1(txtPriceProduct, LabelPriceProduct, Color.GREEN, Color.WHITE);
        EffectComponents.instance.FocusPointer1(txtColorProduct, LabelColorProduct, Color.GREEN, Color.WHITE);
    }

    private void setTime() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Date date = new Date();
                    SimpleDateFormat tf = new SimpleDateFormat("h:mm:ss aa,");
                    SimpleDateFormat df = new SimpleDateFormat("EEEE, dd-MM-yyyy");
                    String time = tf.format(date);
                    jTxTime.setText(time.split(" ")[0] + " " + time.split(" ")[1]);
                    jTxtDate.setText(df.format(date));
                }
            }
        }).start();
    }

    private void scaleImage() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/Image/LogoShopImage.png"));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(LabelLogo.getWidth(), LabelLogo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon acalledIcon = new ImageIcon(imgScale);
        LabelLogo.setIcon(acalledIcon);
    }

    private void addPanelProducts() {

        this.PanelContainProduct.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(30, 30, 30, 30); // Khoảng cách giữa các item
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // gbc.weightx = 1; // Giãn ngang
        this.PanelContainProduct.removeAll();
        ProductController.instance.loadDataProducts();
        int cols = 3; // Số cột
        for (int i = 0; i < ProductController.instance.getDataProduct().size(); i++) {
            var newJpanel = new PanelProducts();
            gbc.gridx = i % cols;
            gbc.gridy = i / cols;
            this.PanelContainProduct.add(newJpanel, gbc);
        }

        this.PanelContainProduct.revalidate();
        this.PanelContainProduct.repaint();
    }

    private void setupWindow() {
        setLocationRelativeTo(null);
        setTitle("FOOTWEAR  ,  SHOP FOR YOU ");
        String iconPath = "D:\\DownLoad\\IconFootWear\\result_social.png";
        setIconImage(Toolkit.getDefaultToolkit().getImage(new File(iconPath).getAbsolutePath()));
    }

    private void styleButton() {
        btnUploadAvatar.setBackgroundColor(Color.ORANGE);
        btnProfle.setBackgroundColor(Color.GRAY);
        btnHomePage.setBackgroundColor(Color.GRAY);
        btnLogOut.setBackgroundColor(Color.GRAY);
        btnManagerAccounts.setBackgroundColor(Color.GRAY);
        btnManagerProducts.setBackgroundColor(Color.GRAY);
        btnUserBill.setBackgroundColor(Color.GRAY);
        btnEditProfile.setBackgroundColor(Color.GREEN);
        btnCancelProfile.setBackgroundColor(Color.lightGray);
        btnSaveEditProfile.setBackgroundColor(Color.GREEN);
        btnUploadProduct.setBackgroundColor(Color.ORANGE);
        btnAddProduct.setBackgroundColor(Color.lightGray);
        btnUpdateProduct.setBackgroundColor(Color.GREEN);
        btnDeleteProduct.setBackgroundColor(Color.RED);
        btnCancelProduct.setBackgroundColor(Color.BLUE);
        btnSaveEditProfile.setVisible(false);
    }

    private void setAvatar(byte[] avatarBytes) {

        if (avatarBytes != null) {
            ImageIcon icon = new ImageIcon(avatarBytes);
            Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            LabelAvatar.setIcon(new ImageIcon(img));
        }
        if (avatarBytes == null) {
            LabelAvatar.setIcon(new ImageIcon(getClass().getResource("/Image/cat.png")));
        }
        LabelAvatar.setBorder(null);
    }

    public void clickMouseTableProduct() {
        int selectedRow = tbProduct.getSelectedRow();
        if (selectedRow != -1) {
            String name = tbProduct.getValueAt(selectedRow, 2).toString();
            float price = Float.parseFloat(tbProduct.getValueAt(selectedRow, 3).toString());
            int quantity = Integer.parseInt(tbProduct.getValueAt(selectedRow, 4).toString());
            String color = tbProduct.getValueAt(selectedRow, 5).toString();
            txtNameProducts.setText(name);
            txtPriceProduct.setText(price + ""); // hoặc setValue nếu là JSpinner
            txtQuantityProduct.setValue(quantity); // JSpinner
            txtColorProduct.setText(color);
        }
    }

    public void ViewProduct() throws SQLException, ClassCastException {
        ProductController.init();
        //load data tu cai instance
        ProductController.instance.loadDataProducts();
        LoadTableProduct();
    }

    private void LoadTableProduct() {
//        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
//        for (int i = 0; i < tbProduct.getColumnCount(); i++) {
//            tbProduct.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
//        }
        DefaultTableModel model = (DefaultTableModel) this.tbProduct.getModel();
        model.setNumRows(0);
        var data = ProductController.instance.getDataProduct();
        int n = 0;
        for (Shoes shoes : data) {
            model.addRow(new Object[]{n++, shoes.getProductId(), shoes.getProductName(), shoes.getProductPrice(), shoes.getProductQuantity(), shoes.getProductColor(), shoes.getProductAvatar(),});
        }
    }

    public void View() {
        txtNameProducts.setText("");
        txtPriceProduct.setText("");
        txtQuantityProduct.setValue(0);
        txtColorProduct.setText("");

    }

//     public boolean View() {
//        txtID.setText("");
//        txtNameProduct.setText("");
//        txtSize.setText("");
//        txtPrice.setText("");;
//     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        LabelLogo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTxTime = new javax.swing.JLabel();
        jTxtDate = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        PanelMenu = new javax.swing.JPanel();
        btnProfle = new Forms.Components.HeaderButton();
        btnHomePage = new Forms.Components.HeaderButton();
        btnLogOut = new Forms.Components.HeaderButton();
        btnUserBill = new Forms.Components.HeaderButton();
        btnManagerProducts = new Forms.Components.HeaderButton();
        btnManagerAccounts = new Forms.Components.HeaderButton();
        PanelContents = new javax.swing.JPanel();
        PanelHomePage = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        PanelContainProduct = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        textFieldController3 = new Forms.Components.TextFieldController();
        textFieldController1 = new Forms.Components.TextFieldController();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        PanelProfile = new javax.swing.JPanel();
        LabelAvatar = new Forms.Components.ProfilePhoto();
        btnUploadAvatar = new Forms.Components.HeaderButton();
        btnEditProfile = new Forms.Components.HeaderButton();
        jLabel1 = new javax.swing.JLabel();
        txtNameProfile = new Forms.Components.TextFieldController();
        txtGmailProfile = new Forms.Components.TextFieldController();
        txtPasswordProfile = new Forms.Components.PasswordField();
        btnSaveEditProfile = new Forms.Components.HeaderButton();
        btnCancelProfile = new Forms.Components.HeaderButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CheckPassword = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        PanelBill = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        PanelProducts = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbProduct = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnDeleteProduct = new Forms.Components.HeaderButton();
        btnCancelProduct = new Forms.Components.HeaderButton();
        btnUploadProduct = new Forms.Components.HeaderButton();
        btnAddProduct = new Forms.Components.HeaderButton();
        btnUpdateProduct = new Forms.Components.HeaderButton();
        profilePhoto1 = new Forms.Components.ProfilePhoto();
        LabelNameProduct = new javax.swing.JLabel();
        LabelPriceProduct = new javax.swing.JLabel();
        LabelQuantityProduct = new javax.swing.JLabel();
        LabelColorProduct = new javax.swing.JLabel();
        txtQuantityProduct = new javax.swing.JSpinner();
        txtPriceProduct = new Forms.Components.TextFieldController();
        txtColorProduct = new Forms.Components.TextFieldController();
        txtNameProducts = new Forms.Components.TextFieldController();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel4.setMinimumSize(new java.awt.Dimension(562, 80));
        jPanel4.setPreferredSize(new java.awt.Dimension(1293, 80));
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

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 23)); // NOI18N
        jLabel3.setText(" CHÀO MỪNG 30/4/2025 , cali TUỔI LÒN ,VIỆT NAM MUÔN NĂM");
        jLabel3.setMaximumSize(new java.awt.Dimension(839, 90));
        jLabel3.setMinimumSize(new java.awt.Dimension(839, 90));
        jLabel3.setOpaque(true);
        jLabel3.setPreferredSize(new java.awt.Dimension(839, 90));
        jLabel3.setVerifyInputWhenFocusTarget(false);
        jLabel3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jLabel3, gridBagConstraints);

        jTxTime.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTxTime.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jTxTime.setMaximumSize(new java.awt.Dimension(85, 85));
        jTxTime.setMinimumSize(new java.awt.Dimension(85, 85));
        jTxTime.setPreferredSize(new java.awt.Dimension(85, 85));
        jPanel4.add(jTxTime, new java.awt.GridBagConstraints());

        jTxtDate.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTxtDate.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jTxtDate.setMaximumSize(new java.awt.Dimension(135, 120));
        jTxtDate.setMinimumSize(new java.awt.Dimension(135, 120));
        jTxtDate.setPreferredSize(new java.awt.Dimension(135, 120));
        jPanel4.add(jTxtDate, new java.awt.GridBagConstraints());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/result_flag.png"))); // NOI18N
        jLabel11.setMaximumSize(new java.awt.Dimension(90, 90));
        jLabel11.setMinimumSize(new java.awt.Dimension(90, 90));
        jLabel11.setPreferredSize(new java.awt.Dimension(90, 90));
        jPanel4.add(jLabel11, new java.awt.GridBagConstraints());

        jPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        PanelMenu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
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
        btnProfle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfleActionPerformed(evt);
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
        btnLogOut.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogOutMouseClicked(evt);
            }
        });

        btnUserBill.setForeground(new java.awt.Color(204, 255, 255));
        btnUserBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/result_bill.png"))); // NOI18N
        btnUserBill.setText("Your Bill");
        btnUserBill.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnUserBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUserBillMouseClicked(evt);
            }
        });
        btnUserBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserBillActionPerformed(evt);
            }
        });

        btnManagerProducts.setForeground(new java.awt.Color(204, 255, 255));
        btnManagerProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ProductManagerIcon.png"))); // NOI18N
        btnManagerProducts.setText("Products");
        btnManagerProducts.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnManagerProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnManagerProductsMouseClicked(evt);
            }
        });
        btnManagerProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagerProductsActionPerformed(evt);
            }
        });

        btnManagerAccounts.setForeground(new java.awt.Color(204, 255, 255));
        btnManagerAccounts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/AccountManagerIcon.png"))); // NOI18N
        btnManagerAccounts.setText("Accounts");
        btnManagerAccounts.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnManagerAccounts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnManagerAccountsMouseClicked(evt);
            }
        });
        btnManagerAccounts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagerAccountsActionPerformed(evt);
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
                        .addComponent(btnHomePage, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUserBill, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProfle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnManagerProducts, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnManagerAccounts, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenuLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnHomePage, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btnUserBill, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnManagerProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnManagerAccounts, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
                .addComponent(btnProfle, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(PanelMenu, java.awt.BorderLayout.LINE_START);

        PanelContents.setOpaque(false);
        PanelContents.setPreferredSize(new java.awt.Dimension(1200, 634));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        javax.swing.GroupLayout PanelContainProductLayout = new javax.swing.GroupLayout(PanelContainProduct);
        PanelContainProduct.setLayout(PanelContainProductLayout);
        PanelContainProductLayout.setHorizontalGroup(
            PanelContainProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1046, Short.MAX_VALUE)
        );
        PanelContainProductLayout.setVerticalGroup(
            PanelContainProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(PanelContainProduct);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("BILL");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 6, 37, 34));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Color:");
        jLabel9.setToolTipText("");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, 20));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("Price: ");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 60, 20));

        textFieldController3.setForeground(new java.awt.Color(255, 51, 51));
        textFieldController3.setText("textFieldController3");
        textFieldController3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel3.add(textFieldController3, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 113, 150, 40));

        textFieldController1.setForeground(new java.awt.Color(255, 0, 51));
        textFieldController1.setText("textFieldController1");
        textFieldController1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        textFieldController1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldController1ActionPerformed(evt);
            }
        });
        jPanel3.add(textFieldController1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 177, 160, 33));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Buy it");
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 110, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("Name:");
        jLabel13.setToolTipText("");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 20));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("Quantity:");
        jLabel14.setToolTipText("");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, 20));

        javax.swing.GroupLayout PanelHomePageLayout = new javax.swing.GroupLayout(PanelHomePage);
        PanelHomePage.setLayout(PanelHomePageLayout);
        PanelHomePageLayout.setHorizontalGroup(
            PanelHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHomePageLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 936, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelHomePageLayout.setVerticalGroup(
            PanelHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
            .addGroup(PanelHomePageLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelProfile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelAvatar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
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

        jLabel1.setText("_________________________________________________________________");
        PanelProfile.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 306, 370, 20));

        txtNameProfile.setEditable(false);
        txtNameProfile.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        PanelProfile.add(txtNameProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, 260, -1));

        txtGmailProfile.setEditable(false);
        txtGmailProfile.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        PanelProfile.add(txtGmailProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 270, -1));

        txtPasswordProfile.setEditable(false);
        txtPasswordProfile.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        txtPasswordProfile.setEchoChar('\u002A'
        );
        txtPasswordProfile.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        PanelProfile.add(txtPasswordProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, 230, 30));

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
        PanelProfile.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 366, 370, 20));

        jLabel7.setText("_________________________________________________________________");
        PanelProfile.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, 370, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "UserName", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout PanelBillLayout = new javax.swing.GroupLayout(PanelBill);
        PanelBill.setLayout(PanelBillLayout);
        PanelBillLayout.setHorizontalGroup(
            PanelBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1260, Short.MAX_VALUE)
        );
        PanelBillLayout.setVerticalGroup(
            PanelBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
        );

        tbProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tbProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No.", "ID", "Name", "Price", "Quantity", "Color", "Image"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbProductMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tbProduct);
        if (tbProduct.getColumnModel().getColumnCount() > 0) {
            tbProduct.getColumnModel().getColumn(0).setCellRenderer(null);
        }

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDeleteProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteProduct.setText("Delete");
        btnDeleteProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteProductMouseClicked(evt);
            }
        });
        jPanel2.add(btnDeleteProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, 130, -1));

        btnCancelProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelProduct.setText("Cancel");
        btnCancelProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelProductMouseClicked(evt);
            }
        });
        jPanel2.add(btnCancelProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 520, 130, -1));

        btnUploadProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnUploadProduct.setText("UploadImage");
        btnUploadProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadProductActionPerformed(evt);
            }
        });
        jPanel2.add(btnUploadProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 130, -1));

        btnAddProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnAddProduct.setText("Add");
        btnAddProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddProductMouseClicked(evt);
            }
        });
        jPanel2.add(btnAddProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 130, -1));

        btnUpdateProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateProduct.setText("Update");
        jPanel2.add(btnUpdateProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 470, 130, -1));

        profilePhoto1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel2.add(profilePhoto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 18, 190, 90));

        LabelNameProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelNameProduct.setForeground(new java.awt.Color(255, 255, 255));
        LabelNameProduct.setText("NameProduct");
        jPanel2.add(LabelNameProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, -1));

        LabelPriceProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelPriceProduct.setForeground(new java.awt.Color(255, 255, 255));
        LabelPriceProduct.setText("Price");
        jPanel2.add(LabelPriceProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        LabelQuantityProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelQuantityProduct.setForeground(new java.awt.Color(255, 255, 255));
        LabelQuantityProduct.setText("Quantity");
        jPanel2.add(LabelQuantityProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, -1, -1));

        LabelColorProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelColorProduct.setForeground(new java.awt.Color(255, 255, 255));
        LabelColorProduct.setText("Color");
        jPanel2.add(LabelColorProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, -1, -1));
        jPanel2.add(txtQuantityProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 80, -1));

        txtPriceProduct.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PriceIcon.png"))); // NOI18N
        jPanel2.add(txtPriceProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 150, -1));

        txtColorProduct.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ColorIcon.png"))); // NOI18N
        jPanel2.add(txtColorProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 150, -1));

        txtNameProducts.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ProductManagerIcon.png"))); // NOI18N
        jPanel2.add(txtNameProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 170, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("____________________________________");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 210, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("____________________________________");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 210, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("____________________________________");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 210, -1));

        javax.swing.GroupLayout PanelProductsLayout = new javax.swing.GroupLayout(PanelProducts);
        PanelProducts.setLayout(PanelProductsLayout);
        PanelProductsLayout.setHorizontalGroup(
            PanelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProductsLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelProductsLayout.setVerticalGroup(
            PanelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelContentsLayout = new javax.swing.GroupLayout(PanelContents);
        PanelContents.setLayout(PanelContentsLayout);
        PanelContentsLayout.setHorizontalGroup(
            PanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelProfile, javax.swing.GroupLayout.DEFAULT_SIZE, 1266, Short.MAX_VALUE)
            .addGroup(PanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelHomePage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelContentsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PanelBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(PanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelProducts, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelContentsLayout.setVerticalGroup(
            PanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelProfile, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
            .addGroup(PanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelHomePage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(PanelContents, java.awt.BorderLayout.CENTER);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("© FootWearShop 2025. Redistribution or reproduction is strictly prohibited. ");
        jPanel1.add(jLabel10, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1395, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProfleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfleMouseClicked
        PanelProfile.setVisible(true);
        PanelHomePage.setVisible(false);
        PanelBill.setVisible(false);
        PanelProducts.setVisible(false);
    }//GEN-LAST:event_btnProfleMouseClicked

    private void btnHomePageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomePageMouseClicked
        PanelProfile.setVisible(false);
        PanelHomePage.setVisible(true);
        PanelBill.setVisible(false);
        PanelProducts.setVisible(false);
        addPanelProducts();       
    }//GEN-LAST:event_btnHomePageMouseClicked

    private void btnLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogOutMouseClicked
        Run.runApp();
        dispose();
    }//GEN-LAST:event_btnLogOutMouseClicked

    private void btnHomePageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomePageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHomePageActionPerformed

    private void btnUserBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserBillMouseClicked
        PanelBill.setVisible(true);
        PanelHomePage.setVisible(false);
        PanelProfile.setVisible(false);
        PanelProducts.setVisible(false);

    }//GEN-LAST:event_btnUserBillMouseClicked

    private void btnUserBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserBillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUserBillActionPerformed

    private void btnProfleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfleActionPerformed

        if (!PanelProfile.isVisible()) {
            txtPasswordProfile.setEchoChar('*');
            CheckPassword.setSelected(false);
        }

    }//GEN-LAST:event_btnProfleActionPerformed

    private void textFieldController1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldController1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldController1ActionPerformed

    private void CheckPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CheckPasswordMouseClicked

        if (CheckPassword.isSelected()) {
            txtPasswordProfile.setEchoChar((char) 0);
        } else {
            txtPasswordProfile.setEchoChar('*');
        }
    }//GEN-LAST:event_CheckPasswordMouseClicked

    private void btnCancelProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelProfileMouseClicked

        txtNameProfile.setEditable(false);
        txtPasswordProfile.setEditable(false);
        txtGmailProfile.setEditable(false);
        txtNameProfile.setText(currentAccount.getUserName());
        txtPasswordProfile.setText(currentAccount.getUserPassword());
        txtGmailProfile.setText(currentAccount.getUserGmail());
        btnSaveEditProfile.setVisible(false);
    }//GEN-LAST:event_btnCancelProfileMouseClicked

    private void btnSaveEditProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveEditProfileMouseClicked

        AccountController.instance.loadDataAccounts();
        try {

            String name = txtNameProfile.getText();
            String password = String.valueOf(txtPasswordProfile.getPassword());
            String gmail = txtGmailProfile.getText();

            if (password.length() < 7 || name.length() < 4) {
                JOptionPane.showMessageDialog(this, "error: LENGTH PASSWORD >= 7 AND NAME >=4");
                return;
            }

            if (EffectComponents.instance.containsVietnameseCharacters(name)) {
                JOptionPane.showMessageDialog(this, "error: NAME WRONG!");
                return;
            }
            if (name.isEmpty() || password.isEmpty() || gmail.isEmpty()) {
                JOptionPane.showMessageDialog(this, "error: INFORMATION CAN NOT EMPTY");
                return;
            }

            if (!gmail.contains("@gmail.com")) {
                JOptionPane.showMessageDialog(this, "error: GMAIL WRONG");
                return;
            }
            if (name.equalsIgnoreCase("admin")) {
                JOptionPane.showMessageDialog(this, "error: NAME IS FOR ADMINISTRATOR USE ONLY!!");
                return;
            }
            Account UpdateAccount = AccountController.instance.updateUser(name, password, gmail, currentAccount.getUserName());
            if (UpdateAccount != null) {
                currentAccount = UpdateAccount;
                JOptionPane.showMessageDialog(this, "Profile Updated Successfully");
                btnSaveEditProfile.setVisible(false);
                txtNameProfile.setEditable(false);
                txtPasswordProfile.setEditable(false);
                txtGmailProfile.setEditable(false);
                return;

            } else {
                JOptionPane.showMessageDialog(this, "Update name false");
                return;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSaveEditProfileMouseClicked

    private void btnEditProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditProfileMouseClicked

        txtNameProfile.setEditable(true);
        txtPasswordProfile.setEditable(true);
        txtGmailProfile.setEditable(true);
        txtNameProfile.requestFocus();
        btnSaveEditProfile.setVisible(true);
    }//GEN-LAST:event_btnEditProfileMouseClicked

    private void btnUploadAvatarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUploadAvatarMouseClicked

        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile();
            icon = new ImageIcon(new ImageIcon(selectedFile.getAbsolutePath())
                    .getImage().getScaledInstance(LabelAvatar.getWidth(), LabelAvatar.getHeight(), Image.SCALE_SMOOTH));
            LabelAvatar.setIcon(icon);
        }

        if (selectedFile == null) {
            JOptionPane.showMessageDialog(this, "PHOTO NOT UPDATE YET!");
            return;
        }
        AccountController.instance.saveAvatarToDatabase(selectedFile, currentAccount.getUserName());
        LabelAvatar.setBorder(new EmptyBorder(0, 0, 0, 0));

    }//GEN-LAST:event_btnUploadAvatarMouseClicked

    private void btnManagerProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManagerProductsMouseClicked
        PanelBill.setVisible(false);
        PanelHomePage.setVisible(false);
        PanelProfile.setVisible(false);
        PanelProducts.setVisible(true);
    }//GEN-LAST:event_btnManagerProductsMouseClicked

    private void btnManagerProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagerProductsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnManagerProductsActionPerformed

    private void btnManagerAccountsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManagerAccountsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnManagerAccountsMouseClicked

    private void btnManagerAccountsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagerAccountsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnManagerAccountsActionPerformed

    private void btnUploadProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadProductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUploadProductActionPerformed

    private void tbProductMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductMouseReleased
        clickMouseTableProduct();
    }//GEN-LAST:event_tbProductMouseReleased

    private void btnAddProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddProductMouseClicked
        String name = txtNameProducts.getText().trim();
        String priceText = txtPriceProduct.getText().trim();
        String quantityText = txtQuantityProduct.getValue().toString();
        String color = txtColorProduct.getText().trim();
        try {
            float price = Float.parseFloat(priceText);
            int quantity = Integer.parseInt(quantityText);

            if (ProductController.instance.addProduct(name, price, quantity, color)) {
                LoadTableProduct();
                View();
                JOptionPane.showMessageDialog(this, "PRODUCT ADDED SUCCESSFULLY");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnAddProductMouseClicked

    private void btnCancelProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelProductMouseClicked
        View();
    }//GEN-LAST:event_btnCancelProductMouseClicked

    private void btnDeleteProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteProductMouseClicked
        String name = txtNameProducts.getText();
        try {
            if(ProductController.instance.deleteProduct(name)){
              LoadTableProduct();
              View();
              JOptionPane.showMessageDialog(this, "DELETED SUCCESSFULLY");
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteProductMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckPassword;
    private Forms.Components.ProfilePhoto LabelAvatar;
    private javax.swing.JLabel LabelColorProduct;
    private javax.swing.JLabel LabelLogo;
    private javax.swing.JLabel LabelNameProduct;
    private javax.swing.JLabel LabelPriceProduct;
    private javax.swing.JLabel LabelQuantityProduct;
    private javax.swing.JPanel PanelBill;
    private javax.swing.JPanel PanelContainProduct;
    private javax.swing.JPanel PanelContents;
    private javax.swing.JPanel PanelHomePage;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JPanel PanelProducts;
    private javax.swing.JPanel PanelProfile;
    private Forms.Components.HeaderButton btnAddProduct;
    private Forms.Components.HeaderButton btnCancelProduct;
    private Forms.Components.HeaderButton btnCancelProfile;
    private Forms.Components.HeaderButton btnDeleteProduct;
    private Forms.Components.HeaderButton btnEditProfile;
    private Forms.Components.HeaderButton btnHomePage;
    private Forms.Components.HeaderButton btnLogOut;
    private Forms.Components.HeaderButton btnManagerAccounts;
    private Forms.Components.HeaderButton btnManagerProducts;
    private Forms.Components.HeaderButton btnProfle;
    private Forms.Components.HeaderButton btnSaveEditProfile;
    private Forms.Components.HeaderButton btnUpdateProduct;
    private Forms.Components.HeaderButton btnUploadAvatar;
    private Forms.Components.HeaderButton btnUploadProduct;
    private Forms.Components.HeaderButton btnUserBill;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jTxTime;
    private javax.swing.JLabel jTxtDate;
    private Forms.Components.ProfilePhoto profilePhoto1;
    private javax.swing.JTable tbProduct;
    private Forms.Components.TextFieldController textFieldController1;
    private Forms.Components.TextFieldController textFieldController3;
    private Forms.Components.TextFieldController txtColorProduct;
    private Forms.Components.TextFieldController txtGmailProfile;
    private Forms.Components.TextFieldController txtNameProducts;
    private Forms.Components.TextFieldController txtNameProfile;
    private Forms.Components.PasswordField txtPasswordProfile;
    private Forms.Components.TextFieldController txtPriceProduct;
    private javax.swing.JSpinner txtQuantityProduct;
    // End of variables declaration//GEN-END:variables
}
