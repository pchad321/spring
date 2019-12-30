package com.zyj.spring.appTest;

import com.zyj.spring.appTest.config.AppConfig;
import com.zyj.spring.appTest.service.IndexService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//		context.scan("com");
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		context.register(IndexService.class);
//		context.refresh();
//		IndexService service = context.getBean(IndexService.class);
//		service.query();
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		IndexService service = context.getBean(IndexService.class);
	}
}
