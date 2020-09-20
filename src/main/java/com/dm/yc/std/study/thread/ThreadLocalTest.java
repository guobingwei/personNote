package com.dm.yc.std.study.thread;

import java.util.concurrent.TimeUnit;

/**
 * thread local test
 * Created by john on 2016/4/12.
 */
public class ThreadLocalTest {
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>();

    protected Long initialValue() {
        return System.currentTimeMillis();
    }

    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end() {
        System.out.println(System.currentTimeMillis() - TIME_THREADLOCAL.get());
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String [] args) throws InterruptedException {
        ThreadLocalTest.begin();
        TimeUnit.SECONDS.sleep(1);

        say();
        eat();

        System.out.println("cost : " + ThreadLocalTest.end() + "mills");
    }

    static class demoThread implements Runnable {

        @Override
        public void run() {
            ThreadLocalTest.end();
            System.out.println(Thread.currentThread().getName() + "terminate .");
        }
    }

    static void say() {
        ThreadLocalTest.end();
    }

    static void eat() {
        ThreadLocalTest.end();
    }
}
