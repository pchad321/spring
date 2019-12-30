package com.zyj.spring.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest extends RecursiveTask<Integer> {
	private static final int THRESHOLD = 2;
	private int start;
	private int end;

	public ForkJoinTest(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		boolean canCompute = (end - start) <= THRESHOLD;
		if (canCompute) {
			for (int i = start; i <= end; i++) {
				sum += i;
			}
		} else {
			int middle = (start + end) / 2;
			ForkJoinTest leftTask = new ForkJoinTest(start, middle);
			ForkJoinTest rightTask = new ForkJoinTest(middle + 1, end);
			leftTask.fork();
			rightTask.fork();
			int leftResult = leftTask.join();
			int rightResult = rightTask.join();
			sum = leftResult + rightResult;
		}

		return sum;
	}

	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		ForkJoinTest task = new ForkJoinTest(1, 4);
		Future<Integer> result = forkJoinPool.submit(task);
		try {
			System.out.println(result.get());
		} catch(Exception e) {

		}
	}
}
