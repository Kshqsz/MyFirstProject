package 学习.异常学习;

import java.util.Scanner;

public class test_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        grilfriend gf = new grilfriend();

        while (true) {
            try {
                String name = sc.next();
                gf.getName();
                gf.setName(name);
                int age = sc.nextInt();
                gf.getAge();

                gf.setAge(age);
                break;
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        System.out.print(gf);
    }
}
