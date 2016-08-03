package com.study.thread;

/**
 * Created by guobing on 2016/8/3.
 */
public class ConditionThreadA extends Thread {
    private ConditionService service;
    public ConditionThreadA(ConditionService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
//            service.set();
            service.awaitA();
        }
    }
}
