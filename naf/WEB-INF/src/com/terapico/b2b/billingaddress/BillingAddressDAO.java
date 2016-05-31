
package com.terapico.b2b.billingaddress;

import java.util.List;
import java.util.Set;
public interface BillingAddressDAO{

	
	public BillingAddress load(String billingAddressId,Set<String> options) throws Exception;
	public BillingAddress clone(String billingAddressId,Set<String> options) throws Exception;
	
	public BillingAddress save(BillingAddress billingAddress,Set<String> options);
	public List<BillingAddress> saveList(List<BillingAddress> billingAddressList,Set<String> options);
	
	public void delete(String billingAddressId, int version) throws Exception;
 	public List<BillingAddress> findBillingAddressByCompany(String buyerCompanyId);
 }


