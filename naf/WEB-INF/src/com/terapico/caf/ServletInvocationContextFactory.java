package com.terapico.caf;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
public class ServletInvocationContextFactory  extends ReflectionTool implements InvocationContextFactory {
	private int start = 2;
	private String formBuilderBeanName="formbuilder";
	private String formBuilderMethodName="buildForm";
	
	private BeanFactory beanFactory=null;
	
	
	public BeanFactory getBeaFactory() {
		
		if(beanFactory==null){
			beanFactory=new SpringBeanFactory();
		}
		return beanFactory;
	}
	public void setBeaFactory(BeanFactory beaFactory) {
		this.beanFactory = beaFactory;
	}
	public static final String OVERRIDE_URI="__overrideURI";
	protected String getRequestURI(HttpServletRequest request)
	{
		String overrideURI=(String)request.getAttribute(OVERRIDE_URI);
		
		if(overrideURI!=null){
			return overrideURI;
		}
		return request.getRequestURI();
		
	}
	public InvocationContext create(Object input) throws InvocationException {
		// TODO Auto-generated method stub

		if (input == null) {
			throw new IllegalArgumentException("Could not create the call, the input parameter is null");
		}

		if (!(input instanceof HttpServletRequest)) {
			throw new IllegalArgumentException("Could not create the call context since the type is: "
					+ input.getClass().getName() + ", Expected class: HttpServletRequest");
		}

		HttpServletRequest request = (HttpServletRequest) input;

		List<String> urlElements = parse(getRequestURI(request));

		if (urlElements.size() < start + 1) {
			throw new InvocationException("No sufficient parameter to call");
		}

		Object targetObject = getBean(request, urlElements);

		if (targetObject == null) {
			throw new InvocationException("Not able to find the target object to call: "+request.getRequestURI());
		}

		Method targetMethod = this.getMethod(request, targetObject, urlElements);

		if (targetMethod == null) {
			throw new InvocationException("Not able to find the target method to call： " +request.getRequestURI());
		}
		
		if(!hasSuffientParameters(urlElements,targetMethod)){
			return buildFormContext(getBeanName(urlElements),targetMethod);
		}
	
		Object[] parameters = this.getParameters(request, targetObject, urlElements, targetMethod);

		SimpleInvocationContext context = new SimpleInvocationContext();
		context.setTargetObject(targetObject);
		context.setTargetMethod(targetMethod);
		context.setParameters(parameters);
		return context;

	}
	protected InvocationContext buildFormContext(String beanName,Method targetMethod) throws InvocationException {
		// TODO Auto-generated method stub
		
		SimpleInvocationContext context = new SimpleInvocationContext();
		Object formBuilder =getBean(formBuilderBeanName);
		if(formBuilder==null){
			throw new InvocationException("Form Builder can not be found with the name: "+ formBuilderBeanName);
		}
		
		context.setTargetObject(formBuilder);
		Method method=findSingleMethod(formBuilder,formBuilderMethodName);
		if(method==null){
			throw new InvocationException("Form Builder method can not be found with the name: "+ formBuilderBeanName+"."+formBuilderMethodName);
		}
		
		context.setTargetMethod(method);
		context.setParameters(new Object[]{beanName,targetMethod});
		return context;
	}
	protected boolean hasSuffientParameters(List<String> urlElements,Method targetMethod)
	{
		int size=urlElements.size();
		Type [] parameterTypes=targetMethod.getGenericParameterTypes();
		
		return (size-start-2)==parameterTypes.length;
		
	}
	

	protected Object getBean(HttpServletRequest request, List<String> urlElements) {

		String beanName = urlElements.get(start);
		return getBean(beanName);
	}

	protected String getBeanName(List<String> urlElements) {

		return urlElements.get(start);
		
	}
	protected Object getBean(String beanName) {
		return this.getBeaFactory().getBean(beanName);
	}
	
	protected Object[] getParameters(HttpServletRequest request, Object targetObject, List<String> urlElements,
			Method method) {

		Type []parameterTypes=method.getGenericParameterTypes();
		if(parameterTypes.length==0){
			return new Object[]{};
		}
		// Object [] parameters=new String[urlElements.size()-start-2];
		Object elements[] = urlElements.toArray();
		Object[] parameters = Arrays.copyOfRange(elements, start+2, urlElements.size());
		
		if(parameterTypes.length != parameters.length){
			throw new IllegalArgumentException("The parameter length expect be:"+parameterTypes.length+" but the actual length is:"+parameters.length);
		}
		
		return getParameters(parameterTypes, parameters);

	}
	protected Method getMethod(HttpServletRequest request, Object targetObject, List<String> urlElements)
			throws InvocationException {
		if(urlElements.size()<start + 2){
		
			throw new InvocationException("Not able to get method name, the method name is not specified by the URI!");
			
		}
		String methodName = urlElements.get(start + 1);

		return findSingleMethod(targetObject,methodName);

	}


	protected List<String> parse(String requestURI) throws InvocationException  {

		List<String> parameters = new ArrayList<String>(10);

		String array[] = requestURI.split("/");
		for (int i = 0; i < array.length; i++) {
			
			try {
				String val = URLDecoder.decode(array[i], "UTF-8").trim();
				parameters.add(val);
			} catch (UnsupportedEncodingException e) {
				throw new InvocationException("Encoding UTF-8 is not supported");
			}
			
		}
		// System.out.println(URLDecoder.decode(schema[2],"UTF-8"));
		return parameters;

	}

}
