package com.zyj.spring.mybatis.utils;

import com.zyj.spring.mybatis.Test;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

public class MyFactoryBean implements FactoryBean {

	private Class clazz;
	public MyFactoryBean(Class clazz) {
		this.clazz = clazz;
	}

	@Override
	public Object getObject() throws Exception {
		Object proxyInstance = Proxy.newProxyInstance(Test.class.getClassLoader(), new Class[]{this.clazz}, new MyInvocationHandler());
		return proxyInstance;
	}

	@Override
	public Class<?> getObjectType() {
		return this.clazz;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
}
