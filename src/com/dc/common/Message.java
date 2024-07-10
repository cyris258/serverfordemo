package com.dc.common;

import java.io.Serializable;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L; // 注意大写的 "L"

    private String sender;
    private String getter;
    private String content;
    private String sendTime;
    private String messageType;

    public Message(String sender, String getter, String content, String sendTime, String messageType) {
        this.sender = sender;
        this.getter = getter;
        this.content = content;
        this.sendTime = sendTime;
        this.messageType = messageType;
    }

    public Message() {
    }

    // 添加对私有字段的访问方法
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    // 重写 toString() 方法，以方便调试
    @Override
    public String toString() {
        return "Message{" +
                "sender='" + sender + '\'' +
                ", getter='" + getter + '\'' +
                ", content='" + content + '\'' +
                ", sendTime='" + sendTime + '\'' +
                ", messageType='" + messageType + '\'' +
                '}';
    }
}
