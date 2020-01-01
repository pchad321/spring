package com.zyj.aspect.dao;

import org.springframework.stereotype.Component;

@Component("aspectDao")
public class AspectDao implements Dao {
	@Override
	public void query() {
		System.out.println("query");
	}
}
