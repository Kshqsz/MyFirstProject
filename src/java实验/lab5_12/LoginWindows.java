package java实验.lab5_12;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.*;
public class LoginWindows extends JFrame implements ActionListener {
    private JLabel userLa;
    private JLabel pwdLa;
    private JTextField userTxt;
    private JPasswordField pwdTxt;
    private JButton sureBt;
    private JPanel pan;
    public LoginWindows() {
        init();
    }
    public void init() {
        Frame frame = new Frame("登录窗口");
        //用户文本
        userLa = new JLabel();
        userLa.setText("账号：");
        userLa.setSize(60, 50);
        userLa.setLocation(100, 80);

        //密码文本
        pwdLa = new JLabel();
        pwdLa.setText("密码：");
        pwdLa.setSize(50, 50);
        pwdLa.setLocation(100, 120);

        //用户输入框
        userTxt = new JTextField();
        userTxt.setSize(100, 20);
        //this.setSize(width, height)
        userTxt.setLocation(170, 95);

        //密码输入框
        pwdTxt = new JPasswordField();
        pwdTxt.setSize(100, 20);
        pwdTxt.setLocation(170, 135);

        //复选框
        pan = new JPanel();
        JCheckBox jcb1 = new JCheckBox("记住密码");
        JCheckBox jcb2 = new JCheckBox("自动登录");
//        pan.setLayout(new GridLayout(1, 2)); // 设置组件的排版
        pan.setSize(300, 50);
        pan.setLocation(60, 190);
        pan.add(jcb1);
        pan.add(jcb2);


        //确认按钮
        sureBt = new JButton("登录");
        sureBt.setSize(60, 25);
        sureBt.setLocation(180, 260);


        this.setTitle("登录窗口");
        this.setLayout(null);
        this.setSize(500, 400);
        this.add(userLa);
        this.add(pwdLa);
        this.add(userTxt);
        this.add(pwdTxt);
        this.add(sureBt);
        this.add(pan);

        sureBt.addActionListener(this);
        this.setVisible(true);

    }
    @Override
    //具体事件的处理
    public void actionPerformed(ActionEvent e) {
        //获取产生事件的事件源强制转换
        JButton bt = (JButton) e.getSource();
        //获取按钮上显示的文本
        String str = bt.getText();
    }
    public static void main(String[] args) {
        LoginWindows loginWindows = new LoginWindows();
    }
}


