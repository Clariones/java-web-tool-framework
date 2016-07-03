
package com.terapico.b2b.sellercompany;

import java.util.Date;
public class SellerCompanyManagerMock implements SellerCompanyManager {

	public SellerCompany createSellerCompany(String name, String owner, String logo, String contractText, String[] options) throws Exception
	{
		return new SellerCompany();
	}
	public SellerCompany updateSellerCompany(String sellerCompanyId, String property, Object newValue) throws Exception 
	{
		return new SellerCompany();
	}
	


	public void delete(String sellerCompanyId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  SellerCompany addProfitCenter(String sellerCompanyId, String name)
	{
		return new SellerCompany();
	}
	public  SellerCompany removeProfitCenter(String sellerCompanyId, String profitCenterId){
		return new SellerCompany();
	}
	public  SellerCompany updateProfitCenter(String sellerCompanyId, String profitCenterId, String property, Object newValue){
		return new SellerCompany();
	}

	public  SellerCompany addCreditAccount(String sellerCompanyId, String name, String buyerId, double authorized, double remain)
	{
		return new SellerCompany();
	}
	public  SellerCompany removeCreditAccount(String sellerCompanyId, String creditAccountId){
		return new SellerCompany();
	}
	public  SellerCompany updateCreditAccount(String sellerCompanyId, String creditAccountId, String property, Object newValue){
		return new SellerCompany();
	}

	public  SellerCompany addOrder(String sellerCompanyId, String buyerId, String title, String costCenterId, String profitCenterId, double totalAmount, String type, boolean markAsDelete, String recurringInfoId, String status)
	{
		return new SellerCompany();
	}
	public  SellerCompany removeOrder(String sellerCompanyId, String orderId){
		return new SellerCompany();
	}
	public  SellerCompany updateOrder(String sellerCompanyId, String orderId, String property, Object newValue){
		return new SellerCompany();
	}

	public  SellerCompany addCustSvcRep(String sellerCompanyId, String email, String passwd, String roleId)
	{
		return new SellerCompany();
	}
	public  SellerCompany removeCustSvcRep(String sellerCompanyId, String custSvcRepId){
		return new SellerCompany();
	}
	public  SellerCompany updateCustSvcRep(String sellerCompanyId, String custSvcRepId, String property, Object newValue){
		return new SellerCompany();
	}




}


