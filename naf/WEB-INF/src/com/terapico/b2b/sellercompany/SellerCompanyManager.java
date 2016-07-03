
package com.terapico.b2b.sellercompany;

import java.util.Date;
public interface SellerCompanyManager{

	public SellerCompany createSellerCompany(String name, String owner, String logo, String contractText, String[] options) throws Exception;	
	public SellerCompany updateSellerCompany(String sellerCompanyId, String property, Object newValue)  throws Exception;
	


	public void delete(String sellerCompanyId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public  SellerCompany addProfitCenter(String sellerCompanyId, String name)  throws Exception;
	public  SellerCompany removeProfitCenter(String sellerCompanyId, String profitCenterId)  throws Exception;
	public  SellerCompany updateProfitCenter(String sellerCompanyId, String profitCenterId, String property, Object newValue)  throws Exception;

	public  SellerCompany addCreditAccount(String sellerCompanyId, String name, String buyerId, double authorized, double remain)  throws Exception;
	public  SellerCompany removeCreditAccount(String sellerCompanyId, String creditAccountId)  throws Exception;
	public  SellerCompany updateCreditAccount(String sellerCompanyId, String creditAccountId, String property, Object newValue)  throws Exception;

	public  SellerCompany addOrder(String sellerCompanyId, String buyerId, String title, String costCenterId, String profitCenterId, double totalAmount, String type, boolean markAsDelete, String recurringInfoId, String status)  throws Exception;
	public  SellerCompany removeOrder(String sellerCompanyId, String orderId)  throws Exception;
	public  SellerCompany updateOrder(String sellerCompanyId, String orderId, String property, Object newValue)  throws Exception;

	public  SellerCompany addCustSvcRep(String sellerCompanyId, String email, String passwd, String roleId)  throws Exception;
	public  SellerCompany removeCustSvcRep(String sellerCompanyId, String custSvcRepId)  throws Exception;
	public  SellerCompany updateCustSvcRep(String sellerCompanyId, String custSvcRepId, String property, Object newValue)  throws Exception;




}


