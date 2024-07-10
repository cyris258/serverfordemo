package com.dc.server;

import com.dc.common.Message;
import com.dc.common.MessageType;
import com.dc.common.User;
import com.sun.org.apache.regexp.internal.RE;
import sun.dc.pr.PRError;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class QQServer {
    private ServerSocket serverSocket;
    private String UserId;

    private static ConcurrentHashMap<String, User> hashMap = new ConcurrentHashMap<>();

    static {
        hashMap.put("saber", new User("saber", "master"));
        hashMap.put("lancer", new User("lancer", "master"));
        hashMap.put("archer", new User("archer", "master"));
        hashMap.put("caster", new User("caster", "master"));
    }

    public QQServer(ServerSocket serverSocket, String userId) {
        this.serverSocket = serverSocket;
        UserId = userId;
    }

    public QQServer() {
        try {
            serverSocket = new ServerSocket(9999);
            System.out.println("服务器启动监听9999端口，等待链接...");
            while (true) {
                Socket socket = serverSocket.accept();
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                User user = (User) objectInputStream.readObject();
                Message message = new Message();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

                boolean b = checkUser(user.getUserId(), user.getPassword());
                if (b) {
                    //TODO
                    // 验证成功 发送成功消息
                    message.setMessageType(MessageType.LOGIN_SUCCESS);
                    objectOutputStream.writeObject(message);
                    //建立socket链接用于通话
                    QQServerConnectClientThread qqServerConnectClientThread = new QQServerConnectClientThread(user.getUserId(), socket);
                    qqServerConnectClientThread.start();
                    QQServerManagement.addQQServerConnectClientThread(user.getUserId(), qqServerConnectClientThread);
                } else {
                    //失败写入失败信息 关闭流
                    message.setMessageType(MessageType.LOGIN_FAILED);
                    objectOutputStream.writeObject(message);
                    socket.close();
                }
            }


        } catch (IOException e) {

            System.out.println(e);
        } catch (ClassNotFoundException e) {

        }
    }

    private boolean checkUser(String userId, String password) {
        if (userId == null || hashMap.get(userId) == null) return false;
        if (!password.equals(hashMap.get(userId).getPassword())) return false;
        return true;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

}
