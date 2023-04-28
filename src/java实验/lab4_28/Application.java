package java实验.lab4_28;

public class Application {
    public static void main(String[] args) {
        Manger manger = new Manger("张三",8000);
        Salesman salesman = new Salesman("李四",6000,1000);
        Worker worker = new Worker("赵五",30,200);
        manger.ComputeSalary();
        salesman.ComputeSalary();
        worker.ComputeSalary();
    }
}


abstract class Employee
{
    String name;
    abstract public void ComputeSalary();
    public Employee(String name)
    {
        this.name = name;
    }
}

class Manger extends Employee
{
    int sal;
    public Manger (String name,int sal)
    {
        super(name);
        this.sal = sal;
    }
    public void ComputeSalary()
    {
        System.out.println("经理的工资为: " + sal);
    }
}

class Salesman extends Employee
{
    int commission;
    int sal;
    public Salesman (String name,int sal,int commission)
    {
        super(name);
        this.sal = sal;
        this.commission = commission;
    }
    public void ComputeSalary()
    {
        System.out.println("销售人员的工资为: " + (sal + commission) );
    }
}

class Worker extends Employee
{
    int days;
    int daysal;
    public Worker (String name,int days,int daysal)
    {
        super(name);
        this.days = days;
        this.daysal = daysal;
    }
    public void ComputeSalary()
    {
        System.out.println("工人的工资为：" + (days * daysal));
    }
}

