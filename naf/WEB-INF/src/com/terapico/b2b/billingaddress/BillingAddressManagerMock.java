
package com.terapico.b2b.billingaddress;

import java.util.Date;
public class BillingAddressManagerMock implements BillingAddressManager {

	public BillingAddress createBillingAddress(String companyId, String line1, String line2, String city, String state, String country, String[] options) throws Exception
	{
		return new BillingAddress();
	}
	public BillingAddress updateBillingAddress(String billingAddressId, String property, Object newValue) throws Exception 
	{
		return new BillingAddress();
	}
	
	public BillingAddress transferToNewCompany(String billingAddressId, String newCompanyId) throws Exception
 	{
 		return new BillingAddress();
 
 	}
 

	public void delete(String billingAddressId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  BillingAddress addPaymentGroup(String billingAddressId, String name, String bizOrderId, String cardNumber)
	{
		return new BillingAddress();
	}
	public  BillingAddress removePaymentGroup(String billingAddressId, String paymentGroupId){
		return new BillingAddress();
	}
	public  BillingAddress updatePaymentGroup(String billingAddressId, String paymentGroupId, String property, Object newValue){
		return new BillingAddress();
	}




}


