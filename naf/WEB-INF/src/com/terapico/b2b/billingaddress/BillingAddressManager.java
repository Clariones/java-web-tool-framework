
package com.terapico.b2b.billingaddress;

import java.util.Date;
public interface BillingAddressManager{

	public BillingAddress createBillingAddress(String companyId, String line1, String line2, String city, String state, String country, String[] options) throws Exception;	
	public BillingAddress updateBillingAddress(String billingAddressId, String property, Object newValue)  throws Exception;
	
	public BillingAddress transferToNewCompany(String billingAddressId, String newCompanyId)  throws Exception;
 

	public void delete(String billingAddressId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public  BillingAddress addPaymentGroup(String billingAddressId, String name, String bizOrderId, String cardNumber)  throws Exception;
	public  BillingAddress removePaymentGroup(String billingAddressId, String paymentGroupId)  throws Exception;
	public  BillingAddress updatePaymentGroup(String billingAddressId, String paymentGroupId, String property, Object newValue)  throws Exception;




}


