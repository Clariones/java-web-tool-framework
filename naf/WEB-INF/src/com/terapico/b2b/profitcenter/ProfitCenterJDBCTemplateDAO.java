
package com.terapico.b2b.profitcenter;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.terapico.b2b.CommonJDBCTemplateDAO;
import com.terapico.b2b.order.Order;
import com.terapico.b2b.sellercompany.SellerCompany;

import com.terapico.b2b.sellercompany.SellerCompanyDAO;
import com.terapico.b2b.order.OrderDAO;


import org.springframework.dao.EmptyResultDataAccessException;

public class ProfitCenterJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ProfitCenterDAO{
 
 	
 	private  SellerCompanyDAO  sellerCompanyDAO;
 	public void setSellerCompanyDAO(SellerCompanyDAO sellerCompanyDAO){
	 	this.sellerCompanyDAO = sellerCompanyDAO;
 	}
 	public SellerCompanyDAO getSellerCompanyDAO(){
	 	return this.sellerCompanyDAO;
 	}

		
	
  	private  OrderDAO  orderDAO;
 	public void setOrderDAO(OrderDAO pOrderDAO){
 	
 		if(pOrderDAO == null){
 			throw new IllegalStateException("Do not try to set orderDAO to null.");
 		}
	 	this.orderDAO = pOrderDAO;
 	}
 	public OrderDAO getOrderDAO(){
 		if(this.orderDAO == null){
 			throw new IllegalStateException("The orderDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.orderDAO;
 	}	
 	
			
		

	public ProfitCenter load(String profitCenterId,Map<String,Object> options) throws Exception{
		return loadInternalProfitCenter(profitCenterId, options);
	}
	public ProfitCenter save(ProfitCenter profitCenter,Map<String,Object> options){
		
		String methodName="save(ProfitCenter profitCenter,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(profitCenter, methodName, "profitCenter");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalProfitCenter(profitCenter,options);
	}
	public ProfitCenter clone(String profitCenterId,Map<String,Object> options) throws Exception{
	
		String methodName="clone(String profitCenterId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(profitCenterId, methodName, "profitCenterId");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ProfitCenter newProfitCenter = load(profitCenterId, options);
		newProfitCenter.setVersion(0);
		
		
 		
 		if(isSaveOrderListEnabled(options)){
 			for(Order item: newProfitCenter.getOrderList()){
 				item.setVersion(0);
 			}
 		}
		
		
		saveInternalProfitCenter(newProfitCenter,options);
		
		return newProfitCenter;
	}
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = getJdbcTemplateObject().update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String profitCenterId, int version) throws  ProfitCenterVersionChangedException,  ProfitCenterNotFoundException {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{profitCenterId};
		int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new ProfitCenterVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ProfitCenterNotFoundException(
					"The " + this.getTableName() + "(" + profitCenterId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String profitCenterId, int version) throws Exception{
	
		String methodName="delete(String profitCenterId, int version)";
		assertMethodArgumentNotNull(profitCenterId, methodName, "profitCenterId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{profitCenterId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(profitCenterId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"name","belongs_to"};
	}
	@Override
	protected String getName() {
		
		return "profit_center";
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

 
 	//private boolean extractBelongsToEnabled = true;
 	//private static final String BELONGSTO = "belongsTo";
 	protected boolean isExtractBelongsToEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ProfitCenterTokens.BELONGSTO);
 	}
 	
 	
 	//private boolean saveBelongsToEnabled = true;
 	protected boolean isSaveBelongsToEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ProfitCenterTokens.BELONGSTO);
 	}
 	

 	
 
		
	//protected static final String ORDER_LIST = "orderList";
	
