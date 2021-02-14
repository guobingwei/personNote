package com.dm.yc.std.study.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Created by weiguobing on 2021-02-14.   11:27
 * email : weiguobing@meituan.com
 */
public class DebugInvocationHandler implements InvocationHandler {

	private final Object target;

	public DebugInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		//调用方法之前，我们可以添加自己的操作
		System.out.println("before method " + method.getName());
		Object result = method.invoke(target, args);

		//调用方法之后，我们同样可以添加自己的操作
		System.out.println("after method " + method.getName());

		return result;
	}
}
