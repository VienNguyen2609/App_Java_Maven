package Controllers;

import DatabaseConnection.SQLConnector;
import Model.Shoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ProductController {

    private ArrayList<Shoes> listShoes = new ArrayList<>();

    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static ProductController instance;
    private static boolean isInitiallized = false;

    public static void init() {
        if (isInitiallized == true) {
            return;
        } else {
            instance = new ProductController();
            isInitiallized = true;
        }
    }

    private void setupDatabaseCommand(String sql) throws SQLException {
        try {
            SQLConnector.getForName();
            conn = SQLConnector.getConnection();
            ps = conn.prepareStatement(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loadDataProducts() {
        listShoes.clear();
        try {
            setupDatabaseCommand("SELECT * FROM Products");
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ProductId");
                String name = rs.getString("ProductName");
                float price = rs.getFloat("ProductPrice");
                int size = rs.getInt("ProductSize");
                int quantity = rs.getInt("ProductQuantity");
                String color = rs.getString("ProductColor");
                byte[] image = rs.getBytes("ProductImage");
                Shoes _shoes = new Shoes(id, name, size, quantity, price, color, image);
                listShoes.add(_shoes);
            }
            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unexpected error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadTableProduct(JTable table) {

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        ProductController.instance.loadDataProducts();
        var data = ProductController.instance.getDataProduct();
        int n = 0;
        for (Shoes shoes : data) {
            model.addRow(new Object[]{n++, shoes.getProductId(), shoes.getProductName(),shoes.getProductSize() ,  shoes.getProductPrice(), shoes.getProductQuantity(), shoes.getProductColor(), shoes.getProductAvatar()});
        }
    }

    public boolean addProduct(String name, int size, float price, int quantity, String color, byte[] image) {
        if (image == null) {
            JOptionPane.showMessageDialog(null, "PRODUCT IMAGE MUST NOT BE EMPTY!");
            return false;
        }
        boolean check = false;
        try {
            setupDatabaseCommand("INSERT INTO Products (ProductName, ProductSize, ProductPrice, ProductQuantity , ProductColor ,ProductImage ) VALUES (?,?,?,?,?,?)");
            ps.setString(1, name);
            ps.setInt(2, size);
            ps.setFloat(3, price);
            ps.setInt(4, quantity);
            ps.setString(5, color);
            ps.setBytes(6, image);
            int n = ps.executeUpdate();

            if (n > 0) {
                Shoes _shoes = new Shoes(name, size, quantity, price, color, image);
                listShoes.add(_shoes);
                check = true;
            }

            ps.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter correct format", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return check;
    }

    public boolean updateProduct(String name, int size ,  int quantity, float price, String color, byte[] image ,int idProduct ) {
        boolean check = false;

        try {
            setupDatabaseCommand("UPDATE Products SET ProductName =? , ProductSize =? , ProductPrice = ?, ProductQuantity = ?, ProductColor = ? , ProductImage =? WHERE ProductId  = ?");
            ps.setString(1, name);
            ps.setInt(2, size);
            ps.setFloat(3, price);
            ps.setInt(4, quantity);
            ps.setString(5, color);
            ps.setBytes(6, image);
            ps.setInt(7, idProduct);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                for (Shoes shoes : listShoes) {
                    if (shoes.getProductId() == idProduct) {
                        shoes.setProductName(name);
                        shoes.setProductSize(size);
                        shoes.setProductQuantity(quantity);
                        shoes.setProductPrice(price);
                        shoes.setProductColor(color);
                        shoes.setProductAvatar(image);
                        check = true;
                        break;
                    }
                }
            }
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return check;
    }

//    public boolean Find(String name) {
//        boolean check = false;
//        try {
//            for (Shoes shoes : listShoes) {
//                if (shoes.getProductName().equalsIgnoreCase(name)) {
//                    check = true;
//                }
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
//        }
//        return check;
//    }
//    public void findProduct(String name, JTable tbProduct) {
//        DefaultTableModel model = (DefaultTableModel) tbProduct.getModel();
//        model.setNumRows(0);
//        int temp = 0;
//        try {
//            for (Shoes shoes : listShoes) {
//                if (shoes.getProductName().equalsIgnoreCase(name)) {
//                    temp++;
//                    int a = listShoes.indexOf(shoes);
//                    model.addRow(new Object[]{a++, shoes.getProductId(), shoes.getProductName(), shoes.getProductPrice(), shoes.getProductQuantity(), shoes.getProductColor(), shoes.getTotalProduct()});
//                }
//            }
//            if (temp == 0) {
//                JOptionPane.showMessageDialog(null, "NAME: " + name + "   \nFAILD!");
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
//        }
//    }
    public boolean deleteProduct(String ProductName) {
        boolean check = false;
        try {
            setupDatabaseCommand("delete from Products where ProductName = ?");
            ps.setString(1, ProductName);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                for (Shoes shoes : listShoes) {
                    if (shoes.getProductName().equalsIgnoreCase(ProductName)) {
                        listShoes.remove(shoes);
                        check = true;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return check;
    }

    public ArrayList<Shoes> getDataProduct() {
        return listShoes;
    }

    public void in() {
        for (Shoes a : listShoes) {
            System.out.println(a.toString());
        }
    }

    public static void main(String[] args) {
        ProductController.init();
        ProductController.instance.loadDataProducts();
        
        ProductController.instance.addProduct("Puma", 40 ,300, 4, "Green" , null);
  

        ProductController.instance.in();

    }
}
