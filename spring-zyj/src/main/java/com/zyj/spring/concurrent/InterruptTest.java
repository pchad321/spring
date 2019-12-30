package com.zyj.spring.concurrent;

public class InterruptTest extends Thread {
	public static int i = 0;

	@Override
	public void run() {
		try {
			while (true) {
				if (Thread.currentThread().isInterrupted() == true) {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
}
