package 实践周.try2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatRoomFrame extends JFrame {
    private JTextArea chatTextArea;
    private JTextField messageTextField;
    private JButton sendButton;
    private JButton historyButton;

    private static ArrayList<String> chatHistory = new ArrayList<>();
    private ObjectOutputStream output;
    private ObjectInputStream input;

    public ChatRoomFrame() {
        super("Chat Room");

        chatTextArea = new JTextArea(15, 30);
        chatTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatTextArea);

        messageTextField = new JTextField(30);

        sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = messageTextField.getText();
                sendMessage(message);
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

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);

        connectToServer();
    }

    private void connectToServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            Socket socket = serverSocket.accept();

            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());

            new Thread(new IncomingMessageHandler()).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String message) {
        chatHistory.add(message);
        chatTextArea.append(message + "\n");

        try {
            output.writeObject(message);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void appendMessage(String message) {
        chatTextArea.append(message + "\n");
    }

    private void showChatHistory() {
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
                    String message = (String) input.readObject();
                    appendMessage(message);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChatRoomFrame();
            }
        });
    }
}
