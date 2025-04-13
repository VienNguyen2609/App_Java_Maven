package Controllers;

import Model.Account;
import DatabaseConnection.SQLConnector;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AccountController {

    ArrayList<Account> listAccount = new ArrayList<>();
    public static AccountController instance;

    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;

    private static boolean isInitiallized = false;

    public static void Init() {
        if (isInitiallized == true) {
            return;
        }
        instance = new AccountController();
        isInitiallized = true;
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

    public void LoadAccount() {
        listAccount.clear();
        try {
            DatabaseConnected("select * from UserAccount");
            rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("UserName");
                String pass = rs.getString("UserPassword");
                String gmail = rs.getString("UserGmail");
                byte[] avatar = rs.getBytes("UserAvatar");
                Account _account = new Account(name, pass, gmail, avatar);
                this.listAccount.add(_account);
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

    public boolean CheckLogin(String name, String pass) {
        boolean check = false;
        try {
            if (name.isEmpty() || pass.isEmpty()) {
                check = false;// JOptionPane.showMessageDialog(null, "INFORMATION CAN NOT BE EMPTY", "ERROR", JOptionPane.CANCEL_OPTION);
            } else if (name.equalsIgnoreCase("admin")) {
                check = false;
            } else {
                for (Account account : this.listAccount) {
                    if (account.getUserName().equalsIgnoreCase(name) && (String.valueOf(account.getUserPassword()).equalsIgnoreCase(pass))) {
                        //gmail.equalsIgnoreCase(account.getGmail());
                        check = true;
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return check;
    }

    public boolean AddAccount(String name, String pass, String gmail) {
        boolean check = false;
        try {
            DatabaseConnected("INSERT INTO UserAccount (UserName, UserPassword, UserGmail)VALUES(?,?,?)");
            int n = ps.executeUpdate();
            if (n != 0) {
                Account _account = new Account(name, pass, gmail);
                this.listAccount.add(_account);
                check = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        return check;
    }

    public boolean DeleteAccount(String name) {
        boolean check = false;
        try {
            DatabaseConnected("Delete From UserAccount where UserName =?");
            ps.setString(1, name);
            int n = ps.executeUpdate();
            if (n > 0) {
                for (Account account : this.listAccount) {
                    if (account.getUserName().equalsIgnoreCase(name)) {
                        this.listAccount.remove(account);
                        check = true;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return check;
    }

    public Account UpdateUser(String name, String pass, String gmail, String UserName) {
        boolean check = false;
        try {
            DatabaseConnected("UPDATE UserAccount SET UserName = ? , UserPassword = ?  , UserGmail = ? WHERE UserName = ?");
            ps.setString(1, name);
            ps.setString(2, pass);
            ps.setString(3, gmail);
            ps.setString(4, UserName);
            int n = ps.executeUpdate();
            if (n > 0) {
                for (Account account : this.listAccount) {
                    if (account.getUserName().equalsIgnoreCase(UserName)) {
                        account.setUserName(name);
                        account.setUserPassword(pass);
                        account.setUserGmail(gmail);
                        return account;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveAvatarToDatabase(File selectedFile, String nameUser) {

        try (
                Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=AppJava_Maven;user=sa;password=26092005;encrypt= false;"); FileInputStream fis = new FileInputStream(selectedFile)) {
            String sql = "UPDATE UserAccount SET UserAvatar = ? WHERE UserName = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(2, nameUser);
            pst.setBinaryStream(1, fis, (int) selectedFile.length());

            int rows = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Account getAccountByUsername(String username) {
        for (Account account : listAccount) {
            if (account.getUserName().equalsIgnoreCase(username)) {
                return account;
            }
        }
        return null;
    }

    public ArrayList<Account> getDataAccount() {
        return listAccount;
    }

    public void in() {
        for (Account account : listAccount) {
            System.out.println(account.toString());
        }
    }

    public static void main(String[] args) {
        AccountController at = new AccountController();
        at.LoadAccount();
        at.in();
    }
}
