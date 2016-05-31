
package com.terapico.b2b.shippinggroup;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import com.terapico.b2b.CommonJDBCTemplateDAO;
import com.terapico.b2b.order.Order;
import com.terapico.b2b.shippingaddress.ShippingAddress;

import com.terapico.b2b.shippingaddress.ShippingAddressDAO;
import com.terapico.b2b.order.OrderDAO;

public class ShippingGroupJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ShippingGroupDAO{
 
 	
 	private  OrderDAO  orderDAO;
 	public void setOrderDAO(OrderDAO orderDAO){
	 	this.orderDAO = orderDAO;
 	}
 	public OrderDAO getOrderDAO(){
	 	return this.orderDAO;
 	}
 
 	
 	private  ShippingAddressDAO  shippingAddressDAO;
 	public void setShippingAddressDAO(ShippingAddressDAO shippingAddressDAO){
	 	this.shippingAddressDAO = shippingAddressDAO;
 	}
 	public ShippingAddressDAO getShippingAddressDAO(){
	 	return this.shippingAddressDAO;
 	}

		

	public ShippingGroup load(String shippingGroupId,Set<String> options) throws Exception{
		return loadInternalShippingGroup(shippingGroupId, options);
	}
	public ShippingGroup save(ShippingGroup shippingGroup,Set<String> options){
		return saveInternalShippingGroup(shippingGroup,options);
	}
	public ShippingGroup clone(String shippingGroupId,Set<String> options) throws Exception{
		ShippingGroup newShippingGroup = load(shippingGroupId, options);
		newShippingGroup.setVersion(0);
		
		
		
		saveInternalShippingGroup(newShippingGroup,options);
		
		return newShippingGroup;
	}
	public void delete(String shippingGroupId, int version) throws Exception{
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{shippingGroupId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			// two suitations here, this object has been deleted; or
			// the version has been changed, the client should reload it and ensure this can be deleted
			SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
			parameters=new Object[]{shippingGroupId};
			int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
			if(count == 1){
				throw new ShippingGroupVersionChangedException("The object version has been changed, please reload to delete");
			}
			if(count < 1){
				throw new ShippingGroupNotFoundException("The object alread has been deleted.");
			}
			if(count > 1){
				throw new IllegalStateException("The database PRIMARY KEY constraint has been damaged, please fix it.");
			}
		
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"name","biz_order","address","amount"};
	}
	@Override
	protected String getName() {
		
		return "shipping_group";
	}
	
	
	static final String ALL="__all__"; //do not assign this to common users,
	protected boolean checkOptions(Set<String> options, String optionToCheck){
	
		if(options==null){
 			return false;
 		}
 		if(options.contains(optionToCheck)){
 			return true;
 		}
 		if(options.contains(ALL)){
 			return true;
 		}
 		return false;
	
	}

 
 	//private boolean extractBizOrderEnabled = true;
 	private static final String BIZORDER = "bizOrder";
 	protected boolean isExtractBizOrderEnabled(Set<String> options){
 		
	 	return checkOptions(options, BIZORDER);
 	}
 	
 	
 	//private boolean saveBizOrderEnabled = true;
 	protected boolean isSaveBizOrderEnabled(Set<String> options){
	 	
 		return checkOptions(options, BIZORDER);
 	}
 	

 	
  
 	//private boolean extractAddressEnabled = true;
 	private static final String ADDRESS = "address";
 	protected boolean isExtractAddressEnabled(Set<String> options){
 		
	 	return checkOptions(options, ADDRESS);
 	}
 	
 	
 	//private boolean saveAddressEnabled = true;
 	protected boolean isSaveAddressEnabled(Set<String> options){
	 	
 		return checkOptions(options, ADDRESS);
 	}
 	

 	
 
		
	

	protected ShippingGroupMapper getMapper(){
		return new ShippingGroupMapper();
	}
	protected ShippingGroup extractShippingGroup(String shippingGroupId){
		String SQL = "select * from shipping_group_data where id=?";	
		ShippingGroup shippingGroup = getJdbcTemplateObject().queryForObject(SQL, new Object[]{shippingGroupId}, getMapper());
		return shippingGroup;
	}

	protected ShippingGroup loadInternalShippingGroup(String shippingGroupId, Set<String> loadOptions) throws Exception{
		
		ShippingGroup shippingGroup = extractShippingGroup(shippingGroupId);
 	
 		if(isExtractBizOrderEnabled(loadOptions)){
	 		extractBizOrder(shippingGroup);
 		}
  	
 		if(isExtractAddressEnabled(loadOptions)){
	 		extractAddress(shippingGroup);
 		}
 
		
		return shippingGroup;
		
	}
	
	
	 

 	protected ShippingGroup extractBizOrder(ShippingGroup shippingGroup) throws Exception{

		Set<String> options = new HashSet<String>();
		Order bizOrder = getOrderDAO().load(shippingGroup.getBizOrder().getId(),options);
		if(bizOrder != null){
			shippingGroup.setBizOrder(bizOrder);
		}
		
 		
 		return shippingGroup;
 	}
 		
  

 	protected ShippingGroup extractAddress(ShippingGroup shippingGroup) throws Exception{

		Set<String> options = new HashSet<String>();
		ShippingAddress address = getShippingAddressDAO().load(shippingGroup.getAddress().getId(),options);
		if(address != null){
			shippingGroup.setAddress(address);
		}
		
 		
 		return shippingGroup;
 	}
 		
 
		
		
  	
