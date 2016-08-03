package com.study.thread;

/**
 * Created by guobing on 2016/8/3.
 */
public class ReentrantReadWriteLockThreadB extends Thread{

    private ReentrantReadWriteLockService service;
    public ReentrantReadWriteLockThreadB(ReentrantReadWriteLockService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.write();
    }
}
