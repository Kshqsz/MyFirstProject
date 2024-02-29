package 实践周.java实践大作业;

import 实践周.others.ScreenUtils;
import 实践周.others.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class loginframe {

    JFrame jf = new JFrame("登录界面");
    JFrame frame = new JFrame("");

    final int WIDTH = 450;
    final int HEIGHT = 300;

    public void init()
    {

        frame.setBounds((ScreenUtils.getScreenWidth() - WIDTH) / 2, (ScreenUtils.getScreenHeight() - HEIGHT) / 2, WIDTH, HEIGHT);
        frame.setResizable(true);


        JTextField text = new JTextField(15);



        JTextField textField = new JTextField("                                                        用户名或密码错误");
        Box box = Box.createHorizontalBox();
        box.add(textField);
        frame.add(box);
        //设置窗口的相关属性
        jf.setBounds((ScreenUtils.getScreenWidth() - WIDTH) / 2, (ScreenUtils.getScreenHeight() - HEIGHT) / 2, WIDTH, HEIGHT);
        jf.setResizable(true);

        //设置窗口的内容


        Box vbox = Box.createVerticalBox();

        //组装用户名
        Box uBox = Box.createHorizontalBox();
        JLabel uLable = new JLabel("用户名: ");
        JTextField ufiled = new JTextField(15);

        uBox.add(uLable);
        uBox.add(Box.createHorizontalStrut(20));
        uBox.add(ufiled);

        //组装密码
        Box pBox = Box.createHorizontalBox();
        JLabel pLable  = new JLabel("密    码: ");
        JTextField pfiled = new JTextField(15);
        pBox.add(pLable);
        pBox.add(Box.createHorizontalStrut(20));
        pBox.add(pfiled);

        //组装按钮
        Box btnBox = Box.createHorizontalBox();
        JButton loginBtn = new JButton("登录");
        JButton regisBtn = new JButton("注册");
        JButton record = new JButton("历史记录");
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String username = ufiled.getText().trim();
                String password = pfiled.getText().trim();
                if (check(username, password))
                {
                    Client client = new Client();
                    client.start(username);
                }
                else
                {
                    frame.setVisible(true);
                }
            }
        });
        btnBox.add(loginBtn);
        btnBox.add(Box.createHorizontalStrut(100));
        btnBox.add(regisBtn);

        vbox.add(Box.createVerticalStrut(50));
        vbox.add(uBox);
        vbox.add(Box.createVerticalStrut(20));
        vbox.add(pBox);
        vbox.add(Box.createVerticalStrut(40));
        vbox.add(btnBox);

        jf.add(vbox);
        jf.setVisible(true);

    }
    public static void main(String[] args) throws Exception {
        show();
        new loginframe().init();
    }
    public static boolean check(String username, String password)
    {
        if (username.equals("宋晓梅") && password.equals("123456")) return true;
        if (username.equals("关松杰") && password.equals("654321")) return true;
        if (username.equals("李晓梅") && password.equals("123654")) return true;
        if (username.equals("张松岩") && password.equals("456123")) return true;
        if (username.equals("王亚杰") && password.equals("321456")) return true;
        if (username.equals("曲小声") && password.equals("654321")) return true;
        return false;
    }

    public static void query() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Scanner cin = new Scanner(System.in);
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "hsk200311";

        Connection conn = DriverManager.getConnection(url, username, password);

        //查询数据
        String sql = "select *from record";
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);
        String str = "";
        while (rs.next())
        {
            String message = rs.getString(1);
            str += message + "\n";
        }
        System.out.println(str);
        stmt.close();
        conn.close();
    }
    public static void insert(String message) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "hsk200311";

        Connection conn = DriverManager.getConnection(url, username, password);
        //插入数据
        String sql = "INSERT into record(message) values('" + message + "');";

        Statement stmt = conn.createStatement();
        //接收修改
        int count = stmt.executeUpdate(sql);

        //查询数据
        stmt.close();
        conn.close();
    }

    public static  void show() throws Exception {
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





