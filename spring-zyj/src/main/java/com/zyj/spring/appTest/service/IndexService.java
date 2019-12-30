package com.zyj.spring.appTest.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class IndexService {
	public IndexService() {
		System.out.println("IndexService Constructor");
	}

	@PostConstruct
	public void init() {
		System.out.println("IndexService init");
	}

	public void query() {
		System.out.println("query");
	}
}
