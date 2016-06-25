
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
	public  SellerCompany addOrder(String sellerCompanyId, String buyerId, String title, double totalAmount, String type, boolean markAsDelete)
	{
		return new SellerCompany();
	}
	public  SellerCompany removeOrder(String sellerCompanyId, String orderId){
		return new SellerCompany();
	}
	public  SellerCompany updateOrder(String sellerCompanyId, String orderId, String property, Object newValue){
		return new SellerCompany();
	}

	public  SellerCompany addCustSvcRep(String sellerCompanyId, String email, String roleId)
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


