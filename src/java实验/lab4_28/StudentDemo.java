package java实验.lab4_28;

public class StudentDemo {
    public static void main(String[] args) {
        Undergraduate ug1 = new Undergraduate("张三",61);
        Graduate gr1 = new Graduate("李四",81);
        ug1.ispass();
        gr1.ispass();
    }
}
class Student
{
    String name;
    double avscore;
    public Student(String name, double avscore) {
        this.name = name;
        this.avscore = avscore;
    }
}

class Undergraduate extends Student
{
    public Undergraduate (String name, double avscore)
    {
        super(name,avscore);
    }

    public void ispass()
    {
        if (this.avscore > 60) System.out.println("通过");
        else System.out.println("未通过");
    }

}

class Graduate extends Student
{
    public Graduate (String name,double avscore)
    {
        super(name,avscore);
    }
    public void ispass()
    {
        if (this.avscore > 80) System.out.println("通过");
        else System.out.println("未通过");
    }
}



