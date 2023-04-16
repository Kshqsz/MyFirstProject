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
