package com.terapico.naf;

import java.lang.reflect.Type;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.terapico.naf.parameter.Parameter;
import com.terapico.naf.parameter.ParameterManager;
import com.terapico.naf.parameter.PersistantParameterManager;

public class ParameterSaveInvokeHelper extends InvokeHelper{
	ParameterManager manager;
	public ParameterSaveInvokeHelper() throws UnknownHostException {
		super();
		manager=new PersistantParameterManager();
		// TODO Auto-generated constructor stub
	}
	
	protected void saveParameters(Type[] methodParameterTypes,List<String> nameList,Object []parameters)
	{
		
		try{
			manager.saveParameters(methodParameterTypes, nameList.toArray(new String[0]),parameters);
		}catch(Exception e){
			this.logln("保存出错");
		}
		
	}
	/*
	 * 
	 * 	private void logln(String requestURI) {
		// TODO Auto-generated method stub
		System.out.println(requestURI);
		if (furi.getServiceName().equals("suggestParameter")) {
				return BaseInvokeResult.createInstance(this.getSuggestedParameter(furi.getParameter()),"Parameter$List");
			}
			if (furi.getServiceName().equals("removeParameter")) {
				return BaseInvokeResult.createInstance(this.removeParameter(furi.getParameter()),"ServerMessage");
			}
			if (furi.getServiceName().equals("allParameters")) {
				return BaseInvokeResult.createInstance(this.getAllParameters(),"Type_ParameterList$Map");
			}
		
		
	}
	 * 
	 * */
	private Object removeParameter(String[] parameter) {
		// TODO Auto-generated method stub
		
		if(parameter.length<1){			
			return "not suffient parameter: "+parameter.length ;			
		}
		manager.removeParameter(parameter[0]);
		return "parameter removed";
	}



	private List<Parameter> getSuggestedParameter(String[] parameter) throws Exception {
		// TODO Auto-generated method stub	
		
		if(parameter.length<2){			
			return new ArrayList<Parameter> ();			
		}
		List<Parameter> parameterGroup= manager.findParameter(parameter[0],parameter[1]);
		if(parameterGroup==null){			
			return new ArrayList<Parameter> ();			
		}
		return parameterGroup;
	}
	
	private Map<Type, List<Parameter>> getAllParameters() throws Exception{
		// TODO Auto-generated method stub
		
		return manager.getParameters();
		
	}

}
