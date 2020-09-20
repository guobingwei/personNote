package com.dm.yc.std.study.aop;

/**
 * cglib动态代理实现AOP拦截
 * 目标类，cglib不需要定义目标类的统一接口
 * Created by guobing on 2016/4/27.
 */
public class CglibBase {
    public void add() {
        System.out.println("cglib add -------------");
    }
}
