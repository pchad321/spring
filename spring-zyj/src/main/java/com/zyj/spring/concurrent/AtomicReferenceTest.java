package com.zyj.spring.concurrent;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {
	public static AtomicReference<User> atomicReference = new AtomicReference<>();

	public static void main(String[] args) {
		User user = new User("Jim", 18);
		atomicReference.set(user);
		User updateUser = new User("Tom", 20);
		atomicReference.compareAndSet(user, updateUser);
		System.out.println(atomicReference.get().getName());
		System.out.println(atomicReference.get().getAge());
	}

	static class User {
		private String name;
		private int age;

		public User(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}
	}
}
