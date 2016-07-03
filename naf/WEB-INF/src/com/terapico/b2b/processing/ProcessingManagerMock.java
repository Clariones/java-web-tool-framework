
package com.terapico.b2b.processing;

import java.util.Date;
public class ProcessingManagerMock implements ProcessingManager {

	public Processing createProcessing(String who, Date processTime, String[] options) throws Exception
	{
		return new Processing();
	}
	public Processing updateProcessing(String processingId, String property, Object newValue) throws Exception 
	{
		return new Processing();
	}
	


	public void delete(String processingId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  Processing addOrder(String processingId, String buyerId, String sellerId, String title, String costCenterId, String profitCenterId, double totalAmount, String type, boolean markAsDelete, String recurringInfoId, String status)
	{
		return new Processing();
	}
	public  Processing removeOrder(String processingId, String orderId){
		return new Processing();
	}
	public  Processing updateOrder(String processingId, String orderId, String property, Object newValue){
		return new Processing();
	}




}


