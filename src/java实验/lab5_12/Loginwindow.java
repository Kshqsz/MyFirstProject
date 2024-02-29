package java实验.lab5_12;
import java.awt.*;
public class Loginwindow {
    public static void main(String[] args) {
        Frame frame = new Frame();
        Panel p1 = new Panel();
        Panel p = new Panel();
        p1.add(new Label("账号"));
        p1.add(new TextField(30));
        p.add(new Label("密码"));
        p.add(new TextField(30));
        Checkbox remember = new Checkbox("记住密码",true);
        Checkbox auto = new Checkbox("自动登录",false);
        Panel p2 = new Panel();
        p2.add(remember);
        p2.add(auto);
        p2.add(new Button("登录"));
        frame.add(p1,BorderLayout.NORTH);
        frame.add(p2,BorderLayout.SOUTH);
        frame.add(p,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
