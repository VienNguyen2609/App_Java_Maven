package Forms;

import Forms.Components.SetThemFlatLaf;
import Forms.Components.ThemeFlatLaf;
import Model.Account;

public class TestHome {

    public static void main(String[] args) {
        SetThemFlatLaf.setThem(ThemeFlatLaf.Dark);
        Account account = new Account("vien", "1234567", "      @gmail.com");
        new HomePage(account).setVisible(true);
    }

}
