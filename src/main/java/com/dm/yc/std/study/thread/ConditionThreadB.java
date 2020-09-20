package com.dm.yc.std.study.thread;

/**
 * Created by guobing on 2016/8/3.
 */
public class ConditionThreadB extends Thread {
    private ConditionService service;
    public ConditionThreadB(ConditionService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
//            service.get();
            service.awaitB();
        }
    }
}
