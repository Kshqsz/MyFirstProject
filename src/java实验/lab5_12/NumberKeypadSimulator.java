package java实验.lab5_12;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NumberKeypadSimulator extends JFrame {

    private JTextArea textArea;
    private JButton resetButton;

    public NumberKeypadSimulator() {
        setTitle("九宫格数字键盘模拟程序");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        Label tips = new Label("键盘输入数字");
        mainPanel.add(tips,BorderLayout.NORTH);
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel keypadPanel = createKeypadPanel();
        mainPanel.add(keypadPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setVisible(true);
    }

    private JPanel createKeypadPanel() {
        JPanel keypadPanel = new JPanel(new GridLayout(5, 3));

        JButton button1 = createButton("1");
        keypadPanel.add(button1);

        JButton button2 = createButton("2");
        keypadPanel.add(button2);

        JButton button3 = createButton("3");
        keypadPanel.add(button3);

        JButton button4 = createButton("4");
        keypadPanel.add(button4);

        JButton button5 = createButton("5");
        keypadPanel.add(button5);

        JButton button6 = createButton("6");
        keypadPanel.add(button6);

        JButton button7 = createButton("7");
        keypadPanel.add(button7);

        JButton button8 = createButton("8");
        keypadPanel.add(button8);

        JButton button9 = createButton("9");
        keypadPanel.add(button9);

        JButton symbolButton1 = createButton("*");
        keypadPanel.add(symbolButton1);

        JButton button0 = createButton("0");
        keypadPanel.add(button0);

        JButton symbolButton2 = createButton("#");
        keypadPanel.add(symbolButton2);

        resetButton = new JButton("重置");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
        JPanel resetPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        resetPanel.add(resetButton);
        keypadPanel.add(resetPanel);
        return keypadPanel;
    }

    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.RED);
            }
            public void mouseExited(MouseEvent e) {
                button.setBackground(null);
            }
            public void mouseClicked(MouseEvent e) {
                textArea.append(button.getText());
                button.setBackground(Color.GREEN);
            }
        });
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NumberKeypadSimulator();
            }
        });
    }
}
