
package com.terapico.b2b.confirmation;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import com.terapico.b2b.order.Order;


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



public class ConfirmationManagerImpl implements ConfirmationManager {

	private  ConfirmationDAO  confirmationDAO;
 	public void setConfirmationDAO(ConfirmationDAO  confirmationDAO){
 	
 		if(confirmationDAO == null){
 			throw new IllegalStateException("Do not try to set confirmationDAO to null.");
 		}
	 	this.confirmationDAO = confirmationDAO;
 	}
 	public ConfirmationDAO getConfirmationDAO(){
 		if(this.confirmationDAO == null){
 			throw new IllegalStateException("The ConfirmationDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.confirmationDAO;
 	}
 	
 	public Confirmation saveConfirmation(Confirmation confirmation, Map<String,Object>options) throws Exception{	
 		return getConfirmationDAO().save(confirmation, options);
 	}
 	public Confirmation loadConfirmation(String confirmationId, Map<String,Object>options) throws Exception{	
 		return getConfirmationDAO().load(confirmationId, options);
 	}
 	
 	
 	
	public Confirmation createConfirmation(String who, Date confirmTime, String[] optionsExpr) throws Exception
	{
		
		
		Confirmation confirmation=createNewConfirmation(optionsExpr);	

		confirmation.setWho(who);
		confirmation.setConfirmTime(confirmTime);

		return saveConfirmation(confirmation, emptyOptions());
		

		
	}
	protected Confirmation createNewConfirmation(String[] optionsExpr) throws Exception
	{
		
		return new Confirmation();
		
	}
	public Confirmation updateConfirmation(String confirmationId, String property, Object newValue) throws Exception 
	{
		return new Confirmation();
	}
	protected Map<String,Object> emptyOptions(){
		return new HashMap<String,Object>();
	}
	
	protected ConfirmationTokens tokens(){
		return ConfirmationTokens.start();
	}
	protected Map<String,Object> allTokens(){
		return ConfirmationTokens.all();
	}
	


	public void delete(String confirmationId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  Confirmation addOrder(String confirmationId, String buyerId, String sellerId, String title, String costCenterId, String profitCenterId, double totalAmount, String type, boolean markAsDelete, String recurringInfoId, String status) throws Exception
	{		
		Order order = createOrder(buyerId, sellerId, title, costCenterId, profitCenterId, totalAmount, type, markAsDelete, recurringInfoId, status);
		
		Confirmation confirmation = loadConfirmation(confirmationId, allTokens());
		synchronized(confirmation){ 
			//will be good when the confirmation loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			confirmation.addOrder( order );		
			return saveConfirmation(confirmation, tokens().withOrderList().done());
		}
	}
	protected Order createOrder(String buyerId, String sellerId, String title, String costCenterId, String profitCenterId, double totalAmount, String type, boolean markAsDelete, String recurringInfoId, String status){

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
	public  Confirmation removeOrder(String confirmationId, String orderId){
		return new Confirmation();
	}
	public  Confirmation updateOrder(String confirmationId, String orderId, String property, Object newValue){
		return new Confirmation();
	}



}


