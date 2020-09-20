package com.dm.yc.std.study.thread;

/**
 * Created by guobing on 2016/8/3.
 */
public class PrintThread1 extends Thread {
    private PrintThread2 pt2;

    public PrintThread1(PrintThread2 pt2) {
        super();
        this.pt2 = pt2;
    }
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("pt1 - " + i);
        }

        synchronized (pt2) {
            try {
                System.out.println("pt1 hold pt2 lock begin ");
                pt2.join();
                System.out.println("pt1 hold pt2 lock end ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
