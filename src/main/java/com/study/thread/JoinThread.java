package com.study.thread;

/**
 * Created by guobing on 2016/8/2.
 */
public class JoinThread extends Thread {
    private GenerThread g;
    public JoinThread(GenerThread g) {
        super();
        this.g = g;
    }

    public void run() {
        /*for(int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
        }*/

        synchronized (g) {
            g.start();
            try {
                System.out.println("jt begin sleep - ");
                Thread.sleep(6 * 1000);
//                g.join();
                System.out.println("jt end sleep - ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
