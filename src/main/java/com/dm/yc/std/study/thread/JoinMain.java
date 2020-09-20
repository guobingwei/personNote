package com.dm.yc.std.study.thread;

/**
 * Created by guobing on 2016/8/2.
 */
public class JoinMain {

    public static void main(String [] args) {
        GenerThread gt = new GenerThread();
        JoinThread jt = new JoinThread(gt);
        ThreadC tc = new ThreadC(gt);
        jt.start();
        try {
            Thread.sleep(2 * 1000);
//            jt.join();
            tc.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
