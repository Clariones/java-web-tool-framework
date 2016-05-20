
package com.terapico.b2b;

import java.util.List;
import java.util.ArrayList;
public class BillingAddressJDBCTemplateDAO extends CommonJDBCTemplateDAO implements BillingAddressDAO{

	public BillingAddress load(String billingAddressId) throws BillingAddressNotFoundException{
		return loadInternalBillingAddress(billingAddressId);
	}
	public BillingAddress save(BillingAddress billingAddress){
		return billingAddress;
	}
	public void delete(String billingAddressId) throws BillingAddressNotFoundException{
	
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"company","line1","line2","city","state","country"};
	}
	@Override
	protected String getName() {
		
		return "billing_address";
	}
	
	 
 	private boolean extractCompanyEnabled = true;
 	public boolean isExtractCompanyEnabled(){
	 	return extractCompanyEnabled;
 	}
 	
 	public void setExtractCompanyEnabled(boolean extractCompanyEnabled){
	 	this.extractCompanyEnabled = extractCompanyEnabled;
 	}
 	
 	private boolean saveCompanyEnabled = true;
 	public boolean isSaveCompanyEnabled(){
	 	return saveCompanyEnabled;
 	}
 	
 	public void setSaveCompanyEnabled(boolean saveCompanyEnabled){
	 	this.saveCompanyEnabled = saveCompanyEnabled;
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
		
	

	protected BillingAddress extractBillingAddress(String billingAddressId){
		return null;
	}

	protected BillingAddress loadInternalBillingAddress(String billingAddressId){
		
		BillingAddress billingAddress = extractBillingAddress(billingAddressId);
 	
 		if(isExtractCompanyEnabled()){
	 		extractCompany(billingAddress);
 		}
 
		
		if(isExtractPaymentGroupListEnabled()){
	 		extractPaymentGroupList(billingAddress);
 		}		
		
		return billingAddress;
		
	}//method end loadInternalBillingAddress(String billingAddressId)
	
	//======================================================================================
	 
 	protected BillingAddress extractCompany(BillingAddress billingAddress){
 		
 		return billingAddress;
 	}
 		
 
		
	protected BillingAddress extractPaymentGroupList(BillingAddress billingAddress){
		
		return billingAddress;
	
	}	
		
	

	protected BillingAddress saveBillingAddress(BillingAddress  billingAddress){
	
		return billingAddress;
	
	}
	protected BillingAddress saveInternalBillingAddress(BillingAddress billingAddress){
		
		saveBillingAddress(billingAddress);
 	
 		if(isSaveCompanyEnabled()){
	 		saveCompany(billingAddress);
 		}
 
		
		if(isSavePaymentGroupListEnabled()){
	 		savePaymentGroupList(billingAddress);
 		}		
		
		return billingAddress;
		
	}//method end loadInternalBillingAddress(String billingAddressId)
	
	
	
	//======================================================================================
	 
 	protected BillingAddress saveCompany(BillingAddress billingAddress){
 	
 		return billingAddress;
 	}
 		
 
		
	protected BillingAddress savePaymentGroupList(BillingAddress billingAddress){
		
		return billingAddress;
	
	}
		
 	
 	public List<BillingAddress> findBillingAddressByCompany(String buyerCompanyId){
 		return new ArrayList<BillingAddress>();
 	}//find end
 
}


