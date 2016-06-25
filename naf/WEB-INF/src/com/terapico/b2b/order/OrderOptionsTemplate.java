package com.terapico.b2b.order;


import com.terapico.b2b.CommonOptions;

public class OrderOptionsTemplate extends CommonOptions{
	
	public static OrderOptionsTemplate start(){
		return new OrderOptionsTemplate();
	}
	public OrderOptionsTemplate withShippingGroupList(){
		
		addSimpleOptions("shippingGroupList");

		return this;
	}
	public OrderOptionsTemplate withLineItemList(){
		
		addSimpleOptions("lineItemList");

		return this;
	}
	public OrderOptionsTemplate withPaymentGroupList(){
		
		addSimpleOptions("paymentGroupList");

		return this;
	}
	public OrderOptionsTemplate withSellerCompany(){		
		addSimpleOptions("sellerCompany");
		return this;
	}
	public OrderOptionsTemplate withBuyerCompany(){
		
		addSimpleOptions("buyerCompany");
		return this;
	}
	
}
