
package com.terapico.b2b;

import java.util.List;
import java.util.ArrayList;
public class PaymentGroupJDBCTemplateDAO extends CommonJDBCTemplateDAO implements PaymentGroupDAO{

	public PaymentGroup load(String paymentGroupId) throws PaymentGroupNotFoundException{
		return loadInternalPaymentGroup(paymentGroupId);
	}
	public PaymentGroup save(PaymentGroup paymentGroup){
		return paymentGroup;
	}
	public void delete(String paymentGroupId) throws PaymentGroupNotFoundException{
	
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"name","biz_order","card_number","billing_address"};
	}
	@Override
	protected String getName() {
		
		return "payment_group";
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
 	
  
 	private boolean extractBillingAddressEnabled = true;
 	public boolean isExtractBillingAddressEnabled(){
	 	return extractBillingAddressEnabled;
 	}
 	
 	public void setExtractBillingAddressEnabled(boolean extractBillingAddressEnabled){
	 	this.extractBillingAddressEnabled = extractBillingAddressEnabled;
 	}
 	
 	private boolean saveBillingAddressEnabled = true;
 	public boolean isSaveBillingAddressEnabled(){
	 	return saveBillingAddressEnabled;
 	}
 	
 	public void setSaveBillingAddressEnabled(boolean saveBillingAddressEnabled){
	 	this.saveBillingAddressEnabled = saveBillingAddressEnabled;
 	}
 	
 
		
	

	protected PaymentGroup extractPaymentGroup(String paymentGroupId){
		return null;
	}

	protected PaymentGroup loadInternalPaymentGroup(String paymentGroupId){
		
		PaymentGroup paymentGroup = extractPaymentGroup(paymentGroupId);
 	
 		if(isExtractBizOrderEnabled()){
	 		extractBizOrder(paymentGroup);
 		}
  	
 		if(isExtractBillingAddressEnabled()){
	 		extractBillingAddress(paymentGroup);
 		}
 
		
		return paymentGroup;
		
	}//method end loadInternalPaymentGroup(String paymentGroupId)
	
	//======================================================================================
	 
 	protected PaymentGroup extractBizOrder(PaymentGroup paymentGroup){
 		
 		return paymentGroup;
 	}
 		
  
 	protected PaymentGroup extractBillingAddress(PaymentGroup paymentGroup){
 		
 		return paymentGroup;
 	}
 		
 
		
	

	protected PaymentGroup savePaymentGroup(PaymentGroup  paymentGroup){
	
		return paymentGroup;
	
	}
	protected PaymentGroup saveInternalPaymentGroup(PaymentGroup paymentGroup){
		
		savePaymentGroup(paymentGroup);
 	
 		if(isSaveBizOrderEnabled()){
	 		saveBizOrder(paymentGroup);
 		}
  	
 		if(isSaveBillingAddressEnabled()){
	 		saveBillingAddress(paymentGroup);
 		}
 
		
		return paymentGroup;
		
	}//method end loadInternalPaymentGroup(String paymentGroupId)
	
	
	
	//======================================================================================
	 
 	protected PaymentGroup saveBizOrder(PaymentGroup paymentGroup){
 	
 		return paymentGroup;
 	}
 		
  
 	protected PaymentGroup saveBillingAddress(PaymentGroup paymentGroup){
 	
 		return paymentGroup;
 	}
 		
 
		
 	
 	public List<PaymentGroup> findPaymentGroupByBizOrder(String orderId){
 		return new ArrayList<PaymentGroup>();
 	}//find end
  	
 	public List<PaymentGroup> findPaymentGroupByBillingAddress(String billingAddressId){
 		return new ArrayList<PaymentGroup>();
 	}//find end
 
}


