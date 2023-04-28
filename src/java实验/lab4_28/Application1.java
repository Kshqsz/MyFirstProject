package java实验.lab4_28;

public class Application1 {
    public static void main(String[] args) {
        ICBBankCard icbBankCard = new ICBBankCard(1000,"123456");
        BCMBankCard bcmBankCard = new BCMBankCard(1000,"654321");
        ABCBankCard abcBankCard = new ABCBankCard(1000,"666666");
        icbBankCard.add(100);
        bcmBankCard.checkpassage();
        abcBankCard.draw(559.02);
        abcBankCard.checkbalance();
        icbBankCard.transfer(200,bcmBankCard);
    }
}

class BankCard
{
    String name;
    double balance;
    String passage;
    public BankCard (double  balance,String passage)
    {
        this.balance = balance;
        this.passage = passage;
    }
    public void checkbalance(){}
    public void add(double money){}
    public void draw(double money){}
    public void checkpassage(){}
    public void transfer(double money,BankCard object){};

}
class ICBBankCard extends BankCard
{
    public ICBBankCard(double balance,String passage)
    {
        super(balance,passage);
        System.out.println("成功创建工商银行卡");
        this.name = "工商银行卡";
    }
    public void checkbalance()
    {
        System.out.println("工商银行卡余额为: " + this.balance);
    }
    public void add(double money)
    {
        balance += money;
        System.out.println("工商银行卡存款 :" + money + "元") ;
    }
    public void draw(double money)
    {
        balance -= money;
        System.out.println("工商银行卡取 :" + money + "元") ;
    }
    public void checkpassage()
    {
        System.out.println("工商银行卡密码为: " + this.passage);
    }
    public void transfer(double money,BankCard object)
    {
        object.balance +=money;
        this.balance -= money;
        System.out.println(this.name + "向" + object.name +"转账" + money);
    }
}
class ABCBankCard extends BankCard
{
    public ABCBankCard(double balance,String passage)
    {
        super(balance,passage);
        System.out.println("成功创建农业银行卡");
        this.name = "农业银行卡";
    }
    public void add(double money)
    {
        balance += money;
        System.out.println("农业银行卡存款 :" + money + "元") ;
    }
    public void draw(double money)
    {
        balance -= money;
        System.out.println("农业银行卡取 :" + money + "元") ;
    }
    public void checkbalance()
    {
        System.out.println("农业银行卡余额为: " + this.balance);
    }
    public void checkpassage()
    {
        System.out.println("农业银行卡密码为: " + this.passage);
    }
    public void transfer(double money,BankCard object)
    {
        object.balance += money;
        this.balance -= money;
        System.out.println(this.name + "向" + object.name +"转账" + money);
    }
}

class BCMBankCard extends BankCard
{
    public BCMBankCard(double balance,String passage)
    {
        super(balance,passage);
        System.out.println("成功创建交通银行卡");
        this.name = "交通银行卡";
    }
    public void add(double money)
    {
        balance += money;
        System.out.println("交通银行卡存款 :" + money + "元") ;
    }
    public void draw(double money)
    {
        balance -= money;
        System.out.println("交通银行卡取 :" + money + "元") ;
    }
    public void checkbalance()
    {
        System.out.println("交通银行卡余额为: " + this.balance);
    }
    public void checkpassage()
    {
        System.out.println("交通银行卡密码为: " + this.passage);
    }
    public void transfer(double money,BankCard object)
    {
        object.balance +=money;
        this.balance -= money;
        System.out.println(this.name + "向" + object.name +"转账" + money);
    }
}