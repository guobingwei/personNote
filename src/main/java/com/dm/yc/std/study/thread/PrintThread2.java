package com.dm.yc.std.study.thread;

/**
 * Created by guobing on 2016/8/3.
 */
public class PrintThread2 extends Thread {
    public void run() {
        /*for(int i = 11; i < 20; i++) {
            System.out.println("pt2 - " + i);
        }*/
        System.out.println("pt2 - ");
    }

    synchronized public void printOther() {
        System.out.println("pt2 - not run method");
    }
}
