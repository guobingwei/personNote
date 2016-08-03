package com.study.thread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * ReentrantReadWriteLock : 读写锁。读读不互斥、读写互斥，写读互斥、写写互斥
 * Created by guobing on 2016/8/3.
 */
public class ReentrantReadWriteLockService {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public void read() {
        try {
            lock.readLock().lock();
            System.out.println("read - " + System.currentTimeMillis());
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    public void write() {
        try {
            lock.writeLock().lock();
            System.out.println("write - " + System.currentTimeMillis());
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public static void main(String [] args) {
        ReentrantReadWriteLockService service = new ReentrantReadWriteLockService();
        ReentrantReadWriteLockThreadA ta = new ReentrantReadWriteLockThreadA(service);
        ReentrantReadWriteLockThreadB tb = new ReentrantReadWriteLockThreadB(service);
        ta.start();
        tb.start();
    }
}
