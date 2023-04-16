# 抽象类的引出

```java
package Abstract;

public class Abstract01 {
    public static void main(String[] args) {

    }
}

abstract class Animal
{
    private String name;

    public Animal(String name) {
        this.name = name;
    }
    // 当父类方法具有不确定性的时候 可以将其设计为抽象方法
    //===> 所谓抽象方法就算没有实现的方法
    //===> 所谓没有实现就是指没有方法体
    //===> 当一个类中存在抽象方法时，需要将类声明为abstract类
    //===> 一般来说，抽象类会被继承 由其子类来实现抽象方法
    public abstract void eat() ;//抽象类没有方法体
}
```



# 抽象类细节1

```java
package Abstract;

public class AbstractDetail01 {
    public static void main(String[] args) {
        //抽象类不能被实例化
        //new A();
    }
}


//抽象类不一定包含abstract 方法
//还可以有实现的方法
abstract class A
{
    public void hi()
    {
        System.out.println("hi");
    }
}

//一旦包含abstract方法，则这个类必须声明为抽象类


//abstract 只能修饰类和方法 不能修饰属性和其他的
```





# 抽象类细节2

```java
package Abstract;

import javafx.beans.property.adapter.JavaBeanBooleanProperty;

import java.security.spec.DSAGenParameterSpec;

public class AbstractDetail02 {
    public static void main(String[] args) {
        System.out.println("hello");
    }
}



//如果一个类继承了抽象类 则它必须实现所有抽象类的各种抽象方法 除非他自己也声明为抽象类
abstract class E
{
    public abstract void hi();
}
abstract class F extends E
{

}

class G extends E
{
    public void hi() {
        //所谓实现就是有方法体
    }
}

//抽象方法不能使用private,final 和 static来修饰 因为这些关键词都是和重写相违背
abstract class H
{
    //public static abstract void hi(); // 抽象方法 用static修饰会被报错

}



//抽象类的本质还是类 可以有所有类的各种成员s
abstract class D
{
    public int n1 = 10;
    public static String name = "12321";
    public void hi()
    {
        System.out.println("hi");
    }
    public abstract void hello();
    public static void ok()
    {
        System.out.println("ok");
    }
}
```



