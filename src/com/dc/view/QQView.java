package com.dc.view;

import com.dc.util.Utility;
import com.sun.org.apache.bcel.internal.generic.FADD;

public class QQView {

    private boolean loop = true;

    private boolean userLoop = true;
    private String keyBoard = "";

    public static void main(String[] args) {
        new QQView().mainMenu();
    }

    private void mainMenu() {
        while (loop) {
            System.out.println("============欢迎登入网络通信系统============");
            System.out.println("============1 登入============");
            System.out.println("============2 ============");
            System.out.println("============9 退出============");
            System.out.println("=============输入你的选择===========");
            keyBoard = Utility.readString(1);
            switch (keyBoard) {
                case "1":
                    System.out.println("登入操作");
                    System.out.println("输入用户名或id");
                    String userId = Utility.readString(100);
                    System.out.println("输入密码");
                    String password = Utility.readString(100);
                    if (true) {
                        while (userLoop) {
                            System.out.println("============网络通信系统用户界面============");
                            System.out.println("============1 显示用户列表============");
                            System.out.println("============2 群发消息============");
                            System.out.println("============3 私聊============");
                            System.out.println("============4 发送文件============");
                            System.out.println("============9 退出============");
                            System.out.println("=============输入你的选择===========");
                            keyBoard = Utility.readString(1);
                            switch (keyBoard) {
                                case "1":
                                    System.out.println("用户列表");
                                    break;
                                case "2":
                                    System.out.println("群发消息");
                                    break;
                                case "3":
                                    System.out.println("私聊");
                                    break;
                                case "4":
                                    System.out.println("发送文件");
                                    break;
                                case "9":
                                    System.out.println("退出成功");
                                    userLoop = false;
                                    break;
                                default:
                                    System.out.println("请按照要求输入");
                            }

                        }
                    } else {
                        System.out.println("用户名或密码错误");
                    }

                    break;
                case "9":
                    loop = false;
                    System.out.println("退出成功");
                    break;
                default:
                    System.out.println("请按照要求输入");
            }
        }
    }
}
