package com.zyj.spring.postProcessorTest.dao;

import org.springframework.stereotype.Component;

@Component
public class MyDao implements Dao {
	@Override
	public void query() {
		System.out.println("mydao query");
	}
}
