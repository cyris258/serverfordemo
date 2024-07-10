package com.dc.common;

import org.omg.SendingContext.RunTime;

public class cpuN {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int cpuNumers = runtime.availableProcessors();
        System.out.println("当前cpu的数量为 ：" + cpuNumers);
    }

}
