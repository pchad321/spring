package com.zyj.autowired;

import com.zyj.autowired.config.AppConfig;
import com.zyj.autowired.dao.UserDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoWiredTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(context.getBean(UserDao.class).getOrderDao());
	}
}
