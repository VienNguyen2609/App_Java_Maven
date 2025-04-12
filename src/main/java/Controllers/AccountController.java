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
            SQLConnector.GetForName();
            Connection conn = SQLConnector.GetConnection();
            String sql = "INSERT INTO account (UserName, PasswordUser, GmailUser)VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pass);
            ps.setString(3, gmail);
            int n = ps.executeUpdate();
            if (n != 0) {
                Account _account = new Account(name, pass, gmail);
                this.listAccount.add(_account);
                System.out.println("concac");
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
                String name = rs.getString("UserName");
                String pass = rs.getString("PasswordUser");
                String gmail = rs.getString("GmailUser");
                byte[] avatar = rs.getBytes("AvatarUser");
                Account _account = new Account(name, pass, gmail, avatar);
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

    public boolean UpdateUserName(String name, String UserName) {
        boolean check = false;
        try {

            SQLConnector.GetForName();
            Connection conn = SQLConnector.GetConnection();
            String updateUserName = "UPDATE account SET UserName = ? WHERE UserName = ?";
            PreparedStatement ps = conn.prepareStatement(updateUserName);
            ps.setString(1, name);
            ps.setString(2, UserName);
            int n = ps.executeUpdate();
            if (n > 0) {
                for (Account account : this.listAccount) {
                    if (account.getUserName().equalsIgnoreCase(UserName)) {
                        account.setUserName(name);
                        check = true;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

//    public boolean LoginUser1(String name, String pass, boolean rememberMe) {
//        boolean check = false;
//        try {
//            SQLConnector.GetForName();
//            Connection conn = SQLConnector.GetConnection();
//            String sql = "SELECT * FROM account WHERE UserName = ? AND PasswordUser = ?";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, name);
//            ps.setString(2, pass);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                String gmail = rs.getString("GmailUser");
//                byte[] avatar = rs.getBytes("AvatarUser");
//                Account acc = new Account(name, pass, gmail, avatar);
//                this.listAccount.add(acc);
//
//                if (rememberMe) {
//                    saveRememberedAccount(acc);
//                }
//                check = true;
//            }
//
//            rs.close();
//            ps.close();
//            conn.close();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return check;
//    }
//    private void saveRememberedAccount(Account acc) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter("remember.txt"))) {
//            writer.write(acc.getUserName()+ ";" + acc.getUserPassword());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public Account getRememberedAccount() {
//        try (BufferedReader reader = new BufferedReader(new FileReader("remember.txt"))) {
//            String line = reader.readLine();
//            if (line != null) {
//                String[] parts = line.split(";");
//                if (parts.length == 2) {
//                    String name = parts[0];
//                    String pass = parts[1];
//                    SQLConnector.GetForName();
//                    Connection conn = SQLConnector.GetConnection();
//                    String sql = "SELECT * FROM account WHERE UserName = ? AND PasswordUser = ?";
//                    PreparedStatement ps = conn.prepareStatement(sql);
//                    ps.setString(1, name);
//                    ps.setString(2, pass);
//                    ResultSet rs = ps.executeQuery();
//                    if (rs.next()) {
//                        String gmail = rs.getString("GmailUser");
//                        byte[] avatar = rs.getBytes("AvatarUser");
//                        return new Account(name, pass, gmail, avatar);
//                    }
//                }
//            }
//        } catch (IOException | SQLException | ClassNotFoundException ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }
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
//   public void in(){
//       for(listAccount x: a){
//           
//       }
//   }
}
