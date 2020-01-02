package com.zyj.aspect.service;

import com.zyj.aspect.dao.Dao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AspectService implements ApplicationContextAware {
	ApplicationContext applicationContext;

	@Autowired
	private Map<String, Dao> map;
	public void query(String name) {
		if ("A".equals(name)) {
			Dao dao = (Dao) this.applicationContext.getBean("aspectDao");
			dao.query();
		} else if ("B".equals(name)) {
			Dao dao = (Dao) this.applicationContext.getBean("aspectDao1");
			dao.query();
		} else {
			System.out.println("not matched");
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
