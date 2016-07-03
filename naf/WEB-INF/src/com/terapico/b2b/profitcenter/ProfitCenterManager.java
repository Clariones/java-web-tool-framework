
package com.terapico.b2b.profitcenter;

import java.util.Date;
public interface ProfitCenterManager{

	public ProfitCenter createProfitCenter(String name, String belongsToId, String[] options) throws Exception;	
	public ProfitCenter updateProfitCenter(String profitCenterId, String property, Object newValue)  throws Exception;
	
	public ProfitCenter transferToNewBelongsTo(String profitCenterId, String newBelongsToId)  throws Exception;
 

	public void delete(String profitCenterId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public  ProfitCenter addOrder(String profitCenterId, String buyerId, String sellerId, String title, String costCenterId, double totalAmount, String type, boolean markAsDelete, String recurringInfoId, String status)  throws Exception;
	public  ProfitCenter removeOrder(String profitCenterId, String orderId)  throws Exception;
	public  ProfitCenter updateOrder(String profitCenterId, String orderId, String property, Object newValue)  throws Exception;




}


