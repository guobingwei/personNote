package com.study.DesignPattern;

/**
 * 单例类深入分析
 * 1、非延迟加载 - 饿汉式
 * 2、延迟加载 - 懒汉式
 * Created by guobing on 2016/4/8.
 */
public class Singleton {
    private Singleton() {
        // private constructor
    }

    private static Singleton instance;
    /**
     *  1、普通做法，存在线程安全问题  - 延迟加载
     *  懒汉式
     */
    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static void main(String [] args) {
        Singleton.getInstance();
        Enum a = SingletonEnum.INSTANCE;
    }

    /**
     * 2、懒汉式
     *  通过同步方法来实现单例，但是性能开销很大 - 同步延迟加载
     *  由于对getInstance()做了同步处理，synchronized将导致性能开销。
     *  如果getInstance()被多个线程频繁的调用，将会导致程序执行性能的下降。
     *  反之，如果getInstance()不会被多个线程频繁的调用，那么这个延迟初始化方案将能提供令人满意的性能。
     */
    public static synchronized Singleton getInstanceSyn() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    /**
     * 3、双重入检查锁
     * 懒汉式
     * 第一次检查不加锁，第二次枷锁。用了volatile变量来防止处理器重排序
     */
    private volatile static Singleton instanceVola;
    public static Singleton getInstanceVola() {
        if(instanceVola == null) {
            synchronized(Singleton.class) {
                if(instanceVola == null) {
                    instanceVola = new Singleton();
                }
            }
        }
        return instanceVola;
    }

    /**
     * 错误写法
     * 4、懒汉式
     * instanceError 不是 volatile类型，双重检测不能保证线程安全
     * new Singleton()用伪代码可以这样表示
     * 1、为单例类分配内存空间
     * 2、把引用指向该内存空间
     * 3、调用构造函数
     * 2.3是可以重排序的。所以存在问题
     */
    private static Singleton instanceError;
    public static Singleton getInstanceError() {
        if(instanceError == null) {
            synchronized (Singleton.class) {
                if(instanceError == null) {
                    instanceError = new Singleton();
                }
            }
        }
        return instanceError;
    }

    /**
     * 5、饿汉式 非延迟加载
     * 类初始化的时候就创建了实例
     * 利用类加载机制实现线程安全
     */
    private static Singleton instanceUnlazy = new Singleton();
    public static Singleton getInstanceUnlazy() {
        return instanceUnlazy;
    }

    /**
     * 6、静态内部类
     * 懒汉式
     * 只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用。
     */
    public static class SingletonHolder {
        private static final Singleton SINGLETON = new Singleton();
        public static final Singleton getSingleton() {
            return SingletonHolder.SINGLETON;
        }
    }
}
