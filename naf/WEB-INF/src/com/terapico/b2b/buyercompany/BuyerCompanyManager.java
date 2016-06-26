
package com.terapico.b2b.buyercompany;

import java.util.Date;
public interface BuyerCompanyManager{

	public BuyerCompany createBuyerCompany(String name, String priceList, int rating, String logo, String owner, String[] options) throws Exception;	
	public BuyerCompany updateBuyerCompany(String buyerCompanyId, String property, Object newValue)  throws Exception;
	


	public void delete(String buyerCompanyId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public  BuyerCompany addBillingAddress(String buyerCompanyId, String line1, String line2, String city, String state, String country)  throws Exception;
	public  BuyerCompany removeBillingAddress(String buyerCompanyId, String billingAddressId)  throws Exception;
	public  BuyerCompany updateBillingAddress(String buyerCompanyId, String billingAddressId, String property, Object newValue)  throws Exception;

	public  BuyerCompany addEmployee(String buyerCompanyId, String name, String email, String passwd, String cellPhone)  throws Exception;
	public  BuyerCompany removeEmployee(String buyerCompanyId, String employeeId)  throws Exception;
	public  BuyerCompany updateEmployee(String buyerCompanyId, String employeeId, String property, Object newValue)  throws Exception;

	public  BuyerCompany addOrder(String buyerCompanyId, String sellerId, String title, double totalAmount, String type, boolean markAsDelete)  throws Exception;
	public  BuyerCompany removeOrder(String buyerCompanyId, String orderId)  throws Exception;
	public  BuyerCompany updateOrder(String buyerCompanyId, String orderId, String property, Object newValue)  throws Exception;




}


