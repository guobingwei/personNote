package com.dm.yc.std.study.thread;

/**
 * Created by guobing on 2016/8/2.
 */
public class ThreadC extends Thread {

    private GenerThread g;
    public ThreadC(GenerThread g) {
        super();
        this.g = g;
    }

    public void run() {
        g.GServer();
    }
}
