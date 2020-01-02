package com.zyj.aspect;

import com.zyj.aspect.app.AppConfig;
import com.zyj.aspect.service.AspectService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AspectTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		context.getBean(AspectService.class).query("B");
//		context.getBean(Dao.class).query();
	}
}
