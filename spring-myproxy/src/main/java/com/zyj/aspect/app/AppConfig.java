package com.zyj.aspect.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.zyj.aspect")
@EnableAspectJAutoProxy
public class AppConfig {
}
