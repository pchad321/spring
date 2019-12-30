package com.zyj.spring.concurrent;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {
	static int[] value = new int[]{1, 2};
	static AtomicIntegerArray aia = new AtomicIntegerArray(value);

	public static void main(String[] args) {
		aia.getAndSet(0, 4);
		System.out.println(aia.get(0));
		System.out.println(value[0]);
	}
}
