
package com.terapico.b2b.custsvcrep;

import java.util.List;
import java.util.Set;
public interface CustSvcRepService{

	
	public CustSvcRep createCustSvcRep(String custSvcRepId,String[] options) throws Exception;
	public CustSvcRep clone(String custSvcRepId, String[] options) throws Exception;
	
	public CustSvcRep save(CustSvcRep custSvcRep,String[] options);
	public List<CustSvcRep> saveList(List<CustSvcRep> custSvcRepList,String[] options);
	
	public void delete(String custSvcRepId, int version) throws Exception;
	public int deleteAll() throws Exception;
 	public List<CustSvcRep> findCustSvcRepByRole(String roleId);
  	public List<CustSvcRep> findCustSvcRepByCompany(String sellerCompanyId);
 }


