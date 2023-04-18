package Interface;

public class InterfaceExercise02 {

}
interface AAAA
{
    int  x = 1;

}
class BBBB
{
    int x  = 0;
}
class C extends BBBB implements AAAA
{
    public void px() {
        System.out.println(AAAA.x);
        System.out.println(super.x);
    }
    public static void main(String[] args)
    {
        new C().px();
    }
}
