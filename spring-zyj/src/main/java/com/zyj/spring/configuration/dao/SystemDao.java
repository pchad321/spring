package com.zyj.spring.configuration.dao;

public class SystemDao implements Dao {

	public SystemDao() {
		System.out.println("systemDao init");
	}

	@Override
	public void query() {
		System.out.println("systemDao query");
	}
}
