
package com.terapico.b2b.assignment;

import java.util.List;
import java.util.Set;
import java.util.Map;
public interface AssignmentDAO{

	
	public Assignment load(String assignmentId,Map<String,Object> options) throws Exception;
	public Assignment clone(String assignmentId,Map<String,Object> options) throws Exception;
	
	public Assignment save(Assignment assignment,Map<String,Object> options);
	public List<Assignment> saveList(List<Assignment> assignmentList,Map<String,Object> options);
	
	public void delete(String assignmentId, int version) throws Exception;
	public int deleteAll() throws Exception;
 	public List<Assignment> findAssignmentByUser(String employeeId);
  	public List<Assignment> findAssignmentByAccess(String accessId);
 }


