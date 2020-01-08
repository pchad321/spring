package com.zyj.spring.postProcessorTest.config;

import com.zyj.spring.postProcessorTest.util.MyBeanFactoryPostProcessor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.zyj.spring.postProcessorTest")
@Import(MyBeanFactoryPostProcessor.class)
public class PostProcessorConfig {
}
