
package com.terapico.b2b.paymentgroup;

import java.util.List;
import java.util.Set;
public interface PaymentGroupService{

	
	public PaymentGroup createPaymentGroup(String paymentGroupId,String[] options) throws Exception;
	public PaymentGroup clone(String paymentGroupId, String[] options) throws Exception;
	
	public PaymentGroup save(PaymentGroup paymentGroup,String[] options);
	public List<PaymentGroup> saveList(List<PaymentGroup> paymentGroupList,String[] options);
	
	public void delete(String paymentGroupId, int version) throws Exception;
	public int deleteAll() throws Exception;
 	public List<PaymentGroup> findPaymentGroupByBizOrder(String orderId);
  	public List<PaymentGroup> findPaymentGroupByBillingAddress(String billingAddressId);
 }


