package Innerclass;

public class AnonymousInnerClassDetail {
    public static void main(String[] args) {
        Outer05 outer05 = new Outer05();
        outer05.f1();
        //外部其他类不能访问匿名内部类

    }
}


class Outer05 {
    private int n1 = 99;

    public void f1() {
        //创建一个基于类的匿名内部类
        //不能添加访问修饰符，因为它的地位就是一个局部变量
        //作用域:仅仅在定义它的方法或代码块中
        Person p = new Person() {
            private int n1 = 88;
            public void hi()
            {
                //可以直接访问外部类所有成员，包含私有的
                //如果外部类和匿名内部类的成员重名时，匿名内部类访问的话默认遵循就近原则
                //如果想访问外部类的成员，使用(外部类名.this.成员)
                System.out.println("匿名内部类重写了hi()方法 n1 = " + n1 + "外部类的n1 = " + Outer05.this.n1);
                //Outer05.this 就是调用 f1的对象
            }
        };
        p.hi();//动态绑定，运行类型是 Outer05$1
        //也可以直接调用,匿名内部类本身也是对象
        // class 匿名内部类 extends Person{}
//        new Person() {
//            public void hi()
//            {
//                System.out.println("匿名内部类重写了hi()方法 哈哈哈哈哈哈哈哈哈哈哈哈哈哈");
//            }
//            public void ok(String str)
//            {
//                super.ok(str);
//            }
//        }.ok("Jack");
    }
}

class Person {
    public void hi() {
        System.out.println("Person hi()");
    }
    public void ok(String str)
    {
        System.out.println("Person ok() " + str );
    }

}


//抽象类/接口...



