package com.dm.yc.std.study.thread;

/**
 * Created by guobing on 2016/8/1.
 */
public class MyObject {
    public synchronized void methodSyc() {
        try {
            System.out.println("begin - ThreadName - "
                    + Thread.currentThread().getName());

            Thread.sleep(5 * 1000);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getSycValue() {
        System.out.println(" syc - " + Thread.currentThread().getName());
        return 1;
    }

    /**
     * 证明结论：方法中的变量不存在线程安全问题，永远都是线程安全的
     * @param username
     */
    public void addI(String username) {
        int num = 0;
        try {
            if("a".equals(username)) {
                num = 100;
                System.out.println("a set over");
                Thread.sleep(2 * 1000);
            } else {
                num = 200;
                System.out.println("b set over");
            }

            System.out.println(username + " - num = " + num);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 非线程安全
     * synchronized可以保证线程安全
     */
    int num = 0;
    public void addIUnsafe(String username) {
        try {
            if("a".equals(username)) {
                num = 100;
                System.out.println("a set over");
                Thread.sleep(2 * 1000);
            } else {
                num = 200;
                System.out.println("b set over");
            }

            System.out.println(username + " - num = " + num);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // 脏读问题
    String userName = "A";
    String passWord = "AA";
    synchronized public void setValue(String userName, String passWord) {
        this.userName = userName;
        try {
            Thread.sleep(2 * 2000);
            this.passWord = passWord;

            System.out.println("thread name - " + Thread.currentThread().getName() +
            " - userName - " + userName + " - passWord - " + passWord);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void getValue() {
        System.out.println("thread name - " + Thread.currentThread().getName() +
                " - userName - " + userName + " - passWord - " + passWord);
    }

    synchronized public void service1() {
        System.out.println("service1");
        service2();
    }

    synchronized public void service2() {
        System.out.println("service2");
        service3();
    }

    synchronized public void service3() {
        System.out.println("service3");
    }

    public static void main(String [] args) {
        try {
            Thread.currentThread().sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
