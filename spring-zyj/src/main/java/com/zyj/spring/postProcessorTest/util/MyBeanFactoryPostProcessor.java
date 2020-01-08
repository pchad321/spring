package com.zyj.spring.postProcessorTest.util;

import com.zyj.spring.postProcessorTest.service.MyService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyBeanFactoryPostProcessor implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		BeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(MyService.class).getBeanDefinition();
		((AbstractBeanDefinition) beanDefinition).setAutowireMode(2);
		registry.registerBeanDefinition("myService", beanDefinition);
	}
}
