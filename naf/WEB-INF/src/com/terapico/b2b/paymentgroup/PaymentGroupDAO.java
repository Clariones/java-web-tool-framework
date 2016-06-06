
package com.terapico.b2b.paymentgroup;

import java.util.List;
import java.util.Set;
public interface PaymentGroupDAO{

	
	public PaymentGroup load(String paymentGroupId,Set<String> options) throws Exception;
	public PaymentGroup clone(String paymentGroupId,Set<String> options) throws Exception;
	
	public PaymentGroup save(PaymentGroup paymentGroup,Set<String> options);
	public List<PaymentGroup> saveList(List<PaymentGroup> paymentGroupList,Set<String> options);
	
	public void delete(String paymentGroupId, int version) throws Exception;
	public int deleteAll() throws Exception;
 	public List<PaymentGroup> findPaymentGroupByBizOrder(String orderId);
  	public List<PaymentGroup> findPaymentGroupByBillingAddress(String billingAddressId);
 }


