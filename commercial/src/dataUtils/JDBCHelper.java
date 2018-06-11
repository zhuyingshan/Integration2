package dataUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class JDBCHelper {
    private static final String url = "jdbc:mysql://localhost/commerce?user=root&password=123456&characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "123456";

    private Connection conn = null;
    public PreparedStatement pst = null;
    public JDBCHelper() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void run(String operateString){
        try {
            pst = conn.prepareStatement(operateString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            this.conn.close();
            this.pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    protected void finalize() {
        this.close();
    }
}

