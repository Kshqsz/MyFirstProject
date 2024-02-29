package java实验.lab6_2;


import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Container con = frame.getContentPane();
        con.setLayout(new GridLayout(1,2));
        JLabel la1 = new JLabel();
        new Thread(new thread(la1)).start();
        con.add(la1);
        frame.pack();
        frame.setVisible(true);

    }
}

class thread implements Runnable
{
    JLabel lab = new JLabel();
    public thread(JLabel lab)
    {
        this.lab = lab;
    }
    public void run()
    {
       while (true)
       {
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
           lab.setText(sdf.format(new Date()));
           try{
               Thread.sleep(1000);
           } catch (Exception e)
           {
               System.out.println(e.getMessage());
           }
       }
    }

}
