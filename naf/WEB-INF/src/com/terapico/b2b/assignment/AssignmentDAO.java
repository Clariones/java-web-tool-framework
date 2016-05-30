
package com.terapico.b2b.assignment;

import java.util.List;
import java.util.Set;
public interface AssignmentDAO{

	
	public Assignment load(String assignmentId,Set<String> options) throws AssignmentNotFoundException;
	public Assignment clone(String assignmentId,Set<String> options) throws AssignmentNotFoundException;
	
	public Assignment save(Assignment assignment,Set<String> options);
	public List<Assignment> saveList(List<Assignment> assignmentList,Set<String> options);
	
	public void delete(String assignmentId, int version) throws Exception;
 	public List<Assignment> findAssignmentByUser(String employeeId);
  	public List<Assignment> findAssignmentByAccess(String accessId);
 }


