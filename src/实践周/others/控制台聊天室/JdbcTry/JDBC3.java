package 实践周.控制台聊天室.JdbcTry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC3 {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        Scanner cin = new Scanner(System.in);
        String message = cin.nextLine();
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "hsk200311";

        Connection conn = DriverManager.getConnection(url, username, password);
        //插入数据
        String sql = "INSERT into record(message) values(\"白子说话\");";

        Statement stmt = conn.createStatement();
        //接收修改
         int count = stmt.executeUpdate(sql);


        //查询数据
        stmt.close();
        conn.close();
    }

}

