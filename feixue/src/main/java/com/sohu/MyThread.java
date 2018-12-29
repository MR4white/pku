package com.sohu;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThread extends Thread {
	private int time;

	public static void main(String[] args) throws InterruptedException {
		ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 20, 0, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<Runnable>(10));
		for (int i = 0; i < 10; i++) {
			pool.execute(new MyThread(i, "Thread " + i));
		}
		
		while(true) {
			long ctc = pool.getCompletedTaskCount();
			long tc = pool.getTaskCount();
			if (ctc == tc) {
				System.out.println("pool finished");
				break;
			} else {
				System.err.println(ctc + " -- " + tc);
			}
			Thread.sleep(100);
		}
		
//		pool.shutdown();
//		System.err.println(pool.isShutdown());
//		System.err.println(pool.isTerminated());
//		System.err.println(pool.isTerminating());
		
//		while (true) {
//			if (pool.isTerminated()) {
//				System.err.println("pool emptry");
//				break;
//			} else {
//				System.err.println("pool hold");
//				Thread.sleep(100);
//			}
//		}
	}

	@Override
	public void run() {
		try {
			Thread.sleep(time * 1000);
			System.out.println(Thread.currentThread().getName() + " finished");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public MyThread(int time, String name) {
		this.time = time;
		setName(name);
	}
}
