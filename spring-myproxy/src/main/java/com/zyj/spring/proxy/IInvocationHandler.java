package com.zyj.spring.proxy;

import java.lang.reflect.Method;

public interface IInvocationHandler {
	Object invoke(Method method, Object... args);
}
