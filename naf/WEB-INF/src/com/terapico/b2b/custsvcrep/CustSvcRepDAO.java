
package com.terapico.b2b.custsvcrep;

import java.util.List;
import java.util.Set;
public interface CustSvcRepDAO{

	
	public CustSvcRep load(String custSvcRepId,Set<String> options) throws Exception;
	public CustSvcRep clone(String custSvcRepId,Set<String> options) throws Exception;
	
	public CustSvcRep save(CustSvcRep custSvcRep,Set<String> options);
	public List<CustSvcRep> saveList(List<CustSvcRep> custSvcRepList,Set<String> options);
	
	public void delete(String custSvcRepId, int version) throws Exception;
 	public List<CustSvcRep> findCustSvcRepByRole(String roleId);
  	public List<CustSvcRep> findCustSvcRepByCompany(String sellerCompanyId);
 }











