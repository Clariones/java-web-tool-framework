package com.terapico.naf.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class SpringBeanFactory {
	AbstractApplicationContext context; 
	public SpringBeanFactory(){
		context = new ClassPathXmlApplicationContext("classpath*:/META-INF/spring.xml");		
	}


	public Object getBean(String beanName) {
		// TODO Auto-generated method stub
		return context.getBean(beanName);
	}
	
	
	public String[] getBeanNames() {
		// TODO Auto-generated method stub
		return context.getBeanDefinitionNames();
	}
	
}
