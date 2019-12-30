package com.zyj.spring.xmlTest;

import com.zyj.spring.TestBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class XmlTest {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
		TestBean testBean = (TestBean) factory.getBean("testBean");
		System.out.println(testBean.getTestStr());
	}
}
