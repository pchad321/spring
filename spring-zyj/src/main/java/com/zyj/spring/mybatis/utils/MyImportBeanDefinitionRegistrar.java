package com.zyj.spring.mybatis.utils;

import com.zyj.spring.mybatis.dao.CardDao;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(CardDao.class);
		GenericBeanDefinition beanDefinition = (GenericBeanDefinition) builder.getBeanDefinition();
		beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getBeanClassName());
		beanDefinition.setBeanClass(MyFactoryBean.class);
		registry.registerBeanDefinition("cardDao", beanDefinition);
	}
}
