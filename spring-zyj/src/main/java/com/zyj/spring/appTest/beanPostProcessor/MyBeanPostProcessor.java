package com.zyj.spring.appTest.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor, PriorityOrdered {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if ("indexService".equals(beanName)) {
			System.out.println("--------------------------");
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if ("indexService".equals(beanName)) {
			System.out.println("++++++++++++++++++++++++++");
		}
		return bean;
	}

	@Override
	public int getOrder() {
		// 返回PostProcessor的执行顺序
		return 101;
	}
}
