package Forms;

import Controllers.AccountController;
import Controllers.ProductController;
import Forms.Components.EffectComponents;
import Main.Run;
import Model.Account;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;

import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

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
        setLocationRelativeTo(null);
        setTitle("FOOTWEAR  ,  SHOP FOR YOU ");
        String iconPath = "D:\\DownLoad\\IconFootWear\\result_social.png";
        setIconImage(Toolkit.getDefaultToolkit().getImage(new File(iconPath).getAbsolutePath()));

        TextNameProfile.setText(account.getUserName());
        TextPasswordProfile.setText(account.getUserPassword());
        TextGmailProfile.setText(account.getUserGmail());

        if (account.getAvatarUser() != null) {
            ImageIcon icon = new ImageIcon(account.getAvatarUser());
            Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            LabelAvatar.setIcon(new ImageIcon(img));
        }
        if (account.getAvatarUser() == null) {
            LabelAvatar.setIcon(new ImageIcon(getClass().getResource("/Image/cat.png")));
        }
        editComponents();

    }

    private void initForAmin() {

        initComponents();
        setLocationRelativeTo(null);
        setTitle("FOOTWEAR  ,  SHOP FOR YOU ");
        String iconPath = "D:\\DownLoad\\IconFootWear\\result_social.png";
        setIconImage(Toolkit.getDefaultToolkit().getImage(new File(iconPath).getAbsolutePath()));
        editComponents();

    }

    private void editComponents() {
        ProductController.init();
        AccountController.Init();
        EffectComponents.Init();
        btnUploadAvatar.setBackgroundColor(Color.lightGray);
        btnProfle.setBackgroundColor(Color.GRAY);
        btnHomePage.setBackgroundColor(Color.GRAY);
        btnLogOut.setBackgroundColor(Color.GRAY);
        btnManagerAccounts.setBackgroundColor(Color.GRAY);
        btnManagerProducts.setBackgroundColor(Color.GRAY);
        btnUserBill.setBackgroundColor(Color.GRAY);
        PanelProfile.setVisible(false);
        PanelHomePage.setVisible(true);
        PanelBill.setVisible(false);
        btnEditProfile.setBackgroundColor(Color.lightGray);
        btnCancelProfile.setBackgroundColor(Color.lightGray);
        btnSaveEditProfile.setBackgroundColor(Color.lightGray);
        btnSaveEditProfile.setVisible(false);
        setTime();
        scaleImage();
        addPanelProducts();
//        this.panelUserBill.setLayout(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.insets = new Insets(30, 30, 30, 30); // Khoảng cách giữa các item
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        // gbc.weightx = 1; // Giãn ngang
//
//      
//            var newJpanel = new PanelUserBill();
//            this.panelUserBill.add(newJpanel, gbc);
//        
//
//        this.panelUserBill.revalidate();
//        this.panelUserBill.repaint();
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
        PanelBill = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelHomePageLayout.setVerticalGroup(
            PanelHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(PanelHomePageLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

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

        jLabel1.setText("_________________________________________________________________");
        PanelProfile.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 306, 370, 20));

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1252, Short.MAX_VALUE)
        );
        PanelBillLayout.setVerticalGroup(
            PanelBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelContentsLayout = new javax.swing.GroupLayout(PanelContents);
        PanelContents.setLayout(PanelContentsLayout);
        PanelContentsLayout.setHorizontalGroup(
            PanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelProfile, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
            .addGroup(PanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelHomePage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelContentsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PanelBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        PanelContentsLayout.setVerticalGroup(
            PanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelProfile, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
            .addGroup(PanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelHomePage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    }//GEN-LAST:event_btnProfleMouseClicked

    private void btnHomePageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomePageMouseClicked
        PanelProfile.setVisible(false);
        PanelHomePage.setVisible(true);
        PanelBill.setVisible(false);
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
    }//GEN-LAST:event_btnUserBillMouseClicked

    private void btnUserBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserBillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUserBillActionPerformed

    private void btnProfleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfleActionPerformed

        if (!PanelProfile.isVisible()) {
            TextPasswordProfile.setEchoChar('*');
            CheckPassword.setSelected(false);
        }

    }//GEN-LAST:event_btnProfleActionPerformed

    private void textFieldController1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldController1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldController1ActionPerformed

    private void CheckPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CheckPasswordMouseClicked

        if (CheckPassword.isSelected()) {
            TextPasswordProfile.setEchoChar((char) 0);
        } else {
            TextPasswordProfile.setEchoChar('*');
        }
    }//GEN-LAST:event_CheckPasswordMouseClicked

    private void btnCancelProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelProfileMouseClicked

        TextNameProfile.setEditable(false);
        TextPasswordProfile.setEditable(false);
        TextGmailProfile.setEditable(false);
        TextNameProfile.setText(currentAccount.getUserName());
        TextPasswordProfile.setText(currentAccount.getUserPassword());
        TextGmailProfile.setText(currentAccount.getUserGmail());
        btnSaveEditProfile.setVisible(false);
    }//GEN-LAST:event_btnCancelProfileMouseClicked

    private void btnSaveEditProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveEditProfileMouseClicked

        AccountController.instance.loadDataAccounts();
        try {

            String name = TextNameProfile.getText();
            String password = String.valueOf(TextPasswordProfile.getPassword());
            String gmail = TextGmailProfile.getText();

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
                TextNameProfile.setEditable(false);
                TextPasswordProfile.setEditable(false);
                TextGmailProfile.setEditable(false);
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

        TextNameProfile.setEditable(true);
        TextPasswordProfile.setEditable(true);
        TextGmailProfile.setEditable(true);
        TextNameProfile.requestFocus();
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
    }//GEN-LAST:event_btnUploadAvatarMouseClicked

    private void btnManagerProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManagerProductsMouseClicked
        // TODO add your handling code here:
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
    private javax.swing.JLabel LabelLogo;
    private javax.swing.JPanel PanelBill;
    private javax.swing.JPanel PanelContainProduct;
    private javax.swing.JPanel PanelContents;
    private javax.swing.JPanel PanelHomePage;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JPanel PanelProfile;
    private Forms.Components.TextFieldController TextGmailProfile;
    private Forms.Components.TextFieldController TextNameProfile;
    private Forms.Components.PasswordField TextPasswordProfile;
    private Forms.Components.HeaderButton btnCancelProfile;
    private Forms.Components.HeaderButton btnEditProfile;
    private Forms.Components.HeaderButton btnHomePage;
    private Forms.Components.HeaderButton btnLogOut;
    private Forms.Components.HeaderButton btnManagerAccounts;
    private Forms.Components.HeaderButton btnManagerProducts;
    private Forms.Components.HeaderButton btnProfle;
    private Forms.Components.HeaderButton btnSaveEditProfile;
    private Forms.Components.HeaderButton btnUploadAvatar;
    private Forms.Components.HeaderButton btnUserBill;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jTxTime;
    private javax.swing.JLabel jTxtDate;
    private Forms.Components.TextFieldController textFieldController1;
    private Forms.Components.TextFieldController textFieldController3;
    // End of variables declaration//GEN-END:variables
}
