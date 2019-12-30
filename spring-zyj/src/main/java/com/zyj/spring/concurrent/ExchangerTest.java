package com.zyj.spring.concurrent;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerTest {
	private static final Exchanger<String> exgr = new Exchanger<>();
	private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

	public static void main(String[] args) {
		threadPool.execute(() -> {
			try {
				String A = "银行流水A";
				exgr.exchange(A);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		threadPool.execute(() -> {
			try {
				String B = "银行流水B";
				String A = exgr.exchange(B);
				System.out.println("A = " + A);
				System.out.println("B = " + B);
			} catch (Exception e) {

			}
		});
		threadPool.shutdown();
	}
}
