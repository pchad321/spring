package com.zyj.spring.mybatis.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyServiceImplInvocationHandler implements InvocationHandler {
	Object target;
	public MyServiceImplInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("-------------");
		return method.invoke(target, args);
	}
}
