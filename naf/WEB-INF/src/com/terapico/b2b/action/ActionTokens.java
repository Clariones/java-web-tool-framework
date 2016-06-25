
package com.terapico.b2b.action;
import com.terapico.b2b.CommonTokens;
import java.util.Map;
public class ActionTokens extends CommonTokens{

	
	public static ActionTokens start(){
		return new ActionTokens();
	}
	public static Map <String,Object> all(){
		return new ActionTokens()
			.withBo()
			.done();
	}
	public static Map <String,Object> withOutLists(){
		return new ActionTokens()
			.withBo()
			.done();
	}
	public static Map <String,Object> empty(){
		return new ActionTokens()
			.done();
	}

	protected static final String BO = "bo";
	public String getBo(){
		return BO;
	}
	public ActionTokens withBo(){		
		addSimpleOptions(BO);
		return this;
	}
	
	
}






