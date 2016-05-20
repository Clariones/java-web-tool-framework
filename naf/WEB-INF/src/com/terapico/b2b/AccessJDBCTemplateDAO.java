
package com.terapico.b2b;

import java.util.List;
import java.util.ArrayList;
public class AccessJDBCTemplateDAO extends CommonJDBCTemplateDAO implements AccessDAO{

	public Access load(String accessId) throws AccessNotFoundException{
		return loadInternalAccess(accessId);
	}
	public Access save(Access access){
		return access;
	}
	public void delete(String accessId) throws AccessNotFoundException{
	
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"role"};
	}
	@Override
	protected String getName() {
		
		return "access";
	}
	
	 
 	private boolean extractRoleEnabled = true;
 	public boolean isExtractRoleEnabled(){
	 	return extractRoleEnabled;
 	}
 	
 	public void setExtractRoleEnabled(boolean extractRoleEnabled){
	 	this.extractRoleEnabled = extractRoleEnabled;
 	}
 	
 	private boolean saveRoleEnabled = true;
 	public boolean isSaveRoleEnabled(){
	 	return saveRoleEnabled;
 	}
 	
 	public void setSaveRoleEnabled(boolean saveRoleEnabled){
	 	this.saveRoleEnabled = saveRoleEnabled;
 	}
 	
 
		
	private boolean extractAssignmentListEnabled = false;
	public boolean isExtractAssignmentListEnabled(){
		return extractAssignmentListEnabled;
		
 	}
 	public void setExtractAssignmentListEnabled(boolean extractAssignmentListEnabled){
		this.extractAssignmentListEnabled = extractAssignmentListEnabled;
		
 	}
 	
 	private boolean saveAssignmentListEnabled = false;
	public boolean isSaveAssignmentListEnabled(){
		return saveAssignmentListEnabled;
		
 	}
 	public void setSaveAssignmentListEnabled(boolean saveAssignmentListEnabled){
		this.saveAssignmentListEnabled = saveAssignmentListEnabled;
		
 	}			
		
	

	protected Access extractAccess(String accessId){
		return null;
	}

	protected Access loadInternalAccess(String accessId){
		
		Access access = extractAccess(accessId);
 	
 		if(isExtractRoleEnabled()){
	 		extractRole(access);
 		}
 
		
		if(isExtractAssignmentListEnabled()){
	 		extractAssignmentList(access);
 		}		
		
		return access;
		
	}//method end loadInternalAccess(String accessId)
	
	//======================================================================================
	 
 	protected Access extractRole(Access access){
 		
 		return access;
 	}
 		
 
		
	protected Access extractAssignmentList(Access access){
		
		return access;
	
	}	
		
	

	protected Access saveAccess(Access  access){
	
		return access;
	
	}
	protected Access saveInternalAccess(Access access){
		
		saveAccess(access);
 	
 		if(isSaveRoleEnabled()){
	 		saveRole(access);
 		}
 
		
		if(isSaveAssignmentListEnabled()){
	 		saveAssignmentList(access);
 		}		
		
		return access;
		
	}//method end loadInternalAccess(String accessId)
	
	
	
	//======================================================================================
	 
 	protected Access saveRole(Access access){
 	
 		return access;
 	}
 		
 
		
	protected Access saveAssignmentList(Access access){
		
		return access;
	
	}
		
 	
 	public List<Access> findAccessByRole(String roleId){
 		return new ArrayList<Access>();
 	}//find end
 
}


