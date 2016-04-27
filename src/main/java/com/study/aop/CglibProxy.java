package com.study.aop;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 实现动态代理类CglibProxy，需要实现MethodInterceptor接口，实现intercept方法。
 * 该代理中在add方法前后加入了自定义的切面逻辑，
 * 目标类add方法执行语句为proxy.invokeSuper(object, args);
 * Created by guobing on 2016/4/27.
 */
public class CglibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 添加切面逻辑（advise），此处是在目标类代码执行之前，即为MethodBeforeAdviceInterceptor。
        System.out.println("cglib before-------------");
        // 执行目标类add方法
        methodProxy.invokeSuper(o, objects);
        // 添加切面逻辑（advise），此处是在目标类代码执行之后，即为MethodAfterAdviceInterceptor。
        System.out.println("cglib after--------------");
        return null;
    }
}
