package com.zyj.spring.dao;

public interface Dao {
	String query(String name, int age) throws Exception;

	void query() throws Exception;
}
