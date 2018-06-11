package dataservice;

import java.sql.*;

/**
 * @author 谢方明
 * JDBC Oracle数据库
 */

public class MathJDBCHelper {
    private static Connection conn = null;
    private static String driver = "oracle.jdbc.driver.OracleDriver"; //驱动
    private static String url = "jdbc:oracle:thin:@//127.0.0.1:1521/orcl"; //连接数据库
    private static String username = "system"; //用户名
    private static String password = "manager"; //密码
    public PreparedStatement pst = null; //保存查询语句

    //连接数据库
    public MathJDBCHelper() {
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