
package com.terapico.b2b.paymentgroup;

import java.util.List;
import java.util.Set;
import java.util.Map;
public interface PaymentGroupDAO{

	
	public PaymentGroup load(String paymentGroupId,Map<String,Object> options) throws Exception;
	public PaymentGroup clone(String paymentGroupId,Map<String,Object> options) throws Exception;
	
	public PaymentGroup save(PaymentGroup paymentGroup,Map<String,Object> options);
	public List<PaymentGroup> saveList(List<PaymentGroup> paymentGroupList,Map<String,Object> options);
	
	public void delete(String paymentGroupId, int version) throws Exception;
	public int deleteAll() throws Exception;
 	public List<PaymentGroup> findPaymentGroupByBizOrder(String orderId);
  	public List<PaymentGroup> findPaymentGroupByBillingAddress(String billingAddressId);
 }


