package dataUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SoftwareJDBCHelper {
    private static Connection conn = null;
    private static String driver = "org.sqlite.JDBC"; //驱动
    private static String url = "jdbc:sqlite:collegeA.db"; //连接数据库
    private static String username = "root"; //用户名
    private static String password = "123456"; //密码
    public PreparedStatement pst = null; //保存查询语句

    //连接数据库
    public SoftwareJDBCHelper() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //保存查询语句
    public void run(String operateString){
        try {
            pst = conn.prepareStatement(operateString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //关闭
    public void close() {
        try {
            this.conn.close();
            this.pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
