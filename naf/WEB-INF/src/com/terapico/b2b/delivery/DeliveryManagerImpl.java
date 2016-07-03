
package com.terapico.b2b.delivery;

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



public class DeliveryManagerImpl implements DeliveryManager {

	private  DeliveryDAO  deliveryDAO;
 	public void setDeliveryDAO(DeliveryDAO  deliveryDAO){
 	
 		if(deliveryDAO == null){
 			throw new IllegalStateException("Do not try to set deliveryDAO to null.");
 		}
	 	this.deliveryDAO = deliveryDAO;
 	}
 	public DeliveryDAO getDeliveryDAO(){
 		if(this.deliveryDAO == null){
 			throw new IllegalStateException("The DeliveryDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.deliveryDAO;
 	}
 	
 	public Delivery saveDelivery(Delivery delivery, Map<String,Object>options) throws Exception{	
 		return getDeliveryDAO().save(delivery, options);
 	}
 	public Delivery loadDelivery(String deliveryId, Map<String,Object>options) throws Exception{	
 		return getDeliveryDAO().load(deliveryId, options);
 	}
 	
 	
 	
	public Delivery createDelivery(String who, Date deliveryTime, String[] optionsExpr) throws Exception
	{
		
		
		Delivery delivery=createNewDelivery(optionsExpr);	

		delivery.setWho(who);
		delivery.setDeliveryTime(deliveryTime);

		return saveDelivery(delivery, emptyOptions());
		

		
	}
	protected Delivery createNewDelivery(String[] optionsExpr) throws Exception
	{
		
		return new Delivery();
		
	}
	public Delivery updateDelivery(String deliveryId, String property, Object newValue) throws Exception 
	{
		return new Delivery();
	}
	protected Map<String,Object> emptyOptions(){
		return new HashMap<String,Object>();
	}
	
	protected DeliveryTokens tokens(){
		return DeliveryTokens.start();
	}
	protected Map<String,Object> allTokens(){
		return DeliveryTokens.all();
	}
	


	public void delete(String deliveryId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  Delivery addOrder(String deliveryId, String buyerId, String sellerId, String title, String costCenterId, String profitCenterId, double totalAmount, String type, boolean markAsDelete, String recurringInfoId, String status) throws Exception
	{		
		Order order = createOrder(buyerId, sellerId, title, costCenterId, profitCenterId, totalAmount, type, markAsDelete, recurringInfoId, status);
		
		Delivery delivery = loadDelivery(deliveryId, allTokens());
		synchronized(delivery){ 
			//will be good when the delivery loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			delivery.addOrder( order );		
			return saveDelivery(delivery, tokens().withOrderList().done());
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
	public  Delivery removeOrder(String deliveryId, String orderId){
		return new Delivery();
	}
	public  Delivery updateOrder(String deliveryId, String orderId, String property, Object newValue){
		return new Delivery();
	}



}


