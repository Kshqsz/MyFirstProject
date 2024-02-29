package 数据结构.第九章;

import java.util.Scanner;

public class GuessPirce {
    static int dis = 28;
    public static void main(String[] args) {
        int l = 0, r = 100;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入你猜想的数字:");
            int x = sc.nextInt();
            if (x == dis) {
                System.out.println("恭喜你猜对了");
                break;
            } else if (x > dis) {
                System.out.println("猜大了");
            } else  {
                System.out.println("猜小了");
            }
        }
    }
}
