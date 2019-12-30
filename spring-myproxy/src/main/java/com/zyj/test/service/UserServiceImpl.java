package com.zyj.test.service;

import com.zyj.test.dao.UserDao;

public class UserServiceImpl implements UserService {
	UserDao dao;

//	public UserServiceImpl(UserDao dao) {
//		this.dao = dao;
//	}

	@Override
	public void find() {
		dao.query();
		System.out.println("UserServiceImpl");
	}

//	public void setDao(UserDao dao) {
//		this.dao = dao;
//	}
}
