
package com.terapico.b2b.access;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import com.terapico.b2b.role.Role;
import com.terapico.b2b.assignment.Assignment;

import com.terapico.b2b.role.RoleDAO;

import com.terapico.b2b.access.Access;
import com.terapico.b2b.employee.Employee;



public class AccessManagerImpl implements AccessManager {

	private  AccessDAO  accessDAO;
 	public void setAccessDAO(AccessDAO  accessDAO){
 	
 		if(accessDAO == null){
 			throw new IllegalStateException("Do not try to set accessDAO to null.");
 		}
	 	this.accessDAO = accessDAO;
 	}
 	public AccessDAO getAccessDAO(){
 		if(this.accessDAO == null){
 			throw new IllegalStateException("The AccessDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.accessDAO;
 	}
 	
 	public Access saveAccess(Access access, Map<String,Object>options) throws Exception{	
 		return getAccessDAO().save(access, options);
 	}
 	public Access loadAccess(String accessId, Map<String,Object>options) throws Exception{	
 		return getAccessDAO().load(accessId, options);
 	}
 	 
 	
 	private  RoleDAO  roleDAO;
 	public void setRoleDAO(RoleDAO roleDAO){
	 	this.roleDAO = roleDAO;
 	}
 	public RoleDAO getRoleDAO(){
	 	return this.roleDAO;
 	}

 	
 	
	public Access createAccess(String roleName, String roleId, String[] optionsExpr) throws Exception
	{
		
		
		Access access=createNewAccess(optionsExpr);	

		access.setRoleName(roleName);
		Role role = loadRole(roleId,emptyOptions());
		access.setRole(role);

		return saveAccess(access, emptyOptions());
		

		
	}
	protected Access createNewAccess(String[] optionsExpr) throws Exception
	{
		
		return new Access();
		
	}
	public Access updateAccess(String accessId, String property, Object newValue) throws Exception 
	{
		return new Access();
	}
	protected Map<String,Object> emptyOptions(){
		return new HashMap<String,Object>();
	}
	
	protected AccessTokens tokens(){
		return AccessTokens.start();
	}
	protected Map<String,Object> allTokens(){
		return AccessTokens.all();
	}
	
	public Access transferToNewRole(String accessId, String newRoleId) throws Exception
 	{
 
		Access access = loadAccess(accessId, allTokens());	
		synchronized(access){
			//will be good when the access loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			Role role = loadRole(newRoleId, emptyOptions());		
			access.setRole(role);		
			return saveAccess(access, emptyOptions());
		}
 	}
 	
 	protected Role loadRole(String newRoleId, Map<String,Object> options) throws Exception
 	{
 		return getRoleDAO().load(newRoleId, options);
 	}
 	
 

	public void delete(String accessId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  Access addAssignment(String accessId, String userId, Date assignedDate) throws Exception
	{		
		Assignment assignment = createAssignment(userId, assignedDate);
		
		Access access = loadAccess(accessId, allTokens());
		synchronized(access){ 
			//will be good when the access loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			access.addAssignment( assignment );		
			return saveAccess(access, tokens().withAssignmentList().done());
		}
	}
	protected Assignment createAssignment(String userId, Date assignedDate){

		Assignment assignment = new Assignment();
		
		
		Employee  user = new Employee();
		user.setId(userId);		
		assignment.setUser(user);		
		assignment.setAssignedDate(assignedDate);
	
		
		return assignment;			
		
	}
	public  Access removeAssignment(String accessId, String assignmentId){
		return new Access();
	}
	public  Access updateAssignment(String accessId, String assignmentId, String property, Object newValue){
		return new Access();
	}



}


