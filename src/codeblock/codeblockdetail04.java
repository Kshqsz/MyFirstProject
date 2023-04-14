package codeblock;

public class codeblockdetail04 {
    public static void main(String[] args) {
        //(1) 进行类的加载
        //1.1 先加载 父类 A02  1.2 再加载B02
        //(2) 创建对象
        new B02();
        new C02();
    }
}
class C02
{
    private int n1 = 100;
    private static int n2 = 200;
    private void m1()
    {

    }
    private static void m2()
    {

    }
    static
    {
        //System.out.println(n1);错误
        System.out.println(n2);//ok
        //m1()错误
        m2();
    }
    {
        //普通代码块可以使用任意成员
        System.out.println(n1);
        System.out.println(n2);
        m1();
        m2();
    }

}
class A02
{
    private static int n1 = getVal01();
    static
    {
        System.out.println("A02的第一个静态代码块");//2
    }
    {
        System.out.println("A02的第一个普通代码块");//5
    }
    public int n3 = getVal02();
    public static int getVal01()
    {
        System.out.println("getval01");//1
        return 10;
    }
    public int getVal02()
    {
        System.out.println("getval02");//6
        return 10;
    }
    public A02()
    {
        System.out.println("A02的构造器");//7
    }

}

class B02 extends A02
{
    private static int n3 = getval03();
    static
    {
        System.out.println("B02的一个静态代码块");//4
    }
    public int n5 = getVal04();
    {
        System.out.println("B02的第一个普通代码块");//9
    }
    public static int getval03()
    {
        System.out.println("getval03");//3
        return 10;
    }
    public int getVal04()
    {
        System.out.println("getval04");//8
        return 10;
    }
    public B02()
    {
        System.out.println("B02的构造器");//10
    }
}