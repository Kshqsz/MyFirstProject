package java实验.lab5_26;

import java.util.Scanner;
import java.util.Vector;

public class JavaExample11_1b {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int l, r;
        l = cin.nextInt();
        r = cin.nextInt();
        ClassInterface t = new ClassInterface(l,r);
        Thread isprime = new Thread(t);
        isprime.start();
        System.out.println("主线程正在执行");
    }
}

class ClassInterface implements Runnable
{
    int l, r;
    public ClassInterface(int l, int r)
    {
        this.l = l;
        this.r = r;
    }
    public void run()
    {
        Vector v = new Vector();
        for (int i = l; i <= r; i++)
        {
            boolean flag = true;
            for (int j = 2; j * j <= i; j++)
            {
                if (i % j == 0)
                {
                    flag = false;
                    break;
                }
            }
            if (flag) v.add(i);
        }
        System.out.println("子线程正在执行");
        System.out.print(l + "到" + r + "的所有质数为: ");
        System.out.println(v);
    }


}


