
package com.terapico.b2b.role;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.terapico.b2b.CommonJDBCTemplateDAO;
import com.terapico.b2b.access.Access;
import com.terapico.b2b.custsvcrep.CustSvcRep;

import com.terapico.b2b.custsvcrep.CustSvcRepDAO;
import com.terapico.b2b.access.AccessDAO;


import org.springframework.dao.EmptyResultDataAccessException;

public class RoleJDBCTemplateDAO extends CommonJDBCTemplateDAO implements RoleDAO{

		
	
  	private  AccessDAO  accessDAO;
 	public void setAccessDAO(AccessDAO pAccessDAO){
 	
 		if(pAccessDAO == null){
 			throw new IllegalStateException("Do not try to set accessDAO to null.");
 		}
	 	this.accessDAO = pAccessDAO;
 	}
 	public AccessDAO getAccessDAO(){
 		if(this.accessDAO == null){
 			throw new IllegalStateException("The accessDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.accessDAO;
 	}	
 	
			
		
	
  	private  CustSvcRepDAO  custSvcRepDAO;
 	public void setCustSvcRepDAO(CustSvcRepDAO pCustSvcRepDAO){
 	
 		if(pCustSvcRepDAO == null){
 			throw new IllegalStateException("Do not try to set custSvcRepDAO to null.");
 		}
	 	this.custSvcRepDAO = pCustSvcRepDAO;
 	}
 	public CustSvcRepDAO getCustSvcRepDAO(){
 		if(this.custSvcRepDAO == null){
 			throw new IllegalStateException("The custSvcRepDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.custSvcRepDAO;
 	}	
 	
			
		

	public Role load(String roleId,Map<String,Object> options) throws Exception{
		return loadInternalRole(roleId, options);
	}
	public Role save(Role role,Map<String,Object> options){
		
		String methodName="save(Role role,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(role, methodName, "role");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRole(role,options);
	}
	public Role clone(String roleId,Map<String,Object> options) throws Exception{
	
		String methodName="clone(String roleId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(roleId, methodName, "roleId");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Role newRole = load(roleId, options);
		newRole.setVersion(0);
		
		
 		
 		if(isSaveAccessListEnabled(options)){
 			for(Access item: newRole.getAccessList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveCustSvcRepListEnabled(options)){
 			for(CustSvcRep item: newRole.getCustSvcRepList()){
 				item.setVersion(0);
 			}
 		}
		
		
		saveInternalRole(newRole,options);
		
		return newRole;
	}
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = getJdbcTemplateObject().update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String roleId, int version) throws  RoleVersionChangedException,  RoleNotFoundException {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{roleId};
		int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new RoleVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RoleNotFoundException(
					"The " + this.getTableName() + "(" + roleId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String roleId, int version) throws Exception{
	
		String methodName="delete(String roleId, int version)";
		assertMethodArgumentNotNull(roleId, methodName, "roleId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{roleId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(roleId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"role_name"};
	}
	@Override
	protected String getName() {
		
		return "role";
	}
	
	
	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
		if(options==null){
 			return false;
 		}
 		if(options.containsKey(optionToCheck)){
 			options.remove(optionToCheck);//consume the key, can not use any more to exactract the data.
 			return true;
 		}
 		if(options.containsKey(ALL)){
 			return true;
 		}
 		return false;
	
	}


		
	//protected static final String ACCESS_LIST = "accessList";
	
	protected boolean isExtractAccessListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RoleTokens.ACCESS_LIST);
		
 	}

	protected boolean isSaveAccessListEnabled(Map<String,Object> options){
		return checkOptions(options, RoleTokens.ACCESS_LIST);
		
 	}
 	
 	
			
		
	//protected static final String CUST_SVC_REP_LIST = "custSvcRepList";
	
	protected boolean isExtractCustSvcRepListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RoleTokens.CUST_SVC_REP_LIST);
		
 	}

	protected boolean isSaveCustSvcRepListEnabled(Map<String,Object> options){
		return checkOptions(options, RoleTokens.CUST_SVC_REP_LIST);
		
 	}
 	
 	
			
		
	

	protected RoleMapper getMapper(){
		return new RoleMapper();
	}
	protected Role extractRole(String roleId) throws Exception{
		String SQL = "select * from role_data where id=?";	
		try{
		
			Role role = getJdbcTemplateObject().queryForObject(SQL, new Object[]{roleId}, getMapper());
			return role;
		}catch(EmptyResultDataAccessException e){
			throw new RoleNotFoundException("Role("+roleId+") is not found!");
		}
		
		
	}

	protected Role loadInternalRole(String roleId, Map<String,Object> loadOptions) throws Exception{
		
		Role role = extractRole(roleId);

		
		if(isExtractAccessListEnabled(loadOptions)){
	 		extractAccessList(role, loadOptions);
 		}		
		
		if(isExtractCustSvcRepListEnabled(loadOptions)){
	 		extractCustSvcRepList(role, loadOptions);
 		}		
		
		return role;
		
	}
	
	
	
		
	protected Role extractAccessList(Role role, Map<String,Object> options){
		
		List<Access> accessList = getAccessDAO().findAccessByRole(role.getId());
		if(accessList != null){
			role.setAccessList(accessList);
		}
		
		return role;
	
	}	
		
	protected Role extractCustSvcRepList(Role role, Map<String,Object> options){
		
		List<CustSvcRep> custSvcRepList = getCustSvcRepDAO().findCustSvcRepByRole(role.getId());
		if(custSvcRepList != null){
			role.setCustSvcRepList(custSvcRepList);
		}
		
		return role;
	
	}	
		
		
 	
		
		
		
	

	protected Role saveRole(Role  role){
	
		String SQL=this.getSaveRoleSQL(role);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRoleParameters(role);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		int newVersion = role.getVersion() + 1;
		role.setVersion(newVersion);
		return role;
	
	}
	public List<Role> saveList(List<Role> roleList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRoleList(roleList);
		
		batchCreate((List<Role>)lists[CREATE_LIST_INDEX]);
		
		batchUpdate((List<Role>)lists[UPDATE_LIST_INDEX]);

		return roleList;
	}

	
	protected List<Object[]> prepareBatchCreateArgs(List<Role> roleList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Role role:roleList ){
			Object [] parameters = prepareCreateRoleParameters(role);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBatchUpdateArgs(List<Role> roleList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Role role:roleList ){
			Object [] parameters = prepareUpdateRoleParameters(role);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCreate(List<Role> roleList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBatchCreateArgs(roleList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUpdate(List<Role> roleList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBatchUpdateArgs(roleList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRoleList(List<Role> roleList){
		
		List<Role> roleCreateList=new ArrayList<Role>();
		List<Role> roleUpdateList=new ArrayList<Role>();
		
		for(Role role: roleList){
			if(isUpdateRequest(role)){
				roleUpdateList.add( role);
				continue;
			}
			roleCreateList.add(role);
		}
		
		return new Object[]{roleCreateList,roleUpdateList};
	}
	
	protected boolean isUpdateRequest(Role role){
 		return role.getVersion() > 0;
 	}
 	protected String getSaveRoleSQL(Role role){
 		if(isUpdateRequest(role)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRoleParameters(Role role){
 		if(isUpdateRequest(role) ){
 			return prepareUpdateRoleParameters(role);
 		}
 		return prepareCreateRoleParameters(role);
 	}
 	protected Object[] prepareUpdateRoleParameters(Role role){
 		Object[] parameters = new Object[3];
 
 		parameters[0] = role.getRoleName();		
 		parameters[1] = role.getId();
 		parameters[2] = role.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateRoleParameters(Role role){
		Object[] parameters = new Object[2];
		String newRoleId=getNextId();
		role.setId(newRoleId);
		parameters[0] =  role.getId();
 
 		parameters[1] = role.getRoleName();		
 				
 		return parameters;
 	}
 	
	protected Role saveInternalRole(Role role, Map<String,Object> options){
		
		saveRole(role);

		
		if(isSaveAccessListEnabled(options)){
	 		saveAccessList(role, options);
 		}		
		
		if(isSaveCustSvcRepListEnabled(options)){
	 		saveCustSvcRepList(role, options);
 		}		
		
		return role;
		
	}
	
	
	
	//======================================================================================
	
		
	protected Role saveAccessList(Role role, Map<String,Object> options){
		List<Access> accessList = role.getAccessList();
		if(accessList == null){
			return role;
		}
		if(accessList.isEmpty()){
			return role;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getAccessDAO().saveList(role.getAccessList(),options);
		
		return role;
	
	}
		
	protected Role saveCustSvcRepList(Role role, Map<String,Object> options){
		List<CustSvcRep> custSvcRepList = role.getCustSvcRepList();
		if(custSvcRepList == null){
			return role;
		}
		if(custSvcRepList.isEmpty()){
			return role;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getCustSvcRepDAO().saveList(role.getCustSvcRepList(),options);
		
		return role;
	
	}
		

	
}


