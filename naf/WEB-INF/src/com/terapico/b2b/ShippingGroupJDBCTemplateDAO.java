
package com.terapico.b2b;

import java.util.List;
import java.util.ArrayList;
public class ShippingGroupJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ShippingGroupDAO{

	public ShippingGroup load(String shippingGroupId) throws ShippingGroupNotFoundException{
		return loadInternalShippingGroup(shippingGroupId);
	}
	public ShippingGroup save(ShippingGroup shippingGroup){
		return shippingGroup;
	}
	public void delete(String shippingGroupId) throws ShippingGroupNotFoundException{
	
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"name","biz_order","address","amount"};
	}
	@Override
	protected String getName() {
		
		return "shipping_group";
	}
	
	 
 	private boolean extractBizOrderEnabled = true;
 	public boolean isExtractBizOrderEnabled(){
	 	return extractBizOrderEnabled;
 	}
 	
 	public void setExtractBizOrderEnabled(boolean extractBizOrderEnabled){
	 	this.extractBizOrderEnabled = extractBizOrderEnabled;
 	}
 	
 	private boolean saveBizOrderEnabled = true;
 	public boolean isSaveBizOrderEnabled(){
	 	return saveBizOrderEnabled;
 	}
 	
 	public void setSaveBizOrderEnabled(boolean saveBizOrderEnabled){
	 	this.saveBizOrderEnabled = saveBizOrderEnabled;
 	}
 	
  
 	private boolean extractAddressEnabled = true;
 	public boolean isExtractAddressEnabled(){
	 	return extractAddressEnabled;
 	}
 	
 	public void setExtractAddressEnabled(boolean extractAddressEnabled){
	 	this.extractAddressEnabled = extractAddressEnabled;
 	}
 	
 	private boolean saveAddressEnabled = true;
 	public boolean isSaveAddressEnabled(){
	 	return saveAddressEnabled;
 	}
 	
 	public void setSaveAddressEnabled(boolean saveAddressEnabled){
	 	this.saveAddressEnabled = saveAddressEnabled;
 	}
 	
 
		
	

	protected ShippingGroup extractShippingGroup(String shippingGroupId){
		return null;
	}

	protected ShippingGroup loadInternalShippingGroup(String shippingGroupId){
		
		ShippingGroup shippingGroup = extractShippingGroup(shippingGroupId);
 	
 		if(isExtractBizOrderEnabled()){
	 		extractBizOrder(shippingGroup);
 		}
  	
 		if(isExtractAddressEnabled()){
	 		extractAddress(shippingGroup);
 		}
 
		
		return shippingGroup;
		
	}//method end loadInternalShippingGroup(String shippingGroupId)
	
	//======================================================================================
	 
 	protected ShippingGroup extractBizOrder(ShippingGroup shippingGroup){
 		
 		return shippingGroup;
 	}
 		
  
 	protected ShippingGroup extractAddress(ShippingGroup shippingGroup){
 		
 		return shippingGroup;
 	}
 		
 
		
	

	protected ShippingGroup saveShippingGroup(ShippingGroup  shippingGroup){
	
		return shippingGroup;
	
	}
	protected ShippingGroup saveInternalShippingGroup(ShippingGroup shippingGroup){
		
		saveShippingGroup(shippingGroup);
 	
 		if(isSaveBizOrderEnabled()){
	 		saveBizOrder(shippingGroup);
 		}
  	
 		if(isSaveAddressEnabled()){
	 		saveAddress(shippingGroup);
 		}
 
		
		return shippingGroup;
		
	}//method end loadInternalShippingGroup(String shippingGroupId)
	
	
	
	//======================================================================================
	 
 	protected ShippingGroup saveBizOrder(ShippingGroup shippingGroup){
 	
 		return shippingGroup;
 	}
 		
  
 	protected ShippingGroup saveAddress(ShippingGroup shippingGroup){
 	
 		return shippingGroup;
 	}
 		
 
		
 	
 	public List<ShippingGroup> findShippingGroupByBizOrder(String orderId){
 		return new ArrayList<ShippingGroup>();
 	}//find end
  	
 	public List<ShippingGroup> findShippingGroupByAddress(String shippingAddressId){
 		return new ArrayList<ShippingGroup>();
 	}//find end
 
}


