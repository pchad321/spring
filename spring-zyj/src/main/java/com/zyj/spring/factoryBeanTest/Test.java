package com.zyj.spring.factoryBeanTest;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Test {
	public static void main(String[] args) throws Exception{
		// 如果在beanName前加上&，那么返回CarFactoryBean的实例；
		// 如果不加上&，那么Spring容器调用接口方法CarFactoryBean#getObject()方法返回
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("factoryBeanTest.xml"));
		CarFactoryBean carFactoryBean = (CarFactoryBean) factory.getBean("&car");
		Car car = carFactoryBean.getObject();
		System.out.println(car.getBrand());

		Car car1 = (Car) factory.getBean("car");
		System.out.println(car1.getBrand());
	}
}
