
package com.terapico.b2b.role;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import com.terapico.b2b.access.Access;
import com.terapico.b2b.custsvcrep.CustSvcRep;


import com.terapico.b2b.role.Role;
import com.terapico.b2b.sellercompany.SellerCompany;



public class RoleManagerImpl implements RoleManager {

	private  RoleDAO  roleDAO;
 	public void setRoleDAO(RoleDAO  roleDAO){
 	
 		if(roleDAO == null){
 			throw new IllegalStateException("Do not try to set roleDAO to null.");
 		}
	 	this.roleDAO = roleDAO;
 	}
 	public RoleDAO getRoleDAO(){
 		if(this.roleDAO == null){
 			throw new IllegalStateException("The RoleDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.roleDAO;
 	}
 	
 	public Role saveRole(Role role, Map<String,Object>options) throws Exception{	
 		return getRoleDAO().save(role, options);
 	}
 	public Role loadRole(String roleId, Map<String,Object>options) throws Exception{	
 		return getRoleDAO().load(roleId, options);
 	}
 	
 	
 	
	public Role createRole(String roleName, String[] optionsExpr) throws Exception
	{
		
		
		Role role=createNewRole(optionsExpr);	

		role.setRoleName(roleName);

		return saveRole(role, emptyOptions());
		

		
	}
	protected Role createNewRole(String[] optionsExpr) throws Exception
	{
		
		return new Role();
		
	}
	public Role updateRole(String roleId, String property, Object newValue) throws Exception 
	{
		return new Role();
	}
	protected Map<String,Object> emptyOptions(){
		return new HashMap<String,Object>();
	}
	
	protected RoleTokens tokens(){
		return RoleTokens.start();
	}
	protected Map<String,Object> allTokens(){
		return RoleTokens.all();
	}
	


	public void delete(String roleId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  Role addAccess(String roleId, String roleName) throws Exception
	{		
		Access access = createAccess(roleName);
		
		Role role = loadRole(roleId, allTokens());
		synchronized(role){ 
			//will be good when the role loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			role.addAccess( access );		
			return saveRole(role, tokens().withAccessList().done());
		}
	}
	protected Access createAccess(String roleName){

		Access access = new Access();
		
		
		access.setRoleName(roleName);
	
		
		return access;			
		
	}
	public  Role removeAccess(String roleId, String accessId){
		return new Role();
	}
	public  Role updateAccess(String roleId, String accessId, String property, Object newValue){
		return new Role();
	}

	public  Role addCustSvcRep(String roleId, String email, String passwd, String companyId) throws Exception
	{		
		CustSvcRep custSvcRep = createCustSvcRep(email, passwd, companyId);
		
		Role role = loadRole(roleId, allTokens());
		synchronized(role){ 
			//will be good when the role loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			role.addCustSvcRep( custSvcRep );		
			return saveRole(role, tokens().withCustSvcRepList().done());
		}
	}
	protected CustSvcRep createCustSvcRep(String email, String passwd, String companyId){

		CustSvcRep custSvcRep = new CustSvcRep();
		
		
		custSvcRep.setEmail(email);		
		custSvcRep.setPasswd(passwd);		
		SellerCompany  company = new SellerCompany();
		company.setId(companyId);		
		custSvcRep.setCompany(company);
	
		
		return custSvcRep;			
		
	}
	public  Role removeCustSvcRep(String roleId, String custSvcRepId){
		return new Role();
	}
	public  Role updateCustSvcRep(String roleId, String custSvcRepId, String property, Object newValue){
		return new Role();
	}



}


