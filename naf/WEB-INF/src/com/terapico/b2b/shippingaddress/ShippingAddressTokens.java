
package com.terapico.b2b.shippingaddress;
import com.terapico.b2b.CommonTokens;
import java.util.Map;
public class ShippingAddressTokens extends CommonTokens{

	
	public static ShippingAddressTokens start(){
		return new ShippingAddressTokens();
	}
	public static Map <String,Object> all(){
		return new ShippingAddressTokens()
			.withShippingGroupList()
			.done();
	}
	public static Map <String,Object> withOutLists(){
		return new ShippingAddressTokens()
			.done();
	}
	public static Map <String,Object> empty(){
		return new ShippingAddressTokens()
			.done();
	}

	protected static final String SHIPPING_GROUP_LIST = "shippingGroupList";
	public String getShippingGroupList(){
		return SHIPPING_GROUP_LIST;
	}
	public ShippingAddressTokens withShippingGroupList(){		
		addSimpleOptions(SHIPPING_GROUP_LIST);
		return this;
	}	
		
}

