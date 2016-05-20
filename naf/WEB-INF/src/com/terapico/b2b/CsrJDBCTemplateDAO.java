
package com.terapico.b2b;

import java.util.List;
import java.util.ArrayList;
public class CsrJDBCTemplateDAO extends CommonJDBCTemplateDAO implements CsrDAO{

	public Csr load(String csrId) throws CsrNotFoundException{
		return loadInternalCsr(csrId);
	}
	public Csr save(Csr csr){
		return csr;
	}
	public void delete(String csrId) throws CsrNotFoundException{
	
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"email","role","company"};
	}
	@Override
	protected String getName() {
		
		return "csr";
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
 	
  
 	private boolean extractCompanyEnabled = true;
 	public boolean isExtractCompanyEnabled(){
	 	return extractCompanyEnabled;
 	}
 	
 	public void setExtractCompanyEnabled(boolean extractCompanyEnabled){
	 	this.extractCompanyEnabled = extractCompanyEnabled;
 	}
 	
 	private boolean saveCompanyEnabled = true;
 	public boolean isSaveCompanyEnabled(){
	 	return saveCompanyEnabled;
 	}
 	
 	public void setSaveCompanyEnabled(boolean saveCompanyEnabled){
	 	this.saveCompanyEnabled = saveCompanyEnabled;
 	}
 	
 
		
	

	protected Csr extractCsr(String csrId){
		return null;
	}

	protected Csr loadInternalCsr(String csrId){
		
		Csr csr = extractCsr(csrId);
 	
 		if(isExtractRoleEnabled()){
	 		extractRole(csr);
 		}
  	
 		if(isExtractCompanyEnabled()){
	 		extractCompany(csr);
 		}
 
		
		return csr;
		
	}//method end loadInternalCsr(String csrId)
	
	//======================================================================================
	 
 	protected Csr extractRole(Csr csr){
 		
 		return csr;
 	}
 		
  
 	protected Csr extractCompany(Csr csr){
 		
 		return csr;
 	}
 		
 
		
	

	protected Csr saveCsr(Csr  csr){
	
		return csr;
	
	}
	protected Csr saveInternalCsr(Csr csr){
		
		saveCsr(csr);
 	
 		if(isSaveRoleEnabled()){
	 		saveRole(csr);
 		}
  	
 		if(isSaveCompanyEnabled()){
	 		saveCompany(csr);
 		}
 
		
		return csr;
		
	}//method end loadInternalCsr(String csrId)
	
	
	
	//======================================================================================
	 
 	protected Csr saveRole(Csr csr){
 	
 		return csr;
 	}
 		
  
 	protected Csr saveCompany(Csr csr){
 	
 		return csr;
 	}
 		
 
		
 	
 	public List<Csr> findCsrByRole(String roleId){
 		return new ArrayList<Csr>();
 	}//find end
  	
 	public List<Csr> findCsrByCompany(String sellerCompanyId){
 		return new ArrayList<Csr>();
 	}//find end
 
}






