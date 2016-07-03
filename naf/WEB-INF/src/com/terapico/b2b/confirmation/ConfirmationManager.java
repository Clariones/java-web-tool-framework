
package com.terapico.b2b.confirmation;

import java.util.Date;
public interface ConfirmationManager{

	public Confirmation createConfirmation(String who, Date confirmTime, String[] options) throws Exception;	
	public Confirmation updateConfirmation(String confirmationId, String property, Object newValue)  throws Exception;
	


	public void delete(String confirmationId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public  Confirmation addOrder(String confirmationId, String buyerId, String sellerId, String title, String costCenterId, String profitCenterId, double totalAmount, String type, boolean markAsDelete, String recurringInfoId, String status)  throws Exception;
	public  Confirmation removeOrder(String confirmationId, String orderId)  throws Exception;
	public  Confirmation updateOrder(String confirmationId, String orderId, String property, Object newValue)  throws Exception;




}


