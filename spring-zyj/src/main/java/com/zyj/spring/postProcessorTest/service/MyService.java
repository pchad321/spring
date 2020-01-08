package com.zyj.spring.postProcessorTest.service;

import com.zyj.spring.postProcessorTest.dao.Dao;
import com.zyj.spring.postProcessorTest.dao.MyDao;
import org.springframework.stereotype.Component;

@Component
public class MyService implements Service {
	Dao dao;

	public void setDao(MyDao dao) {
		this.dao = dao;
	}

	@Override
	public void query() {
		dao.query();
	}
}
