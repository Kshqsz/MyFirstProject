package java实验.lab6_9;
import java.io.*;
import java.net.*;
public class TCPSingleUserServer {
    // 设置服务器的端口号，它应该大于 1024
    public static final int PORT = 8080;
    public static void main(String[] args) throws IOException
    {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Started: " + server);
        try
        {
            // 等待接受用户连接
            Socket socket = server.accept();
            try
            {
                System.out.println("Connection accepted: "+ socket);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter
                        (socket.getOutputStream())),true);
                while (true)
                {
                    String str = in.readLine();
                    if (str.equals("END")) break;
                    System.out.println("Echoing: " + str);
                    out.println(str);
                }
            }
            finally
            {
                System.out.println("closing...");
                socket.close();
            }
        }
        finally
        {
            server.close();
        }
    }
}
