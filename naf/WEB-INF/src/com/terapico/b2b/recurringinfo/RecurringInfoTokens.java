
package com.terapico.b2b.recurringinfo;
import com.terapico.b2b.CommonTokens;
import java.util.Map;
public class RecurringInfoTokens extends CommonTokens{

	
	public static RecurringInfoTokens start(){
		return new RecurringInfoTokens();
	}
	public static Map <String,Object> all(){
		return new RecurringInfoTokens()
			.withOrderList()
			.done();
	}
	public static Map <String,Object> withOutLists(){
		return new RecurringInfoTokens()
			.done();
	}
	public static Map <String,Object> empty(){
		return new RecurringInfoTokens()
			.done();
	}

	protected static final String ORDER_LIST = "orderList";
	public String getOrderList(){
		return ORDER_LIST;
	}
	public RecurringInfoTokens withOrderList(){		
		addSimpleOptions(ORDER_LIST);
		return this;
	}	
		
}

