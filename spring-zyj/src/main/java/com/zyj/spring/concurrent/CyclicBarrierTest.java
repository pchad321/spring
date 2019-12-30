package com.zyj.spring.concurrent;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	static class TaskThread extends Thread {
		CyclicBarrier barrier;

		public TaskThread(CyclicBarrier barrier) {
			this.barrier = barrier;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(1000);
				System.out.println(getName() + "到达栏栅A");
				barrier.await();
				System.out.println(getName() + "冲破栏栅A");

				Thread.sleep(2000);
				System.out.println(getName() + "到达栏栅B");
				barrier.await();
				System.out.println(getName() + "冲破栏栅B");
			} catch (Exception e) {

			}
		}
	}

	public static void main(String[] args) {
		int num = 5;
		CyclicBarrier barrier = new CyclicBarrier(num, () -> {
			System.out.println(Thread.currentThread().getName() + "完成最后的任务");
		});

		for (int i = 0; i < num; i++) {
			new TaskThread(barrier).start();
		}
	}
}
