package com.zyj.spring.postProcessorTest;

import com.zyj.spring.postProcessorTest.config.PostProcessorConfig;
import com.zyj.spring.postProcessorTest.service.Service;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PostProcessorTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PostProcessorConfig.class);
		// 如果MyInstantiationPostProcessor.postProcessAfterInstantiation返回值为false，那么下面的代码会报空指针异常
		context.getBean(Service.class).query();
	}
}
