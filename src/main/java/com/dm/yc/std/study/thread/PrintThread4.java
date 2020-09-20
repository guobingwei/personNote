package com.dm.yc.std.study.thread;

/**
 * Created by guobing on 2016/8/3.
 */
public class PrintThread4 extends Thread {
    private PrintThread2 pt2;
    public PrintThread4(PrintThread2 pt2) {
        super();
        this.pt2 = pt2;
    }

    public void run() {
        pt2.printOther();
    }
}
