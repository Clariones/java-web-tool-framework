
package com.terapico.b2b;

import java.util.List;
import java.util.ArrayList;
public class LineItemJDBCTemplateDAO extends CommonJDBCTemplateDAO implements LineItemDAO{

	public LineItem load(String lineItemId) throws LineItemNotFoundException{
		return loadInternalLineItem(lineItemId);
	}
	public LineItem save(LineItem lineItem){
		return lineItem;
	}
	public void delete(String lineItemId) throws LineItemNotFoundException{
	
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"biz_order","sku_id","sku_name","amount","quantity"};
	}
	@Override
	protected String getName() {
		
		return "line_item";
	}
	
	 
 	private boolean extractBizOrderEnabled = true;
 	public boolean isExtractBizOrderEnabled(){
	 	return extractBizOrderEnabled;
 	}
 	
 	public void setExtractBizOrderEnabled(boolean extractBizOrderEnabled){
	 	this.extractBizOrderEnabled = extractBizOrderEnabled;
 	}
 	
 	private boolean saveBizOrderEnabled = true;
 	public boolean isSaveBizOrderEnabled(){
	 	return saveBizOrderEnabled;
 	}
 	
 	public void setSaveBizOrderEnabled(boolean saveBizOrderEnabled){
	 	this.saveBizOrderEnabled = saveBizOrderEnabled;
 	}
 	
 
		
	

	protected LineItem extractLineItem(String lineItemId){
		return null;
	}

	protected LineItem loadInternalLineItem(String lineItemId){
		
		LineItem lineItem = extractLineItem(lineItemId);
 	
 		if(isExtractBizOrderEnabled()){
	 		extractBizOrder(lineItem);
 		}
 
		
		return lineItem;
		
	}//method end loadInternalLineItem(String lineItemId)
	
	//======================================================================================
	 
 	protected LineItem extractBizOrder(LineItem lineItem){
 		
 		return lineItem;
 	}
 		
 
		
	

	protected LineItem saveLineItem(LineItem  lineItem){
	
		return lineItem;
	
	}
	protected LineItem saveInternalLineItem(LineItem lineItem){
		
		saveLineItem(lineItem);
 	
 		if(isSaveBizOrderEnabled()){
	 		saveBizOrder(lineItem);
 		}
 
		
		return lineItem;
		
	}//method end loadInternalLineItem(String lineItemId)
	
	
	
	//======================================================================================
	 
 	protected LineItem saveBizOrder(LineItem lineItem){
 	
 		return lineItem;
 	}
 		
 
		
 	
 	public List<LineItem> findLineItemByBizOrder(String orderId){
 		return new ArrayList<LineItem>();
 	}//find end
 
}