 	public List<ShippingGroup> findShippingGroupByBizOrder(String orderId){
 	
 		String SQL = "select * from "+this.getTableName()+" where biz_order = ?";
		List<ShippingGroup> shippingGroupList = getJdbcTemplateObject().query(SQL, new Object[]{orderId}, getMapper());
		
 	
 		return shippingGroupList;
 	}
  	
 	public List<ShippingGroup> findShippingGroupByAddress(String shippingAddressId){
 	
 		String SQL = "select * from "+this.getTableName()+" where address = ?";
		List<ShippingGroup> shippingGroupList = getJdbcTemplateObject().query(SQL, new Object[]{shippingAddressId}, getMapper());
		
 	
 		return shippingGroupList;
 	}
 	
		
		
		
	

	protected ShippingGroup saveShippingGroup(ShippingGroup  shippingGroup){
	
		String SQL=this.getSaveShippingGroupSQL(shippingGroup);
		Object [] parameters = getSaveShippingGroupParameters(shippingGroup);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		return shippingGroup;
	
	}
	public List<ShippingGroup> saveList(List<ShippingGroup> shippingGroupList,Set<String> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitShippingGroupList(shippingGroupList);
		
		batchCreate((List<ShippingGroup>)lists[CREATE_LIST_INDEX]);
		
		batchUpdate((List<ShippingGroup>)lists[UPDATE_LIST_INDEX]);

		return shippingGroupList;
	}

	
	protected List<Object[]> prepareBatchCreateArgs(List<ShippingGroup> shippingGroupList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ShippingGroup shippingGroup:shippingGroupList ){
			Object [] parameters = prepareCreateShippingGroupParameters(shippingGroup);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBatchUpdateArgs(List<ShippingGroup> shippingGroupList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ShippingGroup shippingGroup:shippingGroupList ){
			Object [] parameters = prepareUpdateShippingGroupParameters(shippingGroup);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCreate(List<ShippingGroup> shippingGroupList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBatchCreateArgs(shippingGroupList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUpdate(List<ShippingGroup> shippingGroupList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBatchUpdateArgs(shippingGroupList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitShippingGroupList(List<ShippingGroup> shippingGroupList){
		
		List<ShippingGroup> shippingGroupCreateList=new ArrayList<ShippingGroup>();
		List<ShippingGroup> shippingGroupUpdateList=new ArrayList<ShippingGroup>();
		
		for(ShippingGroup shippingGroup: shippingGroupList){
			if(isUpdateRequest(shippingGroup)){
				shippingGroupUpdateList.add( shippingGroup);
				continue;
			}
			shippingGroupCreateList.add(shippingGroup);
		}
		
		return new Object[]{shippingGroupCreateList,shippingGroupUpdateList};
	}
	
	protected boolean isUpdateRequest(ShippingGroup shippingGroup){
 		return shippingGroup.getVersion() > 0;
 	}
 	protected String getSaveShippingGroupSQL(ShippingGroup shippingGroup){
 		if(isUpdateRequest(shippingGroup)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveShippingGroupParameters(ShippingGroup shippingGroup){
 		if(isUpdateRequest(shippingGroup) ){
 			return prepareUpdateShippingGroupParameters(shippingGroup);
 		}
 		return prepareCreateShippingGroupParameters(shippingGroup);
 	}
 	protected Object[] prepareUpdateShippingGroupParameters(ShippingGroup shippingGroup){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = shippingGroup.getName(); 	
 		if(shippingGroup.getBizOrder() != null){
 			parameters[1] = shippingGroup.getBizOrder().getId();
 		}
  	
 		if(shippingGroup.getAddress() != null){
 			parameters[2] = shippingGroup.getAddress().getId();
 		}
 
 		parameters[3] = shippingGroup.getAmount();		
 		parameters[4] = shippingGroup.getId();
 		parameters[5] = shippingGroup.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateShippingGroupParameters(ShippingGroup shippingGroup){
		Object[] parameters = new Object[5];
		String newShippingGroupId=getNextId();
		shippingGroup.setId(newShippingGroupId);
		parameters[0] =  shippingGroup.getId();
 
 		parameters[1] = shippingGroup.getName(); 	
 		if(shippingGroup.getBizOrder() != null){
 			parameters[2] = shippingGroup.getBizOrder().getId();
 		
 		}
 		 	
 		if(shippingGroup.getAddress() != null){
 			parameters[3] = shippingGroup.getAddress().getId();
 		
 		}
 		
 		parameters[4] = shippingGroup.getAmount();		
 				
 		return parameters;
 	}
 	
	protected ShippingGroup saveInternalShippingGroup(ShippingGroup shippingGroup, Set<String> options){
		
		saveShippingGroup(shippingGroup);
 	
 		if(isSaveBizOrderEnabled(options)){
	 		saveBizOrder(shippingGroup);
 		}
  	
 		if(isSaveAddressEnabled(options)){
	 		saveAddress(shippingGroup);
 		}
 
		
		return shippingGroup;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ShippingGroup saveBizOrder(ShippingGroup shippingGroup){
 		//Call inject DAO to execute this method
 		Set<String> options = new HashSet<String>();
 		
 		getOrderDAO().save(shippingGroup.getBizOrder(),options);
 		return shippingGroup;
 		
 	}
	
  
 
 	protected ShippingGroup saveAddress(ShippingGroup shippingGroup){
 		//Call inject DAO to execute this method
 		Set<String> options = new HashSet<String>();
 		
 		getShippingAddressDAO().save(shippingGroup.getAddress(),options);
 		return shippingGroup;
 		
 	}
	
 
		

}


