package com.zyj.spring;

import com.zyj.spring.dao.Dao;
import com.zyj.spring.dao.UserDao;
import com.zyj.spring.proxy.MyInvocationHandler;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.Proxy;

public class Test {
	public static void main(String[] args) throws Exception{
		// 使用自定义动态代理
//		Dao dao = (Dao) ProxyUtil.newInstance(Dao.class, new InvocationHandlerImpl(new UserDao()));
//		System.out.println(dao.query("Tom", 19));
//		dao.query();
//
//		System.out.println("*********************************************");
		// 使用jdk的动态代理
		Dao daoJdk = (Dao) Proxy.newProxyInstance(Test.class.getClassLoader(), new Class[]{Dao.class}, new MyInvocationHandler(new UserDao()));
		daoJdk.query();
		System.out.println(daoJdk.query("Jim", 20));
		byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy", new Class[]{UserDao.class});
		FileOutputStream os = new FileOutputStream("E:\\$Proxy.class");
		os.write(bytes);
		os.flush();
	}
}
