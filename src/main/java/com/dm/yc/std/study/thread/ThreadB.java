package com.dm.yc.std.study.thread;

/**
 * Created by guobing on 2016/8/1.
 */
public class ThreadB extends Thread {

    private MyObject myObject;

    public ThreadB(MyObject myObject) {
        super();
        this.myObject = myObject;
    }

    public void run() {
        super.run();
        myObject.methodSyc();
        myObject.getSycValue();
//        myObject.addIUnsafe("b");
    }
}
