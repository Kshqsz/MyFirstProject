package Interface;

public class InterfacePolyArr {
    public static void main(String[] args) {
        Usb[] usbs = new Usb[2];
        usbs[0] = new Phone_();
        usbs[1] = new Camera_();

        for (int i = 0; i < usbs.length; i++)
        {
            usbs[i].work();//动态绑定
            if (usbs[i] instanceof Phone_)//instanceof 是判断运行类型
            {
                ((Phone_) usbs[i]).call();//向下转型
            }
        }

    }
}

interface Usb{
    void work();
}
class Phone_ implements Usb{
    public void call()
    {
        System.out.println("手机打电话");
    }
    public void work()
    {
        System.out.println("手机工作中");
    }

}
class Camera_ implements Usb{
    public void work()
    {
        System.out.println("相机工作中");
    }
}
