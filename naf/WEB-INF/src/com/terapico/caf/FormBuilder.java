package com.terapico.caf;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.LocalVariableNode;
import org.objectweb.asm.tree.MethodNode;

import com.terapico.caf.baseelement.Action;
import com.terapico.caf.baseelement.Field;
import com.terapico.caf.baseelement.Form;

public class FormBuilder extends ReflectionTool{
	public Form buildForm(String beanName,Method method, Object []presetParameters) throws IOException{
		Form form=new Form();	
		Type[] methodParameterTypes=method.getGenericParameterTypes();
		List<String> nameList=getParameterNames(method);
		int presetParametersLength=presetParameters.length;
		for(int i=0;i<methodParameterTypes.length;i++){
			Field field=new Field();
			String name=nameList.get(i);
			field.setLabel(name);
			field.setName(name);
			if(i<presetParametersLength){
				field.setDefaultValue(presetParameters[i].toString());
			}
			
			
			field.setType(methodParameterTypes[i]);
			form.addField(field);
		}

		form.addAction(new Action(beanName+"/"+method.getName()));
		return form;
	}
	
	
	
	
	private static Map<Method,List<String>>parameterNamesCache=new ConcurrentHashMap<Method,List<String>>();
	protected static List<String> getParameterNames(Method method) throws IOException  {	

		List<String> cachedParameteNames=parameterNamesCache.get(method);
		if(cachedParameteNames!=null){
			return cachedParameteNames;
		}

		
		Class<?> declaringClass = method.getDeclaringClass();
		ClassLoader declaringClassLoader = declaringClass.getClassLoader();

		org.objectweb.asm.Type declaringType = org.objectweb.asm.Type.getType(declaringClass);
		String url = declaringType.getInternalName() + ".class";

		InputStream classFileInputStream = declaringClassLoader.getResourceAsStream(url);
		if (classFileInputStream == null) {
			throw new IllegalArgumentException(
					"The constructor's class loader cannot find the bytecode that defined the constructor's class (URL: "
							+ url + ")");
		}

		ClassNode classNode;
		try {
			classNode = new ClassNode();
			ClassReader classReader = new ClassReader(classFileInputStream);
			classReader.accept(classNode, 0);
		} finally {
			classFileInputStream.close();
		}

		@SuppressWarnings("unchecked")
		List<MethodNode> methods = classNode.methods;
		for (MethodNode methodNode : methods) {

			if (!isMatch(methodNode, method)) {
				continue;
			}

			org.objectweb.asm.Type[] argumentTypes = org.objectweb.asm.Type.getArgumentTypes(methodNode.desc);
			List<String> parameterNames = new ArrayList<String>(argumentTypes.length);

			@SuppressWarnings("unchecked")
			List<LocalVariableNode> localVariables = methodNode.localVariables;

			if (localVariables.isEmpty()) {
				continue;
			}

			for (int i = 0; i < argumentTypes.length; i++) {
				// The first local variable actually represents the "this"
				// object
				LocalVariableNode lv = localVariables.get(i + 1);
				// parameterNames.add(
				// org.objectweb.asm.Type.getType(lv.desc).getClassName()+" " +
				// lv.name);
				parameterNames.add(lv.name);

			}
			
			parameterNamesCache.put(method, parameterNames);
			
			return parameterNames;

		}

		return null;
	}
	@SuppressWarnings("rawtypes")
	protected static boolean isMatch(MethodNode methodNode, Method method) {

		if (!methodNode.name.equals(method.getName())) {
			return false;
		}

		org.objectweb.asm.Type[] types = org.objectweb.asm.Type.getArgumentTypes(methodNode.desc);
		Class[] parameterTypes = method.getParameterTypes();
		if (types.length != parameterTypes.length) {
			return false;
		}
		for (int i = 0; i < types.length; i++) {
			// Type type=types[i];

			if (types[i] != org.objectweb.asm.Type.getType(parameterTypes[i])) {
				// return false;
			}

		}

		return true;

	}
}
