
package com.terapico.b2b;

import java.util.List;

public interface LineItemDAO{

	
	public LineItem load(String lineItemId) throws LineItemNotFoundException;
	public LineItem save(LineItem lineItem);
	public void delete(String lineItemId) throws LineItemNotFoundException;
 	public List<LineItem> findLineItemByBizOrder(String orderId);
 }


