
package com.terapico.b2b.creditaccount;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.sellercompany.SellerCompany;

import com.terapico.b2b.sellercompany.SellerCompanyDAO;
import com.terapico.b2b.buyercompany.BuyerCompanyDAO;




public class CreditAccountManagerImpl implements CreditAccountManager {

	private  CreditAccountDAO  creditAccountDAO;
 	public void setCreditAccountDAO(CreditAccountDAO  creditAccountDAO){
 	
 		if(creditAccountDAO == null){
 			throw new IllegalStateException("Do not try to set creditAccountDAO to null.");
 		}
	 	this.creditAccountDAO = creditAccountDAO;
 	}
 	public CreditAccountDAO getCreditAccountDAO(){
 		if(this.creditAccountDAO == null){
 			throw new IllegalStateException("The CreditAccountDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.creditAccountDAO;
 	}
 	
 	public CreditAccount saveCreditAccount(CreditAccount creditAccount, Map<String,Object>options) throws Exception{	
 		return getCreditAccountDAO().save(creditAccount, options);
 	}
 	public CreditAccount loadCreditAccount(String creditAccountId, Map<String,Object>options) throws Exception{	
 		return getCreditAccountDAO().load(creditAccountId, options);
 	}
 	 
 	
 	private  BuyerCompanyDAO  buyerCompanyDAO;
 	public void setBuyerCompanyDAO(BuyerCompanyDAO buyerCompanyDAO){
	 	this.buyerCompanyDAO = buyerCompanyDAO;
 	}
 	public BuyerCompanyDAO getBuyerCompanyDAO(){
	 	return this.buyerCompanyDAO;
 	}
 
 	
 	private  SellerCompanyDAO  sellerCompanyDAO;
 	public void setSellerCompanyDAO(SellerCompanyDAO sellerCompanyDAO){
	 	this.sellerCompanyDAO = sellerCompanyDAO;
 	}
 	public SellerCompanyDAO getSellerCompanyDAO(){
	 	return this.sellerCompanyDAO;
 	}

 	
 	
	public CreditAccount createCreditAccount(String name, String buyerId, String sellerId, double authorized, double remain, String[] optionsExpr) throws Exception
	{
		
		
		CreditAccount creditAccount=createNewCreditAccount(optionsExpr);	

		creditAccount.setName(name);
		BuyerCompany buyer = loadBuyer(buyerId,emptyOptions());
		creditAccount.setBuyer(buyer);
		SellerCompany seller = loadSeller(sellerId,emptyOptions());
		creditAccount.setSeller(seller);
		creditAccount.setAuthorized(authorized);
		creditAccount.setRemain(remain);

		return saveCreditAccount(creditAccount, emptyOptions());
		

		
	}
	protected CreditAccount createNewCreditAccount(String[] optionsExpr) throws Exception
	{
		
		return new CreditAccount();
		
	}
	public CreditAccount updateCreditAccount(String creditAccountId, String property, Object newValue) throws Exception 
	{
		return new CreditAccount();
	}
	protected Map<String,Object> emptyOptions(){
		return new HashMap<String,Object>();
	}
	
	protected CreditAccountTokens tokens(){
		return CreditAccountTokens.start();
	}
	protected Map<String,Object> allTokens(){
		return CreditAccountTokens.all();
	}
	
	public CreditAccount transferToNewBuyer(String creditAccountId, String newBuyerId) throws Exception
 	{
 
		CreditAccount creditAccount = loadCreditAccount(creditAccountId, allTokens());	
		synchronized(creditAccount){
			//will be good when the creditAccount loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			BuyerCompany buyer = loadBuyer(newBuyerId, emptyOptions());		
			creditAccount.setBuyer(buyer);		
			return saveCreditAccount(creditAccount, emptyOptions());
		}
 	}
 	
 	protected BuyerCompany loadBuyer(String newBuyerId, Map<String,Object> options) throws Exception
 	{
 		return getBuyerCompanyDAO().load(newBuyerId, options);
 	}
 	
 	public CreditAccount transferToNewSeller(String creditAccountId, String newSellerId) throws Exception
 	{
 
		CreditAccount creditAccount = loadCreditAccount(creditAccountId, allTokens());	
		synchronized(creditAccount){
			//will be good when the creditAccount loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			SellerCompany seller = loadSeller(newSellerId, emptyOptions());		
			creditAccount.setSeller(seller);		
			return saveCreditAccount(creditAccount, emptyOptions());
		}
 	}
 	
 	protected SellerCompany loadSeller(String newSellerId, Map<String,Object> options) throws Exception
 	{
 		return getSellerCompanyDAO().load(newSellerId, options);
 	}
 	
 

	public void delete(String creditAccountId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}


}


