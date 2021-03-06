
package com.terapico.b2b.buyercompany;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import com.terapico.b2b.order.Order;
import com.terapico.b2b.creditaccount.CreditAccount;
import com.terapico.b2b.billingaddress.BillingAddress;
import com.terapico.b2b.costcenter.CostCenter;
import com.terapico.b2b.employee.Employee;


import com.terapico.b2b.approval.Approval;
import com.terapico.b2b.confirmation.Confirmation;
import com.terapico.b2b.recurringinfo.RecurringInfo;
import com.terapico.b2b.shipment.Shipment;
import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.processing.Processing;
import com.terapico.b2b.costcenter.CostCenter;
import com.terapico.b2b.profitcenter.ProfitCenter;
import com.terapico.b2b.delivery.Delivery;
import com.terapico.b2b.sellercompany.SellerCompany;



public class BuyerCompanyManagerImpl implements BuyerCompanyManager {

	private  BuyerCompanyDAO  buyerCompanyDAO;
 	public void setBuyerCompanyDAO(BuyerCompanyDAO  buyerCompanyDAO){
 	
 		if(buyerCompanyDAO == null){
 			throw new IllegalStateException("Do not try to set buyerCompanyDAO to null.");
 		}
	 	this.buyerCompanyDAO = buyerCompanyDAO;
 	}
 	public BuyerCompanyDAO getBuyerCompanyDAO(){
 		if(this.buyerCompanyDAO == null){
 			throw new IllegalStateException("The BuyerCompanyDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.buyerCompanyDAO;
 	}
 	
 	public BuyerCompany saveBuyerCompany(BuyerCompany buyerCompany, Map<String,Object>options) throws Exception{	
 		return getBuyerCompanyDAO().save(buyerCompany, options);
 	}
 	public BuyerCompany loadBuyerCompany(String buyerCompanyId, Map<String,Object>options) throws Exception{	
 		return getBuyerCompanyDAO().load(buyerCompanyId, options);
 	}
 	
 	
 	
	public BuyerCompany createBuyerCompany(String name, String priceList, int rating, String logo, String owner, String[] optionsExpr) throws Exception
	{
		
		
		BuyerCompany buyerCompany=createNewBuyerCompany(optionsExpr);	

		buyerCompany.setName(name);
		buyerCompany.setPriceList(priceList);
		buyerCompany.setRating(rating);
		buyerCompany.setLogo(logo);
		buyerCompany.setOwner(owner);

		return saveBuyerCompany(buyerCompany, emptyOptions());
		

		
	}
	protected BuyerCompany createNewBuyerCompany(String[] optionsExpr) throws Exception
	{
		
		return new BuyerCompany();
		
	}
	public BuyerCompany updateBuyerCompany(String buyerCompanyId, String property, Object newValue) throws Exception 
	{
		return new BuyerCompany();
	}
	protected Map<String,Object> emptyOptions(){
		return new HashMap<String,Object>();
	}
	
	protected BuyerCompanyTokens tokens(){
		return BuyerCompanyTokens.start();
	}
	protected Map<String,Object> allTokens(){
		return BuyerCompanyTokens.all();
	}
	


	public void delete(String buyerCompanyId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  BuyerCompany addCostCenter(String buyerCompanyId, String name) throws Exception
	{		
		CostCenter costCenter = createCostCenter(name);
		
		BuyerCompany buyerCompany = loadBuyerCompany(buyerCompanyId, allTokens());
		synchronized(buyerCompany){ 
			//will be good when the buyerCompany loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			buyerCompany.addCostCenter( costCenter );		
			return saveBuyerCompany(buyerCompany, tokens().withCostCenterList().done());
		}
	}
	protected CostCenter createCostCenter(String name){

		CostCenter costCenter = new CostCenter();
		
		
		costCenter.setName(name);
	
		
		return costCenter;			
		
	}
	public  BuyerCompany removeCostCenter(String buyerCompanyId, String costCenterId){
		return new BuyerCompany();
	}
	public  BuyerCompany updateCostCenter(String buyerCompanyId, String costCenterId, String property, Object newValue){
		return new BuyerCompany();
	}

	public  BuyerCompany addCreditAccount(String buyerCompanyId, String name, String sellerId, double authorized, double remain) throws Exception
	{		
		CreditAccount creditAccount = createCreditAccount(name, sellerId, authorized, remain);
		
		BuyerCompany buyerCompany = loadBuyerCompany(buyerCompanyId, allTokens());
		synchronized(buyerCompany){ 
			//will be good when the buyerCompany loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			buyerCompany.addCreditAccount( creditAccount );		
			return saveBuyerCompany(buyerCompany, tokens().withCreditAccountList().done());
		}
	}
	protected CreditAccount createCreditAccount(String name, String sellerId, double authorized, double remain){

		CreditAccount creditAccount = new CreditAccount();
		
		
		creditAccount.setName(name);		
		SellerCompany  seller = new SellerCompany();
		seller.setId(sellerId);		
		creditAccount.setSeller(seller);		
		creditAccount.setAuthorized(authorized);		
		creditAccount.setRemain(remain);
	
		
		return creditAccount;			
		
	}
	public  BuyerCompany removeCreditAccount(String buyerCompanyId, String creditAccountId){
		return new BuyerCompany();
	}
	public  BuyerCompany updateCreditAccount(String buyerCompanyId, String creditAccountId, String property, Object newValue){
		return new BuyerCompany();
	}

	public  BuyerCompany addBillingAddress(String buyerCompanyId, String line1, String line2, String city, String state, String country) throws Exception
	{		
		BillingAddress billingAddress = createBillingAddress(line1, line2, city, state, country);
		
		BuyerCompany buyerCompany = loadBuyerCompany(buyerCompanyId, allTokens());
		synchronized(buyerCompany){ 
			//will be good when the buyerCompany loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			buyerCompany.addBillingAddress( billingAddress );		
			return saveBuyerCompany(buyerCompany, tokens().withBillingAddressList().done());
		}
	}
	protected BillingAddress createBillingAddress(String line1, String line2, String city, String state, String country){

		BillingAddress billingAddress = new BillingAddress();
		
		
		billingAddress.setLine1(line1);		
		billingAddress.setLine2(line2);		
		billingAddress.setCity(city);		
		billingAddress.setState(state);		
		billingAddress.setCountry(country);
	
		
		return billingAddress;			
		
	}
	public  BuyerCompany removeBillingAddress(String buyerCompanyId, String billingAddressId){
		return new BuyerCompany();
	}
	public  BuyerCompany updateBillingAddress(String buyerCompanyId, String billingAddressId, String property, Object newValue){
		return new BuyerCompany();
	}

	public  BuyerCompany addEmployee(String buyerCompanyId, String name, String email, String passwd, String cellPhone) throws Exception
	{		
		Employee employee = createEmployee(name, email, passwd, cellPhone);
		
		BuyerCompany buyerCompany = loadBuyerCompany(buyerCompanyId, allTokens());
		synchronized(buyerCompany){ 
			//will be good when the buyerCompany loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			buyerCompany.addEmployee( employee );		
			return saveBuyerCompany(buyerCompany, tokens().withEmployeeList().done());
		}
	}
	protected Employee createEmployee(String name, String email, String passwd, String cellPhone){

		Employee employee = new Employee();
		
		
		employee.setName(name);		
		employee.setEmail(email);		
		employee.setPasswd(passwd);		
		employee.setCellPhone(cellPhone);
	
		
		return employee;			
		
	}
	public  BuyerCompany removeEmployee(String buyerCompanyId, String employeeId){
		return new BuyerCompany();
	}
	public  BuyerCompany updateEmployee(String buyerCompanyId, String employeeId, String property, Object newValue){
		return new BuyerCompany();
	}

	public  BuyerCompany addOrder(String buyerCompanyId, String sellerId, String title, String costCenterId, String profitCenterId, double totalAmount, String type, boolean markAsDelete, String recurringInfoId, String status) throws Exception
	{		
		Order order = createOrder(sellerId, title, costCenterId, profitCenterId, totalAmount, type, markAsDelete, recurringInfoId, status);
		
		BuyerCompany buyerCompany = loadBuyerCompany(buyerCompanyId, allTokens());
		synchronized(buyerCompany){ 
			//will be good when the buyerCompany loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			buyerCompany.addOrder( order );		
			return saveBuyerCompany(buyerCompany, tokens().withOrderList().done());
		}
	}
	protected Order createOrder(String sellerId, String title, String costCenterId, String profitCenterId, double totalAmount, String type, boolean markAsDelete, String recurringInfoId, String status){

		Order order = new Order();
		
		
		SellerCompany  seller = new SellerCompany();
		seller.setId(sellerId);		
		order.setSeller(seller);		
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
	public  BuyerCompany removeOrder(String buyerCompanyId, String orderId){
		return new BuyerCompany();
	}
	public  BuyerCompany updateOrder(String buyerCompanyId, String orderId, String property, Object newValue){
		return new BuyerCompany();
	}



}


