
package com.terapico.b2b.delivery;
import com.terapico.b2b.CommonTokens;
import java.util.Map;
public class DeliveryTokens extends CommonTokens{

	
	public static DeliveryTokens start(){
		return new DeliveryTokens();
	}
	public static Map <String,Object> all(){
		return new DeliveryTokens()
			.withOrderList()
			.done();
	}
	public static Map <String,Object> withOutLists(){
		return new DeliveryTokens()
			.done();
	}
	public static Map <String,Object> empty(){
		return new DeliveryTokens()
			.done();
	}

	protected static final String ORDER_LIST = "orderList";
	public String getOrderList(){
		return ORDER_LIST;
	}
	public DeliveryTokens withOrderList(){		
		addSimpleOptions(ORDER_LIST);
		return this;
	}	
		
}

