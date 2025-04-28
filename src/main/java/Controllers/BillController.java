package Controllers;

import DatabaseConnection.SQLConnector;
import Model.Account;
import Model.Bill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class BillController {
     
    private ArrayList<Bill> listBill = new ArrayList<>();
    
    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;

    private static boolean isInitiallized = false;
    public static BillController instance;

    public static void init() {
        if (isInitiallized == true) {
            return;
        } else {
            instance = new BillController();
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
    
     public void loadBill() {
        listBill.clear();
        try {
            setupDatabaseCommand("select * from Bill");
            rs = ps.executeQuery();
            while (rs.next()) {
                int billId = rs.getInt("BillId");
                int userId = rs.getInt("UserId");
                int productId = rs.getInt("ProductId");
                Date date = rs.getDate("BillDate");
                int quantity = rs.getInt("Quantity");
                float price = rs.getFloat("Price");
                float total = rs.getFloat("TotalAmount");
                Bill _bill = new Bill(billId, userId,productId , quantity, total  , price , date );
                this.listBill.add(_bill);
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


    public boolean addBill(int userId, int productId, Date billDate, int quantity, float price) {
        boolean check = false;

        try {
            setupDatabaseCommand("INSERT INTO bill ( UserId, ProductId , BillDate ,Quantity ,Price ) VALUES (?,?,?,?,?)");
            ps.setInt(1, userId);
            ps.setInt(2, productId);
            ps.setDate(3, new java.sql.Date(billDate.getTime()));
            ps.setInt(4, quantity);
            ps.setFloat(5, price);
            int n = ps.executeUpdate();
            if(n > 0 ){
               Bill bill = new Bill( userId, productId, quantity, price, billDate); 
               listBill.add(bill);
               check = true ; 
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unexpected error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return check;
    }
    
    public ArrayList<Bill> getDataBills(){
        return listBill ; 
    }
    
}
