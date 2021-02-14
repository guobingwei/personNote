package com.dm.yc.std.study.designpattern.proxy;

/**
 * Created with IntelliJ IDEA.
 * Created by weiguobing on 2021-02-14.   11:39
 * email : weiguobing@meituan.com
 */
public class AliSmsService {

	public String send(String message) {
		System.out.println("send message:" + message);
		return message;
	}

	public static void main(String[] args) {
		AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
		aliSmsService.send("java");
	}
}
