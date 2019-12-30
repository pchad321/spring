package com.zyj.spring.mybatis.service;

import org.springframework.stereotype.Component;

@Component
public class ServiceImpl implements Service {
	@Override
	public void query() {
		System.out.println("serviceImpl query");
	}

	@Override
	public void select() {
		System.out.println("serviceImpl select");
	}
}
