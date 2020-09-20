package com.dm.yc.std.study.thread;

/**
 * yield方法：
 * 放弃当前的cpu资源，让给其它的任务占用cpu时间。但是放弃的时间不确定。
 * Created by guobing on 2016/8/3.
 */
public class YieldThread extends Thread {

    @Override
    public void run() {
        long begin = System.currentTimeMillis();
        int count = 0;
        for(int i = 0; i < 50000; i++) {
            Thread.yield();
            count += i;
        }

        long end = System.currentTimeMillis();
        System.out.println("用时：" + (end - begin) + "毫秒 - count=" + count);
    }

    public static void main(String [] args) {
        YieldThread yt = new YieldThread();
        yt.start();
    }
}
