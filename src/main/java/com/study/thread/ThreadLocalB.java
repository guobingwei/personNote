package com.study.thread;

/**
 * Created by guobing on 2016/8/3.
 */
public class ThreadLocalB extends Thread {
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("threadLocal B add - " + i);
            ThreadLocalTools.tl.set("threadLocalB-" + i);
            System.out.println("threadLocal B get value - " + ThreadLocalTools.tl.get());
        }
    }
}
