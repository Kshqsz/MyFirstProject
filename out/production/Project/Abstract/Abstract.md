# 抽象类的引出

```java
package Abstract;

public class Abstract01 {
    public static void main(String[] args) {

    }
}

abstract class Animal
{
    private String name;

    public Animal(String name) {
        this.name = name;
    }
    // 当父类方法具有不确定性的时候 可以将其设计为抽象方法
    //===> 所谓抽象方法就算没有实现的方法
    //===> 所谓没有实现就是指没有方法体
    //===> 当一个类中存在抽象方法时，需要将类声明为abstract类
    //===> 一般来说，抽象类会被继承 由其子类来实现抽象方法
    public abstract void eat() ;//抽象类没有方法体
}
```



# 抽象类细节1

