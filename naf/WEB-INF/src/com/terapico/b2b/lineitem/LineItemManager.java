
package com.terapico.b2b.lineitem;

import java.util.Date;
public interface LineItemManager{

	public LineItem createLineItem(String bizOrderId, String skuId, String skuName, double amount, int quantity, String[] options) throws Exception;	
	public LineItem updateLineItem(String lineItemId, String property, Object newValue)  throws Exception;
	
	public LineItem transferToNewBizOrder(String lineItemId, String newBizOrderId)  throws Exception;
 

	public void delete(String lineItemId, int version) throws Exception;
	public int deleteAll() throws Exception;



}


