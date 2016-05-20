
package com.terapico.b2b;

import java.util.List;
import java.util.ArrayList;
public class ShippingAddressJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ShippingAddressDAO{

	public ShippingAddress load(String shippingAddressId) throws ShippingAddressNotFoundException{
		return loadInternalShippingAddress(shippingAddressId);
	}
	public ShippingAddress save(ShippingAddress shippingAddress){
		return shippingAddress;
	}
	public void delete(String shippingAddressId) throws ShippingAddressNotFoundException{
	
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"line1","line2","city","state","country"};
	}
	@Override
	protected String getName() {
		
		return "shipping_address";
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
		
	

	protected ShippingAddress extractShippingAddress(String shippingAddressId){
		return null;
	}

	protected ShippingAddress loadInternalShippingAddress(String shippingAddressId){
		
		ShippingAddress shippingAddress = extractShippingAddress(shippingAddressId);

		
		if(isExtractShippingGroupListEnabled()){
	 		extractShippingGroupList(shippingAddress);
 		}		
		
		return shippingAddress;
		
	}//method end loadInternalShippingAddress(String shippingAddressId)
	
	//======================================================================================
	
		
	protected ShippingAddress extractShippingGroupList(ShippingAddress shippingAddress){
		
		return shippingAddress;
	
	}	
		
	

	protected ShippingAddress saveShippingAddress(ShippingAddress  shippingAddress){
	
		return shippingAddress;
	
	}
	protected ShippingAddress saveInternalShippingAddress(ShippingAddress shippingAddress){
		
		saveShippingAddress(shippingAddress);

		
		if(isSaveShippingGroupListEnabled()){
	 		saveShippingGroupList(shippingAddress);
 		}		
		
		return shippingAddress;
		
	}//method end loadInternalShippingAddress(String shippingAddressId)
	
	
	
	//======================================================================================
	
		
	protected ShippingAddress saveShippingGroupList(ShippingAddress shippingAddress){
		
		return shippingAddress;
	
	}
		

}


