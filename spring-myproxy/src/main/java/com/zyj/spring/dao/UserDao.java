package com.zyj.spring.dao;

public class UserDao implements Dao {
	@Override
	public String query(String name, int age) throws Exception {
		System.out.println("查询用户信息。。。");
		System.out.println("用户信息为：");
		System.out.println("姓名：" + name + ", 年龄：" + "age");
		return name;
	}

	@Override
	public void query() throws Exception {
		System.out.println("query....");
	}
}
