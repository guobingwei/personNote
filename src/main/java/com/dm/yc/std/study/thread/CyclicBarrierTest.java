package com.dm.yc.std.study.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 当改成3的时候，线程一直运行。因为没达到3.不会停止。
 * Created by guobing on 2016/8/3.
 */
public class CyclicBarrierTest {

    static CyclicBarrier cb = new CyclicBarrier(3);

    public static void main(String [] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // await告诉CyclicBarrier已经达到内存屏障
                    cb.await();
                    System.out.println(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            cb.await();
            System.out.println(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
