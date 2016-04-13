package com.terapico.naf.spring;

import com.terapico.naf.ObjectInvokeHelper;

public class SpringInvokeHelper extends ObjectInvokeHelper{

	@Override
	protected Object getObject(String objectPath) {
		// TODO Auto-generated method stub
		SpringBeanFactory factory=new SpringBeanFactory();
		return factory.getBean(objectPath);
	}
	

}
