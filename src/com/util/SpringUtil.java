package com.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
	private static ApplicationContext context;
	static{
		init("application.xml");
	}
	public static void init(String xmlPath){
		context = new ClassPathXmlApplicationContext(xmlPath);
	}
	public static Object getBean(String id){
		return context.getBean(id);
	}
	public static <T> T getBean(Class<T> type){
		return context.getBean(type);
	}
	public static void main(String[] args) {
		SpringUtil.init("application.xml");
	}
}
