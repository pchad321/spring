package com.zyj.spring.mybatis.service;

import com.zyj.spring.mybatis.Test;
import com.zyj.spring.mybatis.utils.MyServiceImplInvocationHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

@Component
public class ServiceImplPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if ("serviceImpl".equals(beanName)) {
			bean = Proxy.newProxyInstance(Test.class.getClassLoader(), new Class[]{Service.class}, new MyServiceImplInvocationHandler(bean));
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return null;
	}
}
