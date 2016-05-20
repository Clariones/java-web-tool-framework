
package com.terapico.b2b;

import java.util.List;
import java.util.ArrayList;
public class RoleJDBCTemplateDAO extends CommonJDBCTemplateDAO implements RoleDAO{

	public Role load(String roleId) throws RoleNotFoundException{
		return loadInternalRole(roleId);
	}
	public Role save(Role role){
		return role;
	}
	public void delete(String roleId) throws RoleNotFoundException{
	
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"role_name"};
	}
	@Override
	protected String getName() {
		
		return "role";
	}
	
	
		
	private boolean extractCsrListEnabled = false;
	public boolean isExtractCsrListEnabled(){
		return extractCsrListEnabled;
		
 	}
 	public void setExtractCsrListEnabled(boolean extractCsrListEnabled){
		this.extractCsrListEnabled = extractCsrListEnabled;
		
 	}
 	
 	private boolean saveCsrListEnabled = false;
	public boolean isSaveCsrListEnabled(){
		return saveCsrListEnabled;
		
 	}
 	public void setSaveCsrListEnabled(boolean saveCsrListEnabled){
		this.saveCsrListEnabled = saveCsrListEnabled;
		
 	}			
		
	private boolean extractAccessListEnabled = false;
	public boolean isExtractAccessListEnabled(){
		return extractAccessListEnabled;
		
 	}
 	public void setExtractAccessListEnabled(boolean extractAccessListEnabled){
		this.extractAccessListEnabled = extractAccessListEnabled;
		
 	}
 	
 	private boolean saveAccessListEnabled = false;
	public boolean isSaveAccessListEnabled(){
		return saveAccessListEnabled;
		
 	}
 	public void setSaveAccessListEnabled(boolean saveAccessListEnabled){
		this.saveAccessListEnabled = saveAccessListEnabled;
		
 	}			
		
	

	protected Role extractRole(String roleId){
		return null;
	}

	protected Role loadInternalRole(String roleId){
		
		Role role = extractRole(roleId);

		
		if(isExtractCsrListEnabled()){
	 		extractCsrList(role);
 		}		
		
		if(isExtractAccessListEnabled()){
	 		extractAccessList(role);
 		}		
		
		return role;
		
	}//method end loadInternalRole(String roleId)
	
	//======================================================================================
	
		
	protected Role extractCsrList(Role role){
		
		return role;
	
	}	
		
	protected Role extractAccessList(Role role){
		
		return role;
	
	}	
		
	

	protected Role saveRole(Role  role){
	
		return role;
	
	}
	protected Role saveInternalRole(Role role){
		
		saveRole(role);

		
		if(isSaveCsrListEnabled()){
	 		saveCsrList(role);
 		}		
		
		if(isSaveAccessListEnabled()){
	 		saveAccessList(role);
 		}		
		
		return role;
		
	}//method end loadInternalRole(String roleId)
	
	
	
	//======================================================================================
	
		
	protected Role saveCsrList(Role role){
		
		return role;
	
	}
		
	protected Role saveAccessList(Role role){
		
		return role;
	
	}
		

}


