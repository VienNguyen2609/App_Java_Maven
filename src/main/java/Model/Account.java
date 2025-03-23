package Model;

public class Account {
    private int UserId;
    private String UserName, UserPassWord, UserGmail;
    
    public Account(String name, String pass, String gmail) {
        this.UserName = name;
        this.UserPassWord = pass;
        this.UserGmail = gmail;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }
    
    public Account() {
    }

    public String getName() {
        return UserName;
    }

    public void setName(String name) {
        this.UserName = name;
    }

    public String getPass() {
        return UserPassWord;
    }

    public void setPass(String pass) {
        this.UserPassWord = pass;
    }

    public String getGmail() {
        return UserGmail;
    }

    public void setGmail(String gmail) {
        this.UserGmail = gmail;
    }
}
