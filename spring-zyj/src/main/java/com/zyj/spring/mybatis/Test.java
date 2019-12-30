package com.zyj.spring.mybatis;

import com.zyj.spring.mybatis.config.AppConfig;
import com.zyj.spring.mybatis.service.CardService;
import com.zyj.spring.mybatis.service.Service;
import com.zyj.spring.mybatis.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		context.getBean(CardService.class).query();
		context.getBean(UserService.class).query();
		Service service = (Service) context.getBean("serviceImpl");
		service.query();
	}
}
