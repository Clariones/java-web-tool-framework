
package com.terapico.b2b;

import java.util.List;
import java.util.ArrayList;
public class SellerCompanyJDBCTemplateDAO extends CommonJDBCTemplateDAO implements SellerCompanyDAO{

	public SellerCompany load(String sellerCompanyId) throws SellerCompanyNotFoundException{
		return loadInternalSellerCompany(sellerCompanyId);
	}
	public SellerCompany save(SellerCompany sellerCompany){
		return sellerCompany;
	}
	public void delete(String sellerCompanyId) throws SellerCompanyNotFoundException{
	
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"name"};
	}
	@Override
	protected String getName() {
		
		return "seller_company";
	}
	
	
		
	private boolean extractOrderListEnabled = false;
	public boolean isExtractOrderListEnabled(){
		return extractOrderListEnabled;
		
 	}
 	public void setExtractOrderListEnabled(boolean extractOrderListEnabled){
		this.extractOrderListEnabled = extractOrderListEnabled;
		
 	}
 	
 	private boolean saveOrderListEnabled = false;
	public boolean isSaveOrderListEnabled(){
		return saveOrderListEnabled;
		
 	}
 	public void setSaveOrderListEnabled(boolean saveOrderListEnabled){
		this.saveOrderListEnabled = saveOrderListEnabled;
		
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
		
	

	protected SellerCompany extractSellerCompany(String sellerCompanyId){
		return null;
	}

	protected SellerCompany loadInternalSellerCompany(String sellerCompanyId){
		
		SellerCompany sellerCompany = extractSellerCompany(sellerCompanyId);

		
		if(isExtractOrderListEnabled()){
	 		extractOrderList(sellerCompany);
 		}		
		
		if(isExtractCsrListEnabled()){
	 		extractCsrList(sellerCompany);
 		}		
		
		return sellerCompany;
		
	}//method end loadInternalSellerCompany(String sellerCompanyId)
	
	//======================================================================================
	
		
	protected SellerCompany extractOrderList(SellerCompany sellerCompany){
		
		return sellerCompany;
	
	}	
		
	protected SellerCompany extractCsrList(SellerCompany sellerCompany){
		
		return sellerCompany;
	
	}	
		
	

	protected SellerCompany saveSellerCompany(SellerCompany  sellerCompany){
	
		return sellerCompany;
	
	}
	protected SellerCompany saveInternalSellerCompany(SellerCompany sellerCompany){
		
		saveSellerCompany(sellerCompany);

		
		if(isSaveOrderListEnabled()){
	 		saveOrderList(sellerCompany);
 		}		
		
		if(isSaveCsrListEnabled()){
	 		saveCsrList(sellerCompany);
 		}		
		
		return sellerCompany;
		
	}//method end loadInternalSellerCompany(String sellerCompanyId)
	
	
	
	//======================================================================================
	
		
	protected SellerCompany saveOrderList(SellerCompany sellerCompany){
		
		return sellerCompany;
	
	}
		
	protected SellerCompany saveCsrList(SellerCompany sellerCompany){
		
		return sellerCompany;
	
	}
		

}


