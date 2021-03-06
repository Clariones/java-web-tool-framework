
package com.terapico.b2b.lineitem;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.terapico.b2b.CommonJDBCTemplateDAO;
import com.terapico.b2b.order.Order;

import com.terapico.b2b.order.OrderDAO;


import org.springframework.dao.EmptyResultDataAccessException;

public class LineItemJDBCTemplateDAO extends CommonJDBCTemplateDAO implements LineItemDAO{
 
 	
 	private  OrderDAO  orderDAO;
 	public void setOrderDAO(OrderDAO orderDAO){
	 	this.orderDAO = orderDAO;
 	}
 	public OrderDAO getOrderDAO(){
	 	return this.orderDAO;
 	}

		

	public LineItem load(String lineItemId,Map<String,Object> options) throws Exception{
		return loadInternalLineItem(lineItemId, options);
	}
	public LineItem save(LineItem lineItem,Map<String,Object> options){
		
		String methodName="save(LineItem lineItem,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(lineItem, methodName, "lineItem");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalLineItem(lineItem,options);
	}
	public LineItem clone(String lineItemId,Map<String,Object> options) throws Exception{
	
		String methodName="clone(String lineItemId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(lineItemId, methodName, "lineItemId");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		LineItem newLineItem = load(lineItemId, options);
		newLineItem.setVersion(0);
		
		
		
		saveInternalLineItem(newLineItem,options);
		
		return newLineItem;
	}
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = getJdbcTemplateObject().update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String lineItemId, int version) throws  LineItemVersionChangedException,  LineItemNotFoundException {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{lineItemId};
		int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new LineItemVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new LineItemNotFoundException(
					"The " + this.getTableName() + "(" + lineItemId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String lineItemId, int version) throws Exception{
	
		String methodName="delete(String lineItemId, int version)";
		assertMethodArgumentNotNull(lineItemId, methodName, "lineItemId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{lineItemId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(lineItemId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"biz_order","sku_id","sku_name","amount","quantity","active"};
	}
	@Override
	protected String getName() {
		
		return "line_item";
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

 
 	//private boolean extractBizOrderEnabled = true;
 	//private static final String BIZORDER = "bizOrder";
 	protected boolean isExtractBizOrderEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, LineItemTokens.BIZORDER);
 	}
 	
 	
 	//private boolean saveBizOrderEnabled = true;
 	protected boolean isSaveBizOrderEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, LineItemTokens.BIZORDER);
 	}
 	

 	
 
		
	

	protected LineItemMapper getMapper(){
		return new LineItemMapper();
	}
	protected LineItem extractLineItem(String lineItemId) throws Exception{
		String SQL = "select * from line_item_data where id=?";	
		try{
		
			LineItem lineItem = getJdbcTemplateObject().queryForObject(SQL, new Object[]{lineItemId}, getMapper());
			return lineItem;
		}catch(EmptyResultDataAccessException e){
			throw new LineItemNotFoundException("LineItem("+lineItemId+") is not found!");
		}
		
		
	}

	protected LineItem loadInternalLineItem(String lineItemId, Map<String,Object> loadOptions) throws Exception{
		
		LineItem lineItem = extractLineItem(lineItemId);
 	
 		if(isExtractBizOrderEnabled(loadOptions)){
	 		extractBizOrder(lineItem, loadOptions);
 		}
 
		
		return lineItem;
		
	}
	
	
	 

 	protected LineItem extractBizOrder(LineItem lineItem, Map<String,Object> options) throws Exception{

		if(lineItem.getBizOrder() == null){
			return lineItem;
		}
		String bizOrderId = lineItem.getBizOrder().getId();
		if( bizOrderId == null){
			return lineItem;
		}
		Order bizOrder = getOrderDAO().load(bizOrderId,options);
		if(bizOrder != null){
			lineItem.setBizOrder(bizOrder);
		}
		
 		
 		return lineItem;
 	}
 		
 
		
		
  	
 	public List<LineItem> findLineItemByBizOrder(String orderId){
 	
 		String SQL = "select * from "+this.getTableName()+" where biz_order = ?";
		List<LineItem> lineItemList = getJdbcTemplateObject().query(SQL, new Object[]{orderId}, getMapper());
		
 	
 		return lineItemList;
 	}
 	
		
		
		
	

	protected LineItem saveLineItem(LineItem  lineItem){
	
		String SQL=this.getSaveLineItemSQL(lineItem);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveLineItemParameters(lineItem);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		int newVersion = lineItem.getVersion() + 1;
		lineItem.setVersion(newVersion);
		return lineItem;
	
	}
	public List<LineItem> saveList(List<LineItem> lineItemList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitLineItemList(lineItemList);
		
		batchCreate((List<LineItem>)lists[CREATE_LIST_INDEX]);
		
		batchUpdate((List<LineItem>)lists[UPDATE_LIST_INDEX]);

		return lineItemList;
	}

	
	protected List<Object[]> prepareBatchCreateArgs(List<LineItem> lineItemList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LineItem lineItem:lineItemList ){
			Object [] parameters = prepareCreateLineItemParameters(lineItem);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBatchUpdateArgs(List<LineItem> lineItemList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LineItem lineItem:lineItemList ){
			Object [] parameters = prepareUpdateLineItemParameters(lineItem);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCreate(List<LineItem> lineItemList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBatchCreateArgs(lineItemList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUpdate(List<LineItem> lineItemList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBatchUpdateArgs(lineItemList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitLineItemList(List<LineItem> lineItemList){
		
		List<LineItem> lineItemCreateList=new ArrayList<LineItem>();
		List<LineItem> lineItemUpdateList=new ArrayList<LineItem>();
		
		for(LineItem lineItem: lineItemList){
			if(isUpdateRequest(lineItem)){
				lineItemUpdateList.add( lineItem);
				continue;
			}
			lineItemCreateList.add(lineItem);
		}
		
		return new Object[]{lineItemCreateList,lineItemUpdateList};
	}
	
	protected boolean isUpdateRequest(LineItem lineItem){
 		return lineItem.getVersion() > 0;
 	}
 	protected String getSaveLineItemSQL(LineItem lineItem){
 		if(isUpdateRequest(lineItem)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveLineItemParameters(LineItem lineItem){
 		if(isUpdateRequest(lineItem) ){
 			return prepareUpdateLineItemParameters(lineItem);
 		}
 		return prepareCreateLineItemParameters(lineItem);
 	}
 	protected Object[] prepareUpdateLineItemParameters(LineItem lineItem){
 		Object[] parameters = new Object[8];
  	
 		if(lineItem.getBizOrder() != null){
 			parameters[0] = lineItem.getBizOrder().getId();
 		}
 
 		parameters[1] = lineItem.getSkuId();
 		parameters[2] = lineItem.getSkuName();
 		parameters[3] = lineItem.getAmount();
 		parameters[4] = lineItem.getQuantity();
 		parameters[5] = lineItem.getActive();		
 		parameters[6] = lineItem.getId();
 		parameters[7] = lineItem.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateLineItemParameters(LineItem lineItem){
		Object[] parameters = new Object[7];
		String newLineItemId=getNextId();
		lineItem.setId(newLineItemId);
		parameters[0] =  lineItem.getId();
  	
 		if(lineItem.getBizOrder() != null){
 			parameters[1] = lineItem.getBizOrder().getId();
 		
 		}
 		
 		parameters[2] = lineItem.getSkuId();
 		parameters[3] = lineItem.getSkuName();
 		parameters[4] = lineItem.getAmount();
 		parameters[5] = lineItem.getQuantity();
 		parameters[6] = lineItem.getActive();		
 				
 		return parameters;
 	}
 	
	protected LineItem saveInternalLineItem(LineItem lineItem, Map<String,Object> options){
		
		saveLineItem(lineItem);
 	
 		if(isSaveBizOrderEnabled(options)){
	 		saveBizOrder(lineItem, options);
 		}
 
		
		return lineItem;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected LineItem saveBizOrder(LineItem lineItem, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		getOrderDAO().save(lineItem.getBizOrder(),options);
 		return lineItem;
 		
 	}
	
 
		

	
}


