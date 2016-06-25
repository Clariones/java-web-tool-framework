
package com.terapico.b2b.confirmation;
import com.terapico.b2b.CommonTokens;
import java.util.Map;
public class ConfirmationTokens extends CommonTokens{

	
	public static ConfirmationTokens start(){
		return new ConfirmationTokens();
	}
	public static Map <String,Object> all(){
		return new ConfirmationTokens()
			.withOrderList()
			.done();
	}
	public static Map <String,Object> withOutLists(){
		return new ConfirmationTokens()
			.done();
	}
	public static Map <String,Object> empty(){
		return new ConfirmationTokens()
			.done();
	}

	protected static final String ORDER_LIST = "orderList";
	public String getOrderList(){
		return ORDER_LIST;
	}
	public ConfirmationTokens withOrderList(){		
		addSimpleOptions(ORDER_LIST);
		return this;
	}	
		
}

