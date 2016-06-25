
package com.terapico.b2b.processing;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import com.terapico.b2b.order.Order;

import com.terapico.b2b.order.OrderDAO;

import com.terapico.b2b.approval.Approval;
import com.terapico.b2b.confirmation.Confirmation;
import com.terapico.b2b.shipment.Shipment;
import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.processing.Processing;
import com.terapico.b2b.delivery.Delivery;
import com.terapico.b2b.sellercompany.SellerCompany;



public class ProcessingManagerImpl implements ProcessingManager {

	private  ProcessingDAO  processingDAO;
 	public void setProcessingDAO(ProcessingDAO  processingDAO){
 	
 		if(processingDAO == null){
 			throw new IllegalStateException("Do not try to set processingDAO to null.");
 		}
	 	this.processingDAO = processingDAO;
 	}
 	public ProcessingDAO getProcessingDAO(){
 		if(this.processingDAO == null){
 			throw new IllegalStateException("The ProcessingDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.processingDAO;
 	}
 	
 	public Processing saveProcessing(Processing processing, Map<String,Object>options) throws Exception{	
 		return getProcessingDAO().save(processing, options);
 	}
 	public Processing loadProcessing(String processingId, Map<String,Object>options) throws Exception{	
 		return getProcessingDAO().load(processingId, options);
 	}
 	
 	
 	
	public Processing createProcessing(String who, Date processTime, String[] optionsExpr) throws Exception
	{
		
		
		Processing processing=createNewProcessing(optionsExpr);	

		processing.setWho(who);
		processing.setProcessTime(processTime);
		//save for later setOrderValues(processing);
		Map<String, Object> options = new HashMap<String, Object>();
		
		//return processingDAO.save(processing, options);
		return saveProcessing(processing, options);
		

		
	}
	protected Processing createNewProcessing(String[] optionsExpr) throws Exception
	{
		
		return new Processing();
		
	}
	public Processing updateProcessing(String processingId, String property, Object newValue) throws Exception 
	{
		return new Processing();
	}
	protected Map<String,Object> emptyOptions(){
		return new HashMap<String,Object>();
	}
	
	protected ProcessingTokens tokens(){
		return ProcessingTokens.start();
	}
	protected Map<String,Object> allTokens(){
		return ProcessingTokens.all();
	}
	


	public void delete(String processingId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  Processing addOrder(String processingId, String buyerId, String sellerId, String title, double totalAmount, String type, boolean markAsDelete) throws Exception
	{		
		Order order = createOrder(buyerId, sellerId, title, totalAmount, type, markAsDelete);
		
		Processing processing = loadProcessing(processingId, allTokens());
		
		processing.addOrder( order );
		
		return saveProcessing(processing, tokens().withOrderList().done());
	}
	protected Order createOrder(String buyerId, String sellerId, String title, double totalAmount, String type, boolean markAsDelete){

		Order order = new Order();
		
		
		BuyerCompany  buyer = new BuyerCompany();
		buyer.setId(buyerId);		
		order.setBuyer(buyer);		
		SellerCompany  seller = new SellerCompany();
		seller.setId(sellerId);		
		order.setSeller(seller);		
		order.setTitle(title);		
		order.setTotalAmount(totalAmount);		
		order.setType(type);		
		order.setMarkAsDelete(markAsDelete);
	
		
		return order;			
		
	}
	public  Processing removeOrder(String processingId, String orderId){
		return new Processing();
	}
	public  Processing updateOrder(String processingId, String orderId, String property, Object newValue){
		return new Processing();
	}



}


