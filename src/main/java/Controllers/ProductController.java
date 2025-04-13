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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProductController {

    private ArrayList<Shoes> listShoes = new ArrayList<>();

    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;

    private static ProductController instance;
    private static boolean isInitiallized = false;

    public static void Init() {
        if (isInitiallized == true) {
            return;
        } else {
            instance = new ProductController();
            isInitiallized = true;
        }
    }

    public void DatabaseConnected(String sql) throws SQLException {
        try {
            SQLConnector.GetForName();
            conn = SQLConnector.GetConnection();
            ps = conn.prepareStatement(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void LoadData() {
        listShoes.clear();
        try {
            DatabaseConnected("SELECT * FROM Products");
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ProductId");
                String name = rs.getString("ProductName");
                float price = rs.getFloat("ProductPrice");
                int quantity = rs.getInt("ProductQuantity");
                String color = rs.getString("ProductColor");
                Shoes _shoes = new Shoes(id ,name, quantity, price, color, null);
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

    public boolean addProduct(String name, float price, int quantity, String color) {
        boolean check = false;
        try {
            DatabaseConnected("INSERT INTO Products (ProductName, ProductPrice, ProductQuantity , ProductColor) VALUES (?,?,?,?)");
            ps.setString(1, name);
            ps.setFloat(2, price);
            ps.setInt(3, quantity);
            ps.setString(4, color);
            int n = ps.executeUpdate();
            if (n > 0) {
                Shoes _shoes = new Shoes(name, quantity, price, color);
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

    public boolean UpdateProduct(String name, int quantity, float price, String color, String ProductName) {
        boolean check = false;

        try {
            DatabaseConnected("UPDATE Products SET ProductName =? , ProductPrice = ?, ProductQuantity = ?, ProductColor = ? WHERE ProductName  = ?");
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setInt(3, quantity);
            ps.setString(4, color);
            ps.setString(5, ProductName);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                for (Shoes shoes : listShoes) {
                    if (Find(ProductName)) {
                        shoes.setProductName(name);
                        shoes.setProductQuantity(quantity);
                        shoes.setProductPrice(price);
                        shoes.setProductColor(color);
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

    public boolean Find(String name) {
        boolean check = false;
        try {
            for (Shoes shoes : listShoes) {
                if (shoes.getProductName().equalsIgnoreCase(name)) {
                    check = true;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return check;
    }

    public void FindProduct(String name, JTable tbProduct) {
        DefaultTableModel model = (DefaultTableModel) tbProduct.getModel();
        model.setNumRows(0);
        int temp = 0;
        try {
            for (Shoes shoes : listShoes) {
                if (shoes.getProductName().equalsIgnoreCase(name)) {
                    temp++;
                    int a = listShoes.indexOf(shoes);
                    model.addRow(new Object[]{a++, shoes.getProductId(), shoes.getProductName(), shoes.getProductPrice(), shoes.getProductQuantity(), shoes.getProductColor(), shoes.getTotalProduct()});
                }
            }
            if (temp == 0) {
                JOptionPane.showMessageDialog(null, "NAME: " + name + "   \nFAILD!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean DeleteProduct(String ProductName) {
        boolean check = false;
        try {
            DatabaseConnected("delete from Products where ProductName = ?");
            ps.setString(1, ProductName);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                for (Shoes shoes : listShoes) {
                    if (Find(ProductName)) {
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

    public void in() {
        for (Shoes a : listShoes) {
            System.out.println(a.toString());
        }
    }

    public static void main(String[] args) {
        ProductController.Init();
        ProductController.instance.LoadData();
        ProductController.instance.in();

    }
}
