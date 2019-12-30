package com.zyj.spring.aspectJ;

import com.zyj.spring.aspectJ.config.AppConfig;
import com.zyj.spring.aspectJ.dao.Dao;
import com.zyj.spring.aspectJ.dao.IndexDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Dao dao = (Dao) context.getBean("indexDao");
		// 为什么输出false？
		// 这是由于spring默认使用jdk的动态代理实现aop，所以这里的dao是Dao的实例也是Proxy的实例
		System.out.println(dao instanceof IndexDao);
		dao.query("Hello");
		dao.query();
	}
}
