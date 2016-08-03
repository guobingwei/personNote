package com.study.thread;

/**
 * Created by guobing on 2016/8/3.
 */
public class ThreadLocalA extends Thread {
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("threadLocal A add - " + i);
            ThreadLocalTools.tl.set("threadLocalA-" + i);
            System.out.println("threadLocal A get value - " + ThreadLocalTools.tl.get());
        }
    }

    public static void main(String [] args) {
        ThreadLocalA ta = new ThreadLocalA();
        ThreadLocalB tb = new ThreadLocalB();
        ta.start();
        tb.start();
    }
}
