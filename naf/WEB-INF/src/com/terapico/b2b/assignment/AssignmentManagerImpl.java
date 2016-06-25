
package com.terapico.b2b.assignment;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import com.terapico.b2b.access.Access;
import com.terapico.b2b.employee.Employee;

import com.terapico.b2b.employee.EmployeeDAO;
import com.terapico.b2b.access.AccessDAO;




public class AssignmentManagerImpl implements AssignmentManager {

	private  AssignmentDAO  assignmentDAO;
 	public void setAssignmentDAO(AssignmentDAO  assignmentDAO){
 	
 		if(assignmentDAO == null){
 			throw new IllegalStateException("Do not try to set assignmentDAO to null.");
 		}
	 	this.assignmentDAO = assignmentDAO;
 	}
 	public AssignmentDAO getAssignmentDAO(){
 		if(this.assignmentDAO == null){
 			throw new IllegalStateException("The AssignmentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.assignmentDAO;
 	}
 	
 	public Assignment saveAssignment(Assignment assignment, Map<String,Object>options) throws Exception{	
 		return getAssignmentDAO().save(assignment, options);
 	}
 	public Assignment loadAssignment(String assignmentId, Map<String,Object>options) throws Exception{	
 		return getAssignmentDAO().load(assignmentId, options);
 	}
 	 
 	
 	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO employeeDAO){
	 	this.employeeDAO = employeeDAO;
 	}
 	public EmployeeDAO getEmployeeDAO(){
	 	return this.employeeDAO;
 	}
 
 	
 	private  AccessDAO  accessDAO;
 	public void setAccessDAO(AccessDAO accessDAO){
	 	this.accessDAO = accessDAO;
 	}
 	public AccessDAO getAccessDAO(){
	 	return this.accessDAO;
 	}

 	
 	
	public Assignment createAssignment(String userId, String accessId, Date assignedDate, String[] optionsExpr) throws Exception
	{
		
		
		Assignment assignment=createNewAssignment(optionsExpr);	

		Employee user = loadUser(userId,emptyOptions());
		assignment.setUser(user);
		Access access = loadAccess(accessId,emptyOptions());
		assignment.setAccess(access);
		assignment.setAssignedDate(assignedDate);
		//save for later setOrderValues(assignment);
		Map<String, Object> options = new HashMap<String, Object>();
		
		//return assignmentDAO.save(assignment, options);
		return saveAssignment(assignment, options);
		

		
	}
	protected Assignment createNewAssignment(String[] optionsExpr) throws Exception
	{
		
		return new Assignment();
		
	}
	public Assignment updateAssignment(String assignmentId, String property, Object newValue) throws Exception 
	{
		return new Assignment();
	}
	protected Map<String,Object> emptyOptions(){
		return new HashMap<String,Object>();
	}
	
	protected AssignmentTokens tokens(){
		return AssignmentTokens.start();
	}
	protected Map<String,Object> allTokens(){
		return AssignmentTokens.all();
	}
	
	public Assignment transferToNewUser(String assignmentId, String newUserId) throws Exception
 	{
 		Assignment assignment = loadAssignment(assignmentId, allTokens());	
		Employee user = loadUser(newUserId, emptyOptions());		
		assignment.setUser(user);		
		return saveAssignment(assignment, emptyOptions());
 	}
 	
 	protected Employee loadUser(String newUserId, Map<String,Object> options) throws Exception
 	{
 		return getEmployeeDAO().load(newUserId, options);
 	}
 	
 	public Assignment transferToNewAccess(String assignmentId, String newAccessId) throws Exception
 	{
 		Assignment assignment = loadAssignment(assignmentId, allTokens());	
		Access access = loadAccess(newAccessId, emptyOptions());		
		assignment.setAccess(access);		
		return saveAssignment(assignment, emptyOptions());
 	}
 	
 	protected Access loadAccess(String newAccessId, Map<String,Object> options) throws Exception
 	{
 		return getAccessDAO().load(newAccessId, options);
 	}
 	
 

	public void delete(String assignmentId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}


}


