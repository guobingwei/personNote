package com.dm.yc.std.study.designpattern.strategy;

/**
 * Created by guobingwei on 18/5/16.
 */

/***
 * 封装角色
 */
public class Context {
    private IStrategy strategy;

    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void doSomething() {
        this.strategy.operation();
    }
}
