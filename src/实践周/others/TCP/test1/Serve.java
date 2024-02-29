package 实践周.others.TCP.test1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Serve {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10000);
        Socket socket = ss.accept();

        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        int b;
        while ((b = br.read()) != -1)
        {
            System.out.print((char) b);
        }
        socket.close();
        ss.close();
    }
}
