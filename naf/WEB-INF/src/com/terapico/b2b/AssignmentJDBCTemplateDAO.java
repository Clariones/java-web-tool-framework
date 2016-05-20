
package com.terapico.b2b;

import java.util.List;
import java.util.ArrayList;
public class AssignmentJDBCTemplateDAO extends CommonJDBCTemplateDAO implements AssignmentDAO{

	public Assignment load(String assignmentId) throws AssignmentNotFoundException{
		return loadInternalAssignment(assignmentId);
	}
	public Assignment save(Assignment assignment){
		return assignment;
	}
	public void delete(String assignmentId) throws AssignmentNotFoundException{
	
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"user","access","assigned_date"};
	}
	@Override
	protected String getName() {
		
		return "assignment";
	}
	
	 
 	private boolean extractUserEnabled = true;
 	public boolean isExtractUserEnabled(){
	 	return extractUserEnabled;
 	}
 	
 	public void setExtractUserEnabled(boolean extractUserEnabled){
	 	this.extractUserEnabled = extractUserEnabled;
 	}
 	
 	private boolean saveUserEnabled = true;
 	public boolean isSaveUserEnabled(){
	 	return saveUserEnabled;
 	}
 	
 	public void setSaveUserEnabled(boolean saveUserEnabled){
	 	this.saveUserEnabled = saveUserEnabled;
 	}
 	
  
 	private boolean extractAccessEnabled = true;
 	public boolean isExtractAccessEnabled(){
	 	return extractAccessEnabled;
 	}
 	
 	public void setExtractAccessEnabled(boolean extractAccessEnabled){
	 	this.extractAccessEnabled = extractAccessEnabled;
 	}
 	
 	private boolean saveAccessEnabled = true;
 	public boolean isSaveAccessEnabled(){
	 	return saveAccessEnabled;
 	}
 	
 	public void setSaveAccessEnabled(boolean saveAccessEnabled){
	 	this.saveAccessEnabled = saveAccessEnabled;
 	}
 	
 
		
	

	protected Assignment extractAssignment(String assignmentId){
		return null;
	}

	protected Assignment loadInternalAssignment(String assignmentId){
		
		Assignment assignment = extractAssignment(assignmentId);
 	
 		if(isExtractUserEnabled()){
	 		extractUser(assignment);
 		}
  	
 		if(isExtractAccessEnabled()){
	 		extractAccess(assignment);
 		}
 
		
		return assignment;
		
	}//method end loadInternalAssignment(String assignmentId)
	
	//======================================================================================
	 
 	protected Assignment extractUser(Assignment assignment){
 		
 		return assignment;
 	}
 		
  
 	protected Assignment extractAccess(Assignment assignment){
 		
 		return assignment;
 	}
 		
 
		
	

	protected Assignment saveAssignment(Assignment  assignment){
	
		return assignment;
	
	}
	protected Assignment saveInternalAssignment(Assignment assignment){
		
		saveAssignment(assignment);
 	
 		if(isSaveUserEnabled()){
	 		saveUser(assignment);
 		}
  	
 		if(isSaveAccessEnabled()){
	 		saveAccess(assignment);
 		}
 
		
		return assignment;
		
	}//method end loadInternalAssignment(String assignmentId)
	
	
	
	//======================================================================================
	 
 	protected Assignment saveUser(Assignment assignment){
 	
 		return assignment;
 	}
 		
  
 	protected Assignment saveAccess(Assignment assignment){
 	
 		return assignment;
 	}
 		
 
		
 	
 	public List<Assignment> findAssignmentByUser(String employeeId){
 		return new ArrayList<Assignment>();
 	}//find end
  	
 	public List<Assignment> findAssignmentByAccess(String accessId){
 		return new ArrayList<Assignment>();
 	}//find end
 
}


