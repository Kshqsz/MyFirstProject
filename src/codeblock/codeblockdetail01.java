package codeblock;


public class codeblockdetail01 {
    public static void main(String[] args) {
        //AA aa2 = new AA();
        //System.out.println(Cat.n1);
//        DD dd = new DD();
//        DD dd1 = new DD();
        System.out.println(DD.n1);
    }
}
class DD
{
    public static int n1 = 8888;
    static
    {
        System.out.println("DD 的静态代码块1被执行");
    }
    {
        System.out.println("DD 的普通代码块");
    }

}
class animal
{
    static
    {
        System.out.println("animal 的静态代码块1被执行");
    }
}
class Cat extends animal
{
    public static int n1 = 999;
    static
    {
        System.out.println("Cat 的静态代码块1被执行");
    }

}

class BB
{
    static
    {
        System.out.println("BB 的静态代码块1被执行");
    }
}
class AA extends BB
{
    static
    {
        System.out.println("AA 的静态代码块1被执行");
    }
}

