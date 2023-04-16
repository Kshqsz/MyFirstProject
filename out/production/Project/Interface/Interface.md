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













# 接口基本介绍

```java
package Interface;

public interface Ainterface {
    public int n1 = 10;

    //在接口中，抽象方法，可以省略abstract关键字
    public void hi();

    default public void ok() {
        System.out.println("ok...");
    }

    public static void cry()
    {
        System.out.println("cry");
    }
}

```

```java
package Interface;

public class Interface02 {
    public static void main(String[] args) {

    }
}
//1.如果一个类implements 实现接口
//2.需要实现该接口的所有抽象方法
class A implements Ainterface
{
    public void hi()
    {
        System.out.println("hi()......");
    }

}
```



# 接口应用场景

```java
package Interface;

public class Interface03 {
    public static void main(String[] args) {
        MysqlDB mysqlDB = new MysqlDB();
        t(mysqlDB);
        OracleDB oracleDB = new OracleDB();
        t(oracleDB);
    }
    public static void t(DBInterface db)
    {
        db.connect();
        db.close();
    }
}

```



```java
package Interface;

public interface DBInterface {

    public void connect();
    public void close();

}

```



```java
package Interface;

public class MysqlDB implements DBInterface{
    public void connect()
    {
        System.out.println("连接mysql");
    }
    public void close()
    {
        System.out.println("关闭mysql");
    }
}

```





```java
package Interface;

public class OracleDB implements DBInterface {
    public void connect()
    {
        System.out.println("连接Oracle");
    }
    public void close()
    {
        System.out.println("关闭Oralce");
    }
}

```



















