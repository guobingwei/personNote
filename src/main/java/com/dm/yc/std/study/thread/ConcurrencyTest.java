/**
 * 
 */
package com.dm.yc.std.study.thread;

/**
 * @author guobing
 */
public class ConcurrencyTest {
	private static final long count = 2000000001;
	
	public static void concurrency() throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread thread = new Thread(new Runnable() {
			public void run() {
				int a = 0;
				for(long i = 0; i < count; i++) {
					a += 5;
				}
			}
		});
		
		thread.start();
		int b = 0;
		for(long i = 0; i < count; i++) {
			b--;
		}
		
		// 等待该线程结束之后再执行后面的逻辑
		thread.join();
		long time = System.currentTimeMillis() - start;
		
		System.out.println("concurrency:" + time + "ms,b=" + b);
	}
	
	private static void serial() {
		long start = System.currentTimeMillis();
		int a = 0;
		for(long i = 0; i < count; i++) {
			a += 5;
		}
		int b = 0;
		for(long i = 0; i < count; i++) {
			b--;
		}
		long time = System.currentTimeMillis() - start;
		System.out.println("serial:" + time + "ms,b=" + b + ",a=" + a);
	}
	
	public static void main(String [] args) throws InterruptedException {
		concurrency();
		serial();
	}
}
