
package com.terapico.b2b.approval;

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



public class ApprovalManagerImpl implements ApprovalManager {

	private  ApprovalDAO  approvalDAO;
 	public void setApprovalDAO(ApprovalDAO  approvalDAO){
 	
 		if(approvalDAO == null){
 			throw new IllegalStateException("Do not try to set approvalDAO to null.");
 		}
	 	this.approvalDAO = approvalDAO;
 	}
 	public ApprovalDAO getApprovalDAO(){
 		if(this.approvalDAO == null){
 			throw new IllegalStateException("The ApprovalDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.approvalDAO;
 	}
 	
 	public Approval saveApproval(Approval approval, Map<String,Object>options) throws Exception{	
 		return getApprovalDAO().save(approval, options);
 	}
 	public Approval loadApproval(String approvalId, Map<String,Object>options) throws Exception{	
 		return getApprovalDAO().load(approvalId, options);
 	}
 	
 	
 	
	public Approval createApproval(String who, Date approveTime, String[] optionsExpr) throws Exception
	{
		
		
		Approval approval=createNewApproval(optionsExpr);	

		approval.setWho(who);
		approval.setApproveTime(approveTime);

		return saveApproval(approval, emptyOptions());
		

		
	}
	protected Approval createNewApproval(String[] optionsExpr) throws Exception
	{
		
		return new Approval();
		
	}
	public Approval updateApproval(String approvalId, String property, Object newValue) throws Exception 
	{
		return new Approval();
	}
	protected Map<String,Object> emptyOptions(){
		return new HashMap<String,Object>();
	}
	
	protected ApprovalTokens tokens(){
		return ApprovalTokens.start();
	}
	protected Map<String,Object> allTokens(){
		return ApprovalTokens.all();
	}
	


	public void delete(String approvalId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  Approval addOrder(String approvalId, String buyerId, String sellerId, String title, String costCenterId, String profitCenterId, double totalAmount, String type, boolean markAsDelete, String recurringInfoId, String status) throws Exception
	{		
		Order order = createOrder(buyerId, sellerId, title, costCenterId, profitCenterId, totalAmount, type, markAsDelete, recurringInfoId, status);
		
		Approval approval = loadApproval(approvalId, allTokens());
		synchronized(approval){ 
			//will be good when the approval loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			approval.addOrder( order );		
			return saveApproval(approval, tokens().withOrderList().done());
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
	public  Approval removeOrder(String approvalId, String orderId){
		return new Approval();
	}
	public  Approval updateOrder(String approvalId, String orderId, String property, Object newValue){
		return new Approval();
	}



}


