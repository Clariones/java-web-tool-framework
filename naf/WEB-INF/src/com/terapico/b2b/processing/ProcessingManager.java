
package com.terapico.b2b.processing;

import java.util.Date;
public interface ProcessingManager{

	public Processing createProcessing(String who, Date processTime, String[] options) throws Exception;	
	public Processing updateProcessing(String processingId, String property, Object newValue)  throws Exception;
	


	public void delete(String processingId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public  Processing addOrder(String processingId, String buyerId, String sellerId, String title, double totalAmount, String type, boolean markAsDelete)  throws Exception;
	public  Processing removeOrder(String processingId, String orderId)  throws Exception;
	public  Processing updateOrder(String processingId, String orderId, String property, Object newValue)  throws Exception;




}


