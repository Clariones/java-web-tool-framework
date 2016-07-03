
package com.terapico.b2b.paymentgroup;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import com.terapico.b2b.order.Order;
import com.terapico.b2b.billingaddress.BillingAddress;

import com.terapico.b2b.billingaddress.BillingAddressDAO;
import com.terapico.b2b.order.OrderDAO;




public class PaymentGroupManagerImpl implements PaymentGroupManager {

	private  PaymentGroupDAO  paymentGroupDAO;
 	public void setPaymentGroupDAO(PaymentGroupDAO  paymentGroupDAO){
 	
 		if(paymentGroupDAO == null){
 			throw new IllegalStateException("Do not try to set paymentGroupDAO to null.");
 		}
	 	this.paymentGroupDAO = paymentGroupDAO;
 	}
 	public PaymentGroupDAO getPaymentGroupDAO(){
 		if(this.paymentGroupDAO == null){
 			throw new IllegalStateException("The PaymentGroupDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.paymentGroupDAO;
 	}
 	
 	public PaymentGroup savePaymentGroup(PaymentGroup paymentGroup, Map<String,Object>options) throws Exception{	
 		return getPaymentGroupDAO().save(paymentGroup, options);
 	}
 	public PaymentGroup loadPaymentGroup(String paymentGroupId, Map<String,Object>options) throws Exception{	
 		return getPaymentGroupDAO().load(paymentGroupId, options);
 	}
 	 
 	
 	private  OrderDAO  orderDAO;
 	public void setOrderDAO(OrderDAO orderDAO){
	 	this.orderDAO = orderDAO;
 	}
 	public OrderDAO getOrderDAO(){
	 	return this.orderDAO;
 	}
 
 	
 	private  BillingAddressDAO  billingAddressDAO;
 	public void setBillingAddressDAO(BillingAddressDAO billingAddressDAO){
	 	this.billingAddressDAO = billingAddressDAO;
 	}
 	public BillingAddressDAO getBillingAddressDAO(){
	 	return this.billingAddressDAO;
 	}

 	
 	
	public PaymentGroup createPaymentGroup(String name, String bizOrderId, String cardNumber, String billingAddressId, String[] optionsExpr) throws Exception
	{
		
		
		PaymentGroup paymentGroup=createNewPaymentGroup(optionsExpr);	

		paymentGroup.setName(name);
		Order bizOrder = loadBizOrder(bizOrderId,emptyOptions());
		paymentGroup.setBizOrder(bizOrder);
		paymentGroup.setCardNumber(cardNumber);
		BillingAddress billingAddress = loadBillingAddress(billingAddressId,emptyOptions());
		paymentGroup.setBillingAddress(billingAddress);

		return savePaymentGroup(paymentGroup, emptyOptions());
		

		
	}
	protected PaymentGroup createNewPaymentGroup(String[] optionsExpr) throws Exception
	{
		
		return new PaymentGroup();
		
	}
	public PaymentGroup updatePaymentGroup(String paymentGroupId, String property, Object newValue) throws Exception 
	{
		return new PaymentGroup();
	}
	protected Map<String,Object> emptyOptions(){
		return new HashMap<String,Object>();
	}
	
	protected PaymentGroupTokens tokens(){
		return PaymentGroupTokens.start();
	}
	protected Map<String,Object> allTokens(){
		return PaymentGroupTokens.all();
	}
	
	public PaymentGroup transferToNewBizOrder(String paymentGroupId, String newBizOrderId) throws Exception
 	{
 
		PaymentGroup paymentGroup = loadPaymentGroup(paymentGroupId, allTokens());	
		synchronized(paymentGroup){
			//will be good when the paymentGroup loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			Order bizOrder = loadBizOrder(newBizOrderId, emptyOptions());		
			paymentGroup.setBizOrder(bizOrder);		
			return savePaymentGroup(paymentGroup, emptyOptions());
		}
 	}
 	
 	protected Order loadBizOrder(String newBizOrderId, Map<String,Object> options) throws Exception
 	{
 		return getOrderDAO().load(newBizOrderId, options);
 	}
 	
 	public PaymentGroup transferToNewBillingAddress(String paymentGroupId, String newBillingAddressId) throws Exception
 	{
 
		PaymentGroup paymentGroup = loadPaymentGroup(paymentGroupId, allTokens());	
		synchronized(paymentGroup){
			//will be good when the paymentGroup loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			BillingAddress billingAddress = loadBillingAddress(newBillingAddressId, emptyOptions());		
			paymentGroup.setBillingAddress(billingAddress);		
			return savePaymentGroup(paymentGroup, emptyOptions());
		}
 	}
 	
 	protected BillingAddress loadBillingAddress(String newBillingAddressId, Map<String,Object> options) throws Exception
 	{
 		return getBillingAddressDAO().load(newBillingAddressId, options);
 	}
 	
 

	public void delete(String paymentGroupId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}


}


