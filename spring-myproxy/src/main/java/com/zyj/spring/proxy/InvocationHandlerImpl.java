package com.zyj.spring.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvocationHandlerImpl implements IInvocationHandler {
	private Object target;
	public InvocationHandlerImpl(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Method method, Object... args) {
		try {
			return method.invoke(target, args);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
}
