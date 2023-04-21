package Innerclass;

public class MemberInnerclass01
{
    public static void main(String[] args) {
        Outer08 outer08 = new Outer08();
        outer08.t1();

        //外部其他类 使用成员内部类的三种方式
        //new Inner08()
        //outer08.new Inner08(),相当于把 new Inner08()当作是outer08的成员
        //这就是一个语法，不要特别的纠结
        //第一种方式
        Outer08.Inner08 inner08 = outer08.new Inner08();


    }
}

class Outer08 //外部类
{
    private int n1 = 10;
    public String name = "张三";
    public void  hi()
    {
        System.out.println("hi");
    }
    //1.注意：成员内部类是定义在外部类内的成员位置上
    //2.可以添加任意访问修饰符(public protected 默认 private) 因为它的地位就是一个成员
    class Inner08 // 成员内部类
    {
        private double sal = 99.8;
        public void say()
        {
            //可以直接访问外部类的所有成员，包含私有的
            System.out.println("n1 = " + n1 + " name = " + name );
            hi();
        }
    }

    //写方法
    public void t1()
    {
        //使用成员内部类
        //创建成员内部类的对象，然后使用相关的方法
        Inner08 inner08 = new Inner08();
        inner08.say();
        System.out.println(inner08.sal);
    }
}
