package 实践周.try3;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Client extends JFrame {
    private JTextArea chatTextArea;
    private JTextField messageTextField;
    private JButton sendButton;
    private JButton historyButton;

    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    private List<String> chatHistory;
    private String username;

    public static void main(String[] args) {
        String username = "John"; // Set the desired username here
        Client client = new Client();
        client.start(username);
    }

    public void start(String username) {
        this.username = username;
        chatHistory = new ArrayList<>();

        try {
            Socket socket = new Socket("localhost", 12345);
            System.out.println("连接到服务端.");

            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    createAndShowGUI();
                }
            });

            new Thread(new IncomingMessageHandler()).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createAndShowGUI() {
        setTitle("聊天室");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        chatTextArea = new JTextArea(15, 30);
        chatTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatTextArea);

        messageTextField = new JTextField(30);

        sendButton = new JButton("发送");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = messageTextField.getText();
                sendMessage(username + "发送了信息: " + message);
                try {
                    insert(username + "发送了信息: " + message);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                messageTextField.setText("");
            }
        });

        historyButton = new JButton("历史记录");
        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayChatHistory();
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.add(messageTextField);
        inputPanel.add(sendButton);
        inputPanel.add(historyButton);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    private void sendMessage(String message) {
        try {
            outputStream.writeObject(message);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void appendMessage(String message) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                chatTextArea.append(message + "\n");
            }
        });
    }

    private void displayChatHistory() {
        StringBuilder history = new StringBuilder();
        for (String message : chatHistory) {
            history.append(message).append("\n");
        }
        JOptionPane.showMessageDialog(this, history.toString(), "Chat History", JOptionPane.INFORMATION_MESSAGE);
    }

    private class IncomingMessageHandler implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    Object object = inputStream.readObject();

                    if (object instanceof String) {
                        String message = (String) object;
                        chatHistory.add(message);
                        appendMessage(message);
                    } else if (object instanceof List) {
                        List<String> serverHistory = (List<String>) object;
                        chatHistory.addAll(serverHistory);
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
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
