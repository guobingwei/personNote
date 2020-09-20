package com.dm.yc.std.study.designpattern.observa.observer;

/**
 * Created by guobingwei on 18/5/18.
 */
public class WangSi implements Observer {
    @Override
    public void update(String context) {
        System.out.println("wangsi 笑了");
    }
}
