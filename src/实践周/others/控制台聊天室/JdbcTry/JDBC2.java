package 实践周.控制台聊天室.JdbcTry;

import 实践周.others.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JDBC2 {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        Scanner cin = new Scanner(System.in);
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "hsk200311";

        Connection conn = DriverManager.getConnection(url, username, password);
        String sql = "select *from userinfo;";

        Statement stmt = conn.createStatement();

        List<User> list = new ArrayList<User>();

        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next())
        {
            User user = new User();
            String code = rs.getString("code");
            String name = rs.getString("name");
            String Password = rs.getString("password");
            String email = rs.getString("email");
            user.setCode(code);
            user.setName(name);
            user.setPassword(Password);
            user.setEmail(email);
            list.add(user);
        }
        System.out.println(list);
        stmt.close();
        conn.close();
    }

}

