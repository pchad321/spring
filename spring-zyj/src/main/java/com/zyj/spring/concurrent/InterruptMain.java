package com.zyj.spring.concurrent;

public class InterruptMain {
	public static void main(String[] args) {
		InterruptTest test = new InterruptTest();
		test.start();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {

		}
		test.interrupt();
	}
}
