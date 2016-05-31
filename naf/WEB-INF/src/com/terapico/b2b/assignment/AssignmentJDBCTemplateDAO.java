
package com.terapico.b2b.assignment;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import com.terapico.b2b.CommonJDBCTemplateDAO;
import com.terapico.b2b.access.Access;
import com.terapico.b2b.employee.Employee;

import com.terapico.b2b.employee.EmployeeDAO;
import com.terapico.b2b.access.AccessDAO;

public class AssignmentJDBCTemplateDAO extends CommonJDBCTemplateDAO implements AssignmentDAO{
 
 	
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

		

	public Assignment load(String assignmentId,Set<String> options) throws Exception{
		return loadInternalAssignment(assignmentId, options);
	}
	public Assignment save(Assignment assignment,Set<String> options){
		return saveInternalAssignment(assignment,options);
	}
	public Assignment clone(String assignmentId,Set<String> options) throws Exception{
		Assignment newAssignment = load(assignmentId, options);
		newAssignment.setVersion(0);
		
		
		
		saveInternalAssignment(newAssignment,options);
		
		return newAssignment;
	}
	public void delete(String assignmentId, int version) throws Exception{
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{assignmentId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			// two suitations here, this object has been deleted; or
			// the version has been changed, the client should reload it and ensure this can be deleted
			SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
			parameters=new Object[]{assignmentId};
			int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
			if(count == 1){
				throw new AssignmentVersionChangedException("The object version has been changed, please reload to delete");
			}
			if(count < 1){
				throw new AssignmentNotFoundException("The object alread has been deleted.");
			}
			if(count > 1){
				throw new IllegalStateException("The database PRIMARY KEY constraint has been damaged, please fix it.");
			}
		
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"user","access","assigned_date"};
	}
	@Override
	protected String getName() {
		
		return "assignment";
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

 
 	//private boolean extractUserEnabled = true;
 	private static final String USER = "user";
 	protected boolean isExtractUserEnabled(Set<String> options){
 		
	 	return checkOptions(options, USER);
 	}
 	
 	
 	//private boolean saveUserEnabled = true;
 	protected boolean isSaveUserEnabled(Set<String> options){
	 	
 		return checkOptions(options, USER);
 	}
 	

 	
  
 	//private boolean extractAccessEnabled = true;
 	private static final String ACCESS = "access";
 	protected boolean isExtractAccessEnabled(Set<String> options){
 		
	 	return checkOptions(options, ACCESS);
 	}
 	
 	
 	//private boolean saveAccessEnabled = true;
 	protected boolean isSaveAccessEnabled(Set<String> options){
	 	
 		return checkOptions(options, ACCESS);
 	}
 	

 	
 
		
	

	protected AssignmentMapper getMapper(){
		return new AssignmentMapper();
	}
	protected Assignment extractAssignment(String assignmentId){
		String SQL = "select * from assignment_data where id=?";	
		Assignment assignment = getJdbcTemplateObject().queryForObject(SQL, new Object[]{assignmentId}, getMapper());
		return assignment;
	}

	protected Assignment loadInternalAssignment(String assignmentId, Set<String> loadOptions) throws Exception{
		
		Assignment assignment = extractAssignment(assignmentId);
 	
 		if(isExtractUserEnabled(loadOptions)){
	 		extractUser(assignment);
 		}
  	
 		if(isExtractAccessEnabled(loadOptions)){
	 		extractAccess(assignment);
 		}
 
		
		return assignment;
		
	}
	
	
	 

 	protected Assignment extractUser(Assignment assignment) throws Exception{

		Set<String> options = new HashSet<String>();
		Employee user = getEmployeeDAO().load(assignment.getUser().getId(),options);
		if(user != null){
			assignment.setUser(user);
		}
		
 		
 		return assignment;
 	}
 		
  

 	protected Assignment extractAccess(Assignment assignment) throws Exception{

		Set<String> options = new HashSet<String>();
		Access access = getAccessDAO().load(assignment.getAccess().getId(),options);
		if(access != null){
			assignment.setAccess(access);
		}
		
 		
 		return assignment;
 	}
 		
 
		
		
  	
 	public List<Assignment> findAssignmentByUser(String employeeId){
 	
 		String SQL = "select * from "+this.getTableName()+" where user = ?";
		List<Assignment> assignmentList = getJdbcTemplateObject().query(SQL, new Object[]{employeeId}, getMapper());
		
 	
 		return assignmentList;
 	}
  	
 	public List<Assignment> findAssignmentByAccess(String accessId){
 	
 		String SQL = "select * from "+this.getTableName()+" where access = ?";
		List<Assignment> assignmentList = getJdbcTemplateObject().query(SQL, new Object[]{accessId}, getMapper());
		
 	
 		return assignmentList;
 	}
 	
		
		
		
	

	protected Assignment saveAssignment(Assignment  assignment){
	
		String SQL=this.getSaveAssignmentSQL(assignment);
		Object [] parameters = getSaveAssignmentParameters(assignment);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		return assignment;
	
	}
	public List<Assignment> saveList(List<Assignment> assignmentList,Set<String> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitAssignmentList(assignmentList);
		
		batchCreate((List<Assignment>)lists[CREATE_LIST_INDEX]);
		
		batchUpdate((List<Assignment>)lists[UPDATE_LIST_INDEX]);

		return assignmentList;
	}

	
	protected List<Object[]> prepareBatchCreateArgs(List<Assignment> assignmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Assignment assignment:assignmentList ){
			Object [] parameters = prepareCreateAssignmentParameters(assignment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBatchUpdateArgs(List<Assignment> assignmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Assignment assignment:assignmentList ){
			Object [] parameters = prepareUpdateAssignmentParameters(assignment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCreate(List<Assignment> assignmentList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBatchCreateArgs(assignmentList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUpdate(List<Assignment> assignmentList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBatchUpdateArgs(assignmentList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitAssignmentList(List<Assignment> assignmentList){
		
		List<Assignment> assignmentCreateList=new ArrayList<Assignment>();
		List<Assignment> assignmentUpdateList=new ArrayList<Assignment>();
		
		for(Assignment assignment: assignmentList){
			if(isUpdateRequest(assignment)){
				assignmentUpdateList.add( assignment);
				continue;
			}
			assignmentCreateList.add(assignment);
		}
		
		return new Object[]{assignmentCreateList,assignmentUpdateList};
	}
	
	protected boolean isUpdateRequest(Assignment assignment){
 		return assignment.getVersion() > 0;
 	}
 	protected String getSaveAssignmentSQL(Assignment assignment){
 		if(isUpdateRequest(assignment)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveAssignmentParameters(Assignment assignment){
 		if(isUpdateRequest(assignment) ){
 			return prepareUpdateAssignmentParameters(assignment);
 		}
 		return prepareCreateAssignmentParameters(assignment);
 	}
 	protected Object[] prepareUpdateAssignmentParameters(Assignment assignment){
 		Object[] parameters = new Object[5];
  	
 		if(assignment.getUser() != null){
 			parameters[0] = assignment.getUser().getId();
 		}
  	
 		if(assignment.getAccess() != null){
 			parameters[1] = assignment.getAccess().getId();
 		}
 
 		parameters[2] = assignment.getAssignedDate();		
 		parameters[3] = assignment.getId();
 		parameters[4] = assignment.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateAssignmentParameters(Assignment assignment){
		Object[] parameters = new Object[4];
		String newAssignmentId=getNextId();
		assignment.setId(newAssignmentId);
		parameters[0] =  assignment.getId();
  	
 		if(assignment.getUser() != null){
 			parameters[1] = assignment.getUser().getId();
 		
 		}
 		 	
 		if(assignment.getAccess() != null){
 			parameters[2] = assignment.getAccess().getId();
 		
 		}
 		
 		parameters[3] = assignment.getAssignedDate();		
 				
 		return parameters;
 	}
 	
	protected Assignment saveInternalAssignment(Assignment assignment, Set<String> options){
		
		saveAssignment(assignment);
 	
 		if(isSaveUserEnabled(options)){
	 		saveUser(assignment);
 		}
  	
 		if(isSaveAccessEnabled(options)){
	 		saveAccess(assignment);
 		}
 
		
		return assignment;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Assignment saveUser(Assignment assignment){
 		//Call inject DAO to execute this method
 		Set<String> options = new HashSet<String>();
 		
 		getEmployeeDAO().save(assignment.getUser(),options);
 		return assignment;
 		
 	}
	
  
 
 	protected Assignment saveAccess(Assignment assignment){
 		//Call inject DAO to execute this method
 		Set<String> options = new HashSet<String>();
 		
 		getAccessDAO().save(assignment.getAccess(),options);
 		return assignment;
 		
 	}
	
 
		

}


