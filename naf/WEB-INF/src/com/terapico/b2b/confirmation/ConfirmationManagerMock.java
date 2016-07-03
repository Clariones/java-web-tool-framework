
package com.terapico.b2b.confirmation;

import java.util.Date;
public class ConfirmationManagerMock implements ConfirmationManager {

	public Confirmation createConfirmation(String who, Date confirmTime, String[] options) throws Exception
	{
		return new Confirmation();
	}
	public Confirmation updateConfirmation(String confirmationId, String property, Object newValue) throws Exception 
	{
		return new Confirmation();
	}
	


	public void delete(String confirmationId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  Confirmation addOrder(String confirmationId, String buyerId, String sellerId, String title, String costCenterId, String profitCenterId, double totalAmount, String type, boolean markAsDelete, String recurringInfoId, String status)
	{
		return new Confirmation();
	}
	public  Confirmation removeOrder(String confirmationId, String orderId){
		return new Confirmation();
	}
	public  Confirmation updateOrder(String confirmationId, String orderId, String property, Object newValue){
		return new Confirmation();
	}




}


