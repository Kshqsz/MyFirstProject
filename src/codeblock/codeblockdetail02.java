package codeblock;

public class codeblockdetail02 {
    public static void main(String[] args) {
        A a = new A();
    }
}

class A
{
    private int n2 = getN2();
    {
        System.out.println("A 普通代码块01");
    }
    static
    {
        System.out.println("A 静态代码块01");
    }
    private static int n1 = getN1();

    public static int getN1()
    {
        System.out.println("getN1被调用");
        return 100;
    }
    public int getN2()
    {
        System.out.println("getN2被调用");
        return 100;
    }
    public A()
    {
        System.out.println("A的构造器被调用");
    }



}