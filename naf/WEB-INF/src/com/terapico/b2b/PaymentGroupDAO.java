
package com.terapico.b2b;

import java.util.List;

public interface PaymentGroupDAO{

	
	public PaymentGroup load(String paymentGroupId) throws PaymentGroupNotFoundException;
	public PaymentGroup save(PaymentGroup paymentGroup);
	public void delete(String paymentGroupId) throws PaymentGroupNotFoundException;
 	public List<PaymentGroup> findPaymentGroupByBizOrder(String orderId);
  	public List<PaymentGroup> findPaymentGroupByBillingAddress(String billingAddressId);
 }


