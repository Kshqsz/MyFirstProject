# 代码块

## 代码块细节1

### 静态代码块在类被加载的时候被执行(只会被执行一次)

+ 类被加载的情况举例

1. 创建对象的实例的时候(new)
2. 创建子类对象实例，父类也会被加载(父类先被加载 子类后被加载)
3. 使用类的静态成员时(静态方法，静态属性)

### 普通代码块

+ 在创建对象实例时，会被调用，被创建一次就被调用一次(与类加载无关)。
+ 如果只是使用类的静态成员，普通代码块并不会被调用。



小结：

1. static 代码块是类加载时执行，并且只会执行一次
2. 普通代码块是在创建对象时调用的，创建一次，调用一次

```java
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


```



## 代码块细节2

在一个类中调用时

1. 先调用静态代码块和静态属性的初始化
2. 再调用普通代码块和普通属性的初始化
3. 调用构造方法

```java
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
```



## 代码块细节3

```java
package codeblock;

public class codeblockdetail03 {
    public static void main(String[] args) {
        new BBB();
    }
}
class AAA
{
    {
        System.out.println("AAA的普通代码块");
    }
    public AAA()
    {
        //(1)super()
        //(2)调用本类的普通代码块
        System.out.println("AAA()构造器被调用");
    }
}

class BBB extends AAA
{
    {
        System.out.println("BBB 的普通代码块");
    }
    public BBB()
    {
        //(1)super()
        //(2)调用本类的普通代码块
        System.out.println("BBB() 构造器被调用");
    }
}
```

![image-20230414212106371](C:\Users\24564\AppData\Roaming\Typora\typora-user-images\image-20230414212106371.png)





## 代码块使用细节4

在继承关系中他们的静态代码块，静态属性初始化，普通代码块，普通属性初始化，构造方法的调用顺序如下:

1. 父类的静态代码块和静态属性初始化
2. 子类的静态代码块和静态属性初始化
3. 父类的普通代码块和普通属性初始化
4. 父类构造方法
5. 子类的普通代码块和普通属性初始化
6. 子类的构造方法



静态方法只能调用静态成员，普通代码块可以调用任意成员

```java
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
```