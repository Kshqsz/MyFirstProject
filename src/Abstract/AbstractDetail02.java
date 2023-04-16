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
