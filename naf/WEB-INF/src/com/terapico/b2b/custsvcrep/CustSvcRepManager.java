
package com.terapico.b2b.custsvcrep;

import java.util.Date;
public interface CustSvcRepManager{

	public CustSvcRep createCustSvcRep(String email, String passwd, String roleId, String companyId, String[] options) throws Exception;	
	public CustSvcRep updateCustSvcRep(String custSvcRepId, String property, Object newValue)  throws Exception;
	
	public CustSvcRep transferToNewRole(String custSvcRepId, String newRoleId)  throws Exception;
 	public CustSvcRep transferToNewCompany(String custSvcRepId, String newCompanyId)  throws Exception;
 

	public void delete(String custSvcRepId, int version) throws Exception;
	public int deleteAll() throws Exception;



}


