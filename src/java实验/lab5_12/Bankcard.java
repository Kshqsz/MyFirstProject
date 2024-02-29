package java实验.lab5_12;

import javax.swing.*;
import java.awt.*;

public class Bankcard {

    Frame frame = new Frame("银行卡管理系统");

    Label cardnum = new Label("银行卡号");
    Label idnum = new Label("身份卡号");
    Label name = new Label("用户姓名");
    Label passward = new Label("密码");
    Label balance = new Label("余额");
    Label getbalacne = new Label("取存款");
    Label date = new Label("存款期限");
    Label tips = new Label("操作信息提示");

    CheckboxGroup cbg = new CheckboxGroup();
    Checkbox oneyear = new Checkbox("一年",cbg,false);
    Checkbox threeyear = new Checkbox("3年",cbg,false);
    Checkbox current = new Checkbox("活期",cbg,true);
    Checkbox newsave = new Checkbox("办新卡时存款",true);

    Button newcard = new Button("办新卡");
    Button save = new Button("存款");
    Button getmoney = new Button("取款");
    Button changepsw = new Button("改密码");
    Button newempty = new Button("开空卡");
    Button query = new Button("查询");
    Button delete = new Button("删除");
    Button clear = new Button("清空");

    Button cardid = new Button("卡号");
    Button name_1 = new Button("姓名");
    Button identification = new Button("身份证号");
    Button passw = new Button("密码");
    Button left = new Button("余额");

    TextField bankcards = new TextField(10);
    TextField ids = new TextField(10);
    TextField names = new TextField(10);
    TextField psw = new TextField(10);
    TextField balances = new TextField(10);
    TextField getbalcnes = new TextField(10);


    TextArea textArea = new TextArea(5,70);


    public void init()
    {
        textArea.setEnabled(false);
        balances.setEditable(false);
        Box b1 = Box.createHorizontalBox();
        Box b2 = Box.createHorizontalBox();
        Box b3 = Box.createHorizontalBox();
        Box b = Box.createVerticalBox();
        b1.add(cardnum);
        b1.add(bankcards);
        b1.add(idnum);
        b1.add(ids);
        b2.add(name);
        b2.add(names);
        b2.add(passward);
        b2.add(psw);
        b3.add(balance);
        b3.add(balances);
        b3.add(getbalacne);
        b3.add(getbalcnes);
        b.add(b1);
        b.add(b2);
        b.add(b3);
        frame.add(b,BorderLayout.NORTH);

        Box c1 = Box.createHorizontalBox();
        Box c2 = Box.createHorizontalBox();
        Box c3 = Box.createHorizontalBox();
        Box c4 = Box.createHorizontalBox();
        Box c = Box.createVerticalBox();
        c1.add(date);
        c1.add(oneyear);
        c1.add(threeyear);
        c1.add(current);

        c2.add(newsave);

        c3.add(newcard);
        c3.add(save);
        c3.add(getmoney);
        c3.add(changepsw);
        c4.add(newempty);
        c4.add(query);
        c4.add(delete);
        c4.add(clear);

        c.add(c1);
        c.add(c2);
        c.add(c3);
        c.add(c4);

        frame.add(c,BorderLayout.CENTER);

        Box h1 = Box.createHorizontalBox();
        Box h2 = Box.createHorizontalBox();
        Box h3 = Box.createHorizontalBox();
        Box h = Box.createVerticalBox();

        h1.add(tips);
        h2.add(cardid);
        h2.add(name_1);
        h2.add(identification);
        h2.add(passw);
        h2.add(left);

        h3.add(textArea);

        h.add(h1);
        h.add(h2);
        h.add(h3);

        frame.add(h,BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);

    }


    public static void main(String[] args) {
        Bankcard bankcard = new Bankcard();
        bankcard.init();
    }
}
