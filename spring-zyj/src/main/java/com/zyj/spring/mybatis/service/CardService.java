package com.zyj.spring.mybatis.service;

import com.zyj.spring.mybatis.dao.CardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
	@Autowired
	CardDao dao;

	public void query() {
		dao.query();
	}
}
