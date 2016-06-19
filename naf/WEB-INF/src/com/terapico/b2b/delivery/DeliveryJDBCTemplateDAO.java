
package com.terapico.b2b.delivery;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import com.terapico.b2b.CommonJDBCTemplateDAO;
import com.terapico.b2b.order.Order;

import com.terapico.b2b.order.OrderDAO;

public class DeliveryJDBCTemplateDAO extends CommonJDBCTemplateDAO implements DeliveryDAO{

		
	
  	private  OrderDAO  orderDAO;
 	public void setOrderDAO(OrderDAO pOrderDAO){
 	
 		if(pOrderDAO == null){
 			throw new IllegalStateException("Do not trying to set orderDAO to null.");
 		}
	 	this.orderDAO = pOrderDAO;
 	}
 	public OrderDAO getOrderDAO(){
 		if(this.orderDAO == null){
 			throw new IllegalStateException("The orderDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.orderDAO;
 	}	
 	
			
		

	public Delivery load(String deliveryId,Map<String,Object> options) throws Exception{
		return loadInternalDelivery(deliveryId, options);
	}
	public Delivery save(Delivery delivery,Map<String,Object> options){
		
		String methodName="save(Delivery delivery,Map<String,Object> options){";
		
		assertMethodArgumentNotNull(delivery, methodName, "delivery");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalDelivery(delivery,options);
	}
	public Delivery clone(String deliveryId,Map<String,Object> options) throws Exception{
	
		String methodName="clone(String deliveryId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(deliveryId, methodName, "deliveryId");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Delivery newDelivery = load(deliveryId, options);
		newDelivery.setVersion(0);
		
		
 		
 		if(isSaveOrderListEnabled(options)){
 			for(Order item: newDelivery.getOrderList()){
 				item.setVersion(0);
 			}
 		}
		
		
		saveInternalDelivery(newDelivery,options);
		
		return newDelivery;
	}
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = getJdbcTemplateObject().update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String deliveryId, int version) throws  DeliveryVersionChangedException,  DeliveryNotFoundException {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{deliveryId};
		int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new DeliveryVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new DeliveryNotFoundException(
					"The " + this.getTableName() + "(" + deliveryId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String deliveryId, int version) throws Exception{
	
		String methodName="delete(String deliveryId, int version)";
		assertMethodArgumentNotNull(deliveryId, methodName, "deliveryId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{deliveryId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(deliveryId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"who","delivery_time"};
	}
	@Override
	protected String getName() {
		
		return "delivery";
	}
	
	
	static final String ALL="__all__"; //do not assign this to common users,
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


		
	protected static final String ORDER_LIST = "orderList";
	
	protected boolean isExtractOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,ORDER_LIST);
		
 	}

	protected boolean isSaveOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, ORDER_LIST);
		
 	}
 	
 	
			
		
	

	protected DeliveryMapper getMapper(){
		return new DeliveryMapper();
	}
	protected Delivery extractDelivery(String deliveryId){
		String SQL = "select * from delivery_data where id=?";	
		Delivery delivery = getJdbcTemplateObject().queryForObject(SQL, new Object[]{deliveryId}, getMapper());
		return delivery;
	}

	protected Delivery loadInternalDelivery(String deliveryId, Map<String,Object> loadOptions) throws Exception{
		
		Delivery delivery = extractDelivery(deliveryId);

		
		if(isExtractOrderListEnabled(loadOptions)){
	 		extractOrderList(delivery, loadOptions);
 		}		
		
		return delivery;
		
	}
	
	
	
		
	protected Delivery extractOrderList(Delivery delivery, Map<String,Object> options){
		
		List<Order> orderList = getOrderDAO().findOrderByDelivery(delivery.getId());
		if(orderList != null){
			delivery.setOrderList(orderList);
		}
		
		return delivery;
	
	}	
		
		
 	
		
		
		
	

	protected Delivery saveDelivery(Delivery  delivery){
	
		String SQL=this.getSaveDeliverySQL(delivery);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveDeliveryParameters(delivery);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		return delivery;
	
	}
	public List<Delivery> saveList(List<Delivery> deliveryList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitDeliveryList(deliveryList);
		
		batchCreate((List<Delivery>)lists[CREATE_LIST_INDEX]);
		
		batchUpdate((List<Delivery>)lists[UPDATE_LIST_INDEX]);

		return deliveryList;
	}

	
	protected List<Object[]> prepareBatchCreateArgs(List<Delivery> deliveryList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Delivery delivery:deliveryList ){
			Object [] parameters = prepareCreateDeliveryParameters(delivery);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBatchUpdateArgs(List<Delivery> deliveryList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Delivery delivery:deliveryList ){
			Object [] parameters = prepareUpdateDeliveryParameters(delivery);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCreate(List<Delivery> deliveryList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBatchCreateArgs(deliveryList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUpdate(List<Delivery> deliveryList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBatchUpdateArgs(deliveryList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitDeliveryList(List<Delivery> deliveryList){
		
		List<Delivery> deliveryCreateList=new ArrayList<Delivery>();
		List<Delivery> deliveryUpdateList=new ArrayList<Delivery>();
		
		for(Delivery delivery: deliveryList){
			if(isUpdateRequest(delivery)){
				deliveryUpdateList.add( delivery);
				continue;
			}
			deliveryCreateList.add(delivery);
		}
		
		return new Object[]{deliveryCreateList,deliveryUpdateList};
	}
	
	protected boolean isUpdateRequest(Delivery delivery){
 		return delivery.getVersion() > 0;
 	}
 	protected String getSaveDeliverySQL(Delivery delivery){
 		if(isUpdateRequest(delivery)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveDeliveryParameters(Delivery delivery){
 		if(isUpdateRequest(delivery) ){
 			return prepareUpdateDeliveryParameters(delivery);
 		}
 		return prepareCreateDeliveryParameters(delivery);
 	}
 	protected Object[] prepareUpdateDeliveryParameters(Delivery delivery){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = delivery.getWho();
 		parameters[1] = delivery.getDeliveryTime();		
 		parameters[2] = delivery.getId();
 		parameters[3] = delivery.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateDeliveryParameters(Delivery delivery){
		Object[] parameters = new Object[3];
		String newDeliveryId=getNextId();
		delivery.setId(newDeliveryId);
		parameters[0] =  delivery.getId();
 
 		parameters[1] = delivery.getWho();
 		parameters[2] = delivery.getDeliveryTime();		
 				
 		return parameters;
 	}
 	
	protected Delivery saveInternalDelivery(Delivery delivery, Map<String,Object> options){
		
		saveDelivery(delivery);

		
		if(isSaveOrderListEnabled(options)){
	 		saveOrderList(delivery, options);
 		}		
		
		return delivery;
		
	}
	
	
	
	//======================================================================================
	
		
	protected Delivery saveOrderList(Delivery delivery, Map<String,Object> options){
		List<Order> orderList = delivery.getOrderList();
		if(orderList == null){
			return delivery;
		}
		if(orderList.isEmpty()){
			return delivery;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getOrderDAO().saveList(delivery.getOrderList(),options);
		
		return delivery;
	
	}
		
	protected void assertMethodArgumentNotNull(Object object, String method, String parameterName){
		if(object == null){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' shoud NOT be null");
		}
	}
	protected void assertMethodIntArgumentGreaterThan(int value, int targetValue,String method, String parameterName){
		if(value <= targetValue){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' shoud greater than " + targetValue +" but it is: "+ value);
		}
	}
	protected void assertMethodIntArgumentLessThan(int value, int targetValue,String method, String parameterName){
		if(value >= targetValue){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' shoud less than " + targetValue +" but it is: "+ value);
		}
	}
	
	protected void assertMethodIntArgumentInClosedRange(int value, int startValue, int endValue, String method, String parameterName){
		
		if(startValue>endValue){
			throw new IllegalArgumentException("When calling the check method, please note your parameter, endValue < startValue");
		}
	
		if(value < startValue){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' shoud be in closed range: ["+startValue+","+endValue+"] but it is: "+value);
		}
		if(value > endValue){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' shoud be in closed range: ["+startValue+","+endValue+"] but it is: "+value);
		}
	}
	protected void assertMethodStringArgumentLengthInClosedRange(String value, int lengthMin, int lengthMax, String method, String parameterName){
		
		if(lengthMin < 0){
			throw new IllegalArgumentException("The method assertMethodStringArgumentLengthInClosedRange lengMin should not less than 0");
		}
		
		if(lengthMin > lengthMax){
			throw new IllegalArgumentException("The method assertMethodStringArgumentLengthInClosedRange lengMin less or equal lengthMax");
		}
		
		if(value == null){		
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' length shoud be in closed range: ["+lengthMin+","+lengthMax+"] but it is null");
		}
		if(value.length() < lengthMin){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' length shoud be in closed range: ["+lengthMin+","+lengthMax+"] but it is: "+value.length());
		}
		if(value.length() > lengthMax){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' length shoud be in closed range: ["+lengthMin+","+lengthMax+"] but it is: "+value.length());
		}
	}
	
}


