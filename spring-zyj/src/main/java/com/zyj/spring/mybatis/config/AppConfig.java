package com.zyj.spring.mybatis.config;

import com.zyj.spring.mybatis.annotations.EnableUserService;
import com.zyj.spring.mybatis.annotations.MyScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.zyj.spring.mybatis")
@MyScan
@EnableUserService
public class AppConfig {
}
