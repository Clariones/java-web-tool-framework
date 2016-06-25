
package com.terapico.b2b.paymentgroup;

import java.util.Date;
public class PaymentGroupManagerMock implements PaymentGroupManager {

	public PaymentGroup createPaymentGroup(String name, String bizOrderId, String cardNumber, String billingAddressId, String[] options) throws Exception
	{
		return new PaymentGroup();
	}
	public PaymentGroup updatePaymentGroup(String paymentGroupId, String property, Object newValue) throws Exception 
	{
		return new PaymentGroup();
	}
	
	public PaymentGroup transferToNewBizOrder(String paymentGroupId, String newBizOrderId) throws Exception
 	{
 		return new PaymentGroup();
 
 	}
 	public PaymentGroup transferToNewBillingAddress(String paymentGroupId, String newBillingAddressId) throws Exception
 	{
 		return new PaymentGroup();
 
 	}
 

	public void delete(String paymentGroupId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}



}


