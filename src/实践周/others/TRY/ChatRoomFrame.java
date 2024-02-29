package 实践周.others.TRY;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

public class ChatRoomFrame extends JFrame {
    public  JTextArea chatTextArea;
    public  JTextField messageTextField;
    public JButton sendButton;
    public JButton historyButton;

    private ArrayList<String> chatHistory;

    public ChatRoomFrame() {
        super("Chat Room");
        chatHistory = new ArrayList<>();

        chatTextArea = new JTextArea(15, 30);
        chatTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatTextArea);

        messageTextField = new JTextField(30);

        sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = messageTextField.getText();
                try {
                    sendMessage(message);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                messageTextField.setText("");
            }
        });

        historyButton = new JButton("History");
        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showChatHistory();
            }
        });
        JPanel inputPanel = new JPanel();
        inputPanel.add(messageTextField);
        inputPanel.add(sendButton);
        inputPanel.add(historyButton);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    private void sendMessage(String message) throws Exception {
        chatHistory.add(message);
        chatTextArea.append(message + "\n");
        insert(message);
    }

    private void showChatHistory() {
        StringBuilder history = new StringBuilder();
        for (String message : chatHistory) {
            history.append(message).append("\n");
        }
        JOptionPane.showMessageDialog(this, history.toString(), "Chat History", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChatRoomFrame();
            }
        });
    }
    public static void insert(String message) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "hsk200311";

        Connection conn = DriverManager.getConnection(url, username, password);
        //插入数据
        String sql = "INSERT into record(message) values('" + message + "');";

        Statement stmt = conn.createStatement();
        //接收修改
        int count = stmt.executeUpdate(sql);

        //查询数据
        stmt.close();
        conn.close();
    }
}
