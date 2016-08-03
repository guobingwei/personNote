package com.study.thread;

/**
 * Created by guobing on 2016/8/2.
 */
public class GenerThread extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - General thread");
    }

    synchronized public void GServer() {
        System.out.println(Thread.currentThread().getName() + " - General Server");
    }
}
