package Interface;

import java.util.Scanner;

public class InterfaceDetail02 {
    public static void main(String[] args) {
        System.out.println(IB.n1);//说明n1 就是 static
        //IB.n1 = 30; 说明n1 就是 final
        //Scanner cin = new Scanner(System.in);
    }
}


interface IB {
    //接口中的属性，只能是final的，而且是public static final修饰符
    int n1 = 10;//等价于 public static final int n1 = 10
    void hi();
}
interface IC {
    void say();
}
//接口不能继承其它的类 但是可以继承多个别的接口
interface ID extends IB,IC
{

}
//接口的修饰符 只能 public 和 默认 ，这点和类的修饰符相同
interface IE{}

// 一个类同时可以实现多个接口
class Pig implements IB,IC
{
    public void hi() {

    }

    public void say() {

    }
}