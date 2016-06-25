
package com.terapico.b2b.assignment;

import java.util.Date;
public class AssignmentManagerMock implements AssignmentManager {

	public Assignment createAssignment(String userId, String accessId, Date assignedDate, String[] options) throws Exception
	{
		return new Assignment();
	}
	public Assignment updateAssignment(String assignmentId, String property, Object newValue) throws Exception 
	{
		return new Assignment();
	}
	
	public Assignment transferToNewUser(String assignmentId, String newUserId) throws Exception
 	{
 		return new Assignment();
 
 	}
 	public Assignment transferToNewAccess(String assignmentId, String newAccessId) throws Exception
 	{
 		return new Assignment();
 
 	}
 

	public void delete(String assignmentId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}



}


