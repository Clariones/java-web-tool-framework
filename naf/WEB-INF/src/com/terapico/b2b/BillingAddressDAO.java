
package com.terapico.b2b;

import java.util.List;

public interface BillingAddressDAO{

	
	public BillingAddress load(String billingAddressId) throws BillingAddressNotFoundException;
	public BillingAddress save(BillingAddress billingAddress);
	public void delete(String billingAddressId) throws BillingAddressNotFoundException;
 	public List<BillingAddress> findBillingAddressByCompany(String buyerCompanyId);
 }


