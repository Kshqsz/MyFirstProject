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
}