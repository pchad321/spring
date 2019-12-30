package com.zyj.spring.configuration.config;


import com.zyj.spring.configuration.dao.SystemDao;
import com.zyj.spring.configuration.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 有没有添加@Configuration输出结果是不一样的
 * 当添加了@Configuration时，手动调用的userDao()方法是已经被动态代理代理过后的方法
 * 如果userDao()方法是一个静态方法呢？
 */

@ComponentScan("com.zyj.spring.configuration")
@Configuration
public class AppConfig {
	@Bean
	public UserDao userDao() {
		return new UserDao();
	}

	@Bean
	public SystemDao systemDao() {
		System.out.println("----- before -----");
		userDao();
		System.out.println("----- after -----");
		return new SystemDao();
	}
}
