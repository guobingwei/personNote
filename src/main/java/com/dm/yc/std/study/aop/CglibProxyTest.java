package com.dm.yc.std.study.aop;

/**
 * cglib 实现AOP
 * Created by guobing on 2016/4/27.
 */
public class CglibProxyTest {
    public static void main(String [] args) {

        CglibProxy proxy = new CglibProxy();

        // base为生成的增强过的目标类
        CglibBase cglibBase = Factory.getInstance(proxy);
        cglibBase.add();
    }
}
