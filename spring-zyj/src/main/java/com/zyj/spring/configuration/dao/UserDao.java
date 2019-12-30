package com.zyj.spring.configuration.dao;

public class UserDao implements Dao {

	public UserDao() {
		System.out.println("userDao init");
	}

	@Override
	public void query() {
		System.out.println("userDao query");
	}
}
