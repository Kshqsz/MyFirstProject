package study;

public class Main {
    public static void main(String[] args) {

        a zi = new b();
        zi.love();
    }
}

class a
{
    public void love()
    {
        System.out.print("love");
    }
}

class b extends a
{
    @Override
    public void love()
    {
        System.out.print("love she");
    }
}

