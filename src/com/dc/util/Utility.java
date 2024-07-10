package com.dc.util;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Scanner;

public class Utility {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * 读取菜单选项 1-5
     */
    public static char readMenuSelection() {
        char c;
        while (true) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' || c != '2' || c != '3' || c != '4' || c != '5') {
                System.out.println("请重新输入: ");
            } else {
                break;
            }
        }
        return c;
    }

    /**
     * 读取输入的第一个字符
     *
     * @return
     */
    public static char readChar() {
        String s = readKeyBoard(1, false);
        return s.charAt(0);
    }


    /**
     * @param defaultChar
     * @return
     */
    public static char readChar(char defaultChar) {
        char c;
        String s = readKeyBoard(1, true);
        return s.length() == 0 ? defaultChar : s.charAt(0);
    }

    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }

    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        return str.equals("") ? defaultValue : str;
    }


    public static int readInt() {
        while (true) {
            String str = readKeyBoard(2, false);
            try {
                int n = Integer.parseInt(str);
                return n;
            } catch (NumberFormatException var3) {
                System.out.println("数字输入错误，请重新输入：");
            }
        }
    }

    public static int readInt(int defaultValue) {
        while (true) {
            String str = readKeyBoard(2, true);
            if (str.equals("")) {
                return defaultValue;
            }

            try {
                int n = Integer.parseInt(str);
                return n;
            } catch (NumberFormatException var4) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
    }


    /**
     * 读取键盘输入
     *
     * @param i
     * @param b
     * @return
     */
    private static String readKeyBoard(int i, boolean b) {
        String line = "";
        while (true) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (b) {
                    return line;
                }
            } else if (line.length() >= 1 && line.length() <= i) {
                break;
            }
            System.out.println("输入错误，请从新输入");
        }
        return line;
    }

}
