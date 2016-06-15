
package com.terapico.b2b.custsvcrep;

import java.util.List;
import java.util.Set;
import java.util.Map;
public interface CustSvcRepDAO{

	
	public CustSvcRep load(String custSvcRepId,Map<String,Object> options) throws Exception;
	public CustSvcRep clone(String custSvcRepId,Map<String,Object> options) throws Exception;
	
	public CustSvcRep save(CustSvcRep custSvcRep,Map<String,Object> options);
	public List<CustSvcRep> saveList(List<CustSvcRep> custSvcRepList,Map<String,Object> options);
	
	public void delete(String custSvcRepId, int version) throws Exception;
	public int deleteAll() throws Exception;
 	public List<CustSvcRep> findCustSvcRepByRole(String roleId);
  	public List<CustSvcRep> findCustSvcRepByCompany(String sellerCompanyId);
 }


