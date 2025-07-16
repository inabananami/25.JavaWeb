import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//public class JDBCDemo {
//    public static void main(String[] args) {
//        // 1.注册驱动
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        // 2.获取连接对象
//        String url = "jdbc:mysql://localhost:3306/test";
//        String username = "root";
//        String password = "123456";
//        Connection conn = DriverManager.getConnection(url, username, password);
//        // 3.定义SQL
//        String sql = "update account set money = 2000 where id = 1";
//        // 4.获取执行sql的对象
//        int count = stmt.executeUpdate();
//        // 5.执行sql
//        int count = stmt.executeUpdate(sql);
//    }
//}
