
package com.terapico.b2b.custsvcrep;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
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

		

	public CustSvcRep load(String custSvcRepId,Set<String> options) throws Exception{
		return loadInternalCustSvcRep(custSvcRepId, options);
	}
	public CustSvcRep save(CustSvcRep custSvcRep,Set<String> options){
		return saveInternalCustSvcRep(custSvcRep,options);
	}
	public CustSvcRep clone(String custSvcRepId,Set<String> options) throws Exception{
		CustSvcRep newCustSvcRep = load(custSvcRepId, options);
		newCustSvcRep.setVersion(0);
		
		
		
		saveInternalCustSvcRep(newCustSvcRep,options);
		
		return newCustSvcRep;
	}
	public void delete(String custSvcRepId, int version) throws Exception{
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{custSvcRepId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			// two suitations here, this object has been deleted; or
			// the version has been changed, the client should reload it and ensure this can be deleted
			SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
			parameters=new Object[]{custSvcRepId};
			int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
			if(count == 1){
				throw new CustSvcRepVersionChangedException("The object version has been changed, please reload to delete");
			}
			if(count < 1){
				throw new CustSvcRepNotFoundException("The object alread has been deleted.");
			}
			if(count > 1){
				throw new IllegalStateException("The database PRIMARY KEY constraint has been damaged, please fix it.");
			}
		
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
 	

 	
  
 	//private boolean extractCompanyEnabled = true;
 	private static final String COMPANY = "company";
 	protected boolean isExtractCompanyEnabled(Set<String> options){
 		
	 	return checkOptions(options, COMPANY);
 	}
 	
 	
 	//private boolean saveCompanyEnabled = true;
 	protected boolean isSaveCompanyEnabled(Set<String> options){
	 	
 		return checkOptions(options, COMPANY);
 	}
 	

 	
 
		
	

	protected CustSvcRepMapper getMapper(){
		return new CustSvcRepMapper();
	}
	protected CustSvcRep extractCustSvcRep(String custSvcRepId){
		String SQL = "select * from cust_svc_rep_data where id=?";	
		CustSvcRep custSvcRep = getJdbcTemplateObject().queryForObject(SQL, new Object[]{custSvcRepId}, getMapper());
		return custSvcRep;
	}

	protected CustSvcRep loadInternalCustSvcRep(String custSvcRepId, Set<String> loadOptions) throws Exception{
		
		CustSvcRep custSvcRep = extractCustSvcRep(custSvcRepId);
 	
 		if(isExtractRoleEnabled(loadOptions)){
	 		extractRole(custSvcRep);
 		}
  	
 		if(isExtractCompanyEnabled(loadOptions)){
	 		extractCompany(custSvcRep);
 		}
 
		
		return custSvcRep;
		
	}
	
	
	 

 	protected CustSvcRep extractRole(CustSvcRep custSvcRep) throws Exception{

		Set<String> options = new HashSet<String>();
		Role role = getRoleDAO().load(custSvcRep.getRole().getId(),options);
		if(role != null){
			custSvcRep.setRole(role);
		}
		
 		
 		return custSvcRep;
 	}
 		
  

 	protected CustSvcRep extractCompany(CustSvcRep custSvcRep) throws Exception{

		Set<String> options = new HashSet<String>();
		SellerCompany company = getSellerCompanyDAO().load(custSvcRep.getCompany().getId(),options);
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
		Object [] parameters = getSaveCustSvcRepParameters(custSvcRep);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		return custSvcRep;
	
	}
	public List<CustSvcRep> saveList(List<CustSvcRep> custSvcRepList,Set<String> options){
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
 	
	protected CustSvcRep saveInternalCustSvcRep(CustSvcRep custSvcRep, Set<String> options){
		
		saveCustSvcRep(custSvcRep);
 	
 		if(isSaveRoleEnabled(options)){
	 		saveRole(custSvcRep);
 		}
  	
 		if(isSaveCompanyEnabled(options)){
	 		saveCompany(custSvcRep);
 		}
 
		
		return custSvcRep;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected CustSvcRep saveRole(CustSvcRep custSvcRep){
 		//Call inject DAO to execute this method
 		Set<String> options = new HashSet<String>();
 		
 		getRoleDAO().save(custSvcRep.getRole(),options);
 		return custSvcRep;
 		
 	}
	
  
 
 	protected CustSvcRep saveCompany(CustSvcRep custSvcRep){
 		//Call inject DAO to execute this method
 		Set<String> options = new HashSet<String>();
 		
 		getSellerCompanyDAO().save(custSvcRep.getCompany(),options);
 		return custSvcRep;
 		
 	}
	
 
		

}






