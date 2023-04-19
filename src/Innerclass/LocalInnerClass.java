package Innerclass;

/*
  演示局部内部类的使用
 */
public class LocalInnerClass {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.m1();

    }
}


class Outer02
{
    private int n1 = 100;
    private void m2() {
        System.out.println("Outer02 m2()");
    };
    public void m1()
    {
        //1.局部内部类是定义在外部类的局部位置，通常在方法
        //3.不能添加访问修饰符，但是可以使用final修饰(添加 final 以后就不能被其他类继承了)
        //4.作用域:仅仅在定义它的方法或代码块中
        final class Inner02
        {//局部内部类
            //2.可以直接访问外部类的所有成员，包含私有的
            public void f1() {
                //局部内部类可以直接访问外部类的成员，比如下面 外部类的n1 和 m2()方法
                System.out.println("n1=" + n1);
                m2();
            }
        //class Inner03 extends Inner02 //如果Inner02用final修饰了则不能继承，如果没有则可以继承

        }
        //6.外部类在方法中可以创建Inner02对象，然后调用方法即可
        Inner02 inner02 = new Inner02();
        inner02.f1();
    }

}


