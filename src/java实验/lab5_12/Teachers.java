package java实验.lab5_12;

import javax.swing.*;
import java.awt.*;

public class Teachers {

    Frame frame = new Frame("教师信息维护");

    Label name = new Label("姓名");
    Label degree = new Label("学位");
    Label jobin = new Label("参加工作年份");
    Label handle = new Label("职称");
    Label sex = new Label("请选择教师的性别");
    CheckboxGroup cbg = new CheckboxGroup();

    Checkbox male = new Checkbox("男",cbg,true);
    Checkbox female = new Checkbox("女",cbg,false);

    Button login = new Button("录入教师");
    Button up = new Button("晋升职称");

    TextField names = new TextField();
    TextField degrees = new TextField();
    TextField jobins = new TextField();
    TextField handles = new TextField();
    TextField tips = new TextField("操作提示:");

    public void init()
    {

        Box u1 = Box.createHorizontalBox();
        Box u2 = Box.createHorizontalBox();
        Box u = Box.createVerticalBox();

        u1.add(name);
        u1.add(names);
        u1.add(degree);
        u1.add(degrees);
        u2.add(jobin);
        u2.add(jobins);
        u2.add(handle);
        u2.add(handles);

        u.add(u1);
        u.add(u2);

        frame.add(u,BorderLayout.NORTH);
        Box c = Box.createHorizontalBox();
        c.add(sex);
        c.add(male);
        c.add(female);
        frame.add(c,BorderLayout.CENTER);

        Box d1 = Box.createHorizontalBox();
        Box d2 = Box.createHorizontalBox();
        Box d = Box.createVerticalBox();
        d1.add(login);
        d1.add(up);
        d2.add(tips);
        d.add(d1);
        d.add(d2);

        frame.add(d,BorderLayout.SOUTH);

        frame.setBounds(300,50,380,220);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Teachers teachers = new Teachers();
        teachers.init();
    }
}
