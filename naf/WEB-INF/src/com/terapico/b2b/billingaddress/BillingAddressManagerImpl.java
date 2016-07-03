
package com.terapico.b2b.billingaddress;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.paymentgroup.PaymentGroup;

import com.terapico.b2b.buyercompany.BuyerCompanyDAO;

import com.terapico.b2b.order.Order;
import com.terapico.b2b.billingaddress.BillingAddress;



public class BillingAddressManagerImpl implements BillingAddressManager {

	private  BillingAddressDAO  billingAddressDAO;
 	public void setBillingAddressDAO(BillingAddressDAO  billingAddressDAO){
 	
 		if(billingAddressDAO == null){
 			throw new IllegalStateException("Do not try to set billingAddressDAO to null.");
 		}
	 	this.billingAddressDAO = billingAddressDAO;
 	}
 	public BillingAddressDAO getBillingAddressDAO(){
 		if(this.billingAddressDAO == null){
 			throw new IllegalStateException("The BillingAddressDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.billingAddressDAO;
 	}
 	
 	public BillingAddress saveBillingAddress(BillingAddress billingAddress, Map<String,Object>options) throws Exception{	
 		return getBillingAddressDAO().save(billingAddress, options);
 	}
 	public BillingAddress loadBillingAddress(String billingAddressId, Map<String,Object>options) throws Exception{	
 		return getBillingAddressDAO().load(billingAddressId, options);
 	}
 	 
 	
 	private  BuyerCompanyDAO  buyerCompanyDAO;
 	public void setBuyerCompanyDAO(BuyerCompanyDAO buyerCompanyDAO){
	 	this.buyerCompanyDAO = buyerCompanyDAO;
 	}
 	public BuyerCompanyDAO getBuyerCompanyDAO(){
	 	return this.buyerCompanyDAO;
 	}

 	
 	
	public BillingAddress createBillingAddress(String companyId, String line1, String line2, String city, String state, String country, String[] optionsExpr) throws Exception
	{
		
		
		BillingAddress billingAddress=createNewBillingAddress(optionsExpr);	

		BuyerCompany company = loadCompany(companyId,emptyOptions());
		billingAddress.setCompany(company);
		billingAddress.setLine1(line1);
		billingAddress.setLine2(line2);
		billingAddress.setCity(city);
		billingAddress.setState(state);
		billingAddress.setCountry(country);

		return saveBillingAddress(billingAddress, emptyOptions());
		

		
	}
	protected BillingAddress createNewBillingAddress(String[] optionsExpr) throws Exception
	{
		
		return new BillingAddress();
		
	}
	public BillingAddress updateBillingAddress(String billingAddressId, String property, Object newValue) throws Exception 
	{
		return new BillingAddress();
	}
	protected Map<String,Object> emptyOptions(){
		return new HashMap<String,Object>();
	}
	
	protected BillingAddressTokens tokens(){
		return BillingAddressTokens.start();
	}
	protected Map<String,Object> allTokens(){
		return BillingAddressTokens.all();
	}
	
	public BillingAddress transferToNewCompany(String billingAddressId, String newCompanyId) throws Exception
 	{
 
		BillingAddress billingAddress = loadBillingAddress(billingAddressId, allTokens());	
		synchronized(billingAddress){
			//will be good when the billingAddress loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			BuyerCompany company = loadCompany(newCompanyId, emptyOptions());		
			billingAddress.setCompany(company);		
			return saveBillingAddress(billingAddress, emptyOptions());
		}
 	}
 	
 	protected BuyerCompany loadCompany(String newCompanyId, Map<String,Object> options) throws Exception
 	{
 		return getBuyerCompanyDAO().load(newCompanyId, options);
 	}
 	
 

	public void delete(String billingAddressId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  BillingAddress addPaymentGroup(String billingAddressId, String name, String bizOrderId, String cardNumber) throws Exception
	{		
		PaymentGroup paymentGroup = createPaymentGroup(name, bizOrderId, cardNumber);
		
		BillingAddress billingAddress = loadBillingAddress(billingAddressId, allTokens());
		synchronized(billingAddress){ 
			//will be good when the billingAddress loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			billingAddress.addPaymentGroup( paymentGroup );		
			return saveBillingAddress(billingAddress, tokens().withPaymentGroupList().done());
		}
	}
	protected PaymentGroup createPaymentGroup(String name, String bizOrderId, String cardNumber){

		PaymentGroup paymentGroup = new PaymentGroup();
		
		
		paymentGroup.setName(name);		
		Order  bizOrder = new Order();
		bizOrder.setId(bizOrderId);		
		paymentGroup.setBizOrder(bizOrder);		
		paymentGroup.setCardNumber(cardNumber);
	
		
		return paymentGroup;			
		
	}
	public  BillingAddress removePaymentGroup(String billingAddressId, String paymentGroupId){
		return new BillingAddress();
	}
	public  BillingAddress updatePaymentGroup(String billingAddressId, String paymentGroupId, String property, Object newValue){
		return new BillingAddress();
	}



}


