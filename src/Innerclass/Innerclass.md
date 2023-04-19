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







# 匿名内部类

```java
package Innerclass;
/*
    举例匿名内部类的使用
 */
public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method();
    }
}
class Outer04 // 外部类
{
    private int n1 = 10;
    public void method() {
        //基于接口的匿名内部类
        //解读
        //1.需求：想使用接口IA,并创建对象
        //2.传统方式，就是写一个类然后实现该接口，并创建一个对象
        //3.如果需求是上面这个类只使用一次，Tiger/Dog 后面就不使用(如果创建一个新的对象，那就会显得很亏,而且会定义很多类 显得繁琐)
        //4.可以使用匿名内部类来简化开发
        //5.tiger的编译类型? (看等号的左边) IA
        //6.tiger的运行类型? 就是匿名内部类 XXXX =>Outer04$1
        /*
            我们看底层会分配一个类名 Outer04$1
            class XXXX implements IA{
                public void cry()
                {
                   System.out.println("老虎叫唤");
                }
            }
         */
        //7.jdk 底层在创建匿名内部类 Outer04$1,立即马上就创建了 Outer04$1实例，并且把地址返回给tiger
        //8.匿名内部类使用一次就不能再使用了
        IA tiger = new IA()
        {
            public void cry()
            {
                System.out.println("老虎叫唤");
            }
        };
        System.out.println("tiger的运行类型 = " + tiger.getClass());
        tiger.cry();

//        IA tiger = new Tiger();
//        IA dog= new Dog();
//        tiger.cry();
//        dog.cry();
//        }

        // 演示基于类的匿名内部类
        //分析
        //1.father编译类型 Father
        //2.father运行类型 Outer04$2
        //3.底层会创建匿名内部类

        /*
            class Outer04$2 extends Father
            {
                 public void test()
                {
                    System.out.println("匿名内部类重写了test方法");
                }
            }
         */
        //4.同时也直接返回了匿名内部类 Outer04$2对象
        //5.注意("jack")参数列表会传递给构造器
        Father father = new Father("jack")
        {
            public void test()
            {
                System.out.println("匿名内部类重写了test方法");
            }
        };
        System.out.println("father的运行类型 = "  + father.getClass());
        father.test();

        //基于抽象类的匿名内部类
        Animal animal = new Animal()
        {
            void eat()
            {
                System.out.println("小狗狗吃骨头...");
            }
        };
        animal.eat();
    }
    }
interface IA
{
    public void cry();
}

//class Tiger implements IA
//{
//    public void cry()
//    {
//        System.out.println("老虎叫");
//    }
//}
//
//class Dog implements IA
//{
//    public void cry()
//    {
//        System.out.println("狗叫");
//    }
//}
class Father
{
    public Father(String name) //构造器
    {
        System.out.println("接受到了name = " + name);
    }
    public void test() //方法
    {

    }
}

abstract class Animal
{
    abstract void eat();
}
```





# 匿名内部类的使用细节

```java
package Innerclass;

public class AnonymousInnerClassDetail {
    public static void main(String[] args) {
        Outer05 outer05 = new Outer05();
        outer05.f1();
        //外部其他类不能访问匿名内部类

    }
}


class Outer05 {
    private int n1 = 99;

    public void f1() {
        //创建一个基于类的匿名内部类
        //不能添加访问修饰符，因为它的地位就是一个局部变量
        //作用域:仅仅在定义它的方法或代码块中
        Person p = new Person() {
            private int n1 = 88;
            public void hi()
            {
                //可以直接访问外部类所有成员，包含私有的
                //如果外部类和匿名内部类的成员重名时，匿名内部类访问的话默认遵循就近原则
                //如果想访问外部类的成员，使用(外部类名.this.成员)
                System.out.println("匿名内部类重写了hi()方法 n1 = " + n1 + "外部类的n1 = " + Outer05.this.n1);
                //Outer05.this 就是调用 f1的对象
            }
        };
        p.hi();//动态绑定，运行类型是 Outer05$1
        //也可以直接调用,匿名内部类本身也是对象
        // class 匿名内部类 extends Person{}
//        new Person() {
//            public void hi()
//            {
//                System.out.println("匿名内部类重写了hi()方法 哈哈哈哈哈哈哈哈哈哈哈哈哈哈");
//            }
//            public void ok(String str)
//            {
//                super.ok(str);
//            }
//        }.ok("Jack");
    }
}

class Person {
    public void hi() {
        System.out.println("Person hi()");
    }
    public void ok(String str)
    {
        System.out.println("Person ok() " + str );
    }

}


//抽象类/接口...
```



# 匿名内部类的实践

```java
package Innerclass;

public class InnerClassExercise02 {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        //1.传递的是实现了 Bell接口的匿名内部类 InnerClassExercise02$1
        //2.重写了 ring
        //3.Bell bell = new Bell(){
//        @Override
//        public void ring() {
//            System.out.println("懒猪起床了");
//        }
//    }
        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });
        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴们上课了");
            }
        });
    }

}

interface Bell //接口
{
    void ring();//方法
}

class CellPhone //类
{
    public void alarmClock(Bell bell) // 形参是Bell接口类型
    {
        bell.ring();
    }
}
```



