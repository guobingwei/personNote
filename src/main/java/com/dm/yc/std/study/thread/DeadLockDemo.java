/**
 * 
 */
package com.dm.yc.std.study.thread;

/**
 * @author guobing
 */
public class DeadLockDemo {
	private final String A = "A";
	private final String B = "B";
	
	private void deadLock() {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(A) {
					try {
						Thread.currentThread().sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized(B) {
						System.out.println("A");
					}
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(B) {
					synchronized(A) {
						System.out.println("2");
					}
				}
			}
			
		});
	}
	
	public static void main(String [] args) {
		new DeadLockDemo().deadLock();
	}
}
