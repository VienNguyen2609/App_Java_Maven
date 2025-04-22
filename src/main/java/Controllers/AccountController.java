package Controllers;

import Model.Account;
import DatabaseConnection.SQLConnector;
import Forms.Components.EffectComponents;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AccountController {

    private  ArrayList<Account> listAccount = new ArrayList<>();
    
    public static AccountController instance;
    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;

    private static boolean isInitiallized = false;

    public static void init() {
        if (isInitiallized == true) {
            return;
        }
        instance = new AccountController();
        isInitiallized = true;
    }

    public void setupDatabaseCommand(String sql) throws SQLException {
        try {
            SQLConnector.getForName();
            conn = SQLConnector.getConnection();
            ps = conn.prepareStatement(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loadDataAccounts() {
        listAccount.clear();
        try {
            setupDatabaseCommand("select * from UserAccount");
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("UserId");
                String name = rs.getString("UserName");
                String pass = rs.getString("UserPassword");
                String gmail = rs.getString("UserGmail");
                byte[] avatar = rs.getBytes("UserAvatar");
                Account _account = new Account(id, name, pass, gmail, avatar);
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

    public boolean checkLogin(String name, String pass) {
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

    public boolean addAccount(String name, String pass, String gmail) {
        boolean check = false;
        try {
            setupDatabaseCommand("INSERT INTO UserAccount (UserName, UserPassword, UserGmail)VALUES(?,?,?)");
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
            JOptionPane.showMessageDialog(null, "error: NAME IS EXIST!" );
        }

        return check;
    }

    public boolean deleteAccount(String name) {
        boolean check = false;
        try {
            setupDatabaseCommand("Delete From UserAccount where UserName =?");
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

    public Account updateAccount(String name, String pass, String gmail, String UserName) {

        boolean check = false;
        try {
            setupDatabaseCommand("UPDATE UserAccount SET UserName = ? , UserPassword = ?  , UserGmail = ? WHERE UserName = ?");
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

    public boolean checkAccount(String name, String password, String gmail) {
        boolean check = true;
        if (password.length() < 7 || name.length() < 4) {
            JOptionPane.showMessageDialog(null, "error: LENGTH PASSWORD >= 7 AND NAME >=4");
            check = false;
        }

        if (EffectComponents.instance.containsVietnameseCharacters(name)) {
            JOptionPane.showMessageDialog(null, "error: NAME WRONG!");
            check = false;
        }
        if (name.isEmpty() || password.isEmpty() || gmail.isEmpty()) {
            JOptionPane.showMessageDialog(null, "error: INFORMATION CAN NOT EMPTY");
            check = false;
        }

        if (!gmail.contains("@gmail.com")) {
            JOptionPane.showMessageDialog(null, "error: GMAIL WRONG");
            check = false;
        }
        if (name.equalsIgnoreCase("admin")) {
            JOptionPane.showMessageDialog(null, "error: NAME IS FOR ADMINISTRATOR USE ONLY!!");
            check = false;
        }
        return check;
    }

    public void saveAvatarToDatabase(File selectedFile, String nameUser) {
        try (FileInputStream fis = new FileInputStream(selectedFile)) {
            setupDatabaseCommand("UPDATE UserAccount SET UserAvatar = ? WHERE UserName = ?");
            ps.setString(2, nameUser);
            ps.setBinaryStream(1, fis, (int) selectedFile.length());
            int n = ps.executeUpdate();
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
        at.loadDataAccounts();
        at.in();
    }
}