	protected boolean isExtractOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,ProfitCenterTokens.ORDER_LIST);
		
 	}

	protected boolean isSaveOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, ProfitCenterTokens.ORDER_LIST);
		
 	}
 	
 	
			
		
	

	protected ProfitCenterMapper getMapper(){
		return new ProfitCenterMapper();
	}
	protected ProfitCenter extractProfitCenter(String profitCenterId) throws Exception{
		String SQL = "select * from profit_center_data where id=?";	
		try{
		
			ProfitCenter profitCenter = getJdbcTemplateObject().queryForObject(SQL, new Object[]{profitCenterId}, getMapper());
			return profitCenter;
		}catch(EmptyResultDataAccessException e){
			throw new ProfitCenterNotFoundException("ProfitCenter("+profitCenterId+") is not found!");
		}
		
		
	}

	protected ProfitCenter loadInternalProfitCenter(String profitCenterId, Map<String,Object> loadOptions) throws Exception{
		
		ProfitCenter profitCenter = extractProfitCenter(profitCenterId);
 	
 		if(isExtractBelongsToEnabled(loadOptions)){
	 		extractBelongsTo(profitCenter, loadOptions);
 		}
 
		
		if(isExtractOrderListEnabled(loadOptions)){
	 		extractOrderList(profitCenter, loadOptions);
 		}		
		
		return profitCenter;
		
	}
	
	
	 

 	protected ProfitCenter extractBelongsTo(ProfitCenter profitCenter, Map<String,Object> options) throws Exception{

		if(profitCenter.getBelongsTo() == null){
			return profitCenter;
		}
		String belongsToId = profitCenter.getBelongsTo().getId();
		if( belongsToId == null){
			return profitCenter;
		}
		SellerCompany belongsTo = getSellerCompanyDAO().load(belongsToId,options);
		if(belongsTo != null){
			profitCenter.setBelongsTo(belongsTo);
		}
		
 		
 		return profitCenter;
 	}
 		
 
		
	protected ProfitCenter extractOrderList(ProfitCenter profitCenter, Map<String,Object> options){
		
		List<Order> orderList = getOrderDAO().findOrderByProfitCenter(profitCenter.getId());
		if(orderList != null){
			profitCenter.setOrderList(orderList);
		}
		
		return profitCenter;
	
	}	
		
		
  	
 	public List<ProfitCenter> findProfitCenterByBelongsTo(String sellerCompanyId){
 	
 		String SQL = "select * from "+this.getTableName()+" where belongs_to = ?";
		List<ProfitCenter> profitCenterList = getJdbcTemplateObject().query(SQL, new Object[]{sellerCompanyId}, getMapper());
		
 	
 		return profitCenterList;
 	}
 	
		
		
		
	

	protected ProfitCenter saveProfitCenter(ProfitCenter  profitCenter){
	
		String SQL=this.getSaveProfitCenterSQL(profitCenter);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveProfitCenterParameters(profitCenter);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		int newVersion = profitCenter.getVersion() + 1;
		profitCenter.setVersion(newVersion);
		return profitCenter;
	
	}
	public List<ProfitCenter> saveList(List<ProfitCenter> profitCenterList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitProfitCenterList(profitCenterList);
		
		batchCreate((List<ProfitCenter>)lists[CREATE_LIST_INDEX]);
		
		batchUpdate((List<ProfitCenter>)lists[UPDATE_LIST_INDEX]);

		return profitCenterList;
	}

	
	protected List<Object[]> prepareBatchCreateArgs(List<ProfitCenter> profitCenterList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ProfitCenter profitCenter:profitCenterList ){
			Object [] parameters = prepareCreateProfitCenterParameters(profitCenter);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBatchUpdateArgs(List<ProfitCenter> profitCenterList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ProfitCenter profitCenter:profitCenterList ){
			Object [] parameters = prepareUpdateProfitCenterParameters(profitCenter);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCreate(List<ProfitCenter> profitCenterList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBatchCreateArgs(profitCenterList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUpdate(List<ProfitCenter> profitCenterList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBatchUpdateArgs(profitCenterList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitProfitCenterList(List<ProfitCenter> profitCenterList){
		
		List<ProfitCenter> profitCenterCreateList=new ArrayList<ProfitCenter>();
		List<ProfitCenter> profitCenterUpdateList=new ArrayList<ProfitCenter>();
		
		for(ProfitCenter profitCenter: profitCenterList){
			if(isUpdateRequest(profitCenter)){
				profitCenterUpdateList.add( profitCenter);
				continue;
			}
			profitCenterCreateList.add(profitCenter);
		}
		
		return new Object[]{profitCenterCreateList,profitCenterUpdateList};
	}
	
	protected boolean isUpdateRequest(ProfitCenter profitCenter){
 		return profitCenter.getVersion() > 0;
 	}
 	protected String getSaveProfitCenterSQL(ProfitCenter profitCenter){
 		if(isUpdateRequest(profitCenter)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveProfitCenterParameters(ProfitCenter profitCenter){
 		if(isUpdateRequest(profitCenter) ){
 			return prepareUpdateProfitCenterParameters(profitCenter);
 		}
 		return prepareCreateProfitCenterParameters(profitCenter);
 	}
 	protected Object[] prepareUpdateProfitCenterParameters(ProfitCenter profitCenter){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = profitCenter.getName(); 	
 		if(profitCenter.getBelongsTo() != null){
 			parameters[1] = profitCenter.getBelongsTo().getId();
 		}
 		
 		parameters[2] = profitCenter.getId();
 		parameters[3] = profitCenter.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateProfitCenterParameters(ProfitCenter profitCenter){
		Object[] parameters = new Object[3];
		String newProfitCenterId=getNextId();
		profitCenter.setId(newProfitCenterId);
		parameters[0] =  profitCenter.getId();
 
 		parameters[1] = profitCenter.getName(); 	
 		if(profitCenter.getBelongsTo() != null){
 			parameters[2] = profitCenter.getBelongsTo().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected ProfitCenter saveInternalProfitCenter(ProfitCenter profitCenter, Map<String,Object> options){
		
		saveProfitCenter(profitCenter);
 	
 		if(isSaveBelongsToEnabled(options)){
	 		saveBelongsTo(profitCenter, options);
 		}
 
		
		if(isSaveOrderListEnabled(options)){
	 		saveOrderList(profitCenter, options);
 		}		
		
		return profitCenter;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ProfitCenter saveBelongsTo(ProfitCenter profitCenter, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		getSellerCompanyDAO().save(profitCenter.getBelongsTo(),options);
 		return profitCenter;
 		
 	}
	
 
		
	protected ProfitCenter saveOrderList(ProfitCenter profitCenter, Map<String,Object> options){
		List<Order> orderList = profitCenter.getOrderList();
		if(orderList == null){
			return profitCenter;
		}
		if(orderList.isEmpty()){
			return profitCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getOrderDAO().saveList(profitCenter.getOrderList(),options);
		
		return profitCenter;
	
	}
		

	
}


