package com.zyj.mybatis.Test;

import com.zyj.mybatis.app.AppConfig;
import com.zyj.mybatis.service.CityService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MybatisTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		CityService service = context.getBean(CityService.class);
		System.out.println(service);
	}
}
