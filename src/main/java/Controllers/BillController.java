package Controllers;

import DatabaseConnection.SQLConnector;
import Model.Bill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class BillController {

    private ArrayList<Bill> listBill = new ArrayList<>();

    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;
    public DefaultTableModel model ; 
    
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

//     public void loadBill() {
//        listBill.clear();
//        try {
//            setupDatabaseCommand("select * from Bill");
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                int billId = rs.getInt("BillId");
//                int userId = rs.getInt("UserId");
//                int productId = rs.getInt("ProductId");
//                Date date = rs.getDate("BillDate");
//                int quantity = rs.getInt("Quantity");
//                float price = rs.getFloat("Price");
//                float total = rs.getFloat("TotalAmount");
//                Bill _bill = new Bill(billId, userId,productId , quantity, total  , price , date );
//                this.listBill.add(_bill);
//            }
//            rs.close();
//            ps.close();
//            conn.close();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Unexpected error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
//        }
//    }
    public void loadBills(JTable table) {
        listBill.clear();
         model = (DefaultTableModel) table.getModel();
         model.setRowCount(0);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        try {
            setupDatabaseCommand("SELECT b.BillId, u.UserName, p.ProductName, b.Quantity, b.Price, b.TotalAmount, b.BillDate "
                    + "FROM Bill b "
                    + "JOIN UserAccount u ON b.UserId = u.UserId "
                    + "JOIN Products p ON b.ProductId = p.ProductId");
            rs = ps.executeQuery();
            int n = 0;
            while (rs.next()) {
                model.addRow(new Object[]{n++,
                    rs.getInt("BillId"),
                    rs.getString("UserName"),
                    rs.getString("ProductName"),
                    rs.getInt("Quantity"),
                    rs.getFloat("Price"),
                    rs.getFloat("TotalAmount"),
                    rs.getDate("BillDate")
                });
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean addBill(int userId, int productId, Date billDate, int quantity, float price) {

        try {
            setupDatabaseCommand("INSERT INTO bill ( UserId, ProductId , BillDate ,Quantity ,Price ) VALUES (?,?,?,?,?)");
            ps.setInt(1, userId);
            ps.setInt(2, productId);
            ps.setDate(3, new java.sql.Date(billDate.getTime()));
            ps.setInt(4, quantity);
            ps.setFloat(5, price);
            int n = ps.executeUpdate();
            ps.close();

            if (n > 0) {

                // Nếu thêm thành công, cập nhật số lượng sản phẩm
                setupDatabaseCommand("UPDATE Products SET ProductQuantity = ProductQuantity - ? WHERE ProductId = ?");
                ps.setInt(1, quantity);
                ps.setInt(2, productId);
                int m = ps.executeUpdate(); // Thực thi UPDATE
                ps.close();

                if (m > 0) {

                    // Nếu UPDATE thành công, thêm vào listBill
                    Bill bill = new Bill(userId, productId, quantity, price, billDate);
                    listBill.add(bill);
                    return true;
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unexpected error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean cancelBill(int billId, String productName, int quantity) {
        try {
            setupDatabaseCommand("UPDATE Products SET ProductQuantity = ProductQuantity + ? WHERE ProductName = ?");
            ps.setInt(1, quantity);
            ps.setString(2, productName);
            ps.executeUpdate();
            ps.close();

            setupDatabaseCommand("DELETE FROM Bill WHERE BillId = ?");
            ps.setInt(1, billId);
            int n = ps.executeUpdate();
            ps.close();

            if (n > 0) {
                listBill.removeIf(b -> b.getBillId() == billId);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Bill> getDataBills() {
        return listBill;
    }

}
