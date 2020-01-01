package com.zyj.aspect.service;

import com.zyj.aspect.dao.AspectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AspectService {
	@Autowired
	AspectDao dao;
	public void query() {
		dao.query();
	}
}
