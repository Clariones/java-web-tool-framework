
package com.terapico.b2b.role;

import java.util.Date;
public class RoleManagerMock implements RoleManager {

	public Role createRole(String roleName, String[] options) throws Exception
	{
		return new Role();
	}
	public Role updateRole(String roleId, String property, Object newValue) throws Exception 
	{
		return new Role();
	}
	


	public void delete(String roleId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  Role addAccess(String roleId, String roleName)
	{
		return new Role();
	}
	public  Role removeAccess(String roleId, String accessId){
		return new Role();
	}
	public  Role updateAccess(String roleId, String accessId, String property, Object newValue){
		return new Role();
	}

	public  Role addCustSvcRep(String roleId, String email, String passwd, String companyId)
	{
		return new Role();
	}
	public  Role removeCustSvcRep(String roleId, String custSvcRepId){
		return new Role();
	}
	public  Role updateCustSvcRep(String roleId, String custSvcRepId, String property, Object newValue){
		return new Role();
	}




}


