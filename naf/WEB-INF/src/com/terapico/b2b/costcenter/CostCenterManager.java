
package com.terapico.b2b.costcenter;

import java.util.Date;
public interface CostCenterManager{

	public CostCenter createCostCenter(String name, String belongsToId, String[] options) throws Exception;	
	public CostCenter updateCostCenter(String costCenterId, String property, Object newValue)  throws Exception;
	
	public CostCenter transferToNewBelongsTo(String costCenterId, String newBelongsToId)  throws Exception;
 

	public void delete(String costCenterId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public  CostCenter addOrder(String costCenterId, String buyerId, String sellerId, String title, String profitCenterId, double totalAmount, String type, boolean markAsDelete, String recurringInfoId, String status)  throws Exception;
	public  CostCenter removeOrder(String costCenterId, String orderId)  throws Exception;
	public  CostCenter updateOrder(String costCenterId, String orderId, String property, Object newValue)  throws Exception;




}


