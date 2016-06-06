
package com.terapico.b2b.lineitem;

import java.util.List;
import java.util.Set;
public interface LineItemDAO{

	
	public LineItem load(String lineItemId,Set<String> options) throws Exception;
	public LineItem clone(String lineItemId,Set<String> options) throws Exception;
	
	public LineItem save(LineItem lineItem,Set<String> options);
	public List<LineItem> saveList(List<LineItem> lineItemList,Set<String> options);
	
	public void delete(String lineItemId, int version) throws Exception;
	public int deleteAll() throws Exception;
 	public List<LineItem> findLineItemByBizOrder(String orderId);
 }


