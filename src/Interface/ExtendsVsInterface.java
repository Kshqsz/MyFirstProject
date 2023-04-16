package Interface;

import java.util.Scanner;

public class ExtendsVsInterface {
    public static void main(String[] args) {
        LittleMonkey wuKong = new LittleMonkey("悟空");
        wuKong.climbing();
        wuKong.swimming();
        wuKong.flying();
    }
}

//接口
interface Fishable
{
    void swimming();
}

interface birdable
{
    void flying();
}

//继承
//小结 : 当子类继承了父类 就自带拥有父类的功能
//       如果子类需要拓展功能，可以通过实现接口的方法拓展.
//       可以理解为实现接口是对java单继承机制的一种补充
class Monkey
{
    private String name;
    public Monkey(String name)
    {
        this.name = name;
    }
    public void climbing()
    {
        System.out.println( name + "会爬树");
    }
    public String getName()
    {
        return name;
    }


}

class LittleMonkey extends Monkey implements Fishable,birdable
{
    public LittleMonkey(String name)
    {
        super(name);
    }
    public void swimming()
    {
        System.out.println(getName() + "通过学习可以像鱼儿一样游泳");
    }
    public void flying()
    {
        System.out.println(getName() + "通过学习可以像鸟儿一样飞翔");
    }

}
