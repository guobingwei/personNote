package com.study.thread;

/**
 * 验证wait释放锁，notify不释放锁
 * Created by guobing on 2016/8/3.
 */
public class WaitMethod {

    public void testMethod(Object obj) {
        synchronized (obj) {
            System.out.println("begin wait()");
            try {
                obj.wait(2 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end wait()");
        }
    }

    /**
     * obj.notify用来通知线程w2来执行，但是必须等到w1执行完成。期间不释放锁。
     * obj.wait表示停一下再执行，释放锁
     * @param obj
     */
    public void testNotify(Object obj) {
        synchronized (obj) {
            System.out.println("begin wait()");
            try {
                obj.notify();
                Thread.sleep(2 * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("end wait()");
        }
    }

    public static void main(String [] args) {
        Object obj = new Object();
        WaitThread1 w1 = new WaitThread1(obj);
        WaitThread2 w2 = new WaitThread2(obj);
        w1.start();
        w2.start();
    }
}
