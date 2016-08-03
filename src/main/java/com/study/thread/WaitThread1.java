package com.study.thread;

/**
 * Created by guobing on 2016/8/3.
 */
public class WaitThread1 extends Thread {
    private Object obj;
    public WaitThread1(Object obj) {
        super();
        this.obj = obj;
    }
    public void run() {
        WaitMethod wm = new WaitMethod();
        wm.testNotify(obj);
    }
}
