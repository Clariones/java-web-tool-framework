
package com.terapico.b2b.access;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import com.terapico.b2b.CommonJDBCTemplateDAO;
import com.terapico.b2b.role.Role;
import com.terapico.b2b.assignment.Assignment;

import com.terapico.b2b.assignment.AssignmentMapper;
import com.terapico.b2b.role.RoleMapper;

import com.terapico.b2b.role.RoleDAO;
import com.terapico.b2b.assignment.AssignmentDAO;

public class AccessJDBCTemplateDAO extends CommonJDBCTemplateDAO implements AccessDAO{
 
 	
 	private  RoleDAO  roleDAO;
 	public void setRoleDAO(RoleDAO roleDAO){
	 	this.roleDAO = roleDAO;
 	}
 	public RoleDAO getRoleDAO(){
	 	return this.roleDAO;
 	}

		
	
  	private  AssignmentDAO  assignmentDAO;
 	public void setAssignmentDAO(AssignmentDAO pAssignmentDAO){
 	
 		if(pAssignmentDAO == null){
 			throw new IllegalStateException("Do not trying to set assignmentDAO to null.");
 		}
	 	this.assignmentDAO = pAssignmentDAO;
 	}
 	public AssignmentDAO getAssignmentDAO(){
 		if(this.assignmentDAO == null){
 			throw new IllegalStateException("The assignmentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.assignmentDAO;
 	}	
 	
			
		

	public Access load(String accessId,Set<String> options) throws AccessNotFoundException{
		return loadInternalAccess(accessId, options);
	}
	public Access save(Access access,Set<String> options){
		return saveInternalAccess(access,options);
	}
	public Access clone(String accessId,Set<String> options) throws AccessNotFoundException{
		Access newAccess = load(accessId, options);
		newAccess.setVersion(0);
		
		
 		
 		if(isSaveAssignmentListEnabled(options)){
 			for(Assignment item: newAccess.getAssignmentList()){
 				item.setVersion(0);
 			}
 		}
		
		
		saveInternalAccess(newAccess,options);
		
		return newAccess;
	}
	public void delete(String accessId, int version) throws Exception{
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{accessId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			// two suitations here, this object has been deleted; or
			// the version has been changed, the client should reload it and ensure this can be deleted
			SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
			parameters=new Object[]{accessId};
			int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
			if(count == 1){
				throw new AccessVersionChangedException("The object version has been changed, please reload to delete");
			}
			if(count < 1){
				throw new AccessNotFoundException("The object alread has been deleted.");
			}
			if(count > 1){
				throw new IllegalStateException("The database PRIMARY KEY constraint has been damaged, please fix it.");
			}
		
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"role"};
	}
	@Override
	protected String getName() {
		
		return "access";
	}
	
	
	static final String ALL="__all__"; //do not assign this to common users,
	protected boolean checkOptions(Set<String> options, String optionToCheck){
	
		if(options==null){
 			return false;
 		}
 		if(options.contains(optionToCheck)){
 			return true;
 		}
 		if(options.contains(ALL)){
 			return true;
 		}
 		return false;
	
	}

 
 	//private boolean extractRoleEnabled = true;
 	private static final String ROLE = "role";
 	protected boolean isExtractRoleEnabled(Set<String> options){
 		
	 	return checkOptions(options, ROLE);
 	}
 	
 	
 	//private boolean saveRoleEnabled = true;
 	protected boolean isSaveRoleEnabled(Set<String> options){
	 	
 		return checkOptions(options, ROLE);
 	}
 	

 	
 
		
	protected static final String ASSIGNMENT_LIST = "assignmentList";
	
	protected boolean isExtractAssignmentListEnabled(Set<String> options){
		
 		return checkOptions(options,ASSIGNMENT_LIST);
		
 	}

	protected boolean isSaveAssignmentListEnabled(Set<String> options){
		return checkOptions(options, ASSIGNMENT_LIST);
		
 	}
 	
 	
			
		
	


	protected Access extractAccess(String accessId){
		String SQL = "select * from access_data where id=?";	
		Access access = getJdbcTemplateObject().queryForObject(SQL, new Object[]{accessId},new AccessMapper());
		return access;
	}

	protected Access loadInternalAccess(String accessId, Set<String> loadOptions){
		
		Access access = extractAccess(accessId);
 	
 		if(isExtractRoleEnabled(loadOptions)){
	 		extractRole(access);
 		}
 
		
		if(isExtractAssignmentListEnabled(loadOptions)){
	 		extractAssignmentList(access);
 		}		
		
		return access;
		
	}
	
	
	 

 	protected Access extractRole(Access access){
 		
 		String SQL = "select * from role_data where id=?";
		Role role = getJdbcTemplateObject().queryForObject(SQL, new Object[]{access.getRole().getId()},new RoleMapper());
		if(role != null){
			access.setRole(role);
		}
		
		
 		
 		return access;
 	}
 		
 
		
	protected Access extractAssignmentList(Access access){
		
		String SQL = "select * from assignment_data where access = ?";
		List<Assignment> assignmentList = getJdbcTemplateObject().query(SQL, new Object[]{access.getId()},new AssignmentMapper());
		if(assignmentList != null){
			access.setAssignmentList(assignmentList);
		}
		
		return access;
	
	}	
		
	

	protected Access saveAccess(Access  access){
	
		String SQL=this.getSaveAccessSQL(access);
		Object [] parameters = getSaveAccessParameters(access);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		return access;
	
	}
	public List<Access> saveList(List<Access> accessList,Set<String> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitAccessList(accessList);
		
		batchCreate((List<Access>)lists[CREATE_LIST_INDEX]);
		
		batchUpdate((List<Access>)lists[UPDATE_LIST_INDEX]);

		return accessList;
	}

	
	protected List<Object[]> prepareBatchCreateArgs(List<Access> accessList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Access access:accessList ){
			Object [] parameters = prepareCreateAccessParameters(access);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBatchUpdateArgs(List<Access> accessList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Access access:accessList ){
			Object [] parameters = prepareUpdateAccessParameters(access);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCreate(List<Access> accessList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBatchCreateArgs(accessList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUpdate(List<Access> accessList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBatchUpdateArgs(accessList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitAccessList(List<Access> accessList){
		
		List<Access> accessCreateList=new ArrayList<Access>();
		List<Access> accessUpdateList=new ArrayList<Access>();
		
		for(Access access: accessList){
			if(isUpdateRequest(access)){
				accessUpdateList.add( access);
				continue;
			}
			accessCreateList.add(access);
		}
		
		return new Object[]{accessCreateList,accessUpdateList};
	}
	
	protected boolean isUpdateRequest(Access access){
 		return access.getVersion() > 0;
 	}
 	protected String getSaveAccessSQL(Access access){
 		if(isUpdateRequest(access)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveAccessParameters(Access access){
 		if(isUpdateRequest(access) ){
 			return prepareUpdateAccessParameters(access);
 		}
 		return prepareCreateAccessParameters(access);
 	}
 	protected Object[] prepareUpdateAccessParameters(Access access){
 		Object[] parameters = new Object[3];
  	
 		if(access.getRole() != null){
 			parameters[0] = access.getRole().getId();
 		}
 		
 		parameters[1] = access.getId();
 		parameters[2] = access.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateAccessParameters(Access access){
		Object[] parameters = new Object[2];
		String newAccessId=getNextId();
		access.setId(newAccessId);
		parameters[0] =  access.getId();
  	
 		if(access.getRole() != null){
 			parameters[1] = access.getRole().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected Access saveInternalAccess(Access access, Set<String> options){
		
		saveAccess(access);
 	
 		if(isSaveRoleEnabled(options)){
	 		saveRole(access);
 		}
 
		
		if(isSaveAssignmentListEnabled(options)){
	 		saveAssignmentList(access);
 		}		
		
		return access;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Access saveRole(Access access){
 		//Call inject DAO to execute this method
 		Set<String> options = new HashSet<String>();
 		
 		getRoleDAO().save(access.getRole(),options);
 		return access;
 		
 	}
	
 
		
	protected Access saveAssignmentList(Access access){
		List<Assignment> assignmentList = access.getAssignmentList();
		if(assignmentList==null){
			return access;
		}
		if(assignmentList.isEmpty()){
			return access;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		Set<String> options = new HashSet<String>();
		getAssignmentDAO().saveList(access.getAssignmentList(),options);
		
		return access;
	
	}
		
 	
 	public List<Access> findAccessByRole(String roleId){
 		return new ArrayList<Access>();
 	}//find end
 
}


