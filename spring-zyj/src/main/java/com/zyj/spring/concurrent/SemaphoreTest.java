package com.zyj.spring.concurrent;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class SemaphoreTest<T> {
	private final Set<T> set;
	private final Semaphore sem;

	public SemaphoreTest(int bound) {
		this.set = Collections.synchronizedSet(new HashSet<T>());
		sem = new Semaphore(bound);
	}

	public boolean add(T t) throws Exception {
		sem.acquire();
		boolean wasAdded = false;
		try {
			wasAdded = set.add(t);
			return wasAdded;
		} finally {
			if (!wasAdded) {
				sem.release();
			}
		}
	}

	public boolean remove(Object o) {
		boolean wasRemoved = set.remove(o);
		if (wasRemoved)
			sem.release();
		return wasRemoved;
	}
}
