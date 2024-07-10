package com.dc.server;

import com.dc.common.Message;
import com.dc.common.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDateTime;

public class QQServerConnectClientThread extends Thread {
    private String userId;
    private Socket socket;

    public QQServerConnectClientThread(String userId, Socket socket) {
        this.userId = userId;
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("用户" + userId + "上线");
        try (
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream())
        ) {
            while (true) {
                Message message = (Message) objectInputStream.readObject();

                // 处理来自客户端的消息
                handleClientMessage(message, objectOutputStream);
            }
        } catch (IOException e) {
            // 处理输入/输出异常
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // 处理类未找到异常
            e.printStackTrace();
        } finally {
            // 在退出线程前关闭资源
            closeResources(socket);
        }
    }

    private void handleClientMessage(Message message, ObjectOutputStream objectOutputStream) throws IOException {
        // 根据消息类型执行不同的操作
        if (MessageType.GET_USERS_MESSAGE.equals(message.getMessageType())) {
            String allUser = QQServerManagement.getAllUser();
            Message responseMessage = new Message();
            responseMessage.setMessageType(MessageType.GET_USERS_MESSAGE);
            responseMessage.setContent(allUser);
            responseMessage.setGetter(message.getSender());
            responseMessage.setSendTime(LocalDateTime.now().toString());

            // 发送响应消息给客户端
            objectOutputStream.writeObject(responseMessage);
        } else {
            // 处理其他消息类型或添加相应的逻辑
        }
    }

    private void closeResources(Socket socket) {
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            // 处理关闭套接字时可能出现的异常
            e.printStackTrace();
        }
    }
}
