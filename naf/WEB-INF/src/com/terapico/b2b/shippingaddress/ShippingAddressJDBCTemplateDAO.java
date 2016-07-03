
package com.terapico.b2b.shippingaddress;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.terapico.b2b.CommonJDBCTemplateDAO;
import com.terapico.b2b.shippinggroup.ShippingGroup;

import com.terapico.b2b.shippinggroup.ShippingGroupDAO;


import org.springframework.dao.EmptyResultDataAccessException;

public class ShippingAddressJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ShippingAddressDAO{

		
	
  	private  ShippingGroupDAO  shippingGroupDAO;
 	public void setShippingGroupDAO(ShippingGroupDAO pShippingGroupDAO){
 	
 		if(pShippingGroupDAO == null){
 			throw new IllegalStateException("Do not try to set shippingGroupDAO to null.");
 		}
	 	this.shippingGroupDAO = pShippingGroupDAO;
 	}
 	public ShippingGroupDAO getShippingGroupDAO(){
 		if(this.shippingGroupDAO == null){
 			throw new IllegalStateException("The shippingGroupDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.shippingGroupDAO;
 	}	
 	
			
		

	public ShippingAddress load(String shippingAddressId,Map<String,Object> options) throws Exception{
		return loadInternalShippingAddress(shippingAddressId, options);
	}
	public ShippingAddress save(ShippingAddress shippingAddress,Map<String,Object> options){
		
		String methodName="save(ShippingAddress shippingAddress,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(shippingAddress, methodName, "shippingAddress");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalShippingAddress(shippingAddress,options);
	}
	public ShippingAddress clone(String shippingAddressId,Map<String,Object> options) throws Exception{
	
		String methodName="clone(String shippingAddressId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(shippingAddressId, methodName, "shippingAddressId");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ShippingAddress newShippingAddress = load(shippingAddressId, options);
		newShippingAddress.setVersion(0);
		
		
 		
 		if(isSaveShippingGroupListEnabled(options)){
 			for(ShippingGroup item: newShippingAddress.getShippingGroupList()){
 				item.setVersion(0);
 			}
 		}
		
		
		saveInternalShippingAddress(newShippingAddress,options);
		
		return newShippingAddress;
	}
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = getJdbcTemplateObject().update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String shippingAddressId, int version) throws  ShippingAddressVersionChangedException,  ShippingAddressNotFoundException {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{shippingAddressId};
		int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new ShippingAddressVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ShippingAddressNotFoundException(
					"The " + this.getTableName() + "(" + shippingAddressId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String shippingAddressId, int version) throws Exception{
	
		String methodName="delete(String shippingAddressId, int version)";
		assertMethodArgumentNotNull(shippingAddressId, methodName, "shippingAddressId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{shippingAddressId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(shippingAddressId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"line1","line2","city","state","country"};
	}
	@Override
	protected String getName() {
		
		return "shipping_address";
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


		
	//protected static final String SHIPPING_GROUP_LIST = "shippingGroupList";
	
	protected boolean isExtractShippingGroupListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,ShippingAddressTokens.SHIPPING_GROUP_LIST);
		
 	}

	protected boolean isSaveShippingGroupListEnabled(Map<String,Object> options){
		return checkOptions(options, ShippingAddressTokens.SHIPPING_GROUP_LIST);
		
 	}
 	
 	
			
		
	

	protected ShippingAddressMapper getMapper(){
		return new ShippingAddressMapper();
	}
	protected ShippingAddress extractShippingAddress(String shippingAddressId) throws Exception{
		String SQL = "select * from shipping_address_data where id=?";	
		try{
		
			ShippingAddress shippingAddress = getJdbcTemplateObject().queryForObject(SQL, new Object[]{shippingAddressId}, getMapper());
			return shippingAddress;
		}catch(EmptyResultDataAccessException e){
			throw new ShippingAddressNotFoundException("ShippingAddress("+shippingAddressId+") is not found!");
		}
		
		
	}

	protected ShippingAddress loadInternalShippingAddress(String shippingAddressId, Map<String,Object> loadOptions) throws Exception{
		
		ShippingAddress shippingAddress = extractShippingAddress(shippingAddressId);

		
		if(isExtractShippingGroupListEnabled(loadOptions)){
	 		extractShippingGroupList(shippingAddress, loadOptions);
 		}		
		
		return shippingAddress;
		
	}
	
	
	
		
	protected ShippingAddress extractShippingGroupList(ShippingAddress shippingAddress, Map<String,Object> options){
		
		List<ShippingGroup> shippingGroupList = getShippingGroupDAO().findShippingGroupByAddress(shippingAddress.getId());
		if(shippingGroupList != null){
			shippingAddress.setShippingGroupList(shippingGroupList);
		}
		
		return shippingAddress;
	
	}	
		
		
 	
		
		
		
	

	protected ShippingAddress saveShippingAddress(ShippingAddress  shippingAddress){
	
		String SQL=this.getSaveShippingAddressSQL(shippingAddress);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveShippingAddressParameters(shippingAddress);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		int newVersion = shippingAddress.getVersion() + 1;
		shippingAddress.setVersion(newVersion);
		return shippingAddress;
	
	}
	public List<ShippingAddress> saveList(List<ShippingAddress> shippingAddressList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitShippingAddressList(shippingAddressList);
		
		batchCreate((List<ShippingAddress>)lists[CREATE_LIST_INDEX]);
		
		batchUpdate((List<ShippingAddress>)lists[UPDATE_LIST_INDEX]);

		return shippingAddressList;
	}

	
	protected List<Object[]> prepareBatchCreateArgs(List<ShippingAddress> shippingAddressList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ShippingAddress shippingAddress:shippingAddressList ){
			Object [] parameters = prepareCreateShippingAddressParameters(shippingAddress);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBatchUpdateArgs(List<ShippingAddress> shippingAddressList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ShippingAddress shippingAddress:shippingAddressList ){
			Object [] parameters = prepareUpdateShippingAddressParameters(shippingAddress);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCreate(List<ShippingAddress> shippingAddressList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBatchCreateArgs(shippingAddressList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUpdate(List<ShippingAddress> shippingAddressList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBatchUpdateArgs(shippingAddressList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitShippingAddressList(List<ShippingAddress> shippingAddressList){
		
		List<ShippingAddress> shippingAddressCreateList=new ArrayList<ShippingAddress>();
		List<ShippingAddress> shippingAddressUpdateList=new ArrayList<ShippingAddress>();
		
		for(ShippingAddress shippingAddress: shippingAddressList){
			if(isUpdateRequest(shippingAddress)){
				shippingAddressUpdateList.add( shippingAddress);
				continue;
			}
			shippingAddressCreateList.add(shippingAddress);
		}
		
		return new Object[]{shippingAddressCreateList,shippingAddressUpdateList};
	}
	
	protected boolean isUpdateRequest(ShippingAddress shippingAddress){
 		return shippingAddress.getVersion() > 0;
 	}
 	protected String getSaveShippingAddressSQL(ShippingAddress shippingAddress){
 		if(isUpdateRequest(shippingAddress)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveShippingAddressParameters(ShippingAddress shippingAddress){
 		if(isUpdateRequest(shippingAddress) ){
 			return prepareUpdateShippingAddressParameters(shippingAddress);
 		}
 		return prepareCreateShippingAddressParameters(shippingAddress);
 	}
 	protected Object[] prepareUpdateShippingAddressParameters(ShippingAddress shippingAddress){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = shippingAddress.getLine1();
 		parameters[1] = shippingAddress.getLine2();
 		parameters[2] = shippingAddress.getCity();
 		parameters[3] = shippingAddress.getState();
 		parameters[4] = shippingAddress.getCountry();		
 		parameters[5] = shippingAddress.getId();
 		parameters[6] = shippingAddress.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateShippingAddressParameters(ShippingAddress shippingAddress){
		Object[] parameters = new Object[6];
		String newShippingAddressId=getNextId();
		shippingAddress.setId(newShippingAddressId);
		parameters[0] =  shippingAddress.getId();
 
 		parameters[1] = shippingAddress.getLine1();
 		parameters[2] = shippingAddress.getLine2();
 		parameters[3] = shippingAddress.getCity();
 		parameters[4] = shippingAddress.getState();
 		parameters[5] = shippingAddress.getCountry();		
 				
 		return parameters;
 	}
 	
	protected ShippingAddress saveInternalShippingAddress(ShippingAddress shippingAddress, Map<String,Object> options){
		
		saveShippingAddress(shippingAddress);

		
		if(isSaveShippingGroupListEnabled(options)){
	 		saveShippingGroupList(shippingAddress, options);
 		}		
		
		return shippingAddress;
		
	}
	
	
	
	//======================================================================================
	
		
	protected ShippingAddress saveShippingGroupList(ShippingAddress shippingAddress, Map<String,Object> options){
		List<ShippingGroup> shippingGroupList = shippingAddress.getShippingGroupList();
		if(shippingGroupList == null){
			return shippingAddress;
		}
		if(shippingGroupList.isEmpty()){
			return shippingAddress;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getShippingGroupDAO().saveList(shippingAddress.getShippingGroupList(),options);
		
		return shippingAddress;
	
	}
		

	
}


