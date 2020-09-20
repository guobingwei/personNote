package com.dm.yc.std.study.aop;

import org.springframework.cglib.proxy.Enhancer;

/**
 * 获得增强之后的目标类，即添加了切入逻辑advice之后的目标类
 * Created by guobing on 2016/4/27.
 */
public class Factory {
    public static CglibBase getInstance(CglibProxy cglibProxy) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CglibBase.class);

        //回调方法的参数为代理类对象CglibProxy，最后增强目标类调用的是代理类对象CglibProxy中的intercept方法
        enhancer.setCallback(cglibProxy);

        // 此刻，base不是单纯的目标类，而是增强过的目标类
        CglibBase cglibBase = (CglibBase)enhancer.create();

        return cglibBase;
    }
}
