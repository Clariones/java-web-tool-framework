
package com.terapico.b2b;

import java.util.List;
import java.util.ArrayList;
public class BuyerCompanyJDBCTemplateDAO extends CommonJDBCTemplateDAO implements BuyerCompanyDAO{

	public BuyerCompany load(String buyerCompanyId) throws BuyerCompanyNotFoundException{
		return loadInternalBuyerCompany(buyerCompanyId);
	}
	public BuyerCompany save(BuyerCompany buyerCompany){
		return buyerCompany;
	}
	public void delete(String buyerCompanyId) throws BuyerCompanyNotFoundException{
	
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"name","price_list"};
	}
	@Override
	protected String getName() {
		
		return "buyer_company";
	}
	
	
		
	private boolean extractBillingAddressListEnabled = false;
	public boolean isExtractBillingAddressListEnabled(){
		return extractBillingAddressListEnabled;
		
 	}
 	public void setExtractBillingAddressListEnabled(boolean extractBillingAddressListEnabled){
		this.extractBillingAddressListEnabled = extractBillingAddressListEnabled;
		
 	}
 	
 	private boolean saveBillingAddressListEnabled = false;
	public boolean isSaveBillingAddressListEnabled(){
		return saveBillingAddressListEnabled;
		
 	}
 	public void setSaveBillingAddressListEnabled(boolean saveBillingAddressListEnabled){
		this.saveBillingAddressListEnabled = saveBillingAddressListEnabled;
		
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
		
	private boolean extractEmployeeListEnabled = false;
	public boolean isExtractEmployeeListEnabled(){
		return extractEmployeeListEnabled;
		
 	}
 	public void setExtractEmployeeListEnabled(boolean extractEmployeeListEnabled){
		this.extractEmployeeListEnabled = extractEmployeeListEnabled;
		
 	}
 	
 	private boolean saveEmployeeListEnabled = false;
	public boolean isSaveEmployeeListEnabled(){
		return saveEmployeeListEnabled;
		
 	}
 	public void setSaveEmployeeListEnabled(boolean saveEmployeeListEnabled){
		this.saveEmployeeListEnabled = saveEmployeeListEnabled;
		
 	}			
		
	

	protected BuyerCompany extractBuyerCompany(String buyerCompanyId){
		return null;
	}

	protected BuyerCompany loadInternalBuyerCompany(String buyerCompanyId){
		
		BuyerCompany buyerCompany = extractBuyerCompany(buyerCompanyId);

		
		if(isExtractBillingAddressListEnabled()){
	 		extractBillingAddressList(buyerCompany);
 		}		
		
		if(isExtractOrderListEnabled()){
	 		extractOrderList(buyerCompany);
 		}		
		
		if(isExtractEmployeeListEnabled()){
	 		extractEmployeeList(buyerCompany);
 		}		
		
		return buyerCompany;
		
	}//method end loadInternalBuyerCompany(String buyerCompanyId)
	
	//======================================================================================
	
		
	protected BuyerCompany extractBillingAddressList(BuyerCompany buyerCompany){
		
		return buyerCompany;
	
	}	
		
	protected BuyerCompany extractOrderList(BuyerCompany buyerCompany){
		
		return buyerCompany;
	
	}	
		
	protected BuyerCompany extractEmployeeList(BuyerCompany buyerCompany){
		
		return buyerCompany;
	
	}	
		
	

	protected BuyerCompany saveBuyerCompany(BuyerCompany  buyerCompany){
	
		return buyerCompany;
	
	}
	protected BuyerCompany saveInternalBuyerCompany(BuyerCompany buyerCompany){
		
		saveBuyerCompany(buyerCompany);

		
		if(isSaveBillingAddressListEnabled()){
	 		saveBillingAddressList(buyerCompany);
 		}		
		
		if(isSaveOrderListEnabled()){
	 		saveOrderList(buyerCompany);
 		}		
		
		if(isSaveEmployeeListEnabled()){
	 		saveEmployeeList(buyerCompany);
 		}		
		
		return buyerCompany;
		
	}//method end loadInternalBuyerCompany(String buyerCompanyId)
	
	
	
	//======================================================================================
	
		
	protected BuyerCompany saveBillingAddressList(BuyerCompany buyerCompany){
		
		return buyerCompany;
	
	}
		
	protected BuyerCompany saveOrderList(BuyerCompany buyerCompany){
		
		return buyerCompany;
	
	}
		
	protected BuyerCompany saveEmployeeList(BuyerCompany buyerCompany){
		
		return buyerCompany;
	
	}
		

}


