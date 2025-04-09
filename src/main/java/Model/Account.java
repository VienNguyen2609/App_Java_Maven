package Model;

public class Account {
    private int userId;
    private String userName, userPassword, userGmail;
    
    public Account(String name, String pass, String gmail) {
        this.userName = name;
        this.userPassword = pass;
        this.userGmail = gmail;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int UserId) {
        this.userId = UserId;
    }
    
    public Account() {
    }

    public String getName() {
        return userName;
    }

    public void setName(String name) {
        this.userName = name;
    }

    public String getPass() {
        return userPassword;
    }

    public void setPass(String pass) {
        this.userPassword = pass;
    }

    public String getGmail() {
        return userGmail;
    }

    public void setGmail(String gmail) {
        this.userGmail = gmail;
    }

    @Override
    public String toString() {
        return "Account{" + "userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userGmail=" + userGmail + '}';
    }
    
}
