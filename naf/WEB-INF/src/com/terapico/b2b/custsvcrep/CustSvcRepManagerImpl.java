
package com.terapico.b2b.custsvcrep;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import com.terapico.b2b.role.Role;
import com.terapico.b2b.sellercompany.SellerCompany;

import com.terapico.b2b.role.RoleDAO;
import com.terapico.b2b.sellercompany.SellerCompanyDAO;




public class CustSvcRepManagerImpl implements CustSvcRepManager {

	private  CustSvcRepDAO  custSvcRepDAO;
 	public void setCustSvcRepDAO(CustSvcRepDAO  custSvcRepDAO){
 	
 		if(custSvcRepDAO == null){
 			throw new IllegalStateException("Do not try to set custSvcRepDAO to null.");
 		}
	 	this.custSvcRepDAO = custSvcRepDAO;
 	}
 	public CustSvcRepDAO getCustSvcRepDAO(){
 		if(this.custSvcRepDAO == null){
 			throw new IllegalStateException("The CustSvcRepDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.custSvcRepDAO;
 	}
 	
 	public CustSvcRep saveCustSvcRep(CustSvcRep custSvcRep, Map<String,Object>options) throws Exception{	
 		return getCustSvcRepDAO().save(custSvcRep, options);
 	}
 	public CustSvcRep loadCustSvcRep(String custSvcRepId, Map<String,Object>options) throws Exception{	
 		return getCustSvcRepDAO().load(custSvcRepId, options);
 	}
 	 
 	
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

 	
 	
	public CustSvcRep createCustSvcRep(String email, String roleId, String companyId, String[] optionsExpr) throws Exception
	{
		
		
		CustSvcRep custSvcRep=createNewCustSvcRep(optionsExpr);	

		custSvcRep.setEmail(email);
		Role role = loadRole(roleId,emptyOptions());
		custSvcRep.setRole(role);
		SellerCompany company = loadCompany(companyId,emptyOptions());
		custSvcRep.setCompany(company);
		//save for later setOrderValues(custSvcRep);
		Map<String, Object> options = new HashMap<String, Object>();
		
		//return custSvcRepDAO.save(custSvcRep, options);
		return saveCustSvcRep(custSvcRep, options);
		

		
	}
	protected CustSvcRep createNewCustSvcRep(String[] optionsExpr) throws Exception
	{
		
		return new CustSvcRep();
		
	}
	public CustSvcRep updateCustSvcRep(String custSvcRepId, String property, Object newValue) throws Exception 
	{
		return new CustSvcRep();
	}
	protected Map<String,Object> emptyOptions(){
		return new HashMap<String,Object>();
	}
	
	protected CustSvcRepTokens tokens(){
		return CustSvcRepTokens.start();
	}
	protected Map<String,Object> allTokens(){
		return CustSvcRepTokens.all();
	}
	
	public CustSvcRep transferToNewRole(String custSvcRepId, String newRoleId) throws Exception
 	{
 		CustSvcRep custSvcRep = loadCustSvcRep(custSvcRepId, allTokens());	
		Role role = loadRole(newRoleId, emptyOptions());		
		custSvcRep.setRole(role);		
		return saveCustSvcRep(custSvcRep, emptyOptions());
 	}
 	
 	protected Role loadRole(String newRoleId, Map<String,Object> options) throws Exception
 	{
 		return getRoleDAO().load(newRoleId, options);
 	}
 	
 	public CustSvcRep transferToNewCompany(String custSvcRepId, String newCompanyId) throws Exception
 	{
 		CustSvcRep custSvcRep = loadCustSvcRep(custSvcRepId, allTokens());	
		SellerCompany company = loadCompany(newCompanyId, emptyOptions());		
		custSvcRep.setCompany(company);		
		return saveCustSvcRep(custSvcRep, emptyOptions());
 	}
 	
 	protected SellerCompany loadCompany(String newCompanyId, Map<String,Object> options) throws Exception
 	{
 		return getSellerCompanyDAO().load(newCompanyId, options);
 	}
 	
 

	public void delete(String custSvcRepId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}


}


