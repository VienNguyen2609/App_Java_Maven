package Controllers;

import Model.Account;
import SQLConnection.SQLConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountController {

    ArrayList<Account> listAccount = new ArrayList<>();
    public static AccountController instance;

    private static boolean isInitiallized = false;

    public static void Init() {
        if (isInitiallized == true) {
            return;
        }
        instance = new AccountController();
        isInitiallized = true;
    }

    public boolean LoginUser(String name, String pass) {
        boolean check = false;
        try {
            if (name.isEmpty() | pass.isEmpty()) {
                // JOptionPane.showMessageDialog(null, "INFORMATION CAN NOT BE EMPTY", "ERROR", JOptionPane.CANCEL_OPTION);

            } else {
                for (Account account : this.listAccount) {
                    if (account.getName().equalsIgnoreCase(name) && (String.valueOf(account.getPass()).equalsIgnoreCase(pass))) {
                        check = true;
                        break;
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return check;
    }

    public boolean addAccount(String name, String pass, String gmail) {
        boolean check = false;
        try {
            SQLConnector.GetForName();
            Connection conn = SQLConnector.GetConnection();
            String sql = "insert into account values (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pass);
            ps.setString(3, gmail);
            int n = ps.executeUpdate();
            if (n != 0) {
                Account _account = new Account(name, pass, gmail);
                this.listAccount.add(_account);
                check = true;
            }
        } catch (SQLException e) {
             // JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return check;
    }

    public void LoadAccount() {
        listAccount.clear();
        try {
            SQLConnector.GetForName();
            Connection conn = SQLConnector.GetConnection();
            String sql = "select * from account ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int n = 1;
            while (rs.next()) {
                String name = rs.getString("username");
                String pass = rs.getString("pass");
                String gmail = rs.getString("gmail");
                Account _account = new Account(name, pass, gmail);
                this.listAccount.add(_account);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            //  JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            //    JOptionPane.showMessageDialog(null, "Unexpected error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean DeleteAccount(String name) {
        boolean check = false;
        try {
            SQLConnector.GetForName();
            Connection conn = SQLConnector.GetConnection();
            String DeleteAccount = "Delete From account where name =?";
            PreparedStatement ps = conn.prepareStatement(DeleteAccount);
            ps.setString(1, name);
            int n = ps.executeUpdate();
            if (n > 0) {
                for (Account account : this.listAccount) {
                    if (account.getName().equalsIgnoreCase(name)) {
                        this.listAccount.remove(account);
                        check = true;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            //  JOptionPane.showMessageDialog(null,"ERROR: " + e.getMessage());
        }
        return check;
    }



    public ArrayList<Account> getDataAccount() {
        return listAccount;
    }

   
}
