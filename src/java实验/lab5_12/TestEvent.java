package java实验.lab5_12;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class TestEvent extends JFrame {
    JButton button1;
    JLabel label1;
    JLabel label2;
    TextField field1;
    TextField field2;
    JCheckBox checkBox1;
    JCheckBox checkBox2;
    public TestEvent()
    {
        setSize(300,400);
        button1 = new JButton("登录");
        label1 = new JLabel("账号");
        label2 = new JLabel("密码");
        field1 = new TextField("",24);
        field2 = new TextField("",24);
        Container container = getContentPane();
        checkBox1 = new JCheckBox("记住密码");
        checkBox2 = new JCheckBox("自动登录");
        add(button1);
        add(label1);
        add(field1);
        add(label2);
        add(field2);
        container.add(checkBox1);
        container.add(checkBox2);
    }
    public static void main(String[] args) {
        TestEvent frame = new TestEvent();
        frame.setTitle("登录窗口");
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());
        frame.button1.addActionListener(new EventResponse());
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

class EventResponse implements ActionListener
{
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}