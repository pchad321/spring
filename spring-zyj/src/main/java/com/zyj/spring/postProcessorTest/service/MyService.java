package com.zyj.spring.postProcessorTest.service;

import com.zyj.spring.postProcessorTest.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyService implements Service {
	@Autowired
	Dao dao;

	@Override
	public void query() {
		System.out.println(dao.getClass().getSimpleName());
	}
}
