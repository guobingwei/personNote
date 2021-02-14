package com.dm.yc.std.study.designpattern.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Created by weiguobing on 2021-02-14.   11:40
 * email : weiguobing@meituan.com
 */
public class DebugMethodInterceptor implements MethodInterceptor {

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

		//调用方法之前，我们可以添加自己的操作
		System.out.println("before method " + method.getName());

		Object object = methodProxy.invokeSuper(o, objects);

		//调用方法之后，我们同样可以添加自己的操作
		System.out.println("after method " + method.getName());
		return object;
	}
}
