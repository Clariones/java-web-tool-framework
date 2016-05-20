
package com.terapico.b2b;

import java.util.List;
import java.util.ArrayList;
public class OrderJDBCTemplateDAO extends CommonJDBCTemplateDAO implements OrderDAO{

	public Order load(String orderId) throws OrderNotFoundException{
		return loadInternalOrder(orderId);
	}
	public Order save(Order order){
		return order;
	}
	public void delete(String orderId) throws OrderNotFoundException{
	
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"buyer","seller","title","total_amount","type"};
	}
	@Override
	protected String getName() {
		
		return "order";
	}
	
	 
 	private boolean extractBuyerEnabled = true;
 	public boolean isExtractBuyerEnabled(){
	 	return extractBuyerEnabled;
 	}
 	
 	public void setExtractBuyerEnabled(boolean extractBuyerEnabled){
	 	this.extractBuyerEnabled = extractBuyerEnabled;
 	}
 	
 	private boolean saveBuyerEnabled = true;
 	public boolean isSaveBuyerEnabled(){
	 	return saveBuyerEnabled;
 	}
 	
 	public void setSaveBuyerEnabled(boolean saveBuyerEnabled){
	 	this.saveBuyerEnabled = saveBuyerEnabled;
 	}
 	
  
 	private boolean extractSellerEnabled = true;
 	public boolean isExtractSellerEnabled(){
	 	return extractSellerEnabled;
 	}
 	
 	public void setExtractSellerEnabled(boolean extractSellerEnabled){
	 	this.extractSellerEnabled = extractSellerEnabled;
 	}
 	
 	private boolean saveSellerEnabled = true;
 	public boolean isSaveSellerEnabled(){
	 	return saveSellerEnabled;
 	}
 	
 	public void setSaveSellerEnabled(boolean saveSellerEnabled){
	 	this.saveSellerEnabled = saveSellerEnabled;
 	}
 	
 
		
	private boolean extractPaymentGroupListEnabled = false;
	public boolean isExtractPaymentGroupListEnabled(){
		return extractPaymentGroupListEnabled;
		
 	}
 	public void setExtractPaymentGroupListEnabled(boolean extractPaymentGroupListEnabled){
		this.extractPaymentGroupListEnabled = extractPaymentGroupListEnabled;
		
 	}
 	
 	private boolean savePaymentGroupListEnabled = false;
	public boolean isSavePaymentGroupListEnabled(){
		return savePaymentGroupListEnabled;
		
 	}
 	public void setSavePaymentGroupListEnabled(boolean savePaymentGroupListEnabled){
		this.savePaymentGroupListEnabled = savePaymentGroupListEnabled;
		
 	}			
		
	private boolean extractShippingGroupListEnabled = false;
	public boolean isExtractShippingGroupListEnabled(){
		return extractShippingGroupListEnabled;
		
 	}
 	public void setExtractShippingGroupListEnabled(boolean extractShippingGroupListEnabled){
		this.extractShippingGroupListEnabled = extractShippingGroupListEnabled;
		
 	}
 	
 	private boolean saveShippingGroupListEnabled = false;
	public boolean isSaveShippingGroupListEnabled(){
		return saveShippingGroupListEnabled;
		
 	}
 	public void setSaveShippingGroupListEnabled(boolean saveShippingGroupListEnabled){
		this.saveShippingGroupListEnabled = saveShippingGroupListEnabled;
		
 	}			
		
	private boolean extractLineItemListEnabled = false;
	public boolean isExtractLineItemListEnabled(){
		return extractLineItemListEnabled;
		
 	}
 	public void setExtractLineItemListEnabled(boolean extractLineItemListEnabled){
		this.extractLineItemListEnabled = extractLineItemListEnabled;
		
 	}
 	
 	private boolean saveLineItemListEnabled = false;
	public boolean isSaveLineItemListEnabled(){
		return saveLineItemListEnabled;
		
 	}
 	public void setSaveLineItemListEnabled(boolean saveLineItemListEnabled){
		this.saveLineItemListEnabled = saveLineItemListEnabled;
		
 	}			
		
	

	protected Order extractOrder(String orderId){
		return null;
	}

	protected Order loadInternalOrder(String orderId){
		
		Order order = extractOrder(orderId);
 	
 		if(isExtractBuyerEnabled()){
	 		extractBuyer(order);
 		}
  	
 		if(isExtractSellerEnabled()){
	 		extractSeller(order);
 		}
 
		
		if(isExtractPaymentGroupListEnabled()){
	 		extractPaymentGroupList(order);
 		}		
		
		if(isExtractShippingGroupListEnabled()){
	 		extractShippingGroupList(order);
 		}		
		
		if(isExtractLineItemListEnabled()){
	 		extractLineItemList(order);
 		}		
		
		return order;
		
	}//method end loadInternalOrder(String orderId)
	
	//======================================================================================
	 
 	protected Order extractBuyer(Order order){
 		
 		return order;
 	}
 		
  
 	protected Order extractSeller(Order order){
 		
 		return order;
 	}
 		
 
		
	protected Order extractPaymentGroupList(Order order){
		
		return order;
	
	}	
		
	protected Order extractShippingGroupList(Order order){
		
		return order;
	
	}	
		
	protected Order extractLineItemList(Order order){
		
		return order;
	
	}	
		
	

	protected Order saveOrder(Order  order){
	
		return order;
	
	}
	protected Order saveInternalOrder(Order order){
		
		saveOrder(order);
 	
 		if(isSaveBuyerEnabled()){
	 		saveBuyer(order);
 		}
  	
 		if(isSaveSellerEnabled()){
	 		saveSeller(order);
 		}
 
		
		if(isSavePaymentGroupListEnabled()){
	 		savePaymentGroupList(order);
 		}		
		
		if(isSaveShippingGroupListEnabled()){
	 		saveShippingGroupList(order);
 		}		
		
		if(isSaveLineItemListEnabled()){
	 		saveLineItemList(order);
 		}		
		
		return order;
		
	}//method end loadInternalOrder(String orderId)
	
	
	
	//======================================================================================
	 
 	protected Order saveBuyer(Order order){
 	
 		return order;
 	}
 		
  
 	protected Order saveSeller(Order order){
 	
 		return order;
 	}
 		
 
		
	protected Order savePaymentGroupList(Order order){
		
		return order;
	
	}
		
	protected Order saveShippingGroupList(Order order){
		
		return order;
	
	}
		
	protected Order saveLineItemList(Order order){
		
		return order;
	
	}
		
 	
 	public List<Order> findOrderByBuyer(String buyerCompanyId){
 		return new ArrayList<Order>();
 	}//find end
  	
 	public List<Order> findOrderBySeller(String sellerCompanyId){
 		return new ArrayList<Order>();
 	}//find end
 
}


