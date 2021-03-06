
package com.terapico.b2b.buyercompany;

import java.util.Date;
public class BuyerCompanyManagerMock implements BuyerCompanyManager {

	public BuyerCompany createBuyerCompany(String name, String priceList, int rating, String logo, String owner, String[] options) throws Exception
	{
		return new BuyerCompany();
	}
	public BuyerCompany updateBuyerCompany(String buyerCompanyId, String property, Object newValue) throws Exception 
	{
		return new BuyerCompany();
	}
	


	public void delete(String buyerCompanyId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  BuyerCompany addCostCenter(String buyerCompanyId, String name)
	{
		return new BuyerCompany();
	}
	public  BuyerCompany removeCostCenter(String buyerCompanyId, String costCenterId){
		return new BuyerCompany();
	}
	public  BuyerCompany updateCostCenter(String buyerCompanyId, String costCenterId, String property, Object newValue){
		return new BuyerCompany();
	}

	public  BuyerCompany addCreditAccount(String buyerCompanyId, String name, String sellerId, double authorized, double remain)
	{
		return new BuyerCompany();
	}
	public  BuyerCompany removeCreditAccount(String buyerCompanyId, String creditAccountId){
		return new BuyerCompany();
	}
	public  BuyerCompany updateCreditAccount(String buyerCompanyId, String creditAccountId, String property, Object newValue){
		return new BuyerCompany();
	}

	public  BuyerCompany addBillingAddress(String buyerCompanyId, String line1, String line2, String city, String state, String country)
	{
		return new BuyerCompany();
	}
	public  BuyerCompany removeBillingAddress(String buyerCompanyId, String billingAddressId){
		return new BuyerCompany();
	}
	public  BuyerCompany updateBillingAddress(String buyerCompanyId, String billingAddressId, String property, Object newValue){
		return new BuyerCompany();
	}

	public  BuyerCompany addEmployee(String buyerCompanyId, String name, String email, String passwd, String cellPhone)
	{
		return new BuyerCompany();
	}
	public  BuyerCompany removeEmployee(String buyerCompanyId, String employeeId){
		return new BuyerCompany();
	}
	public  BuyerCompany updateEmployee(String buyerCompanyId, String employeeId, String property, Object newValue){
		return new BuyerCompany();
	}

	public  BuyerCompany addOrder(String buyerCompanyId, String sellerId, String title, String costCenterId, String profitCenterId, double totalAmount, String type, boolean markAsDelete, String recurringInfoId, String status)
	{
		return new BuyerCompany();
	}
	public  BuyerCompany removeOrder(String buyerCompanyId, String orderId){
		return new BuyerCompany();
	}
	public  BuyerCompany updateOrder(String buyerCompanyId, String orderId, String property, Object newValue){
		return new BuyerCompany();
	}




}


