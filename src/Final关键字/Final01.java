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


























