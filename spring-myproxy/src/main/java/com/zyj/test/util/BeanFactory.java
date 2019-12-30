package com.zyj.test.util;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class BeanFactory {
	ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();

	public BeanFactory(String xmlFilePath) throws SpringException {
		parseXml(xmlFilePath);
	}

	public void parseXml(String xmlFilePath) throws SpringException {
		String classPath = this.getClass().getResource("/").getPath();
		File file = new File(classPath.substring(0, classPath.length() - 8) + "resources/" + xmlFilePath);
		SAXReader reader = new SAXReader();
		try {
			/**
			 *  1. 实例化对象
			 *  2. 判断是否有property
			 */
			Document document = reader.read(file);
			Element root = document.getRootElement();
			Attribute attribute = root.attribute("default-autowire");
			boolean defaultAutowireFlag = false;
			if (attribute != null) {
				defaultAutowireFlag = true;
			}

			for (Iterator<Element> itFirst = root.elementIterator(); itFirst.hasNext(); ) {
				Element elementFirstChild = itFirst.next();
				Attribute id = elementFirstChild.attribute("id");
				Attribute className = elementFirstChild.attribute("class");
				String idString = id.getValue();
				String classNameString = className.getValue();
				Class clazz = Class.forName(classNameString);
				Object object = null;

				for (Iterator<Element> itSecond = elementFirstChild.elementIterator(); itSecond.hasNext(); ) {
					Element elementSecondChild = itSecond.next();
					if ("property".equals(elementSecondChild.getName())) {
						/**
						 * 使用第一种方式 setter
						 */
						object = clazz.newInstance();
						Attribute ref = elementSecondChild.attribute("ref");
						Attribute refName = elementSecondChild.attribute("name");
						Object refObject = map.get(ref.getValue());
						Field field = clazz.getDeclaredField(refName.getValue());
						field.setAccessible(true);
						field.set(object, refObject);
					} else {
						/**
						 * 使用第二种方式 constructor
						 */
						Attribute ref = elementSecondChild.attribute("ref");
						Attribute refName = elementSecondChild.attribute("name");
						Object refObject = map.get(ref.getValue());
						Class refClass = clazz.getDeclaredField(refName.getValue()).getType();
						Constructor constructor = clazz.getConstructor(refClass);
						object = constructor.newInstance(refObject);
					}
				}

				if (defaultAutowireFlag && object == null) {
					if ("byType".equals(attribute.getValue())) {
						Field[] fields = clazz.getDeclaredFields();
						for (Field field : fields) {
							Class fieldClass = field.getType();

							int count = 0;
							Object injectObject = null;
							for (String key : map.keySet()) {
								Class tempClass = map.get(key).getClass().getInterfaces()[0];
								if (tempClass.hashCode() == tempClass.hashCode()) {
									injectObject = map.get(key);
									count++;
								}
							}

							if (count > 1) {
								throw new SpringException("need one but find two!");
							} else {
								object = clazz.newInstance();
								field.setAccessible(true);
								field.set(object, injectObject);
							}
						}
					}
				}

				if (object == null) {
					object = clazz.newInstance();
				}

				map.put(idString, object);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Object getBean(String beanName) {
		return map.get(beanName);
	}
}
