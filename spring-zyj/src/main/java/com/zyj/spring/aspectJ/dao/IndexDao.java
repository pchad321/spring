package com.zyj.spring.aspectJ.dao;

import com.zyj.spring.aspectJ.annotation.MyAnnotation;
import org.springframework.stereotype.Repository;

@Repository("indexDao")
public class IndexDao implements Dao {
	public void query(String str) {
		System.out.println(str);
	}

	@MyAnnotation
	public void query() {
		System.out.println("query");
	}
}
