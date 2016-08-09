package com.study.thread;

/**
 *
 * 三个线程，一个打印1-10，另一个打印11-20，最后一个打印21-30，需要按顺序打印出来
 * Created by guobing on 2016/8/3.
 */
public class PrintMain {
    public static void main(String [] args) {
        PrintThread2 pt2 = new PrintThread2();
        PrintThread1 pt1 = new PrintThread1(pt2);
//        PrintThread3 pt3 = new PrintThread3();
        PrintThread4 pt4 = new PrintThread4(pt2);
        try {
            pt1.start();
            pt4.start();
            pt4.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
