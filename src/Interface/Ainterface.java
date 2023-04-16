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
