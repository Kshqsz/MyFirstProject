package Interface;

public class MysqlDB implements DBInterface{
    public void connect()
    {
        System.out.println("连接mysql");
    }
    public void close()
    {
        System.out.println("关闭mysql");
    }
}
