package java实验.lab6_9;
import java.net.*;
import  java.io.*;
public class TCPSingleUserClient {
    public static void main(String[] args) throws IOException
    {
        // 在 getByName()中，使用 null 作为参数
        // 来指定本地服务器的地址
        InetAddress addr = InetAddress.getByName(null);
        // 同样的，也可以使用如下的代码来实现同样的功能
        // InetAddress addr = InetAddress.getByName("127.0.0.1");
        // InetAddress addr = InetAddress.getByName("localhost");
        System.out.println("addr = " + addr);
        Socket socket = new Socket(addr, TCPSingleUserServer.PORT);
        try{
            System.out.println("socket = " + socket);
            BufferedReader in =new BufferedReader(new InputStreamReader
                    (socket.getInputStream())
            );
            PrintWriter out =new PrintWriter(new BufferedWriter(new
                    OutputStreamWriter
                    (socket.getOutputStream())),true);
            for(int i = 0; i < 10; i ++)
            {
                out.println("Sending Line " + i + " ....");
                String str = in.readLine();
                System.out.println(str);
            }
            out.println("END");
        }
        finally
        {
            System.out.println("closing...");
            socket.close();
        }
    }
}
