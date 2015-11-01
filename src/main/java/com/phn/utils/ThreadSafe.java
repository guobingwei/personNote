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

        // 线程安全测试代码
        /*new ReaderThread().start();
        ready = true;
        number = 42;*/

        // 线程初步测试
        /*Demo demo = new Demo();
        demo.start();
        for(int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }*/

        // 线程同步测试代码
        Ticket t =new Ticket();
        Thread t1 = new Thread(t,"窗口一");
        Thread t2 = new Thread(t,"窗口二");
        Thread t3 = new Thread(t,"窗口三");
        Thread t4 = new Thread(t,"窗口四");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class Demo extends Thread {
    public void run () {
        for(int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}

class Ticket implements Runnable{
    private int ticket = 4000;
    public synchronized void  saleTicket(){
        if(ticket>0)
            System.out.println(Thread.currentThread().getName()+"卖出了"+ticket--);

    }
    public void run(){
        while(true){
            saleTicket();
        }
    }
}