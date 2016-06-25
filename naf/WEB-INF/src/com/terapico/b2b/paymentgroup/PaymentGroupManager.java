
package com.terapico.b2b.paymentgroup;

import java.util.Date;
public interface PaymentGroupManager{

	public PaymentGroup createPaymentGroup(String name, String bizOrderId, String cardNumber, String billingAddressId, String[] options) throws Exception;	
	public PaymentGroup updatePaymentGroup(String paymentGroupId, String property, Object newValue)  throws Exception;
	
	public PaymentGroup transferToNewBizOrder(String paymentGroupId, String newBizOrderId)  throws Exception;
 	public PaymentGroup transferToNewBillingAddress(String paymentGroupId, String newBillingAddressId)  throws Exception;
 

	public void delete(String paymentGroupId, int version) throws Exception;
	public int deleteAll() throws Exception;



}


