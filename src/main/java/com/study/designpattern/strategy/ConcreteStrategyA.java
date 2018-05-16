package com.study.designpattern.strategy;

/**
 * Created by guobingwei on 18/5/16.
 */
public class ConcreteStrategyA implements IStrategy {
    @Override
    public void operation() {
        System.out.println("A");
    }
}
