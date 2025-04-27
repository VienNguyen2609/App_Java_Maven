package Controllers;

import DatabaseConnection.SQLConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BillController {

    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;

    private static boolean isInitiallized = false;
    private static BillController instance;

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
    
    public boolean addBill(int userId, int productId, Date billDate, int quantity , float  price){
        boolean check = false; 
        return check ; 
    }
    
}
