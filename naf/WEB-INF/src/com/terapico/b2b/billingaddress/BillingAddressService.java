
package com.terapico.b2b.billingaddress;

import java.util.List;
import java.util.Set;
public interface BillingAddressService{

	
	public BillingAddress createBillingAddress(String billingAddressId,String[] options) throws Exception;
	public BillingAddress clone(String billingAddressId, String[] options) throws Exception;
	
	public BillingAddress save(BillingAddress billingAddress,String[] options);
	public List<BillingAddress> saveList(List<BillingAddress> billingAddressList,String[] options);
	
	public void delete(String billingAddressId, int version) throws Exception;
	public int deleteAll() throws Exception;
 	public List<BillingAddress> findBillingAddressByCompany(String buyerCompanyId);
 }


