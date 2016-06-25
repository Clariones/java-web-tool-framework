
package com.terapico.b2b.shippinggroup;
import com.terapico.b2b.CommonTokens;
import java.util.Map;
public class ShippingGroupTokens extends CommonTokens{

	
	public static ShippingGroupTokens start(){
		return new ShippingGroupTokens();
	}
	public static Map <String,Object> all(){
		return new ShippingGroupTokens()
			.withBizOrder()
			.withAddress()
			.done();
	}
	public static Map <String,Object> withOutLists(){
		return new ShippingGroupTokens()
			.withBizOrder()
			.withAddress()
			.done();
	}
	public static Map <String,Object> empty(){
		return new ShippingGroupTokens()
			.done();
	}

	protected static final String BIZORDER = "bizOrder";
	public String getBizOrder(){
		return BIZORDER;
	}
	public ShippingGroupTokens withBizOrder(){		
		addSimpleOptions(BIZORDER);
		return this;
	}
	
	
	protected static final String ADDRESS = "address";
	public String getAddress(){
		return ADDRESS;
	}
	public ShippingGroupTokens withAddress(){		
		addSimpleOptions(ADDRESS);
		return this;
	}
	
	
}

