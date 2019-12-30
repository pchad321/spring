package com.zyj.test;

import com.zyj.test.service.UserService;
import com.zyj.test.util.BeanFactory;
import com.zyj.test.util.SpringException;

public class Test {
	public static void main(String[] args) throws SpringException {
		BeanFactory factory = new BeanFactory("spring.xml");
		UserService service = (UserService) factory.getBean("service");
		service.find();
	}
}
