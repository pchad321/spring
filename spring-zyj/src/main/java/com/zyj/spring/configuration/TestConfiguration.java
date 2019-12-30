package com.zyj.spring.configuration;

import com.zyj.spring.configuration.config.AppConfig;
import com.zyj.spring.configuration.dao.Dao;
import com.zyj.spring.configuration.dao.UserDao;
import com.zyj.spring.configuration.util.MyMethodInterceptor;
import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestConfiguration {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("---------------------------------");
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(UserDao.class);
		enhancer.setUseFactory(false);
		enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
		enhancer.setCallback(new MyMethodInterceptor());
		Dao dao = (Dao) enhancer.create();
		dao.query();
	}
}
