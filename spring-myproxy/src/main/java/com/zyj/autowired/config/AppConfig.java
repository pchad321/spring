package com.zyj.autowired.config;

import com.zyj.autowired.util.MyScanRegistrar;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.zyj.autowired")
@Import(MyScanRegistrar.class)
public class AppConfig {

}