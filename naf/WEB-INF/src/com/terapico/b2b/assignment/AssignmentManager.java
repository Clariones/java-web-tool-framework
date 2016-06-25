
package com.terapico.b2b.assignment;

import java.util.Date;
public interface AssignmentManager{

	public Assignment createAssignment(String userId, String accessId, Date assignedDate, String[] options) throws Exception;	
	public Assignment updateAssignment(String assignmentId, String property, Object newValue)  throws Exception;
	
	public Assignment transferToNewUser(String assignmentId, String newUserId)  throws Exception;
 	public Assignment transferToNewAccess(String assignmentId, String newAccessId)  throws Exception;
 

	public void delete(String assignmentId, int version) throws Exception;
	public int deleteAll() throws Exception;



}


