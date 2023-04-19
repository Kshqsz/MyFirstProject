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