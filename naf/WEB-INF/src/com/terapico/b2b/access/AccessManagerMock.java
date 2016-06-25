
package com.terapico.b2b.access;

import java.util.Date;
public class AccessManagerMock implements AccessManager {

	public Access createAccess(String roleName, String roleId, String[] options) throws Exception
	{
		return new Access();
	}
	public Access updateAccess(String accessId, String property, Object newValue) throws Exception 
	{
		return new Access();
	}
	
	public Access transferToNewRole(String accessId, String newRoleId) throws Exception
 	{
 		return new Access();
 
 	}
 

	public void delete(String accessId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  Access addAssignment(String accessId, String userId, Date assignedDate)
	{
		return new Access();
	}
	public  Access removeAssignment(String accessId, String assignmentId){
		return new Access();
	}
	public  Access updateAssignment(String accessId, String assignmentId, String property, Object newValue){
		return new Access();
	}




}


