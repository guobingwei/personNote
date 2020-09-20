package com.dm.yc.std.study.thread;

import java.util.concurrent.CountDownLatch;

/**
 * 接受int类型的参数作为计数器。当计数器为0时不再阻塞当前线程。
 * Created by guobing on 2016/8/3.
 */
public class JoinCountDownLatch {

    static CountDownLatch cdl = new CountDownLatch(2);

    public static void main(String [] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                cdl.countDown();
                System.out.println(2);
                cdl.countDown();
            }
        }).start();

        try {
            cdl.await();
            System.out.println(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
