
package com.terapico.b2b.billingaddress;

import java.util.List;
import java.util.Set;
import java.util.Map;
public interface BillingAddressDAO{

	
	public BillingAddress load(String billingAddressId,Map<String,Object> options) throws Exception;
	public BillingAddress clone(String billingAddressId,Map<String,Object> options) throws Exception;
	
	public BillingAddress save(BillingAddress billingAddress,Map<String,Object> options);
	public List<BillingAddress> saveList(List<BillingAddress> billingAddressList,Map<String,Object> options);
	
	public void delete(String billingAddressId, int version) throws Exception;
	public int deleteAll() throws Exception;
 	public List<BillingAddress> findBillingAddressByCompany(String buyerCompanyId);
 }


