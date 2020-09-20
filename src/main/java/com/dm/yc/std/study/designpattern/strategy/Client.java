package com.dm.yc.std.study.designpattern.strategy;

/**
 * Created by guobingwei on 18/5/16.
 */

/***
 * 高层模块
 */
public class Client {

    public static void main(String[] args) {
        // 具体算法
        ConcreteStrategyA concreteStrategyA = new ConcreteStrategyA();

        // 上下文对象
        Context context = new Context(concreteStrategyA);

        // 执行封装后的方法
        context.doSomething();
    }
}
