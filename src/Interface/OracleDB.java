package Interface;

public class OracleDB implements DBInterface {
    public void connect()
    {
        System.out.println("连接Oracle");
    }
    public void close()
    {
        System.out.println("关闭Oralce");
    }
}
