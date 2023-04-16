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