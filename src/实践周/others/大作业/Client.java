package 实践周.others.大作业;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1",10000);

        Scanner cin = new Scanner(System.in);
        OutputStream os = socket.getOutputStream();

        while (true)
        {
            System.out.println("请输入您要发送的信息");
            String str = cin.nextLine();
            if ("886".equals(str)) break;
            os.write(str.getBytes());
        }
        socket.close();

    }

}
