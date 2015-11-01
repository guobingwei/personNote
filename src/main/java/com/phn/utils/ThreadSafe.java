package com.phn.utils;

/**
 * Created by john on 2015/11/1.
 */
public class ThreadSafe extends Thread{
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready) {
                Thread.yield();
                System.out.print(number);
            }
        }
    }

    public static void main(String [] args) {
        /*new ReaderThread().start();
        ready = true;
        number = 42;*/

        Demo demo = new Demo();
        demo.start();
        for(int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }

    }
}

class Demo extends Thread {
    public void run () {
        for(int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}