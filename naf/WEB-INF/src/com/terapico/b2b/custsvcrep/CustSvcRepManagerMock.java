
package com.terapico.b2b.custsvcrep;

import java.util.Date;
public class CustSvcRepManagerMock implements CustSvcRepManager {

	public CustSvcRep createCustSvcRep(String email, String roleId, String companyId, String[] options) throws Exception
	{
		return new CustSvcRep();
	}
	public CustSvcRep updateCustSvcRep(String custSvcRepId, String property, Object newValue) throws Exception 
	{
		return new CustSvcRep();
	}
	
	public CustSvcRep transferToNewRole(String custSvcRepId, String newRoleId) throws Exception
 	{
 		return new CustSvcRep();
 
 	}
 	public CustSvcRep transferToNewCompany(String custSvcRepId, String newCompanyId) throws Exception
 	{
 		return new CustSvcRep();
 
 	}
 

	public void delete(String custSvcRepId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}



}


