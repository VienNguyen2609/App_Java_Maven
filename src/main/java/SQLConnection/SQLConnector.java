package SQLConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnector {

    private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final static String url = "jdbc:sqlserver://localhost:1433;databaseName=USERLOGIN;user=sa;password=26092005;encrypt= false;";
    private final static String user = "sa";
    private final static String password = "26092005";

    public static Connection GetConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    public static void GetForName() throws ClassNotFoundException {
        Class.forName(driver);
    }

}
