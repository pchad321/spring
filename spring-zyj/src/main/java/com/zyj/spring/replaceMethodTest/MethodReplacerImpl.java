package com.zyj.spring.replaceMethodTest;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class MethodReplacerImpl implements MethodReplacer {
	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println("replace old method");
		return null;
	}
}
