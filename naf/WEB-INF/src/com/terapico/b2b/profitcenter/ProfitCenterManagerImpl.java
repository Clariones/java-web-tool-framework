
package com.terapico.b2b.profitcenter;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import com.terapico.b2b.order.Order;
import com.terapico.b2b.sellercompany.SellerCompany;

import com.terapico.b2b.sellercompany.SellerCompanyDAO;

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



public class ProfitCenterManagerImpl implements ProfitCenterManager {

	private  ProfitCenterDAO  profitCenterDAO;
 	public void setProfitCenterDAO(ProfitCenterDAO  profitCenterDAO){
 	
 		if(profitCenterDAO == null){
 			throw new IllegalStateException("Do not try to set profitCenterDAO to null.");
 		}
	 	this.profitCenterDAO = profitCenterDAO;
 	}
 	public ProfitCenterDAO getProfitCenterDAO(){
 		if(this.profitCenterDAO == null){
 			throw new IllegalStateException("The ProfitCenterDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.profitCenterDAO;
 	}
 	
 	public ProfitCenter saveProfitCenter(ProfitCenter profitCenter, Map<String,Object>options) throws Exception{	
 		return getProfitCenterDAO().save(profitCenter, options);
 	}
 	public ProfitCenter loadProfitCenter(String profitCenterId, Map<String,Object>options) throws Exception{	
 		return getProfitCenterDAO().load(profitCenterId, options);
 	}
 	 
 	
 	private  SellerCompanyDAO  sellerCompanyDAO;
 	public void setSellerCompanyDAO(SellerCompanyDAO sellerCompanyDAO){
	 	this.sellerCompanyDAO = sellerCompanyDAO;
 	}
 	public SellerCompanyDAO getSellerCompanyDAO(){
	 	return this.sellerCompanyDAO;
 	}

 	
 	
	public ProfitCenter createProfitCenter(String name, String belongsToId, String[] optionsExpr) throws Exception
	{
		
		
		ProfitCenter profitCenter=createNewProfitCenter(optionsExpr);	

		profitCenter.setName(name);
		SellerCompany belongsTo = loadBelongsTo(belongsToId,emptyOptions());
		profitCenter.setBelongsTo(belongsTo);

		return saveProfitCenter(profitCenter, emptyOptions());
		

		
	}
	protected ProfitCenter createNewProfitCenter(String[] optionsExpr) throws Exception
	{
		
		return new ProfitCenter();
		
	}
	public ProfitCenter updateProfitCenter(String profitCenterId, String property, Object newValue) throws Exception 
	{
		return new ProfitCenter();
	}
	protected Map<String,Object> emptyOptions(){
		return new HashMap<String,Object>();
	}
	
	protected ProfitCenterTokens tokens(){
		return ProfitCenterTokens.start();
	}
	protected Map<String,Object> allTokens(){
		return ProfitCenterTokens.all();
	}
	
	public ProfitCenter transferToNewBelongsTo(String profitCenterId, String newBelongsToId) throws Exception
 	{
 
		ProfitCenter profitCenter = loadProfitCenter(profitCenterId, allTokens());	
		synchronized(profitCenter){
			//will be good when the profitCenter loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			SellerCompany belongsTo = loadBelongsTo(newBelongsToId, emptyOptions());		
			profitCenter.setBelongsTo(belongsTo);		
			return saveProfitCenter(profitCenter, emptyOptions());
		}
 	}
 	
 	protected SellerCompany loadBelongsTo(String newBelongsToId, Map<String,Object> options) throws Exception
 	{
 		return getSellerCompanyDAO().load(newBelongsToId, options);
 	}
 	
 

	public void delete(String profitCenterId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  ProfitCenter addOrder(String profitCenterId, String buyerId, String sellerId, String title, String costCenterId, double totalAmount, String type, boolean markAsDelete, String recurringInfoId, String status) throws Exception
	{		
		Order order = createOrder(buyerId, sellerId, title, costCenterId, totalAmount, type, markAsDelete, recurringInfoId, status);
		
		ProfitCenter profitCenter = loadProfitCenter(profitCenterId, allTokens());
		synchronized(profitCenter){ 
			//will be good when the profitCenter loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			profitCenter.addOrder( order );		
			return saveProfitCenter(profitCenter, tokens().withOrderList().done());
		}
	}
	protected Order createOrder(String buyerId, String sellerId, String title, String costCenterId, double totalAmount, String type, boolean markAsDelete, String recurringInfoId, String status){

		Order order = new Order();
		
		
		BuyerCompany  buyer = new BuyerCompany();
		buyer.setId(buyerId);		
		order.setBuyer(buyer);		
		SellerCompany  seller = new SellerCompany();
		seller.setId(sellerId);		
		order.setSeller(seller);		
		order.setTitle(title);		
		CostCenter  costCenter = new CostCenter();
		costCenter.setId(costCenterId);		
		order.setCostCenter(costCenter);		
		order.setTotalAmount(totalAmount);		
		order.setType(type);		
		order.setMarkAsDelete(markAsDelete);		
		RecurringInfo  recurringInfo = new RecurringInfo();
		recurringInfo.setId(recurringInfoId);		
		order.setRecurringInfo(recurringInfo);		
		order.setStatus(status);
	
		
		return order;			
		
	}
	public  ProfitCenter removeOrder(String profitCenterId, String orderId){
		return new ProfitCenter();
	}
	public  ProfitCenter updateOrder(String profitCenterId, String orderId, String property, Object newValue){
		return new ProfitCenter();
	}



}


