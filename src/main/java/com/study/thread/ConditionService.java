package com.study.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 一对一交替打印符号或字母
 * Created by guobing on 2016/8/3.
 */
public class ConditionService {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private boolean hasValue = false;

    public void set() {
        try {
            lock.lock();
            while (hasValue) {
                condition.await();
            }

            System.out.println("打印★");
            hasValue = true;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        try {
            lock.lock();
            while (!hasValue) {
                condition.await();
            }

            System.out.println("打印☆");
            hasValue = false;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void await() {
        try {
            lock.lock();
            System.out.println("await的时间为：" + System.currentTimeMillis());
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signal() {
        try {
            lock.lock();
            System.out.println("signal的时间为：" + System.currentTimeMillis());
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void signalAll_A() {
        try {
            lock.lock();
            System.out.println("signalAll_A的时间为：" + System.currentTimeMillis());
            conditionA.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void signalAll_B() {
        try {
            lock.lock();
            System.out.println("signalAll_B的时间为：" + System.currentTimeMillis());
            conditionB.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void awaitA() {
        try {
            lock.lock();
            System.out.println("begin awaitA的时间为：" + System.currentTimeMillis());
            conditionA.await();
            System.out.println("end awaitA的时间为：" + System.currentTimeMillis() +
            " - threadName : " + Thread.currentThread().getName());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void awaitB() {
        try {
            lock.lock();
            System.out.println("begin awaitB的时间为：" + System.currentTimeMillis());
            conditionB.await();
            System.out.println("end awaitB的时间为：" + System.currentTimeMillis() +
                    " - threadName : " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String [] args) throws InterruptedException {

        // 交替打印
        ConditionService cs = new ConditionService();
        ConditionThreadA ca = new ConditionThreadA(cs);
        ca.setName("A");
        ca.start();
        ConditionThreadB cb = new ConditionThreadB(cs);
        cb.setName("B");
        cb.start();

        // 等待通知机制、唤醒
        /*Thread.sleep(3 * 1000);
        cs.signal();*/

        // 使用多个condition通知部分线程
        Thread.sleep(6 * 1000);
        cs.signalAll_A();
        Thread.sleep(2 * 1000);
        cs.signalAll_B();
    }
}
