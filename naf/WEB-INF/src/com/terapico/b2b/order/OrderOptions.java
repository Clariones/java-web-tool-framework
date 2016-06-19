package com.terapico.b2b.order;

import java.util.HashMap;
import java.util.Map;

public class OrderOptions {
	Map <String,Object> options;
	public static OrderOptions start(){
		return new OrderOptions();
	}
	public OrderOptions withShippingGroupList(){
		
		addSimpleOptions("shippingGroupList");

		return this;
	}
	public OrderOptions withLineItemList(){
		
		addSimpleOptions("lineItemList");

		return this;
	}
	public OrderOptions withPaymentGroupList(){
		
		addSimpleOptions("paymentGroupList");

		return this;
	}
	public OrderOptions withSellerCompany(){		
		addSimpleOptions("sellerCompany");
		return this;
	}
	public OrderOptions withBuyerCompany(){
		
		addSimpleOptions("buyerCompany");
		return this;
	}
	public Map <String,Object> done()
	{
		ensureOptions();
		return options;
	}
	
	protected void addSimpleOptions(String key){
		ensureOptions();
		options.put(key, key);
	}
	protected void addMapOptions(String key, Object value){
		ensureOptions();
		options.put(key, value);
		
	}
	protected void ensureOptions()
	{
		if(options == null){
			options = new HashMap<String,Object>();
		}
	}
	//the way to implement this is with withLineItemList().withShippingGroupList().
}
