package Innerclass;

//一个类的内部完整的嵌套了另一个类结构。被嵌套的类称为内部类，嵌套其他类的类称为外部类。
//[类的五大成员]:属性，方法，构造器，代码块，内部类
//内部类最大的特点就是可以直接访问私有属性，并且可以体现类与类之间的包含关系

public class Innerclass01 {
    public static void main(String [] args)
    {

    }
}

class Outer
{
    private int n1 = 100;

    public Outer(int n1)
    {
        this.n1 = n1;
    }
    public void m1()
    {
        System.out.println("m1()");
    }
    {
        System.out.println("代码块...");
    }
    class Inner
    {

    }

}

