package com.zyj.spring.lookupTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LookupTest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		GetBeanTest getBeanTest = context.getBean(GetBeanTest.class);
		getBeanTest.show();
	}
}
