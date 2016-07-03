package com.terapico.b2b.order;

import com.terapico.b2b.action.Action;
import com.terapico.b2b.lineitem.LineItem;
import com.terapico.b2b.paymentgroup.PaymentGroup;
import com.terapico.b2b.shippinggroup.ShippingGroup;

public class OrdreJsonTool {

	public static Object prepareForJson(Order order) {
		// TODO Auto-generated method stub
		for(LineItem item:order.getLineItemList()){
			item.setBizOrder(null);
		}
		for(ShippingGroup item: order.getShippingGroupList()){
			item.setBizOrder(null);
		}
		for(PaymentGroup item: order.getPaymentGroupList()){
			item.setBizOrder(null);
		}

		for(Action item: order.getActionList()){
			item.setBo(null);
		}
		return order;
	}

}
