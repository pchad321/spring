package com.zyj.spring.concurrent;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterTest {
	private static AtomicIntegerFieldUpdater<User> aifu =
			AtomicIntegerFieldUpdater.newUpdater(User.class, "age");

	public static void main(String[] args) {
		User user = new User("Tom", 20);
		System.out.println(aifu.getAndIncrement(user));
		System.out.println(aifu.get(user));
	}

	public static class User {
		private String name;
		public volatile int age;

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
