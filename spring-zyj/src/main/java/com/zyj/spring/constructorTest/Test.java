package com.zyj.spring.constructorTest;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Test {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("constructorTest.xml"));
		Teacher teacher = factory.getBean(Teacher.class);
		teacher.introduce();
	}
}
