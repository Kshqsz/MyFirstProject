package 实践周.others;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class Server {
    static ArrayList<Socket> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10000);

        //1.把本地文件中正确的用户名和密码获取到
        Properties prop = new Properties();
        FileInputStream fis= new FileInputStream("src\\实践周\\控制台聊天室\\users.txt");
        prop.load(fis);
        fis.close();

        while (true)
        {
            Socket socket = ss.accept();
            System.out.println("有客户端来连接");
            new Thread(new MyRunnable(socket, prop)).start();
        }
    }
}
class MyRunnable implements Runnable
{
    Socket socket;
    Properties prop;
    public MyRunnable(Socket socket, Properties prop) {
        this.socket = socket;
        this.prop = prop;
    }

    @Override
    public void run()
    {
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true)
            {
                String choose = br.readLine();
                if (choose.equals("login"))
                {
                    login(br);
                }
                else if (choose.equals("register"))
                {
                    System.out.println("用户选择了注册操作");
                }
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //获取用户登录时 传递过来的信息
    //并进行判断
    public void login(BufferedReader br) throws Exception {
        System.out.println("用户选择了登录操作");
        String userinfo = br.readLine();

        String[] userInfoArr = userinfo.split("&");
        String usernameInput = userInfoArr[0].split("=")[1];
        String passwordInput = userInfoArr[1].split("=")[1];
        System.out.println("用户输入的用户名为:" + usernameInput);
        System.out.println("用户输入的密码为:" + passwordInput);
        if (prop.containsKey(usernameInput))
        {
            //如果用户名存在, 继续访问判断密码
            String rightPassword = prop.get(usernameInput) + "";
            if (rightPassword.equals(passwordInput))
            {
                //提示用户登录成功,可以开始聊天
                writeMessage2Client("1");
                //登录成功的时候，就需要把客户端的连接对象socket保存起来
                //接受客户端发送过来的信息，并打印在控制台
                Server.list.add(socket);
                if (usernameInput.equals("7101")) usernameInput = "宋晓梅";
                if (usernameInput.equals("7102")) usernameInput = "关松杰";
                if (usernameInput.equals("7103")) usernameInput = "李晓梅";
                if (usernameInput.equals("7104")) usernameInput = "张松岩";
                if (usernameInput.equals("7105")) usernameInput = "王亚杰";
                if (usernameInput.equals("7106")) usernameInput = "曲小声";
                talk2All(br, usernameInput);
            }
            else
            {
                writeMessage2Client("2");
            }
        }
        else
        {
            writeMessage2Client("3");
        }
    }
    public void talk2All(BufferedReader br, String username) throws Exception {
        while (true)
        {
            String message = br.readLine();
            System.out.println(username + "发送消息:" + message);
            for (Socket s : Server.list)
            {
                writeMessage2Client(s,username + "发送消息:" + message);
            }
        }
    }
    public void writeMessage2Client(String message) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        insert(message);
        bw.write(message);
        bw.newLine();
        bw.flush();
    }
    public void writeMessage2Client(Socket s, String message) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        insert(message);
        bw.write(message);
        bw.newLine();
        bw.flush();
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

}

