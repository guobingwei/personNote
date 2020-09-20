package com.dm.yc.std.study.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 控制资源的线程并发访问数量
 * Created by guobing on 2016/8/3.
 */
public class SemaphoreTest {
    private static final int count = 30;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(count);

    private static Semaphore s = new Semaphore(10);

    public static void main(String [] args) {
        for(int i = 0; i < count; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 获取许可证
                        s.acquire();
                        System.out.println("save data");
                        // 释放许可证
                        s.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        threadPool.shutdown();
    }
}
