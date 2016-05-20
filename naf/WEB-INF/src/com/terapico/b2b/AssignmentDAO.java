
package com.terapico.b2b;

import java.util.List;

public interface AssignmentDAO{

	
	public Assignment load(String assignmentId) throws AssignmentNotFoundException;
	public Assignment save(Assignment assignment);
	public void delete(String assignmentId) throws AssignmentNotFoundException;
 	public List<Assignment> findAssignmentByUser(String employeeId);
  	public List<Assignment> findAssignmentByAccess(String accessId);
 }


