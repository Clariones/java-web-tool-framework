
package com.terapico.b2b.lineitem;

import java.util.List;
import java.util.Set;
import java.util.Map;
public interface LineItemDAO{

	
	public LineItem load(String lineItemId,Map<String,Object> options) throws Exception;
	public LineItem clone(String lineItemId,Map<String,Object> options) throws Exception;
	
	public LineItem save(LineItem lineItem,Map<String,Object> options);
	public List<LineItem> saveList(List<LineItem> lineItemList,Map<String,Object> options);
	
	public void delete(String lineItemId, int version) throws Exception;
	public int deleteAll() throws Exception;
 	public List<LineItem> findLineItemByBizOrder(String orderId);
 }


