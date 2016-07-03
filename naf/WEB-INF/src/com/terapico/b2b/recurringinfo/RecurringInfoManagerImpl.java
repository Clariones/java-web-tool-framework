
package com.terapico.b2b.recurringinfo;

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



public class RecurringInfoManagerImpl implements RecurringInfoManager {

	private  RecurringInfoDAO  recurringInfoDAO;
 	public void setRecurringInfoDAO(RecurringInfoDAO  recurringInfoDAO){
 	
 		if(recurringInfoDAO == null){
 			throw new IllegalStateException("Do not try to set recurringInfoDAO to null.");
 		}
	 	this.recurringInfoDAO = recurringInfoDAO;
 	}
 	public RecurringInfoDAO getRecurringInfoDAO(){
 		if(this.recurringInfoDAO == null){
 			throw new IllegalStateException("The RecurringInfoDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.recurringInfoDAO;
 	}
 	
 	public RecurringInfo saveRecurringInfo(RecurringInfo recurringInfo, Map<String,Object>options) throws Exception{	
 		return getRecurringInfoDAO().save(recurringInfo, options);
 	}
 	public RecurringInfo loadRecurringInfo(String recurringInfoId, Map<String,Object>options) throws Exception{	
 		return getRecurringInfoDAO().load(recurringInfoId, options);
 	}
 	
 	
 	
	public RecurringInfo createRecurringInfo(String name, Date nextTime, String cronExpr, String[] optionsExpr) throws Exception
	{
		
		
		RecurringInfo recurringInfo=createNewRecurringInfo(optionsExpr);	

		recurringInfo.setName(name);
		recurringInfo.setNextTime(nextTime);
		recurringInfo.setCronExpr(cronExpr);

		return saveRecurringInfo(recurringInfo, emptyOptions());
		

		
	}
	protected RecurringInfo createNewRecurringInfo(String[] optionsExpr) throws Exception
	{
		
		return new RecurringInfo();
		
	}
	public RecurringInfo updateRecurringInfo(String recurringInfoId, String property, Object newValue) throws Exception 
	{
		return new RecurringInfo();
	}
	protected Map<String,Object> emptyOptions(){
		return new HashMap<String,Object>();
	}
	
	protected RecurringInfoTokens tokens(){
		return RecurringInfoTokens.start();
	}
	protected Map<String,Object> allTokens(){
		return RecurringInfoTokens.all();
	}
	


	public void delete(String recurringInfoId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  RecurringInfo addOrder(String recurringInfoId, String buyerId, String sellerId, String title, String costCenterId, String profitCenterId, double totalAmount, String type, boolean markAsDelete, String status) throws Exception
	{		
		Order order = createOrder(buyerId, sellerId, title, costCenterId, profitCenterId, totalAmount, type, markAsDelete, status);
		
		RecurringInfo recurringInfo = loadRecurringInfo(recurringInfoId, allTokens());
		synchronized(recurringInfo){ 
			//will be good when the recurringInfo loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			recurringInfo.addOrder( order );		
			return saveRecurringInfo(recurringInfo, tokens().withOrderList().done());
		}
	}
	protected Order createOrder(String buyerId, String sellerId, String title, String costCenterId, String profitCenterId, double totalAmount, String type, boolean markAsDelete, String status){

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
		order.setStatus(status);
	
		
		return order;			
		
	}
	public  RecurringInfo removeOrder(String recurringInfoId, String orderId){
		return new RecurringInfo();
	}
	public  RecurringInfo updateOrder(String recurringInfoId, String orderId, String property, Object newValue){
		return new RecurringInfo();
	}



}


