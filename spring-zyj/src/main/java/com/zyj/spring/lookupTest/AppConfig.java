package com.zyj.spring.lookupTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;

@ComponentScan
public class AppConfig {

	@Bean
	@Primary
	public Teacher teacher() {
		return new Teacher();
	}

	@Bean
	public Student student() {
		return new Student();
	}
}
