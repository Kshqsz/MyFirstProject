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














