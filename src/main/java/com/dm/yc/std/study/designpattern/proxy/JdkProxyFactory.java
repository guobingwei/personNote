package com.dm.yc.std.study.designpattern.proxy;

import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * Created by weiguobing on 2021-02-14.   11:29
 * email : weiguobing@meituan.com
 */
public class JdkProxyFactory {

	public static Object getProxy(Object target) {

		return Proxy.newProxyInstance(
				target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
				new DebugInvocationHandler(target)
		);
	}
}
