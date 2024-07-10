package com.dc.server;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class QQServerManagement {
    public static HashMap<String, QQServerConnectClientThread> hashMap = new HashMap<>();

    public static void addQQServerConnectClientThread(String userId, QQServerConnectClientThread serverConnectClientThread) {
        hashMap.put(userId, serverConnectClientThread);
    }

    public static QQServerConnectClientThread getQQServerConnectClientThreadByUserId(String userId) {
        return hashMap.get(userId);
    }

    public static String getAllUser() {
        Set<String> keySet = hashMap.keySet();
        Iterator<String> iterator = keySet.iterator();
        String OnLine = "";
        while (iterator.hasNext()) {
            OnLine += iterator.toString() + " ";
        }
        return OnLine;
    }
}
