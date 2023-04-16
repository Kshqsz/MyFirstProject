# final基本使用

```java
package Final关键字;

public class Final01 {
    public static void main(String[] args) {
        E e = new E();
        //e.RAT = 0.09;

    }
}

//如果我们要求A类不能被其他类继承
//可以使用final修饰 A类

final class A {}


class C
{
    //如果我们要求hi不能被子类重写
    //可以使用final来修饰 hi方法
    public final void hi() {}
}
class D extends C
{
    //重写
//    public void hi()
//    {
//        System.out.println("重写了C类的hi方法");
//    }

}
//class B extends A {}


//当不希望类的某个属性的值被修改，可以使用final修饰
class E
 {
    public final double RAT = 0.08;
}

//当不希望某个局部变量被修改时，可以使用final修饰
class F
{
    public void cry()
    {
        //这时，num为局部变量
        final double num = 0.01;
        //num = 0.9;
        System.out.println("num = " + num);
    }
}
```



# final使用细节1

```java
package Final关键字;

import javax.swing.plaf.synth.SynthTextAreaUI;

public class FinalDetail01 {
    public static void main(String[] args) {
        CC cc = new CC();
        new EE().cal();
    }
}

class AA
{
    /*
    1.定义时，如public final double TAX = 0.08;
    2.在构造器中
    3.在代码块中
     */
    public final double TAX = 0.08;
    public final double TAX1;
    public final double TAX2;
    public AA()//构造器中赋值
    {
        TAX1 = 1.1;
    }
    {//代码块中赋值
        TAX2 = 2.2;
    }
}


class BB
{
    /*
    如果final修饰的属性是静态的 则初始化位置只能是
    1.定义时 2在静态代码块 不能在构造器与普通代码块中赋值
     */
    public static final double TAX_ = 99.9;
    public static final double TAX_1;
    //public static final double TAX_2;
    static
    {
        TAX_1 = 1;
    }


}



//final 类不能继承 但是可以实例化

final class CC {}







//类中有final方法可以被继承使用 但不能重写
class DD
{
    public final void cal()
    {
        System.out.println("cal()方法");
    }
}


class EE extends DD
{

}
```





# final使用细节2

```java
package Final关键字;

public class FinalDetail02 {
    public static void main(String[] args) {
        System.out.println(BBB.num);


        //包装类 ,string 是final 类不能被继承
    }
}



//final 不能修饰构造器



//final 和 static 往往搭配使用，效率更高，不会导致类加载，底层编译器做了优化处理(即代码块不会被执行)

class BBB
{
    public final static int num = 100;
    static
    {
        System.out.println("BBB 静态代码块被执行");
    }
}
```

