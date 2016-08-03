package com.study.thread;

/**
 * Created by guobing on 2016/8/3.
 */
public class PrintThread3 extends Thread {
    public void run() {
        for(int i = 20; i < 30; i++) {
            System.out.println("pt3 - " + i);
        }
    }
}
