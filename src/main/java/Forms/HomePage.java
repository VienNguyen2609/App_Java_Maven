package Forms;

import Controllers.AccountController;
import Controllers.BillController;
import Controllers.ProductController;
import Forms.Components.EffectComponents;
import Main.Run;
import Model.Account;
import Model.Shoes;
import RunAdmin.RunAdmin;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class HomePage extends javax.swing.JFrame {

    private Account currentAccount;

    private int quantityAvailableBill;
    private File selectedFile;
    private Icon icon;

    private String nameText;
    private String colorText;
    private String passwordText;
    private String gmailText;
    private float priceText;
    private int idProductText;
    private int sizeProductText;
    private int quantityText;
    private int selectedRow;
    private byte[] imageProduct = null;

    private byte[] imageUser = null;
    private int idUserText;

    private int status = 0;

    public HomePage() {
    }

    public HomePage(Account account) {
        this.currentAccount = account;
        init(account);
    }

    private void init(Account account) {

        initComponents();
        txtNameProfile.setText(account.getUserName());
        txtPasswordProfile.setText(account.getUserPassword());
        txtGmailProfile.setText(account.getUserGmail());
        setAvatar(account.getAvatarUser());
        editComponents();
        if (!account.getUserName().equalsIgnoreCase("admin")) {
            btnManagerProducts.setVisible(false);
            btnManagerAccounts.setVisible(false);
            status = 1;
        }

    }

    private void editComponents() {

        ProductController.init();
        AccountController.init();
        EffectComponents.init();
        BillController.init();
        jScrollPane2.getVerticalScrollBar().setUnitIncrement(15); // tốc độ lướt của jscroll 
        SpinnerNumberModel model = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
        txtQuantityProduct.setModel(model);
        styleButton();
        stylePanel();
        setTime();
        setupWindow();
        //   searchProduct();
        addPanelProducts();
        mouseClickRightTableBill();
        txtBillName.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
        txtBillSize.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
        txtBillQuantity.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
        txtBillPrice.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
        txtBillColor.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
        ProductController.instance.loadTableProduct(tbProduct);
        BillController.instance.loadBills(tbBill, currentAccount.getUserName());
        AccountController.instance.loadTableAccount(tbAccount);
        tbAccount.getTableHeader().setReorderingAllowed(false);
        EffectComponents.instance.scaleImage(LabelLogo, "/Image/LogoShopImage.png");
      //  EffectComponents.instance.scaleImage(LabelIconProfile, "/Image/profileIcon.png");
        EffectComponents.instance.focusPointer1(txtNameProduct, LabelNameProduct, Color.GREEN, Color.WHITE);
        EffectComponents.instance.focusPointer1(txtSizeProduct, LabelSizeProduct, Color.GREEN, Color.WHITE);
        EffectComponents.instance.focusPointer1(txtPriceProduct, LabelPriceProduct, Color.GREEN, Color.WHITE);
        EffectComponents.instance.focusPointer1(txtColorProduct, LabelColorProduct, Color.GREEN, Color.WHITE);
        EffectComponents.instance.focusPointer1(txtNameUser, LabelNameUser, Color.GREEN, Color.WHITE);
        EffectComponents.instance.focusPointer1(txtPasswordUser, LabelPasswordUser, Color.GREEN, Color.WHITE);
        EffectComponents.instance.focusPointer1(txtGmailUser, LabelGmailUser, Color.GREEN, Color.WHITE);
    }

    private void getTextfiledOfProductComponents() {

        nameText = txtNameProduct.getText().trim();
        sizeProductText = Integer.parseInt(txtSizeProduct.getText().trim());
        colorText = txtColorProduct.getText().trim();
        selectedRow = tbProduct.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a product from the table first!");
            return;
        }
        priceText = Float.parseFloat(txtPriceProduct.getText().trim());
        quantityText = Integer.parseInt(txtQuantityProduct.getValue().toString().trim());
        idProductText = Integer.parseInt(tbProduct.getValueAt(selectedRow, 1).toString().trim());

        if (nameText.isEmpty() || sizeProductText <= 0 || colorText.isEmpty() || priceText <= 0 || quantityText <= 0) {
            JOptionPane.showMessageDialog(this, "INFORMATION NOT EMPTY");
            return;
        }
        try {
            if (selectedFile == null) {
                return;
            } else {
                imageProduct = Files.readAllBytes(selectedFile.toPath());
            }
        } catch (IOException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getTextfiledOfProfileComponents() {
        nameText = txtNameProfile.getText();
        passwordText = String.valueOf(txtPasswordProfile.getPassword());
        gmailText = txtGmailProfile.getText();

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

//    private void searchProduct() {
//        txtSearch.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                PanelContainProduct.setLayout(new GridBagLayout());
//                PanelContainProduct.removeAll();
//                
//                GridBagConstraints gbc = new GridBagConstraints();
//                gbc.gridx = 0;
//                gbc.gridy = 0;
//                gbc.gridwidth = 2;
//                PanelContainProduct.add(txtSearch, gbc);
//                PanelContainProduct.add(btnSearch, gbc);
//
//                Shoes found = ProductController.instance.searchProductByName(txtSearch.getText().trim());
//                if (found != null) {
//                    gbc.gridx = 0;
//                    gbc.gridy = 1;
//                    gbc.gridwidth = 2;
//                    PanelProducts panel = new PanelProducts(found, null);
//                    PanelContainProduct.add(panel, gbc);
//                } else {
//                    gbc.gridx = 0;
//                    gbc.gridy = 1;
//                    gbc.gridwidth = 2;
//                    JLabel notFound = new JLabel("Không tìm thấy sản phẩm!");
//                    notFound.setForeground(Color.RED);
//                    notFound.setFont(new Font("Arial", Font.BOLD, 16));
//                    PanelContainProduct.add(notFound, gbc);
//                }
//
//                if (txtSearch.getText().isEmpty()) {
//                    addPanelProducts(); // Hiển thị lại tất cả nếu không nhập gì
//                    return;
//                }
//            }
//        });
//    }
//    private void performSearch(String keyword) {
//        this.PanelContainProduct.removeAll();
//        this.PanelContainProduct.setLayout(new GridBagLayout());
//
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.insets = new Insets(10, 30, 30, 30);
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//
//        // Thêm lại txtSearch và btnSearch
//        gbc.gridx = 1;
//        gbc.gridy = 0;
//        gbc.gridwidth = 1;
//        this.PanelContainProduct.add(txtSearch, gbc);
//        this.PanelContainProduct.add(btnSearch, gbc);
//        if (keyword.isEmpty()) {
//            displayAllProducts(); // Hiển thị lại tất cả nếu không nhập gì
//            return;
//        }
//
//        Shoes found = ProductController.instance.searchProductByName(keyword);
//        if (found != null) {
//            gbc.gridx = 0;
//            gbc.gridy = 1;
//            gbc.gridwidth = 2;
//            PanelProducts panel = new PanelProducts(found, this);
//            this.PanelContainProduct.add(panel, gbc);
//        } else {
//            gbc.gridx = 0;
//            gbc.gridy = 1;
//            gbc.gridwidth = 2;
//            JLabel notFound = new JLabel("Không tìm thấy sản phẩm!");
//            notFound.setForeground(Color.RED);
//            notFound.setFont(new Font("Arial", Font.BOLD, 16));
//            this.PanelContainProduct.add(notFound, gbc);
//        }
//
//        this.PanelContainProduct.revalidate();
//        this.PanelContainProduct.repaint();
//    }
//
//    private void displayAllProducts() {
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.insets = new Insets(10, 30, 30, 30);
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.gridx = 1;
//        gbc.gridy = 0;
//        gbc.gridwidth = 1;
//        this.PanelContainProduct.add(txtSearch, gbc);
//        this.PanelContainProduct.add(btnSearch, gbc);
//        int cols = 3;
//        for (int i = 0; i < ProductController.instance.getDataProduct().size(); i++) {
//            Shoes shoes = ProductController.instance.getDataProduct().get(i);
//            var newJpanel = new PanelProducts(shoes, this);
//            gbc.gridx = i % cols;
//            gbc.gridy = (i / cols) + 1;
//            this.PanelContainProduct.add(newJpanel, gbc);
//        }
//
//        this.PanelContainProduct.revalidate();
//        this.PanelContainProduct.repaint();
//    }
    private void addPanelProducts() {

        this.PanelContainProduct.setLayout(new GridBagLayout());
        this.PanelContainProduct.removeAll();
        ProductController.instance.loadDataProducts();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 20, 20); // Khoảng cách giữa các item
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // gbc.weightx = 1; // Giãn ngang

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        this.PanelContainProduct.add(txtSearch, gbc);
        this.PanelContainProduct.add(btnSearch, gbc);

        gbc.gridwidth = 1;
        int cols = 3; // Số cột
        for (int i = 0; i < ProductController.instance.getDataProduct().size(); i++) {
            Shoes shoes = ProductController.instance.getDataProduct().get(i);
            var newJpanel = new PanelProducts(shoes, this);
            gbc.gridx = i % cols;
            gbc.gridy = (i / cols) + 1;
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
        btnUploadImageProduct.setBackgroundColor(Color.ORANGE);
        btnAddProduct.setBackgroundColor(Color.lightGray);
        btnUpdateProduct.setBackgroundColor(Color.GREEN);
        btnDeleteProduct.setBackgroundColor(Color.RED);
        btnCancelProduct.setBackgroundColor(Color.BLUE);
        btnUploadAvatarUser.setBackgroundColor(Color.ORANGE);
        btnPushProductToHome.setBackgroundColor(Color.RED);
        btnUpdateUser.setBackgroundColor(Color.ORANGE);
        btnAddUser.setBackgroundColor(Color.RED);
        btnDeleteUser.setBackgroundColor(Color.GREEN);
        btnCancelUser.setBackgroundColor(Color.BLUE);
        btnRefreshBill.setBackgroundColor(Color.RED);
        btnSearch.setBackgroundColor(Color.LIGHT_GRAY);
        btnSaveEditProfile.setVisible(false);
    }

    private void stylePanel() {
        PanelProfile.setVisible(false);
        PanelHomePage.setVisible(true);
        PanelProducts.setVisible(false);
        PanelBill.setVisible(false);
        PanelAccount.setVisible(false);
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
        selectedRow = tbProduct.getSelectedRow();
        if (selectedRow != -1) {
            String name = tbProduct.getValueAt(selectedRow, 2).toString();
            int size = Integer.parseInt(tbProduct.getValueAt(selectedRow, 3).toString());
            float price = Float.parseFloat(tbProduct.getValueAt(selectedRow, 4).toString());
            int quantity = Integer.parseInt(tbProduct.getValueAt(selectedRow, 5).toString());
            String color = tbProduct.getValueAt(selectedRow, 6).toString();
            byte[] image = (byte[]) tbProduct.getValueAt(selectedRow, 7);
//            LabelNameProduct.setForeground(Color.GREEN);
//            LabelSizeProduct.setForeground(Color.GREEN);
//            LabelPriceProduct.setForeground(Color.GREEN);
//            LabelQuantityProduct.setForeground(Color.GREEN);
//            LabelColorProduct.setForeground(Color.GREEN);
            txtNameProduct.setText(name);
            txtSizeProduct.setText("" + size);
            txtPriceProduct.setText(price + ""); // hoặc setValue nếu là JSpinner
            txtQuantityProduct.setValue(quantity); // JSpinner
            txtColorProduct.setText(color);
            if (image != null) {
                ImageIcon icon = new ImageIcon(image);
                LabelImageProduct.setIcon(icon);
            } else {
                LabelImageProduct.setIcon(null);
            }
        }

    }

    public void clickMouseTableAccount() {
        selectedRow = tbAccount.getSelectedRow();
        if (selectedRow != -1) {
            String name = tbAccount.getValueAt(selectedRow, 2).toString();
            String Password = tbAccount.getValueAt(selectedRow, 3).toString();
            String gmail = tbAccount.getValueAt(selectedRow, 4).toString();
            byte[] image = (byte[]) tbAccount.getValueAt(selectedRow, 5);
//            LabelNameProduct.setForeground(Color.GREEN);
//            LabelSizeProduct.setForeground(Color.GREEN);
//            LabelPriceProduct.setForeground(Color.GREEN);
//            LabelQuantityProduct.setForeground(Color.GREEN);
//            LabelColorProduct.setForeground(Color.GREEN);
            txtNameUser.setText(name);
            txtPasswordUser.setText(Password);
            txtGmailUser.setText(gmail);
            if (image != null) {
                ImageIcon icon = new ImageIcon(image);
                LabelImageUser.setIcon(icon);
            } else {
                LabelImageUser.setIcon(null);
            }
        }
    }

    public void viewTextProduct() {
        txtNameProduct.setText("");
        txtSizeProduct.setText("");
        txtPriceProduct.setText("");
        txtQuantityProduct.setValue(0);
        txtColorProduct.setText("");
    }

    public void viewBill() {
        ImageProductBill.setIcon(null);
        txtBillColor.setText("");
        txtBillSize.setText("");
        txtBillPrice.setText("");
        txtBillColor.setText("");
        txtBillQuantity.setText("");
    }

    private int productIdCurrent;

    public void getTextBill(int productId, String name, String size, String price, String color, int quantityAvailable, ImageIcon imageIcon) {
        ImageProductBill.setIcon(imageIcon);
        productIdCurrent = productId;
        txtBillName.setText(name);
        txtBillPrice.setText(price);
        txtBillColor.setText(color);
        txtBillSize.setText(size);
        this.quantityAvailableBill = quantityAvailable;
    }

    public void mouseClickRightTableBill() {
        // Popup Menu (chuột phải)
        deleteItem.addActionListener(e -> {
            int selectedRow = tbBill.getSelectedRow();
            if (selectedRow != -1) {
                int confirm = JOptionPane.showConfirmDialog(this, "DO YOU WANT DELELE THIS BILL ? ", "CONFIRM", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    int billId = Integer.parseInt(tbBill.getValueAt(selectedRow, 1).toString());
                    String productName = tbBill.getValueAt(selectedRow, 3).toString();
                    int quantity = Integer.parseInt(tbBill.getValueAt(selectedRow, 4).toString());
                    //BillController.instance.model.removeRow(selectedRow);
                    BillController.instance.cancelBill(billId, productName, quantity);
                    BillController.instance.loadBills(tbBill, currentAccount.getUserName());
                    addPanelProducts();
                }
            }
        });
        popupMenu.add(deleteItem);
        // Bắt sự kiện chuột phải để mở popup
        tbBill.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                showPopup(e);
            }

            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }

            private void showPopup(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    int row = tbBill.rowAtPoint(e.getPoint());
                    if (row != -1) {
                        tbBill.setRowSelectionInterval(row, row);
                        popupMenu.show(e.getComponent(), e.getX(), e.getY());
                    }
                }
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        popupMenu = new javax.swing.JPopupMenu();
        deleteItem = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        PanelHeader = new javax.swing.JPanel();
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
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnBuy = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnCanelBuy = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        ImageProductBill = new javax.swing.JLabel();
        txtBillColor = new Forms.Components.TextFieldController();
        txtBillName = new Forms.Components.TextFieldController();
        txtBillSize = new Forms.Components.TextFieldController();
        txtBillPrice = new Forms.Components.TextFieldController();
        txtBillQuantity = new Forms.Components.TextFieldController();
        jScrollPane2 = new javax.swing.JScrollPane();
        PanelContainProduct = new javax.swing.JPanel();
        txtSearch = new Forms.Components.TextFieldController();
        btnSearch = new Forms.Components.HeaderButton();
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
        tbBill = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnRefreshBill = new Forms.Components.HeaderButton();
        PanelProducts = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbProduct = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnDeleteProduct = new Forms.Components.HeaderButton();
        btnCancelProduct = new Forms.Components.HeaderButton();
        btnUploadImageProduct = new Forms.Components.HeaderButton();
        btnAddProduct = new Forms.Components.HeaderButton();
        btnUpdateProduct = new Forms.Components.HeaderButton();
        LabelPriceProduct = new javax.swing.JLabel();
        LabelNameProduct = new javax.swing.JLabel();
        LabelQuantityProduct = new javax.swing.JLabel();
        LabelColorProduct = new javax.swing.JLabel();
        txtQuantityProduct = new javax.swing.JSpinner();
        txtPriceProduct = new Forms.Components.TextFieldController();
        txtColorProduct = new Forms.Components.TextFieldController();
        txtNameProduct = new Forms.Components.TextFieldController();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnPushProductToHome = new Forms.Components.HeaderButton();
        LabelImageProduct = new Forms.Components.ProfilePhoto();
        txtSizeProduct = new Forms.Components.TextFieldController();
        jLabel18 = new javax.swing.JLabel();
        LabelSizeProduct = new javax.swing.JLabel();
        PanelAccount = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbAccount = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnDeleteUser = new Forms.Components.HeaderButton();
        btnCancelUser = new Forms.Components.HeaderButton();
        btnUploadAvatarUser = new Forms.Components.HeaderButton();
        btnAddUser = new Forms.Components.HeaderButton();
        btnUpdateUser = new Forms.Components.HeaderButton();
        LabelGmailUser = new javax.swing.JLabel();
        LabelNameUser = new javax.swing.JLabel();
        txtGmailUser = new Forms.Components.TextFieldController();
        txtNameUser = new Forms.Components.TextFieldController();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        LabelImageUser = new Forms.Components.ProfilePhoto();
        txtPasswordUser = new Forms.Components.TextFieldController();
        jLabel23 = new javax.swing.JLabel();
        LabelPasswordUser = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        deleteItem.setText("CANCEL THIS BILL?");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));

        jPanel1.setPreferredSize(new java.awt.Dimension(1337, 802));
        jPanel1.setLayout(new java.awt.BorderLayout());

        PanelHeader.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        PanelHeader.setMinimumSize(new java.awt.Dimension(562, 80));
        PanelHeader.setPreferredSize(new java.awt.Dimension(1293, 80));
        PanelHeader.setLayout(new java.awt.GridBagLayout());

        LabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/LogoShopImage.png"))); // NOI18N
        LabelLogo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 0, 51)));
        LabelLogo.setMaximumSize(new java.awt.Dimension(150, 150));
        LabelLogo.setMinimumSize(new java.awt.Dimension(130, 130));
        LabelLogo.setOpaque(true);
        LabelLogo.setPreferredSize(new java.awt.Dimension(1200, 125));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        PanelHeader.add(LabelLogo, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 23)); // NOI18N
        jLabel3.setText("SHOPEEKY");
        jLabel3.setMaximumSize(new java.awt.Dimension(90, 90));
        jLabel3.setMinimumSize(new java.awt.Dimension(180, 90));
        jLabel3.setOpaque(true);
        jLabel3.setPreferredSize(new java.awt.Dimension(180, 90));
        jLabel3.setVerifyInputWhenFocusTarget(false);
        jLabel3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipady = -11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 565, 1, 0);
        PanelHeader.add(jLabel3, gridBagConstraints);

        jTxTime.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTxTime.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jTxTime.setMaximumSize(new java.awt.Dimension(85, 85));
        jTxTime.setMinimumSize(new java.awt.Dimension(85, 30));
        jTxTime.setPreferredSize(new java.awt.Dimension(85, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 189, 0, 0);
        PanelHeader.add(jTxTime, gridBagConstraints);

        jTxtDate.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTxtDate.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jTxtDate.setFocusable(false);
        jTxtDate.setMaximumSize(new java.awt.Dimension(135, 30));
        jTxtDate.setMinimumSize(new java.awt.Dimension(155, 30));
        jTxtDate.setPreferredSize(new java.awt.Dimension(155, 30));
        jTxtDate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 0, 0, 0);
        PanelHeader.add(jTxtDate, gridBagConstraints);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/result_flag.png"))); // NOI18N
        jLabel11.setMaximumSize(new java.awt.Dimension(90, 90));
        jLabel11.setMinimumSize(new java.awt.Dimension(90, 90));
        jLabel11.setPreferredSize(new java.awt.Dimension(90, 90));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipady = -11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 1, 1);
        PanelHeader.add(jLabel11, gridBagConstraints);

        jPanel1.add(PanelHeader, java.awt.BorderLayout.PAGE_START);

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
        btnUserBill.setText("Bill");
        btnUserBill.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnUserBill.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUserBill.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnUserBill.setIconTextGap(5);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 334, Short.MAX_VALUE)
                .addComponent(btnProfle, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(PanelMenu, java.awt.BorderLayout.LINE_START);

        PanelContents.setOpaque(false);
        PanelContents.setPreferredSize(new java.awt.Dimension(1200, 634));

        PanelHomePage.setPreferredSize(new java.awt.Dimension(1100, 720));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("BILL");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 37, 34));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Color");
        jLabel9.setToolTipText("");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("Price ");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 50, 30));

        btnBuy.setBackground(new java.awt.Color(255, 0, 51));
        btnBuy.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBuy.setForeground(new java.awt.Color(255, 255, 255));
        btnBuy.setText("Buy it");
        btnBuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuyMouseExited(evt);
            }
        });
        jPanel3.add(btnBuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 110, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("Size");
        jLabel13.setToolTipText("");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("Quantity");
        jLabel14.setToolTipText("");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, 30));

        btnCanelBuy.setBackground(new java.awt.Color(204, 204, 204));
        btnCanelBuy.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCanelBuy.setForeground(new java.awt.Color(255, 255, 255));
        btnCanelBuy.setText("Cancel");
        btnCanelBuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCanelBuyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCanelBuyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCanelBuyMouseExited(evt);
            }
        });
        jPanel3.add(btnCanelBuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 540, 110, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 0));
        jLabel19.setText("Name");
        jLabel19.setToolTipText("");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        ImageProductBill.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 0)));
        jPanel3.add(ImageProductBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 210, 130));

        txtBillColor.setBorder(new javax.swing.border.MatteBorder(null));
        txtBillColor.setForeground(new java.awt.Color(255, 0, 51));
        txtBillColor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtBillColor.setName(""); // NOI18N
        txtBillColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBillColorActionPerformed(evt);
            }
        });
        jPanel3.add(txtBillColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, 170, 30));

        txtBillName.setBorder(new javax.swing.border.MatteBorder(null));
        txtBillName.setForeground(new java.awt.Color(255, 0, 51));
        txtBillName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtBillName.setName(""); // NOI18N
        txtBillName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBillNameActionPerformed(evt);
            }
        });
        jPanel3.add(txtBillName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 170, 30));

        txtBillSize.setBorder(new javax.swing.border.MatteBorder(null));
        txtBillSize.setForeground(new java.awt.Color(255, 0, 51));
        txtBillSize.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtBillSize.setName(""); // NOI18N
        txtBillSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBillSizeActionPerformed(evt);
            }
        });
        jPanel3.add(txtBillSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 170, 30));

        txtBillPrice.setBorder(new javax.swing.border.MatteBorder(null));
        txtBillPrice.setForeground(new java.awt.Color(255, 0, 51));
        txtBillPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtBillPrice.setName(""); // NOI18N
        txtBillPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBillPriceActionPerformed(evt);
            }
        });
        jPanel3.add(txtBillPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 170, 30));

        txtBillQuantity.setBorder(new javax.swing.border.MatteBorder(null));
        txtBillQuantity.setForeground(new java.awt.Color(255, 0, 51));
        txtBillQuantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtBillQuantity.setName(""); // NOI18N
        txtBillQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBillQuantityActionPerformed(evt);
            }
        });
        jPanel3.add(txtBillQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 170, 30));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        txtSearch.setForeground(new java.awt.Color(255, 255, 255));
        txtSearch.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtSearch.setMinimumSize(new java.awt.Dimension(70, 40));
        txtSearch.setPreferredSize(new java.awt.Dimension(70, 40));
        txtSearch.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/searchIcon.png"))); // NOI18N

        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnSearch.setMinimumSize(new java.awt.Dimension(77, 28));
        btnSearch.setPreferredSize(new java.awt.Dimension(77, 40));

        javax.swing.GroupLayout PanelContainProductLayout = new javax.swing.GroupLayout(PanelContainProduct);
        PanelContainProduct.setLayout(PanelContainProductLayout);
        PanelContainProductLayout.setHorizontalGroup(
            PanelContainProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContainProductLayout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1093, Short.MAX_VALUE))
        );
        PanelContainProductLayout.setVerticalGroup(
            PanelContainProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContainProductLayout.createSequentialGroup()
                .addGroup(PanelContainProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 1080, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(PanelContainProduct);

        javax.swing.GroupLayout PanelHomePageLayout = new javax.swing.GroupLayout(PanelHomePage);
        PanelHomePage.setLayout(PanelHomePageLayout);
        PanelHomePageLayout.setHorizontalGroup(
            PanelHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHomePageLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1049, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelHomePageLayout.setVerticalGroup(
            PanelHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PanelProfile.setMinimumSize(new java.awt.Dimension(898, 458));
        PanelProfile.setPreferredSize(new java.awt.Dimension(898, 458));
        PanelProfile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelAvatar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        PanelProfile.add(LabelAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 170, 130));

        btnUploadAvatar.setBackground(new java.awt.Color(153, 153, 255));
        btnUploadAvatar.setForeground(new java.awt.Color(255, 255, 255));
        btnUploadAvatar.setText("Upload Avatar");
        btnUploadAvatar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUploadAvatarMouseClicked(evt);
            }
        });
        PanelProfile.add(btnUploadAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 150, -1));

        btnEditProfile.setForeground(new java.awt.Color(255, 255, 255));
        btnEditProfile.setText("Edit Profile");
        btnEditProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditProfileMouseClicked(evt);
            }
        });
        PanelProfile.add(btnEditProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 430, 150, -1));

        jLabel1.setText("_________________________________________________________________");
        PanelProfile.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 370, 20));

        txtNameProfile.setEditable(false);
        txtNameProfile.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        PanelProfile.add(txtNameProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, 260, -1));

        txtGmailProfile.setEditable(false);
        txtGmailProfile.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        PanelProfile.add(txtGmailProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, 270, -1));

        txtPasswordProfile.setEditable(false);
        txtPasswordProfile.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        txtPasswordProfile.setEchoChar('\u002A'
        );
        txtPasswordProfile.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        PanelProfile.add(txtPasswordProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 330, 230, 30));

        btnSaveEditProfile.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveEditProfile.setText("Save");
        btnSaveEditProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveEditProfileMouseClicked(evt);
            }
        });
        PanelProfile.add(btnSaveEditProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 600, 100, -1));

        btnCancelProfile.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelProfile.setText("Cancel");
        btnCancelProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelProfileMouseClicked(evt);
            }
        });
        PanelProfile.add(btnCancelProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 430, 110, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/result_account.png"))); // NOI18N
        jLabel2.setText("Name:");
        PanelProfile.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 80, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/result_padlock.png"))); // NOI18N
        jLabel4.setText("Password:");
        PanelProfile.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, 110, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/GmailIcon.png"))); // NOI18N
        jLabel5.setText("Gmail:");
        PanelProfile.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, 90, -1));

        CheckPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckPassword.setText("Show Password");
        CheckPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CheckPasswordMouseClicked(evt);
            }
        });
        PanelProfile.add(CheckPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 340, -1, -1));

        jLabel6.setText("_________________________________________________________________");
        PanelProfile.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 370, 20));

        jLabel7.setText("_________________________________________________________________");
        PanelProfile.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 370, 30));

        tbBill.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tbBill.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        tbBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No.", "BillId", "UserName", "Product", "Size", "Quantity", "Price", "Total", "DateBooking"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbBill.setShowHorizontalLines(true);
        tbBill.setShowVerticalLines(true);
        tbBill.getTableHeader().setResizingAllowed(false);
        tbBill.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbBill);
        if (tbBill.getColumnModel().getColumnCount() > 0) {
            tbBill.getColumnModel().getColumn(1).setResizable(false);
            tbBill.getColumnModel().getColumn(2).setResizable(false);
            tbBill.getColumnModel().getColumn(3).setResizable(false);
            tbBill.getColumnModel().getColumn(4).setResizable(false);
            tbBill.getColumnModel().getColumn(5).setResizable(false);
            tbBill.getColumnModel().getColumn(6).setResizable(false);
            tbBill.getColumnModel().getColumn(7).setResizable(false);
            tbBill.getColumnModel().getColumn(8).setResizable(false);
        }

        btnRefreshBill.setForeground(new java.awt.Color(255, 255, 255));
        btnRefreshBill.setText("Refresh");
        btnRefreshBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRefreshBillMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRefreshBill, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRefreshBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelBillLayout = new javax.swing.GroupLayout(PanelBill);
        PanelBill.setLayout(PanelBillLayout);
        PanelBillLayout.setHorizontalGroup(
            PanelBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBillLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1262, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelBillLayout.setVerticalGroup(
            PanelBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
            .addGroup(PanelBillLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tbProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No.", "ID", "Name", "Size", "Price", "Quantity", "Color", "Image"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Integer.class, java.lang.String.class, java.lang.Byte.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProduct.setShowHorizontalLines(true);
        tbProduct.setShowVerticalLines(true);
        tbProduct.getTableHeader().setResizingAllowed(false);
        tbProduct.getTableHeader().setReorderingAllowed(false);
        tbProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbProductMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tbProduct);
        if (tbProduct.getColumnModel().getColumnCount() > 0) {
            tbProduct.getColumnModel().getColumn(0).setMinWidth(50);
            tbProduct.getColumnModel().getColumn(0).setMaxWidth(50);
            tbProduct.getColumnModel().getColumn(1).setMinWidth(55);
            tbProduct.getColumnModel().getColumn(1).setMaxWidth(55);
            tbProduct.getColumnModel().getColumn(2).setMinWidth(120);
            tbProduct.getColumnModel().getColumn(2).setMaxWidth(120);
            tbProduct.getColumnModel().getColumn(3).setMinWidth(50);
            tbProduct.getColumnModel().getColumn(3).setMaxWidth(50);
            tbProduct.getColumnModel().getColumn(4).setMinWidth(120);
            tbProduct.getColumnModel().getColumn(4).setMaxWidth(120);
            tbProduct.getColumnModel().getColumn(5).setMinWidth(70);
            tbProduct.getColumnModel().getColumn(5).setMaxWidth(70);
            tbProduct.getColumnModel().getColumn(6).setMinWidth(150);
            tbProduct.getColumnModel().getColumn(6).setMaxWidth(150);
            tbProduct.getColumnModel().getColumn(7).setMinWidth(170);
            tbProduct.getColumnModel().getColumn(7).setMaxWidth(155);
        }

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDeleteProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteProduct.setText("Delete");
        btnDeleteProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteProductMouseClicked(evt);
            }
        });
        jPanel2.add(btnDeleteProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 570, 130, -1));

        btnCancelProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelProduct.setText("Cancel");
        btnCancelProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelProductMouseClicked(evt);
            }
        });
        jPanel2.add(btnCancelProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 570, 130, -1));

        btnUploadImageProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnUploadImageProduct.setText("UploadImage");
        btnUploadImageProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUploadImageProductMouseClicked(evt);
            }
        });
        jPanel2.add(btnUploadImageProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 130, -1));

        btnAddProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnAddProduct.setText("Add");
        btnAddProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddProductMouseClicked(evt);
            }
        });
        jPanel2.add(btnAddProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, 130, -1));

        btnUpdateProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateProduct.setText("Update");
        btnUpdateProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateProductMouseClicked(evt);
            }
        });
        jPanel2.add(btnUpdateProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 520, 130, -1));

        LabelPriceProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelPriceProduct.setForeground(new java.awt.Color(255, 255, 255));
        LabelPriceProduct.setText("Price");
        jPanel2.add(LabelPriceProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        LabelNameProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelNameProduct.setForeground(new java.awt.Color(255, 255, 255));
        LabelNameProduct.setText("NameProduct");
        jPanel2.add(LabelNameProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        LabelQuantityProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelQuantityProduct.setForeground(new java.awt.Color(255, 255, 255));
        LabelQuantityProduct.setText("Quantity");
        jPanel2.add(LabelQuantityProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        LabelColorProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelColorProduct.setForeground(new java.awt.Color(255, 255, 255));
        LabelColorProduct.setText("Color");
        jPanel2.add(LabelColorProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, -1, -1));

        txtQuantityProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel2.add(txtQuantityProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 80, -1));

        txtPriceProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPriceProduct.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PriceIcon.png"))); // NOI18N
        jPanel2.add(txtPriceProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 150, -1));

        txtColorProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtColorProduct.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ColorIcon.png"))); // NOI18N
        jPanel2.add(txtColorProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 150, -1));

        txtNameProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNameProduct.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ProductManagerIcon.png"))); // NOI18N
        jPanel2.add(txtNameProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 170, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("____________________________________");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 210, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("____________________________________");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 210, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("____________________________________");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 210, 30));

        btnPushProductToHome.setForeground(new java.awt.Color(255, 255, 255));
        btnPushProductToHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/refreshIcon.png"))); // NOI18N
        btnPushProductToHome.setText("Refresh ");
        btnPushProductToHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPushProductToHomeMouseClicked(evt);
            }
        });
        jPanel2.add(btnPushProductToHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 560, 130, 40));

        LabelImageProduct.setPreferredSize(new java.awt.Dimension(160, 130));
        jPanel2.add(LabelImageProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, 130));

        txtSizeProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSizeProduct.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/SizeIcon.png"))); // NOI18N
        jPanel2.add(txtSizeProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 170, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("____________________________________");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 210, 30));

        LabelSizeProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelSizeProduct.setForeground(new java.awt.Color(255, 255, 255));
        LabelSizeProduct.setText("Size");
        jPanel2.add(LabelSizeProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 30, -1));

        javax.swing.GroupLayout PanelProductsLayout = new javax.swing.GroupLayout(PanelProducts);
        PanelProducts.setLayout(PanelProductsLayout);
        PanelProductsLayout.setHorizontalGroup(
            PanelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProductsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelProductsLayout.setVerticalGroup(
            PanelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tbAccount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tbAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No.", "Id", "Name", "Password", "Gmail", "Avatar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Byte.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbAccount.setShowHorizontalLines(true);
        tbAccount.setShowVerticalLines(true);
        tbAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbAccountMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tbAccount);
        if (tbAccount.getColumnModel().getColumnCount() > 0) {
            tbAccount.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDeleteUser.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteUser.setText("Delete");
        btnDeleteUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteUserMouseClicked(evt);
            }
        });
        jPanel4.add(btnDeleteUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 500, 130, -1));

        btnCancelUser.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelUser.setText("Cancel");
        btnCancelUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelUserMouseClicked(evt);
            }
        });
        jPanel4.add(btnCancelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 500, 130, -1));

        btnUploadAvatarUser.setForeground(new java.awt.Color(255, 255, 255));
        btnUploadAvatarUser.setText("UploadImage");
        btnUploadAvatarUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUploadAvatarUserMouseClicked(evt);
            }
        });
        jPanel4.add(btnUploadAvatarUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 130, -1));

        btnAddUser.setForeground(new java.awt.Color(255, 255, 255));
        btnAddUser.setText("Add");
        btnAddUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddUserMouseClicked(evt);
            }
        });
        jPanel4.add(btnAddUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, 130, -1));

        btnUpdateUser.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateUser.setText("Update");
        btnUpdateUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateUserMouseClicked(evt);
            }
        });
        jPanel4.add(btnUpdateUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 130, -1));

        LabelGmailUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelGmailUser.setForeground(new java.awt.Color(255, 255, 255));
        LabelGmailUser.setText("Gmail");
        jPanel4.add(LabelGmailUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, -1));

        LabelNameUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelNameUser.setForeground(new java.awt.Color(255, 255, 255));
        LabelNameUser.setText("Name");
        jPanel4.add(LabelNameUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        txtGmailUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtGmailUser.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/GmailIcon.png"))); // NOI18N
        jPanel4.add(txtGmailUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 210, -1));

        txtNameUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNameUser.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/result_account.png"))); // NOI18N
        jPanel4.add(txtNameUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 200, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("____________________________________");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 210, 30));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("____________________________________");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 210, 30));

        LabelImageUser.setPreferredSize(new java.awt.Dimension(160, 130));
        jPanel4.add(LabelImageUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, 130));

        txtPasswordUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPasswordUser.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/result_padlock.png"))); // NOI18N
        jPanel4.add(txtPasswordUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 200, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("____________________________________");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 210, 30));

        LabelPasswordUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelPasswordUser.setForeground(new java.awt.Color(255, 255, 255));
        LabelPasswordUser.setText("Password");
        jPanel4.add(LabelPasswordUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 70, -1));

        javax.swing.GroupLayout PanelAccountLayout = new javax.swing.GroupLayout(PanelAccount);
        PanelAccount.setLayout(PanelAccountLayout);
        PanelAccountLayout.setHorizontalGroup(
            PanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAccountLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE))
        );
        PanelAccountLayout.setVerticalGroup(
            PanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelContentsLayout = new javax.swing.GroupLayout(PanelContents);
        PanelContents.setLayout(PanelContentsLayout);
        PanelContentsLayout.setHorizontalGroup(
            PanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelProfile, javax.swing.GroupLayout.DEFAULT_SIZE, 1379, Short.MAX_VALUE)
            .addGroup(PanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelHomePage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1377, Short.MAX_VALUE))
            .addGroup(PanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelBill, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelProducts, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelContentsLayout.setVerticalGroup(
            PanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelProfile, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
            .addGroup(PanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelHomePage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE))
            .addGroup(PanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(PanelContents, java.awt.BorderLayout.CENTER);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("© SHOPEEKY 2025. Redistribution or reproduction is strictly prohibited. ");
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
        PanelAccount.setVisible(false);
    }//GEN-LAST:event_btnProfleMouseClicked

    private void btnHomePageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomePageMouseClicked
        PanelProfile.setVisible(false);
        PanelHomePage.setVisible(true);
        PanelBill.setVisible(false);
        PanelProducts.setVisible(false);
        PanelAccount.setVisible(false);
    }//GEN-LAST:event_btnHomePageMouseClicked

    private void btnLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogOutMouseClicked

        if (status == 1) {
            Run.runApp();
            dispose();
        } else {
            RunAdmin.runApp();
            dispose();
        }

    }//GEN-LAST:event_btnLogOutMouseClicked

    private void btnUserBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserBillMouseClicked
        PanelBill.setVisible(true);
        PanelHomePage.setVisible(false);
        PanelProfile.setVisible(false);
        PanelProducts.setVisible(false);
        PanelAccount.setVisible(false);
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

        getTextfiledOfProfileComponents();
        AccountController.instance.loadDataAccounts();
        try {

            if (!AccountController.instance.checkAccount1(nameText, passwordText, gmailText, status)) {
                return;
            }

            Account UpdateAccount = AccountController.instance.updateAccount(nameText, passwordText, gmailText, currentAccount.getUserName());
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
        PanelAccount.setVisible(false);
    }//GEN-LAST:event_btnManagerProductsMouseClicked

    private void btnManagerProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagerProductsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnManagerProductsActionPerformed

    private void btnManagerAccountsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManagerAccountsMouseClicked
        PanelBill.setVisible(false);
        PanelHomePage.setVisible(false);
        PanelProfile.setVisible(false);
        PanelProducts.setVisible(false);
        PanelAccount.setVisible(true);
    }//GEN-LAST:event_btnManagerAccountsMouseClicked

    private void tbProductMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductMouseReleased
        clickMouseTableProduct();
    }//GEN-LAST:event_tbProductMouseReleased

    private void btnAddProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddProductMouseClicked

        getTextfiledOfProductComponents();
        try {
            if (ProductController.instance.addProduct(nameText, sizeProductText, priceText, quantityText, colorText, imageProduct)) {
                ProductController.instance.loadDataProducts();
                ProductController.instance.loadTableProduct(tbProduct);
                viewTextProduct();
                LabelImageProduct.setIcon(null);
                // LabelImageProduct.setBorder(new MatteBorder(1, 1, 1, 1, Color.YELLOW));
                JOptionPane.showMessageDialog(this, "PRODUCT ADDED SUCCESSFULLY");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnAddProductMouseClicked

    private void btnCancelProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelProductMouseClicked
        viewTextProduct();
    }//GEN-LAST:event_btnCancelProductMouseClicked

    private void btnDeleteProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteProductMouseClicked

        getTextfiledOfProductComponents();
        ProductController.instance.loadDataProducts();
        try {
            int check = JOptionPane.showConfirmDialog(this, "DO YOU WANT DELETE THIS PRODUCT!", "CONFIRM", JOptionPane.YES_NO_OPTION);

            if (check == JOptionPane.YES_OPTION) {
                if (ProductController.instance.deleteProduct(nameText)) {
                    ProductController.instance.loadTableProduct(tbProduct);
                    viewTextProduct();
                    JOptionPane.showMessageDialog(this, "DELETED SUCCESSFULLY");
                } else {
                    JOptionPane.showMessageDialog(this, "DELETE FAILURE");
                    return;
                }
            } else {
                return;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteProductMouseClicked

    private void btnUploadImageProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUploadImageProductMouseClicked

        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile();
            icon = new ImageIcon(new ImageIcon(selectedFile.getAbsolutePath())
                    .getImage().getScaledInstance(LabelImageProduct.getWidth(), LabelImageProduct.getHeight(), Image.SCALE_SMOOTH));
            LabelImageProduct.setIcon(icon);
            LabelImageProduct.setBorder(null);
        }
        if (selectedFile == null) {
            JOptionPane.showMessageDialog(this, "PHOTO NOT UPDATE YET!");
            return;
        }


    }//GEN-LAST:event_btnUploadImageProductMouseClicked

    private void btnUpdateProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateProductMouseClicked

        getTextfiledOfProductComponents();
        if (ProductController.instance.updateProduct(nameText, sizeProductText, quantityText, priceText, colorText, imageProduct, idProductText)) {
            JOptionPane.showMessageDialog(this, "UPDATED THIS PRODUCT ID: " + idProductText + " SUCCESSFULLY");
            ProductController.instance.loadTableProduct(tbProduct);
            viewTextProduct();
            LabelImageProduct.setIcon(null);
            //   LabelImageProduct.setBorder(new MatteBorder(1, 1, 1, 1, Color.YELLOW));
            return;
        } else {
            JOptionPane.showMessageDialog(this, "UPDATED FAILURE THIS PRODUCT ID: " + idProductText);
            return;
        }

    }//GEN-LAST:event_btnUpdateProductMouseClicked

    private void btnPushProductToHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPushProductToHomeMouseClicked

        int check = JOptionPane.showConfirmDialog(this, "UPLOAD ALL PRODUCT TO HOMEPAGE!", "CONFIRM", JOptionPane.YES_NO_OPTION);
        if (check == JOptionPane.YES_OPTION) {
            addPanelProducts();
            JOptionPane.showMessageDialog(this, "UPLOAD TO HOMEPAGE SUCCESSFULLY!");
        } else {
            return;
        }

    }//GEN-LAST:event_btnPushProductToHomeMouseClicked

    private void btnCanelBuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCanelBuyMouseClicked
        viewBill();
    }//GEN-LAST:event_btnCanelBuyMouseClicked

    private void btnBuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuyMouseClicked

        try {

            int quantity = Integer.parseInt(txtBillQuantity.getText().trim());
            if (quantity > quantityAvailableBill || quantity < 0 || quantity == 0) {
                JOptionPane.showMessageDialog(this, "Purchase quantity exceeds available stock!");
                return;
            }

            float price = Float.parseFloat(txtBillPrice.getText().trim());
            int size = Integer.parseInt(txtBillSize.getText().trim());
            int check = JOptionPane.showConfirmDialog(this, "ARE YOU SURE WANT BUY IT ", "CONFIRM", JOptionPane.YES_NO_OPTION);
            if (check == JOptionPane.YES_OPTION) {
                if (BillController.instance.addBill(currentAccount.getUserId(), productIdCurrent, size, new java.sql.Date(new Date().getTime()), quantity, price)) {
                    JOptionPane.showMessageDialog(this, "BUY SUCCESSFULLY");
                    BillController.instance.loadBills(tbBill, currentAccount.getUserName());
                    addPanelProducts();
                    viewBill();
                    return;
                }
            } else {
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ENTER A NUMBER NOT STRING", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuyMouseClicked

    private void btnBuyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuyMouseEntered
        btnBuy.setBackground(Color.GREEN);
    }//GEN-LAST:event_btnBuyMouseEntered

    private void btnBuyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuyMouseExited
        btnBuy.setBackground(Color.RED);
    }//GEN-LAST:event_btnBuyMouseExited

    private void btnCanelBuyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCanelBuyMouseEntered
        btnCanelBuy.setBackground(Color.MAGENTA);
    }//GEN-LAST:event_btnCanelBuyMouseEntered

    private void btnCanelBuyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCanelBuyMouseExited
        btnCanelBuy.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_btnCanelBuyMouseExited

    private void btnDeleteUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteUserMouseClicked

        selectedRow = tbAccount.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a product from the table first!");
            return;
        }
        idUserText = Integer.parseInt(tbAccount.getValueAt(selectedRow, 1).toString().trim());
        if (AccountController.instance.deleteAccount(idUserText)) {
            JOptionPane.showMessageDialog(this, "DELETED SUCCESSFULLY ID:" + idUserText);
            AccountController.instance.loadTableAccount(tbAccount);
        }
    }//GEN-LAST:event_btnDeleteUserMouseClicked

    private void btnCancelUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelUserMouseClicked
        txtNameUser.setText("");
        txtPasswordUser.setText("");
        txtGmailUser.setText("");
        LabelImageUser.setIcon(null);
    }//GEN-LAST:event_btnCancelUserMouseClicked

    private void btnUploadAvatarUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUploadAvatarUserMouseClicked
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile();
            icon = new ImageIcon(new ImageIcon(selectedFile.getAbsolutePath())
                    .getImage().getScaledInstance(LabelImageUser.getWidth(), LabelImageUser.getHeight(), Image.SCALE_SMOOTH));
            LabelImageUser.setIcon(icon);
            LabelImageUser.setBorder(null);
        }
        if (selectedFile == null) {
            JOptionPane.showMessageDialog(this, "PHOTO NOT UPDATE YET!");
            return;
        }
    }//GEN-LAST:event_btnUploadAvatarUserMouseClicked

    private void btnAddUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddUserMouseClicked

        String name = txtNameUser.getText().trim();
        String pass = txtPasswordUser.getText().trim();
        String gamil = txtGmailUser.getText().trim();

        if (!AccountController.instance.checkAccount(name, pass, gamil)) {
            return;
        }
        if (selectedFile == null) {
            return;
        } else {
            try {
                imageUser = Files.readAllBytes(selectedFile.toPath());
            } catch (IOException ex) {
                Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (AccountController.instance.addAccount(name, pass, gamil, imageUser)) {
            JOptionPane.showMessageDialog(this, "ADDED ACCOUNT SUCCESSFULLY!");
            AccountController.instance.loadTableAccount(tbAccount);
            return;
        }

    }//GEN-LAST:event_btnAddUserMouseClicked

    private void btnUpdateUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateUserMouseClicked

        selectedRow = tbAccount.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a product from the table first!");
            return;
        }
        idUserText = Integer.parseInt(tbAccount.getValueAt(selectedRow, 1).toString().trim());
        String name = txtNameUser.getText().trim();
        String pass = txtPasswordUser.getText().trim();
        String gamil = txtGmailUser.getText().trim();
        if (!AccountController.instance.checkAccount(name, pass, gamil)) {
            return;
        }
        if (AccountController.instance.updateAccountManager(name, pass, gamil, idUserText)) {
            JOptionPane.showMessageDialog(this, "UPDATE SUCCESSFULLY ID USER:" + idProductText);
            AccountController.instance.loadTableAccount(tbAccount);

        }
    }//GEN-LAST:event_btnUpdateUserMouseClicked

    private void tbAccountMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAccountMouseReleased
        clickMouseTableAccount();
    }//GEN-LAST:event_tbAccountMouseReleased

    private void btnRefreshBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshBillMouseClicked
        BillController.instance.loadBills(tbBill, currentAccount.getUserName());
    }//GEN-LAST:event_btnRefreshBillMouseClicked

    private void txtBillColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBillColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBillColorActionPerformed

    private void txtBillNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBillNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBillNameActionPerformed

    private void txtBillSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBillSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBillSizeActionPerformed

    private void txtBillPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBillPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBillPriceActionPerformed

    private void txtBillQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBillQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBillQuantityActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckPassword;
    private javax.swing.JLabel ImageProductBill;
    private Forms.Components.ProfilePhoto LabelAvatar;
    private javax.swing.JLabel LabelColorProduct;
    private javax.swing.JLabel LabelGmailUser;
    private Forms.Components.ProfilePhoto LabelImageProduct;
    private Forms.Components.ProfilePhoto LabelImageUser;
    private javax.swing.JLabel LabelLogo;
    private javax.swing.JLabel LabelNameProduct;
    private javax.swing.JLabel LabelNameUser;
    private javax.swing.JLabel LabelPasswordUser;
    private javax.swing.JLabel LabelPriceProduct;
    private javax.swing.JLabel LabelQuantityProduct;
    private javax.swing.JLabel LabelSizeProduct;
    private javax.swing.JPanel PanelAccount;
    private javax.swing.JPanel PanelBill;
    private javax.swing.JPanel PanelContainProduct;
    private javax.swing.JPanel PanelContents;
    private javax.swing.JPanel PanelHeader;
    private javax.swing.JPanel PanelHomePage;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JPanel PanelProducts;
    private javax.swing.JPanel PanelProfile;
    private Forms.Components.HeaderButton btnAddProduct;
    private Forms.Components.HeaderButton btnAddUser;
    private javax.swing.JButton btnBuy;
    private Forms.Components.HeaderButton btnCancelProduct;
    private Forms.Components.HeaderButton btnCancelProfile;
    private Forms.Components.HeaderButton btnCancelUser;
    private javax.swing.JButton btnCanelBuy;
    private Forms.Components.HeaderButton btnDeleteProduct;
    private Forms.Components.HeaderButton btnDeleteUser;
    private Forms.Components.HeaderButton btnEditProfile;
    private Forms.Components.HeaderButton btnHomePage;
    private Forms.Components.HeaderButton btnLogOut;
    private Forms.Components.HeaderButton btnManagerAccounts;
    private Forms.Components.HeaderButton btnManagerProducts;
    private Forms.Components.HeaderButton btnProfle;
    private Forms.Components.HeaderButton btnPushProductToHome;
    private Forms.Components.HeaderButton btnRefreshBill;
    private Forms.Components.HeaderButton btnSaveEditProfile;
    private Forms.Components.HeaderButton btnSearch;
    private Forms.Components.HeaderButton btnUpdateProduct;
    private Forms.Components.HeaderButton btnUpdateUser;
    private Forms.Components.HeaderButton btnUploadAvatar;
    private Forms.Components.HeaderButton btnUploadAvatarUser;
    private Forms.Components.HeaderButton btnUploadImageProduct;
    private Forms.Components.HeaderButton btnUserBill;
    private javax.swing.JMenuItem deleteItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel jTxTime;
    private javax.swing.JLabel jTxtDate;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JTable tbAccount;
    private javax.swing.JTable tbBill;
    private javax.swing.JTable tbProduct;
    private Forms.Components.TextFieldController txtBillColor;
    private Forms.Components.TextFieldController txtBillName;
    private Forms.Components.TextFieldController txtBillPrice;
    private Forms.Components.TextFieldController txtBillQuantity;
    private Forms.Components.TextFieldController txtBillSize;
    private Forms.Components.TextFieldController txtColorProduct;
    private Forms.Components.TextFieldController txtGmailProfile;
    private Forms.Components.TextFieldController txtGmailUser;
    private Forms.Components.TextFieldController txtNameProduct;
    private Forms.Components.TextFieldController txtNameProfile;
    private Forms.Components.TextFieldController txtNameUser;
    private Forms.Components.PasswordField txtPasswordProfile;
    private Forms.Components.TextFieldController txtPasswordUser;
    private Forms.Components.TextFieldController txtPriceProduct;
    private javax.swing.JSpinner txtQuantityProduct;
    private Forms.Components.TextFieldController txtSearch;
    private Forms.Components.TextFieldController txtSizeProduct;
    // End of variables declaration//GEN-END:variables
}
