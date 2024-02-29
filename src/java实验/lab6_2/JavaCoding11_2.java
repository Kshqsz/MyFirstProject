package java实验.lab6_2;

public class JavaCoding11_2
{
    public static void main(String[] args) {
        WareHouse wareHouse = new WareHouse();
        wareHouse.init(5);
        ProducerThread producerThread = new ProducerThread(wareHouse);
        ConsumerThread consumerThread = new ConsumerThread(wareHouse);
        Thread ta = new Thread(producerThread);
        Thread tb = new Thread(consumerThread);
        ta.start();
        tb.start();
    }
}
class WareHouse {
    private int amount;
    public void init(int value)
    {
        amount = value;
    }
    public synchronized void produce(int value)
    {
        while (amount != 0)
        {
            try {
                wait();
            }catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        amount = amount + value;
        System.out.println("生产者生成" + value + "件商品后仓库还剩:" + amount + "件商品");
        notify();
    }
    public synchronized void consume(int value)
    {
        while (amount == 0)
        {
            try {
                wait();
            }catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        amount = amount - value;
        System.out.println("消费者消费" + value + "件商品后仓库还剩:" +amount + "件商品" );
        notify();
    }
}

class ProducerThread implements Runnable
{
    private WareHouse wareHouse;
    public ProducerThread(WareHouse wareHouse)
    {
        this.wareHouse = wareHouse;
    }
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            try
            {
                Thread.sleep(1000);
            }catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
            wareHouse.produce(i);
        }
    }
}

class ConsumerThread implements Runnable
{
    private WareHouse wareHouse;
    public ConsumerThread(WareHouse wareHouse)
    {
        this.wareHouse = wareHouse;
    }
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            try
            {
                Thread.sleep(1000);
            }catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
            wareHouse.consume(i);
        }
    }
}



