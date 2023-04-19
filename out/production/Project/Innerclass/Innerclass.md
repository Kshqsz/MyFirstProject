# 内部类的引出

```java
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
```





# 局部内部类

```java
package Innerclass;

/*
  演示局部内部类的使用
 */
public class LocalInnerClass {
    public static void main(String[] args) {
        //6.外部其他类不能访问局部内部类(因为 局部内部类的地位是一个局部变量)
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
            private int n1 = 800;
            public void f1() {
                //5.局部内部类可以直接访问外部类的成员，比如下面 外部类的n1 和 m2()方法
                //7.如果外部类和局部内部类的成员重名时，默认遵循就近原则
                // 如果想访问外部类的成员，使用(外部类名.this.成员)
                // Outer02.this 本质就是外部类的对象,即哪个对象调用了m1，Outer02.this就是哪个对象
                System.out.println("n1=" + n1 + "外部类的n1 = " + Outer02.this.n1 );
                m2();
            }
        //class Inner03 extends Inner02 //如果Inner02用final修饰了则不能继承，如果没有则可以继承
        }
        //6.外部类在方法中可以创建Inner02对象，然后调用方法即可
        Inner02 inner02 = new Inner02();
        inner02.f1();
    }

}
```



