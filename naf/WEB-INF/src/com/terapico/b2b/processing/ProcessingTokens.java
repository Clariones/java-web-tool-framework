
package com.terapico.b2b.processing;
import com.terapico.b2b.CommonTokens;
import java.util.Map;
public class ProcessingTokens extends CommonTokens{

	
	public static ProcessingTokens start(){
		return new ProcessingTokens();
	}
	public static Map <String,Object> all(){
		return new ProcessingTokens()
			.withOrderList()
			.done();
	}
	public static Map <String,Object> withOutLists(){
		return new ProcessingTokens()
			.done();
	}
	public static Map <String,Object> empty(){
		return new ProcessingTokens()
			.done();
	}

	protected static final String ORDER_LIST = "orderList";
	public String getOrderList(){
		return ORDER_LIST;
	}
	public ProcessingTokens withOrderList(){		
		addSimpleOptions(ORDER_LIST);
		return this;
	}	
		
}

