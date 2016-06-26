
package com.terapico.b2b.custsvcrep;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import com.terapico.b2b.CommonJDBCTemplateDAO;
import com.terapico.b2b.role.Role;
import com.terapico.b2b.sellercompany.SellerCompany;

import com.terapico.b2b.role.RoleDAO;
import com.terapico.b2b.sellercompany.SellerCompanyDAO;

public class CustSvcRepJDBCTemplateDAO extends CommonJDBCTemplateDAO implements CustSvcRepDAO{
 
 	
 	private  RoleDAO  roleDAO;
 	public void setRoleDAO(RoleDAO roleDAO){
	 	this.roleDAO = roleDAO;
 	}
 	public RoleDAO getRoleDAO(){
	 	return this.roleDAO;
 	}
 
 	
 	private  SellerCompanyDAO  sellerCompanyDAO;
 	public void setSellerCompanyDAO(SellerCompanyDAO sellerCompanyDAO){
	 	this.sellerCompanyDAO = sellerCompanyDAO;
 	}
 	public SellerCompanyDAO getSellerCompanyDAO(){
	 	return this.sellerCompanyDAO;
 	}

		

	public CustSvcRep load(String custSvcRepId,Map<String,Object> options) throws Exception{
		return loadInternalCustSvcRep(custSvcRepId, options);
	}
	public CustSvcRep save(CustSvcRep custSvcRep,Map<String,Object> options){
		
		String methodName="save(CustSvcRep custSvcRep,Map<String,Object> options){";
		
		assertMethodArgumentNotNull(custSvcRep, methodName, "custSvcRep");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalCustSvcRep(custSvcRep,options);
	}
	public CustSvcRep clone(String custSvcRepId,Map<String,Object> options) throws Exception{
	
		String methodName="clone(String custSvcRepId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(custSvcRepId, methodName, "custSvcRepId");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		CustSvcRep newCustSvcRep = load(custSvcRepId, options);
		newCustSvcRep.setVersion(0);
		
		
		
		saveInternalCustSvcRep(newCustSvcRep,options);
		
		return newCustSvcRep;
	}
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = getJdbcTemplateObject().update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String custSvcRepId, int version) throws  CustSvcRepVersionChangedException,  CustSvcRepNotFoundException {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{custSvcRepId};
		int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new CustSvcRepVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new CustSvcRepNotFoundException(
					"The " + this.getTableName() + "(" + custSvcRepId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String custSvcRepId, int version) throws Exception{
	
		String methodName="delete(String custSvcRepId, int version)";
		assertMethodArgumentNotNull(custSvcRepId, methodName, "custSvcRepId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{custSvcRepId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(custSvcRepId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"email","role","company"};
	}
	@Override
	protected String getName() {
		
		return "cust_svc_rep";
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

 
 	//private boolean extractRoleEnabled = true;
 	//private static final String ROLE = "role";
 	protected boolean isExtractRoleEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, CustSvcRepTokens.ROLE);
 	}
 	
 	
 	//private boolean saveRoleEnabled = true;
 	protected boolean isSaveRoleEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, CustSvcRepTokens.ROLE);
 	}
 	

 	
  
 	//private boolean extractCompanyEnabled = true;
 	//private static final String COMPANY = "company";
 	protected boolean isExtractCompanyEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, CustSvcRepTokens.COMPANY);
 	}
 	
 	
 	//private boolean saveCompanyEnabled = true;
 	protected boolean isSaveCompanyEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, CustSvcRepTokens.COMPANY);
 	}
 	

 	
 
		
	

	protected CustSvcRepMapper getMapper(){
		return new CustSvcRepMapper();
	}
	protected CustSvcRep extractCustSvcRep(String custSvcRepId){
		String SQL = "select * from cust_svc_rep_data where id=?";	
		CustSvcRep custSvcRep = getJdbcTemplateObject().queryForObject(SQL, new Object[]{custSvcRepId}, getMapper());
		return custSvcRep;
	}

	protected CustSvcRep loadInternalCustSvcRep(String custSvcRepId, Map<String,Object> loadOptions) throws Exception{
		
		CustSvcRep custSvcRep = extractCustSvcRep(custSvcRepId);
 	
 		if(isExtractRoleEnabled(loadOptions)){
	 		extractRole(custSvcRep, loadOptions);
 		}
  	
 		if(isExtractCompanyEnabled(loadOptions)){
	 		extractCompany(custSvcRep, loadOptions);
 		}
 
		
		return custSvcRep;
		
	}
	
	
	 

 	protected CustSvcRep extractRole(CustSvcRep custSvcRep, Map<String,Object> options) throws Exception{

		if(custSvcRep.getRole() == null){
			return custSvcRep;
		}
		String roleId = custSvcRep.getRole().getId();
		if( roleId == null){
			return custSvcRep;
		}
		Role role = getRoleDAO().load(roleId,options);
		if(role != null){
			custSvcRep.setRole(role);
		}
		
 		
 		return custSvcRep;
 	}
 		
  

 	protected CustSvcRep extractCompany(CustSvcRep custSvcRep, Map<String,Object> options) throws Exception{

		if(custSvcRep.getCompany() == null){
			return custSvcRep;
		}
		String companyId = custSvcRep.getCompany().getId();
		if( companyId == null){
			return custSvcRep;
		}
		SellerCompany company = getSellerCompanyDAO().load(companyId,options);
		if(company != null){
			custSvcRep.setCompany(company);
		}
		
 		
 		return custSvcRep;
 	}
 		
 
		
		
  	
 	public List<CustSvcRep> findCustSvcRepByRole(String roleId){
 	
 		String SQL = "select * from "+this.getTableName()+" where role = ?";
		List<CustSvcRep> custSvcRepList = getJdbcTemplateObject().query(SQL, new Object[]{roleId}, getMapper());
		
 	
 		return custSvcRepList;
 	}
  	
 	public List<CustSvcRep> findCustSvcRepByCompany(String sellerCompanyId){
 	
 		String SQL = "select * from "+this.getTableName()+" where company = ?";
		List<CustSvcRep> custSvcRepList = getJdbcTemplateObject().query(SQL, new Object[]{sellerCompanyId}, getMapper());
		
 	
 		return custSvcRepList;
 	}
 	
		
		
		
	

	protected CustSvcRep saveCustSvcRep(CustSvcRep  custSvcRep){
	
		String SQL=this.getSaveCustSvcRepSQL(custSvcRep);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveCustSvcRepParameters(custSvcRep);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		int newVersion = custSvcRep.getVersion() + 1;
		custSvcRep.setVersion(newVersion);
		return custSvcRep;
	
	}
	public List<CustSvcRep> saveList(List<CustSvcRep> custSvcRepList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitCustSvcRepList(custSvcRepList);
		
		batchCreate((List<CustSvcRep>)lists[CREATE_LIST_INDEX]);
		
		batchUpdate((List<CustSvcRep>)lists[UPDATE_LIST_INDEX]);

		return custSvcRepList;
	}

	
	protected List<Object[]> prepareBatchCreateArgs(List<CustSvcRep> custSvcRepList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(CustSvcRep custSvcRep:custSvcRepList ){
			Object [] parameters = prepareCreateCustSvcRepParameters(custSvcRep);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBatchUpdateArgs(List<CustSvcRep> custSvcRepList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(CustSvcRep custSvcRep:custSvcRepList ){
			Object [] parameters = prepareUpdateCustSvcRepParameters(custSvcRep);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCreate(List<CustSvcRep> custSvcRepList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBatchCreateArgs(custSvcRepList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUpdate(List<CustSvcRep> custSvcRepList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBatchUpdateArgs(custSvcRepList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitCustSvcRepList(List<CustSvcRep> custSvcRepList){
		
		List<CustSvcRep> custSvcRepCreateList=new ArrayList<CustSvcRep>();
		List<CustSvcRep> custSvcRepUpdateList=new ArrayList<CustSvcRep>();
		
		for(CustSvcRep custSvcRep: custSvcRepList){
			if(isUpdateRequest(custSvcRep)){
				custSvcRepUpdateList.add( custSvcRep);
				continue;
			}
			custSvcRepCreateList.add(custSvcRep);
		}
		
		return new Object[]{custSvcRepCreateList,custSvcRepUpdateList};
	}
	
	protected boolean isUpdateRequest(CustSvcRep custSvcRep){
 		return custSvcRep.getVersion() > 0;
 	}
 	protected String getSaveCustSvcRepSQL(CustSvcRep custSvcRep){
 		if(isUpdateRequest(custSvcRep)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveCustSvcRepParameters(CustSvcRep custSvcRep){
 		if(isUpdateRequest(custSvcRep) ){
 			return prepareUpdateCustSvcRepParameters(custSvcRep);
 		}
 		return prepareCreateCustSvcRepParameters(custSvcRep);
 	}
 	protected Object[] prepareUpdateCustSvcRepParameters(CustSvcRep custSvcRep){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = custSvcRep.getEmail(); 	
 		if(custSvcRep.getRole() != null){
 			parameters[1] = custSvcRep.getRole().getId();
 		}
  	
 		if(custSvcRep.getCompany() != null){
 			parameters[2] = custSvcRep.getCompany().getId();
 		}
 		
 		parameters[3] = custSvcRep.getId();
 		parameters[4] = custSvcRep.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateCustSvcRepParameters(CustSvcRep custSvcRep){
		Object[] parameters = new Object[4];
		String newCustSvcRepId=getNextId();
		custSvcRep.setId(newCustSvcRepId);
		parameters[0] =  custSvcRep.getId();
 
 		parameters[1] = custSvcRep.getEmail(); 	
 		if(custSvcRep.getRole() != null){
 			parameters[2] = custSvcRep.getRole().getId();
 		
 		}
 		 	
 		if(custSvcRep.getCompany() != null){
 			parameters[3] = custSvcRep.getCompany().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected CustSvcRep saveInternalCustSvcRep(CustSvcRep custSvcRep, Map<String,Object> options){
		
		saveCustSvcRep(custSvcRep);
 	
 		if(isSaveRoleEnabled(options)){
	 		saveRole(custSvcRep, options);
 		}
  	
 		if(isSaveCompanyEnabled(options)){
	 		saveCompany(custSvcRep, options);
 		}
 
		
		return custSvcRep;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected CustSvcRep saveRole(CustSvcRep custSvcRep, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		getRoleDAO().save(custSvcRep.getRole(),options);
 		return custSvcRep;
 		
 	}
	
  
 
 	protected CustSvcRep saveCompany(CustSvcRep custSvcRep, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		getSellerCompanyDAO().save(custSvcRep.getCompany(),options);
 		return custSvcRep;
 		
 	}
	
 
		

	
}


