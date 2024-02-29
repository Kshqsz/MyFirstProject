package 实践周.others;

import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Client {

    static List<User> list = new ArrayList<User>();
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",10000);
        System.out.println("服务器已经连接成功");


        while (true)
        {
            System.out.println("==========欢迎来到聊天室==========");
            System.out.println("1登录");
            System.out.println("2注册");
            System.out.println("请输入您的选择: ");
            Scanner cin = new Scanner(System.in);
            String choose = cin.nextLine();
            if (choose.equals("1"))
            {
                login(socket);
            }
            else if (choose.equals("2"))
            {
                System.out.println("用户选择了注册");
            }
            else System.out.println("没用这个选项");
        }
    }
    public static void login(Socket socket) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Scanner cin = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = cin.nextLine();
        System.out.println("请输入密码");
        String password = cin.nextLine();

        StringBuilder sb = new StringBuilder();
        sb.append("username=").append(username).append("&password=").append(password);

        bw.write("login");
        bw.newLine();
        bw.flush();

        bw.write(sb.toString());
        bw.newLine();
        bw.flush();

        //接受数据
        //获取输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String message = br.readLine();
        System.out.println(message);
        // 1: 登录成功 2: 密码有误 3: 用户名不存在
        if (message.equals("1"))
        {
            System.out.println("登录成功 开始聊天");
            //开一条单独的线程，专门用来接受服务端发送过来的聊天记录
            new Thread(new ClientMyRunnable(socket)).start();
            //开始打印
            talk2All(bw);
        }
        else if (message.equals(("2")))
        {
            System.out.println("密码输入错误");
        }
        else if (message.equals("3"))
        {
            System.out.println("用户名不存在");
        }
    }

    //往服务器写出消息
    private static void talk2All(BufferedWriter bw) throws IOException {
        Scanner cin = new Scanner(System.in);
        while (true)
        {
            System.out.println("请输入您要说的话");
            String str = cin.nextLine();

            //把聊天内容写给服务器
            bw.write(str);
            bw.newLine();
            bw.flush();

        }
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

}

class ClientMyRunnable implements Runnable
{
    Socket socket;
    public ClientMyRunnable(Socket socket)
    {
        this.socket = socket;
    }
    @Override
    public void run()
    {
        //循环重复地接收
        while (true)
        {
            try
            {
                //接收服务器发送过来的聊天记录
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String msg = br.readLine();
                System.out.println(msg);
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}


