package com.study.thread;

/**
 * Created by guobing on 2016/8/1.
 */
public class ThreadA extends Thread {
    private MyObject myObject;

    public ThreadA(MyObject myObject) {
        super();
        this.myObject = myObject;
    }

    public void run() {
        super.run();

        myObject.methodSyc();
//        myObject.getSycValue();

//        myObject.addIUnsafe("a");

//        myObject.setValue("B", "BB");

//        myObject.service1();

    }

    public static void main(String [] args) {
        // 不同线程访问同一个对象的情况
        /*MyObject myObject = new MyObject();
        ThreadA a = new ThreadA(myObject);
        a.setName("A");
        ThreadB b = new ThreadB(myObject);
        b.setName("B");
        a.start();
        b.start();*/


        // 不同线程访问不同对象，应该是没有线程安全问题的
        /*MyObject obj1 = new MyObject();
        MyObject obj2 = new MyObject();
        ThreadA t1 = new ThreadA(obj1);
        t1.setName("A");
        ThreadB t2 = new ThreadB(obj2);
        t2.setName("B");
        t1.start();
        t2.start();*/

        // 测试脏读问题
        /*MyObject obj1 = new MyObject();
        ThreadA t1 = new ThreadA(obj1);
//        obj1.getValue();

        t1.start();

        try {
            Thread.sleep(2 * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        obj1.getValue();*/

        // 可重入锁问题
        MyObject obj1 = new MyObject();
        ThreadA t1 = new ThreadA(obj1);
        ThreadB t2 = new ThreadB(obj1);
        t1.start();
        t2.start();
    }

}
