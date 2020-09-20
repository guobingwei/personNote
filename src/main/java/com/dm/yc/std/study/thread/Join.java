package com.dm.yc.std.study.thread;

import java.util.concurrent.TimeUnit;

/**
 * test join
 * Created by john on 2016/4/12.
 */
public class Join {
    public static void  main(String [] args) throws InterruptedException {
        /*Thread previous = Thread.currentThread();
        for(int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }

        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " main terminate.");*/

    }

    static class Domino implements Runnable {
        private Thread thread;
        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {

            }

            System.out.println(Thread.currentThread().getName() + " run terminate.");
        }
    }

    class JoinThread extends Thread {
        public void run() {
            for(int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
            }
        }
    }

    class GenThread extends Thread {
        public void run() {
            System.out.println(Thread.currentThread().getName() + " - General thread");
        }
    }
}
