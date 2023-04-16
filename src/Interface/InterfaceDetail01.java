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