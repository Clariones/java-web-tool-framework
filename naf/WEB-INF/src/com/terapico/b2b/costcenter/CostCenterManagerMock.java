
package com.terapico.b2b.costcenter;

import java.util.Date;
public class CostCenterManagerMock implements CostCenterManager {

	public CostCenter createCostCenter(String name, String belongsToId, String[] options) throws Exception
	{
		return new CostCenter();
	}
	public CostCenter updateCostCenter(String costCenterId, String property, Object newValue) throws Exception 
	{
		return new CostCenter();
	}
	
	public CostCenter transferToNewBelongsTo(String costCenterId, String newBelongsToId) throws Exception
 	{
 		return new CostCenter();
 
 	}
 

	public void delete(String costCenterId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  CostCenter addOrder(String costCenterId, String buyerId, String sellerId, String title, String profitCenterId, double totalAmount, String type, boolean markAsDelete, String recurringInfoId, String status)
	{
		return new CostCenter();
	}
	public  CostCenter removeOrder(String costCenterId, String orderId){
		return new CostCenter();
	}
	public  CostCenter updateOrder(String costCenterId, String orderId, String property, Object newValue){
		return new CostCenter();
	}




}


