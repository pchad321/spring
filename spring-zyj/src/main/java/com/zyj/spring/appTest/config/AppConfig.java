package com.zyj.spring.appTest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(value = "com.zyj.spring")
@EnableAspectJAutoProxy
public class AppConfig {

}
