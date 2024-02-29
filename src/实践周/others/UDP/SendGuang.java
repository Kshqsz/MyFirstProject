package 实践周.UDP;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class SendGuang {
    public static void main(String[] args) throws IOException {

        DatagramSocket ds = new DatagramSocket();
        Scanner cin = new Scanner(System.in);
        while (true)
        {
            System.out.println("请输入要说的话");
            String str = cin.nextLine();
            if (str.equals("886")) break;

            byte[] bytes = str.getBytes();
            InetAddress address = InetAddress.getByName("255.255.255");
            int port = 10086;
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port);
            ds.send(dp);
        }
        ds.close();
    }
}
