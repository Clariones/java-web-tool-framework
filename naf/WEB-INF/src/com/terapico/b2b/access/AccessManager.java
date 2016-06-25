
package com.terapico.b2b.access;

import java.util.Date;
public interface AccessManager{

	public Access createAccess(String roleName, String roleId, String[] options) throws Exception;	
	public Access updateAccess(String accessId, String property, Object newValue)  throws Exception;
	
	public Access transferToNewRole(String accessId, String newRoleId)  throws Exception;
 

	public void delete(String accessId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public  Access addAssignment(String accessId, String userId, Date assignedDate)  throws Exception;
	public  Access removeAssignment(String accessId, String assignmentId)  throws Exception;
	public  Access updateAssignment(String accessId, String assignmentId, String property, Object newValue)  throws Exception;




}


