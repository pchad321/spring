package com.zyj.aspect.dao;

import org.springframework.stereotype.Component;

@Component
public class AspectDao1 implements Dao{
	@Override
	public void query() {
		System.out.println("dao1 query");
	}
}
