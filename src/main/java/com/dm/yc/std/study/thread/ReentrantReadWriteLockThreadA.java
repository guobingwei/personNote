package com.dm.yc.std.study.thread;

/**
 * Created by guobing on 2016/8/3.
 */
public class ReentrantReadWriteLockThreadA extends Thread {
    private ReentrantReadWriteLockService service;
    public ReentrantReadWriteLockThreadA(ReentrantReadWriteLockService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.write();
    }
}
