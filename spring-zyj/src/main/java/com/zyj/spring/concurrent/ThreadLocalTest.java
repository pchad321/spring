package com.zyj.spring.concurrent;

import java.util.concurrent.CountDownLatch;

public class ThreadLocalTest {
	public static int num = 0;

	public static void joinTest() throws Exception {
		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 100000; i++) {
//				System.out.println("Thread1 ------ " + i);
				num++;
			}
		});

		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 100000; i++) {
//				System.out.println("Thread2 ------ " + i);
				num++;
			}
		});

		Thread thread3 = new Thread(() -> {
			for (int i = 0; i < 100000; i++) {
//				System.out.println("Thread3 ------ " + i);
				num++;
			}
		});

		thread1.start();
		thread2.start();
		thread3.start();
		thread1.join();
		thread2.join();
		thread3.join();
//		System.out.println("++++++++");
		System.out.println(num);
	}

	public static void countDownTest() throws Exception {
		CountDownLatch latch = new CountDownLatch(3);
		for (int i = 0; i < 3; i++) {
			Thread thread = new Thread(() -> {
				for (int j = 0; j < 100000; j++) {
					num++;
				}
			});
			thread.start();
			latch.countDown();
		}

		latch.await();
		System.out.println(num);
	}

	public static void main(String[] args) throws Exception {
//		joinTest();
		countDownTest();
	}
}
