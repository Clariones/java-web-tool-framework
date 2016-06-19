
package com.terapico.b2b.assignment;

import java.util.List;
import java.util.Set;
public interface AssignmentService{

	
	public Assignment createAssignment(String assignmentId,String[] options) throws Exception;
	public Assignment clone(String assignmentId, String[] options) throws Exception;
	
	public Assignment save(Assignment assignment,String[] options);
	public List<Assignment> saveList(List<Assignment> assignmentList,String[] options);
	
	public void delete(String assignmentId, int version) throws Exception;
	public int deleteAll() throws Exception;
 	public List<Assignment> findAssignmentByUser(String employeeId);
  	public List<Assignment> findAssignmentByAccess(String accessId);
 }


