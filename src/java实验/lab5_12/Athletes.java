package java实验.lab5_12;


import javax.swing.*;
import java.awt.*;

public class Athletes {
    Frame frame = new Frame();

    Label num = new Label("请输入运动员的编号");
    TextField tf = new TextField(20);

    Label sex = new Label("选择性别");
    CheckboxGroup cbg = new CheckboxGroup();
    Checkbox male = new Checkbox("男",cbg,true);
    Checkbox female = new Checkbox("女",cbg,true);

    Label choose = new Label("选择参加的运动项目");
    Choice choosep= new Choice();


    Label programes = new Label("运动员参赛项目");
    TextArea ta = new TextArea(5,30);

    Button reset = new Button("重置");
    Button exit = new Button("退出");

//    TextArea ta = new TextArea(5, 30);
//    Choice colorChooser = new Choice();
//    CheckboxGroup cbg = new CheckboxGroup();
//    Checkbox male = new Checkbox("男", cbg, true);
//    Checkbox female = new Checkbox("女", cbg, true);
//    Checkbox isMarried = new Checkbox("是否已婚?");
//    TextField tf = new TextField(20);
//    Button ok = new Button("确认");
//    List colorList = new List(6, true);

    public void init() {
        Box box1 = Box.createVerticalBox();
        Box box2 = Box.createHorizontalBox();
        Box box12 = Box.createVerticalBox();
        box2.add(reset);
        box2.add(exit);
        box1.add(programes);
        box1.add(ta);
        box12.add(box1);
        box12.add(box2);
        frame.add(box12,BorderLayout.SOUTH);

        Box top = Box.createHorizontalBox();
        top.add(num);
        top.add(tf);
        frame.add(top,BorderLayout.NORTH);

        Box cen = Box.createVerticalBox();
        Box cen1 = Box.createHorizontalBox();
        cen1.add(sex);
        cen1.add(male);
        cen1.add(female);
        Box cen2 = Box.createHorizontalBox();
        cen2.add(choose);
        choosep.add("铅球");
        choosep.add("跳远");
        choosep.add("400米赛跑");
        cen2.add(choosep);
        cen.add(cen1);
        cen.add(cen2);

        frame.add(cen,BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);





//        Box bBox = Box.createHorizontalBox();
//        bBox.add(tf);
//        bBox.add(ok);
//        frame.add(bBox, BorderLayout.SOUTH);
//        colorChooser.add("红色");
//        colorChooser.add("蓝色");
//        colorList.add("绿色");
//        Box cBox = Box.createHorizontalBox();
//        cBox.add(colorChooser);
//        cBox.add(male);
//        cBox.add(female);
//        cBox.add(isMarried);
//
//        Box topLeft = Box.createVerticalBox();
//        topLeft.add(ta);
//        topLeft.add(cBox);
//
//        colorList.add("红色");
//        colorList.add("蓝色");
//        colorList.add("绿色");
//        Box top = Box.createHorizontalBox();
//        top.add(topLeft);
//        top.add(colorList);
//        frame.add(top);
//        frame.pack();
//        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Athletes athletes = new Athletes();
        athletes.init();
    }

}

//        Box hBox = Box.createHorizontalBox();
//        hBox.add(new Button("水平按钮1"));
//        hBox.add(new Button("水平按钮2"));
//        Box vBox = Box.createVerticalBox();
//        vBox.add(new Button("垂直按钮1"));
//        vBox.add(new Button("垂直按钮2"));
//        frame.add(hBox,BorderLayout.NORTH);
//        frame.add(vBox);



//        BoxLayout boxLayout = new BoxLayout(frame,BoxLayout.Y_AXIS);
//        frame.setLayout(boxLayout);
//
//        frame.add(new Button("按钮1"));
//        frame.add(new Button("按钮2"));




