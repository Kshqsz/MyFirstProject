# 接口的快速入门

```java
package Interface;

public class Interface01 {
    public static void main(String[] args) {
        Camera camera = new Camera();
        Phone phone = new Phone();

        Computer computer = new Computer();
        computer.work(phone);
        System.out.println("===============");


        computer.work(camera);
    }
}



```





```java
package Interface;

public interface UsbInterface {
    public void start();
    public void stop();

}
```



```java
package Interface;

public class Phone implements UsbInterface{
    public void start()
    {
        System.out.println("手机开始工作");
    }

    public void stop()
    {
        System.out.println("手机停止工作");
    }
}
```





```java
package Interface;

public class Camera implements UsbInterface{
    public void start()
    {
        System.out.println("相机开始工作");
    }

    public void stop()
    {
        System.out.println("相机停止工作");
    }
}
```



```java
package Interface;

public class Computer {
    public void work(UsbInterface usbInterface)
    {
        //通过接口来调用方法
        usbInterface.start();
        usbInterface.stop();
    }
}
```



































