package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Account {

    private int userId;
    private String userName, userPassword, userGmail;
    private byte[] avatarUser;

    public static Account instance;

    private static boolean isInitiallized = false;

    public static void Init() {
        if (isInitiallized == true) {
            return;
        }
        instance = new Account();
        isInitiallized = true;
    }

    public Account(String name, String pass, String gmail) {
        this(name, pass, gmail, null);
    }

    public Account(String userName, String userPassword, String userGmail, byte[] avatarUser) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userGmail = userGmail;
        this.avatarUser = avatarUser;
    }

    public Account() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserGmail() {
        return userGmail;
    }

    public void setUserGmail(String userGmail) {
        this.userGmail = userGmail;
    }

    public byte[] getAvatarUser() {
        return avatarUser;
    }

    public void setAvatarUser(byte[] avatarUser) {
        this.avatarUser = avatarUser;
    }

    public static List<Account> readAccountsFromFile(String path) {
        List<Account> accounts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) { // đủ thông tin
                    String username = parts[0];
                    String password = parts[1];
                    String email = parts[2];
                    byte[] avatar = Base64.getDecoder().decode(parts[4]);

                    Account acc = new Account(username, password, email, avatar);
                    accounts.add(acc);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public String toString() {
        return "Account{" + "userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userGmail=" + userGmail + '}';
    }

}
