package java实验.lab5_12;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ispass {

    Frame frame = new Frame("及格判断");

    Label score = new Label("分数");
    Label result = new Label("结果");

    TextField scores = new TextField(30);
    TextField results = new TextField(30);

    JButton judge = new JButton("判断");
    JButton reset = new JButton("重置");

    public void init()
    {
        MyListener myListener = new MyListener();
        judge.addActionListener(myListener);
        Box h1 = Box.createHorizontalBox();
        Box h2 = Box.createHorizontalBox();
        Box h = Box.createVerticalBox();

        h1.add(score);
        h1.add(scores);
        h2.add(result);
        h2.add(results);

        h.add(h1);
        h.add(h2);

        Box d = Box.createHorizontalBox();

        d.add(judge);
        d.add(reset);

        frame.add(h,BorderLayout.NORTH);
        frame.add(d,BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
    private class MyListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            JButton bt = (JButton) e.getSource();
            String str = bt.getText();
            if (str == "判断")
            {
                String sc = scores.getText();
                int a = Integer.parseInt(sc);
                if (a >= 60)
                {
                    results.setText("及格");
                }
                else
                {
                    results.setText("不及格");
                }
            }
        }
    }


    public static void main(String[] args) {
        ispass ispas = new ispass();
        ispas.init();
    }
}
