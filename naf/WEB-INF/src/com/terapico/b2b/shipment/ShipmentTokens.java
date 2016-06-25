
package com.terapico.b2b.shipment;
import com.terapico.b2b.CommonTokens;
import java.util.Map;
public class ShipmentTokens extends CommonTokens{

	
	public static ShipmentTokens start(){
		return new ShipmentTokens();
	}
	public static Map <String,Object> all(){
		return new ShipmentTokens()
			.withOrderList()
			.done();
	}
	public static Map <String,Object> withOutLists(){
		return new ShipmentTokens()
			.done();
	}
	public static Map <String,Object> empty(){
		return new ShipmentTokens()
			.done();
	}

	protected static final String ORDER_LIST = "orderList";
	public String getOrderList(){
		return ORDER_LIST;
	}
	public ShipmentTokens withOrderList(){		
		addSimpleOptions(ORDER_LIST);
		return this;
	}	
		
}

