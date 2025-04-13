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

public class ProductController {

    ArrayList<Shoes> listShoes = new ArrayList<>();
    
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
                Shoes _shoes = new Shoes(id, name, quantity, price, color, null);
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
