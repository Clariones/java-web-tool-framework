
package com.terapico.b2b.shipment;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import com.terapico.b2b.CommonJDBCTemplateDAO;
import com.terapico.b2b.order.Order;

import com.terapico.b2b.order.OrderDAO;

public class ShipmentJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ShipmentDAO{

		
	
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
 	
			
		

	public Shipment load(String shipmentId,Map<String,Object> options) throws Exception{
		return loadInternalShipment(shipmentId, options);
	}
	public Shipment save(Shipment shipment,Map<String,Object> options){
		
		String methodName="save(Shipment shipment,Map<String,Object> options){";
		
		assertMethodArgumentNotNull(shipment, methodName, "shipment");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalShipment(shipment,options);
	}
	public Shipment clone(String shipmentId,Map<String,Object> options) throws Exception{
	
		String methodName="clone(String shipmentId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(shipmentId, methodName, "shipmentId");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Shipment newShipment = load(shipmentId, options);
		newShipment.setVersion(0);
		
		
 		
 		if(isSaveOrderListEnabled(options)){
 			for(Order item: newShipment.getOrderList()){
 				item.setVersion(0);
 			}
 		}
		
		
		saveInternalShipment(newShipment,options);
		
		return newShipment;
	}
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = getJdbcTemplateObject().update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String shipmentId, int version) throws  ShipmentVersionChangedException,  ShipmentNotFoundException {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{shipmentId};
		int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new ShipmentVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ShipmentNotFoundException(
					"The " + this.getTableName() + "(" + shipmentId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String shipmentId, int version) throws Exception{
	
		String methodName="delete(String shipmentId, int version)";
		assertMethodArgumentNotNull(shipmentId, methodName, "shipmentId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{shipmentId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(shipmentId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"who","shup_time"};
	}
	@Override
	protected String getName() {
		
		return "shipment";
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
 	
 	
			
		
	

	protected ShipmentMapper getMapper(){
		return new ShipmentMapper();
	}
	protected Shipment extractShipment(String shipmentId){
		String SQL = "select * from shipment_data where id=?";	
		Shipment shipment = getJdbcTemplateObject().queryForObject(SQL, new Object[]{shipmentId}, getMapper());
		return shipment;
	}

	protected Shipment loadInternalShipment(String shipmentId, Map<String,Object> loadOptions) throws Exception{
		
		Shipment shipment = extractShipment(shipmentId);

		
		if(isExtractOrderListEnabled(loadOptions)){
	 		extractOrderList(shipment, loadOptions);
 		}		
		
		return shipment;
		
	}
	
	
	
		
	protected Shipment extractOrderList(Shipment shipment, Map<String,Object> options){
		
		List<Order> orderList = getOrderDAO().findOrderByShipment(shipment.getId());
		if(orderList != null){
			shipment.setOrderList(orderList);
		}
		
		return shipment;
	
	}	
		
		
 	
		
		
		
	

	protected Shipment saveShipment(Shipment  shipment){
	
		String SQL=this.getSaveShipmentSQL(shipment);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveShipmentParameters(shipment);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		return shipment;
	
	}
	public List<Shipment> saveList(List<Shipment> shipmentList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitShipmentList(shipmentList);
		
		batchCreate((List<Shipment>)lists[CREATE_LIST_INDEX]);
		
		batchUpdate((List<Shipment>)lists[UPDATE_LIST_INDEX]);

		return shipmentList;
	}

	
	protected List<Object[]> prepareBatchCreateArgs(List<Shipment> shipmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Shipment shipment:shipmentList ){
			Object [] parameters = prepareCreateShipmentParameters(shipment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBatchUpdateArgs(List<Shipment> shipmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Shipment shipment:shipmentList ){
			Object [] parameters = prepareUpdateShipmentParameters(shipment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCreate(List<Shipment> shipmentList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBatchCreateArgs(shipmentList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUpdate(List<Shipment> shipmentList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBatchUpdateArgs(shipmentList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitShipmentList(List<Shipment> shipmentList){
		
		List<Shipment> shipmentCreateList=new ArrayList<Shipment>();
		List<Shipment> shipmentUpdateList=new ArrayList<Shipment>();
		
		for(Shipment shipment: shipmentList){
			if(isUpdateRequest(shipment)){
				shipmentUpdateList.add( shipment);
				continue;
			}
			shipmentCreateList.add(shipment);
		}
		
		return new Object[]{shipmentCreateList,shipmentUpdateList};
	}
	
	protected boolean isUpdateRequest(Shipment shipment){
 		return shipment.getVersion() > 0;
 	}
 	protected String getSaveShipmentSQL(Shipment shipment){
 		if(isUpdateRequest(shipment)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveShipmentParameters(Shipment shipment){
 		if(isUpdateRequest(shipment) ){
 			return prepareUpdateShipmentParameters(shipment);
 		}
 		return prepareCreateShipmentParameters(shipment);
 	}
 	protected Object[] prepareUpdateShipmentParameters(Shipment shipment){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = shipment.getWho();
 		parameters[1] = shipment.getShupTime();		
 		parameters[2] = shipment.getId();
 		parameters[3] = shipment.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateShipmentParameters(Shipment shipment){
		Object[] parameters = new Object[3];
		String newShipmentId=getNextId();
		shipment.setId(newShipmentId);
		parameters[0] =  shipment.getId();
 
 		parameters[1] = shipment.getWho();
 		parameters[2] = shipment.getShupTime();		
 				
 		return parameters;
 	}
 	
	protected Shipment saveInternalShipment(Shipment shipment, Map<String,Object> options){
		
		saveShipment(shipment);

		
		if(isSaveOrderListEnabled(options)){
	 		saveOrderList(shipment, options);
 		}		
		
		return shipment;
		
	}
	
	
	
	//======================================================================================
	
		
	protected Shipment saveOrderList(Shipment shipment, Map<String,Object> options){
		List<Order> orderList = shipment.getOrderList();
		if(orderList == null){
			return shipment;
		}
		if(orderList.isEmpty()){
			return shipment;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getOrderDAO().saveList(shipment.getOrderList(),options);
		
		return shipment;
	
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


