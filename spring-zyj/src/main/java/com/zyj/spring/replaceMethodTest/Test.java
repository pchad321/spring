package com.zyj.spring.replaceMethodTest;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Test {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("replaceMethodTest.xml"));
		TestChangeMethod testChangeMethod = factory.getBean(TestChangeMethod.class);
		testChangeMethod.change();
	}
}
