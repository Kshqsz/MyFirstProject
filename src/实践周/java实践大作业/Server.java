package 实践周.java实践大作业;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server extends JFrame {
    private JTextArea chatTextArea;
    private List<ClientHandler> clients = new ArrayList<>();
    private List<String> chatHistory = new ArrayList<>();

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    public Server() {
        setTitle("聊天室服务器");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        chatTextArea = new JTextArea(15, 30);
        chatTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatTextArea);
        add(scrollPane, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            appendMessage("服务端端口号为12345.");

            while (true) {
                Socket socket = serverSocket.accept();
                appendMessage("有新用户连接: " + socket);

                ClientHandler clientHandler = new ClientHandler(socket);
                clients.add(clientHandler);
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadcastMessage(String message) {
        appendMessage("有新的信息: " + message);
        chatHistory.add(message);

        for (ClientHandler client : clients) {
            client.sendMessage(message);
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

    private class ClientHandler extends Thread {
        private Socket socket;
        private ObjectInputStream inputStream;
        private ObjectOutputStream outputStream;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                inputStream = new ObjectInputStream(socket.getInputStream());
                outputStream = new ObjectOutputStream(socket.getOutputStream());

                // Send chat history to the newly connected client
                outputStream.writeObject(chatHistory);

                while (true) {
                    String message = (String) inputStream.readObject();
                    appendMessage("收到了信息: " + message);
                    broadcastMessage(message);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    inputStream.close();
                    outputStream.close();
                    socket.close();
                    clients.remove(this);
                    appendMessage("Client disconnected: " + socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void sendMessage(String message) {
            try {
                outputStream.writeObject(message);
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
