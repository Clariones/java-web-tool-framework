
package com.terapico.b2b.costcenter;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import com.terapico.b2b.order.Order;
import com.terapico.b2b.buyercompany.BuyerCompany;

import com.terapico.b2b.buyercompany.BuyerCompanyDAO;

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



public class CostCenterManagerImpl implements CostCenterManager {

	private  CostCenterDAO  costCenterDAO;
 	public void setCostCenterDAO(CostCenterDAO  costCenterDAO){
 	
 		if(costCenterDAO == null){
 			throw new IllegalStateException("Do not try to set costCenterDAO to null.");
 		}
	 	this.costCenterDAO = costCenterDAO;
 	}
 	public CostCenterDAO getCostCenterDAO(){
 		if(this.costCenterDAO == null){
 			throw new IllegalStateException("The CostCenterDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.costCenterDAO;
 	}
 	
 	public CostCenter saveCostCenter(CostCenter costCenter, Map<String,Object>options) throws Exception{	
 		return getCostCenterDAO().save(costCenter, options);
 	}
 	public CostCenter loadCostCenter(String costCenterId, Map<String,Object>options) throws Exception{	
 		return getCostCenterDAO().load(costCenterId, options);
 	}
 	 
 	
 	private  BuyerCompanyDAO  buyerCompanyDAO;
 	public void setBuyerCompanyDAO(BuyerCompanyDAO buyerCompanyDAO){
	 	this.buyerCompanyDAO = buyerCompanyDAO;
 	}
 	public BuyerCompanyDAO getBuyerCompanyDAO(){
	 	return this.buyerCompanyDAO;
 	}

 	
 	
	public CostCenter createCostCenter(String name, String belongsToId, String[] optionsExpr) throws Exception
	{
		
		
		CostCenter costCenter=createNewCostCenter(optionsExpr);	

		costCenter.setName(name);
		BuyerCompany belongsTo = loadBelongsTo(belongsToId,emptyOptions());
		costCenter.setBelongsTo(belongsTo);

		return saveCostCenter(costCenter, emptyOptions());
		

		
	}
	protected CostCenter createNewCostCenter(String[] optionsExpr) throws Exception
	{
		
		return new CostCenter();
		
	}
	public CostCenter updateCostCenter(String costCenterId, String property, Object newValue) throws Exception 
	{
		return new CostCenter();
	}
	protected Map<String,Object> emptyOptions(){
		return new HashMap<String,Object>();
	}
	
	protected CostCenterTokens tokens(){
		return CostCenterTokens.start();
	}
	protected Map<String,Object> allTokens(){
		return CostCenterTokens.all();
	}
	
	public CostCenter transferToNewBelongsTo(String costCenterId, String newBelongsToId) throws Exception
 	{
 
		CostCenter costCenter = loadCostCenter(costCenterId, allTokens());	
		synchronized(costCenter){
			//will be good when the costCenter loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			BuyerCompany belongsTo = loadBelongsTo(newBelongsToId, emptyOptions());		
			costCenter.setBelongsTo(belongsTo);		
			return saveCostCenter(costCenter, emptyOptions());
		}
 	}
 	
 	protected BuyerCompany loadBelongsTo(String newBelongsToId, Map<String,Object> options) throws Exception
 	{
 		return getBuyerCompanyDAO().load(newBelongsToId, options);
 	}
 	
 

	public void delete(String costCenterId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  CostCenter addOrder(String costCenterId, String buyerId, String sellerId, String title, String profitCenterId, double totalAmount, String type, boolean markAsDelete, String recurringInfoId, String status) throws Exception
	{		
		Order order = createOrder(buyerId, sellerId, title, profitCenterId, totalAmount, type, markAsDelete, recurringInfoId, status);
		
		CostCenter costCenter = loadCostCenter(costCenterId, allTokens());
		synchronized(costCenter){ 
			//will be good when the costCenter loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			costCenter.addOrder( order );		
			return saveCostCenter(costCenter, tokens().withOrderList().done());
		}
	}
	protected Order createOrder(String buyerId, String sellerId, String title, String profitCenterId, double totalAmount, String type, boolean markAsDelete, String recurringInfoId, String status){

		Order order = new Order();
		
		
		BuyerCompany  buyer = new BuyerCompany();
		buyer.setId(buyerId);		
		order.setBuyer(buyer);		
		SellerCompany  seller = new SellerCompany();
		seller.setId(sellerId);		
		order.setSeller(seller);		
		order.setTitle(title);		
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
	public  CostCenter removeOrder(String costCenterId, String orderId){
		return new CostCenter();
	}
	public  CostCenter updateOrder(String costCenterId, String orderId, String property, Object newValue){
		return new CostCenter();
	}



}


