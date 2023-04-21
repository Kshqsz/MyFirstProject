package java实验.lab4_21;

public class bankcard {
    public static void main(String[] args) {

    }
}

class Bankcard
{
    int balance = 0;
    String password;
    String ID;

    public Bankcard() { };

    public int getBalance() {
        return balance;
    }
    public void add(int money)
    {
        balance += money;
    }
    public void sub(int money)
    {
        balance -=money;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Bankcard{" +
                "balance=" + balance +
                ", password='" + password + '\'' +
                ", ID='" + ID + '\'' +
                '}';
    }
    public void setID(String id)
    {
        this.ID = id;
    }


}