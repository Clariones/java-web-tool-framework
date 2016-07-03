
package com.terapico.b2b.profitcenter;

import java.util.Date;
public class ProfitCenterManagerMock implements ProfitCenterManager {

	public ProfitCenter createProfitCenter(String name, String belongsToId, String[] options) throws Exception
	{
		return new ProfitCenter();
	}
	public ProfitCenter updateProfitCenter(String profitCenterId, String property, Object newValue) throws Exception 
	{
		return new ProfitCenter();
	}
	
	public ProfitCenter transferToNewBelongsTo(String profitCenterId, String newBelongsToId) throws Exception
 	{
 		return new ProfitCenter();
 
 	}
 

	public void delete(String profitCenterId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  ProfitCenter addOrder(String profitCenterId, String buyerId, String sellerId, String title, String costCenterId, double totalAmount, String type, boolean markAsDelete, String recurringInfoId, String status)
	{
		return new ProfitCenter();
	}
	public  ProfitCenter removeOrder(String profitCenterId, String orderId){
		return new ProfitCenter();
	}
	public  ProfitCenter updateOrder(String profitCenterId, String orderId, String property, Object newValue){
		return new ProfitCenter();
	}




}


