
package com.terapico.b2b.role;

import java.util.Date;
public interface RoleManager{

	public Role createRole(String roleName, String[] options) throws Exception;	
	public Role updateRole(String roleId, String property, Object newValue)  throws Exception;
	


	public void delete(String roleId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public  Role addAccess(String roleId, String roleName)  throws Exception;
	public  Role removeAccess(String roleId, String accessId)  throws Exception;
	public  Role updateAccess(String roleId, String accessId, String property, Object newValue)  throws Exception;

	public  Role addCustSvcRep(String roleId, String email, String companyId)  throws Exception;
	public  Role removeCustSvcRep(String roleId, String custSvcRepId)  throws Exception;
	public  Role updateCustSvcRep(String roleId, String custSvcRepId, String property, Object newValue)  throws Exception;




}


