package com.dm.yc.std.study.designpattern.proxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created with IntelliJ IDEA.
 * Created by weiguobing on 2021-02-14.   11:43
 * email : weiguobing@meituan.com
 */
public class CglibProxyFactory {

	public static Object getProxy(Class<?> clazz) {
		// 创建动态代理增强类
		Enhancer enhancer = new Enhancer();
		// 设置类加载器
		enhancer.setClassLoader(clazz.getClassLoader());
		// 设置被代理类
		enhancer.setSuperclass(clazz);
		// 设置方法拦截器
		enhancer.setCallback(new DebugMethodInterceptor());
		// 创建代理类
		return enhancer.create();
	}
}