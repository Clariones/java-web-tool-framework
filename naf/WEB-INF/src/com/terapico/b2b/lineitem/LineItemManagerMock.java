
package com.terapico.b2b.lineitem;

import java.util.Date;
public class LineItemManagerMock implements LineItemManager {

	public LineItem createLineItem(String bizOrderId, String skuId, String skuName, double amount, int quantity, boolean active, String[] options) throws Exception
	{
		return new LineItem();
	}
	public LineItem updateLineItem(String lineItemId, String property, Object newValue) throws Exception 
	{
		return new LineItem();
	}
	
	public LineItem transferToNewBizOrder(String lineItemId, String newBizOrderId) throws Exception
 	{
 		return new LineItem();
 
 	}
 

	public void delete(String lineItemId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}



}


