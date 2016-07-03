
package com.terapico.b2b.sellercompany;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import com.terapico.b2b.order.Order;
import com.terapico.b2b.creditaccount.CreditAccount;
import com.terapico.b2b.custsvcrep.CustSvcRep;
import com.terapico.b2b.profitcenter.ProfitCenter;


import com.terapico.b2b.approval.Approval;
import com.terapico.b2b.confirmation.Confirmation;
import com.terapico.b2b.recurringinfo.RecurringInfo;
import com.terapico.b2b.shipment.Shipment;
import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.processing.Processing;
import com.terapico.b2b.role.Role;
import com.terapico.b2b.costcenter.CostCenter;
import com.terapico.b2b.profitcenter.ProfitCenter;
import com.terapico.b2b.delivery.Delivery;
import com.terapico.b2b.sellercompany.SellerCompany;



public class SellerCompanyManagerImpl implements SellerCompanyManager {

	private  SellerCompanyDAO  sellerCompanyDAO;
 	public void setSellerCompanyDAO(SellerCompanyDAO  sellerCompanyDAO){
 	
 		if(sellerCompanyDAO == null){
 			throw new IllegalStateException("Do not try to set sellerCompanyDAO to null.");
 		}
	 	this.sellerCompanyDAO = sellerCompanyDAO;
 	}
 	public SellerCompanyDAO getSellerCompanyDAO(){
 		if(this.sellerCompanyDAO == null){
 			throw new IllegalStateException("The SellerCompanyDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.sellerCompanyDAO;
 	}
 	
 	public SellerCompany saveSellerCompany(SellerCompany sellerCompany, Map<String,Object>options) throws Exception{	
 		return getSellerCompanyDAO().save(sellerCompany, options);
 	}
 	public SellerCompany loadSellerCompany(String sellerCompanyId, Map<String,Object>options) throws Exception{	
 		return getSellerCompanyDAO().load(sellerCompanyId, options);
 	}
 	
 	
 	
	public SellerCompany createSellerCompany(String name, String owner, String logo, String contractText, String[] optionsExpr) throws Exception
	{
		
		
		SellerCompany sellerCompany=createNewSellerCompany(optionsExpr);	

		sellerCompany.setName(name);
		sellerCompany.setOwner(owner);
		sellerCompany.setLogo(logo);
		sellerCompany.setContractText(contractText);

		return saveSellerCompany(sellerCompany, emptyOptions());
		

		
	}
	protected SellerCompany createNewSellerCompany(String[] optionsExpr) throws Exception
	{
		
		return new SellerCompany();
		
	}
	public SellerCompany updateSellerCompany(String sellerCompanyId, String property, Object newValue) throws Exception 
	{
		return new SellerCompany();
	}
	protected Map<String,Object> emptyOptions(){
		return new HashMap<String,Object>();
	}
	
	protected SellerCompanyTokens tokens(){
		return SellerCompanyTokens.start();
	}
	protected Map<String,Object> allTokens(){
		return SellerCompanyTokens.all();
	}
	


	public void delete(String sellerCompanyId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  SellerCompany addProfitCenter(String sellerCompanyId, String name) throws Exception
	{		
		ProfitCenter profitCenter = createProfitCenter(name);
		
		SellerCompany sellerCompany = loadSellerCompany(sellerCompanyId, allTokens());
		synchronized(sellerCompany){ 
			//will be good when the sellerCompany loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			sellerCompany.addProfitCenter( profitCenter );		
			return saveSellerCompany(sellerCompany, tokens().withProfitCenterList().done());
		}
	}
	protected ProfitCenter createProfitCenter(String name){

		ProfitCenter profitCenter = new ProfitCenter();
		
		
		profitCenter.setName(name);
	
		
		return profitCenter;			
		
	}
	public  SellerCompany removeProfitCenter(String sellerCompanyId, String profitCenterId){
		return new SellerCompany();
	}
	public  SellerCompany updateProfitCenter(String sellerCompanyId, String profitCenterId, String property, Object newValue){
		return new SellerCompany();
	}

	public  SellerCompany addCreditAccount(String sellerCompanyId, String name, String buyerId, double authorized, double remain) throws Exception
	{		
		CreditAccount creditAccount = createCreditAccount(name, buyerId, authorized, remain);
		
		SellerCompany sellerCompany = loadSellerCompany(sellerCompanyId, allTokens());
		synchronized(sellerCompany){ 
			//will be good when the sellerCompany loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			sellerCompany.addCreditAccount( creditAccount );		
			return saveSellerCompany(sellerCompany, tokens().withCreditAccountList().done());
		}
	}
	protected CreditAccount createCreditAccount(String name, String buyerId, double authorized, double remain){

		CreditAccount creditAccount = new CreditAccount();
		
		
		creditAccount.setName(name);		
		BuyerCompany  buyer = new BuyerCompany();
		buyer.setId(buyerId);		
		creditAccount.setBuyer(buyer);		
		creditAccount.setAuthorized(authorized);		
		creditAccount.setRemain(remain);
	
		
		return creditAccount;			
		
	}
	public  SellerCompany removeCreditAccount(String sellerCompanyId, String creditAccountId){
		return new SellerCompany();
	}
	public  SellerCompany updateCreditAccount(String sellerCompanyId, String creditAccountId, String property, Object newValue){
		return new SellerCompany();
	}

	public  SellerCompany addOrder(String sellerCompanyId, String buyerId, String title, String costCenterId, String profitCenterId, double totalAmount, String type, boolean markAsDelete, String recurringInfoId, String status) throws Exception
	{		
		Order order = createOrder(buyerId, title, costCenterId, profitCenterId, totalAmount, type, markAsDelete, recurringInfoId, status);
		
		SellerCompany sellerCompany = loadSellerCompany(sellerCompanyId, allTokens());
		synchronized(sellerCompany){ 
			//will be good when the sellerCompany loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			sellerCompany.addOrder( order );		
			return saveSellerCompany(sellerCompany, tokens().withOrderList().done());
		}
	}
	protected Order createOrder(String buyerId, String title, String costCenterId, String profitCenterId, double totalAmount, String type, boolean markAsDelete, String recurringInfoId, String status){

		Order order = new Order();
		
		
		BuyerCompany  buyer = new BuyerCompany();
		buyer.setId(buyerId);		
		order.setBuyer(buyer);		
		order.setTitle(title);		
		CostCenter  costCenter = new CostCenter();
		costCenter.setId(costCenterId);		
		order.setCostCenter(costCenter);		
		ProfitCenter  profitCenter = new ProfitCenter();
		profitCenter.setId(profitCenterId);		
		order.setProfitCenter(profitCenter);		
		order.setTotalAmount(totalAmount);		
		order.setType(type);		
		order.setMarkAsDelete(markAsDelete);		
		RecurringInfo  recurringInfo = new RecurringInfo();
		recurringInfo.setId(recurringInfoId);		
		order.setRecurringInfo(recurringInfo);		
		order.setStatus(status);
	
		
		return order;			
		
	}
	public  SellerCompany removeOrder(String sellerCompanyId, String orderId){
		return new SellerCompany();
	}
	public  SellerCompany updateOrder(String sellerCompanyId, String orderId, String property, Object newValue){
		return new SellerCompany();
	}

	public  SellerCompany addCustSvcRep(String sellerCompanyId, String email, String passwd, String roleId) throws Exception
	{		
		CustSvcRep custSvcRep = createCustSvcRep(email, passwd, roleId);
		
		SellerCompany sellerCompany = loadSellerCompany(sellerCompanyId, allTokens());
		synchronized(sellerCompany){ 
			//will be good when the sellerCompany loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			sellerCompany.addCustSvcRep( custSvcRep );		
			return saveSellerCompany(sellerCompany, tokens().withCustSvcRepList().done());
		}
	}
	protected CustSvcRep createCustSvcRep(String email, String passwd, String roleId){

		CustSvcRep custSvcRep = new CustSvcRep();
		
		
		custSvcRep.setEmail(email);		
		custSvcRep.setPasswd(passwd);		
		Role  role = new Role();
		role.setId(roleId);		
		custSvcRep.setRole(role);
	
		
		return custSvcRep;			
		
	}
	public  SellerCompany removeCustSvcRep(String sellerCompanyId, String custSvcRepId){
		return new SellerCompany();
	}
	public  SellerCompany updateCustSvcRep(String sellerCompanyId, String custSvcRepId, String property, Object newValue){
		return new SellerCompany();
	}



}


