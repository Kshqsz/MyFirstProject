# 接口的快速入门

```java
package Interface;

public class Interface01 {
    public static void main(String[] args) {
        Camera camera = new Camera();
        Phone phone = new Phone();

        Computer computer = new Computer();
        computer.work(phone);
        System.out.println("===============");


        computer.work(camera);
    }
}



```





```java
package Interface;

public interface UsbInterface {
    public void start();
    public void stop();

}
```



```java
package Interface;

public class Phone implements UsbInterface{
    public void start()
    {
        System.out.println("手机开始工作");
    }

    public void stop()
    {
        System.out.println("手机停止工作");
    }
}
```





```java
package Interface;

public class Camera implements UsbInterface{
    public void start()
    {
        System.out.println("相机开始工作");
    }

    public void stop()
    {
        System.out.println("相机停止工作");
    }
}
```



```java
package Interface;

public class Computer {
    public void work(UsbInterface usbInterface)
    {
        //通过接口来调用方法
        usbInterface.start();
        usbInterface.stop();
    }
}
```













# 接口基本介绍

```java
package Interface;

public interface Ainterface {
    public int n1 = 10;

    //在接口中，抽象方法，可以省略abstract关键字
    public void hi();

    default public void ok() {
        System.out.println("ok...");
    }

    public static void cry()
    {
        System.out.println("cry");
    }
}

```

```java
package Interface;

public class Interface02 {
    public static void main(String[] args) {

    }
}
//1.如果一个类implements 实现接口
//2.需要实现该接口的所有抽象方法
class A implements Ainterface
{
    public void hi()
    {
        System.out.println("hi()......");
    }

}
```



# 接口应用场景

```java
package Interface;

public class Interface03 {
    public static void main(String[] args) {
        MysqlDB mysqlDB = new MysqlDB();
        t(mysqlDB);
        OracleDB oracleDB = new OracleDB();
        t(oracleDB);
    }
    public static void t(DBInterface db)
    {
        db.connect();
        db.close();
    }
}

```



```java
package Interface;

public interface DBInterface {

    public void connect();
    public void close();

}

```



```java
package Interface;

public class MysqlDB implements DBInterface{
    public void connect()
    {
        System.out.println("连接mysql");
    }
    public void close()
    {
        System.out.println("关闭mysql");
    }
}

```





```java
package Interface;

public class OracleDB implements DBInterface {
    public void connect()
    {
        System.out.println("连接Oracle");
    }
    public void close()
    {
        System.out.println("关闭Oralce");
    }
}

```







# 接口使用细节1

```java
package Interface;

public class InterfaceDetail01 {
    public static void main(String[] args) {

    }
}

/*
    1.接口不能被实例化
    2.接口中的所有方法都是public 方法，接口中抽象方法可以不用abstract 修饰
    3.一个普通类实现接口,就必须将该接口的所有方法都实现 可以是使用alt + 回车 实现
    4.抽象类实现接口时，可以不实现接口的抽象方法
 */

interface IA{
    void say();
    void hi();

}
class Cat implements IA
{
    public void say()
    {
    }
    public void hi()
    {
    }

}
abstract class Tiger implements IA
{

}

```





# 接口使用细节2

```java
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
```



# 接口 VS 继承

```java
 package Interface;

import java.util.Scanner;

public class ExtendsVsInterface {
    public static void main(String[] args) {
        LittleMonkey wuKong = new LittleMonkey("悟空");
        wuKong.climbing();
        wuKong.swimming();
        wuKong.flying();
    }
}

//接口
interface Fishable
{
    void swimming();
}

interface birdable
{
    void flying();
}

//继承
//小结 : 当子类继承了父类 就自带拥有父类的功能
//       如果子类需要拓展功能，可以通过实现接口的方法拓展.
//       可以理解为实现接口是对java单继承机制的一种补充
class Monkey
{
    private String name;
    public Monkey(String name)
    {
        this.name = name;
    }
    public void climbing()
    {
        System.out.println( name + "会爬树");
    }
    public String getName()
    {
        return name;
    }
}

class LittleMonkey extends Monkey implements Fishable,birdable
{
    public LittleMonkey(String name)
    {
        super(name);
    }
    public void swimming()
    {
        System.out.println(getName() + "通过学习可以像鱼儿一样游泳");
    }
    public void flying()
    {
        System.out.println(getName() + "通过学习可以像鸟儿一样飞翔");
    }

}
```





# 接口的多态特性

```java
package Interface;

public class InterfacePolyParameter {
    public static void main(String[] args) {

        //接口的多态体现
        //接口类型的变量if01 可以指向 实现了IF接口类的对象实例
        IF if01 = new Monster();
        if01 = new Car();

        //继承体现的多态
        //父类的类型变量 a 可以指向 继承了AAA的子类的对象实例
        AAA a = new BBB();

        a = new CCC();
    }
}


interface IF {}
class Monster implements IF {}
class Car implements IF {}


class AAA
{

}
class BBB extends AAA {}
class CCC extends AAA {}

```



```java
//接口数组
package Interface;

public class InterfacePolyArr {
    public static void main(String[] args) {
        Usb[] usbs = new Usb[2];
        usbs[0] = new Phone_();
        usbs[1] = new Camera_();

        for (int i = 0; i < usbs.length; i++)
        {
            usbs[i].work();//动态绑定
            if (usbs[i] instanceof Phone_)//instanceof 是判断运行类型
            {
                ((Phone_) usbs[i]).call();//向下转型
            }
        }

    }
}

interface Usb{
    void work();
}
class Phone_ implements Usb{
    public void call()
    {
        System.out.println("手机打电话");
    }
    public void work()
    {
        System.out.println("手机工作中");
    }

}
class Camera_ implements Usb{
    public void work()
    {
        System.out.println("相机工作中");
    }
}

```





# 接口的多态传递

```java
package Interface;

/*
   演示多态传递现象
 */
public class InterfacePloyPass {
    public static void main(String[] args) {
        //接口类型的变量可以指向，实现了该接口的类的对象实例
        IG ig = new Teacher();
        //如果IG 继承了 IH 接口，而Teacher 类实现了 IG接口
        //那么，实际上就相当于 Teacher 类也是实现了 IH接口

        IH ih = new Teacher();


    }
}

interface IH
{
    void hi();
}


interface IG extends IH { }
class Teacher implements IG
{
    public void hi()
    {

    }

```
