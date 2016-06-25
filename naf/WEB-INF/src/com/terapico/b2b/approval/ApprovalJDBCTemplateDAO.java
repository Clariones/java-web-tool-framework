
package com.terapico.b2b.approval;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import com.terapico.b2b.CommonJDBCTemplateDAO;
import com.terapico.b2b.order.Order;

import com.terapico.b2b.order.OrderDAO;

public class ApprovalJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ApprovalDAO{

		
	
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
 	
			
		

	public Approval load(String approvalId,Map<String,Object> options) throws Exception{
		return loadInternalApproval(approvalId, options);
	}
	public Approval save(Approval approval,Map<String,Object> options){
		
		String methodName="save(Approval approval,Map<String,Object> options){";
		
		assertMethodArgumentNotNull(approval, methodName, "approval");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalApproval(approval,options);
	}
	public Approval clone(String approvalId,Map<String,Object> options) throws Exception{
	
		String methodName="clone(String approvalId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(approvalId, methodName, "approvalId");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Approval newApproval = load(approvalId, options);
		newApproval.setVersion(0);
		
		
 		
 		if(isSaveOrderListEnabled(options)){
 			for(Order item: newApproval.getOrderList()){
 				item.setVersion(0);
 			}
 		}
		
		
		saveInternalApproval(newApproval,options);
		
		return newApproval;
	}
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = getJdbcTemplateObject().update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String approvalId, int version) throws  ApprovalVersionChangedException,  ApprovalNotFoundException {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{approvalId};
		int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new ApprovalVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ApprovalNotFoundException(
					"The " + this.getTableName() + "(" + approvalId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String approvalId, int version) throws Exception{
	
		String methodName="delete(String approvalId, int version)";
		assertMethodArgumentNotNull(approvalId, methodName, "approvalId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{approvalId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(approvalId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"who","approve_time"};
	}
	@Override
	protected String getName() {
		
		return "approval";
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


		
	protected static final String ORDER_LIST = "orderList";
	
	protected boolean isExtractOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,ORDER_LIST);
		
 	}

	protected boolean isSaveOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, ORDER_LIST);
		
 	}
 	
 	
			
		
	

	protected ApprovalMapper getMapper(){
		return new ApprovalMapper();
	}
	protected Approval extractApproval(String approvalId){
		String SQL = "select * from approval_data where id=?";	
		Approval approval = getJdbcTemplateObject().queryForObject(SQL, new Object[]{approvalId}, getMapper());
		return approval;
	}

	protected Approval loadInternalApproval(String approvalId, Map<String,Object> loadOptions) throws Exception{
		
		Approval approval = extractApproval(approvalId);

		
		if(isExtractOrderListEnabled(loadOptions)){
	 		extractOrderList(approval, loadOptions);
 		}		
		
		return approval;
		
	}
	
	
	
		
	protected Approval extractOrderList(Approval approval, Map<String,Object> options){
		
		List<Order> orderList = getOrderDAO().findOrderByApproval(approval.getId());
		if(orderList != null){
			approval.setOrderList(orderList);
		}
		
		return approval;
	
	}	
		
		
 	
		
		
		
	

	protected Approval saveApproval(Approval  approval){
	
		String SQL=this.getSaveApprovalSQL(approval);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveApprovalParameters(approval);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		int newVersion = approval.getVersion() + 1;
		approval.setVersion(newVersion);
		return approval;
	
	}
	public List<Approval> saveList(List<Approval> approvalList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitApprovalList(approvalList);
		
		batchCreate((List<Approval>)lists[CREATE_LIST_INDEX]);
		
		batchUpdate((List<Approval>)lists[UPDATE_LIST_INDEX]);

		return approvalList;
	}

	
	protected List<Object[]> prepareBatchCreateArgs(List<Approval> approvalList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Approval approval:approvalList ){
			Object [] parameters = prepareCreateApprovalParameters(approval);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBatchUpdateArgs(List<Approval> approvalList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Approval approval:approvalList ){
			Object [] parameters = prepareUpdateApprovalParameters(approval);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCreate(List<Approval> approvalList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBatchCreateArgs(approvalList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUpdate(List<Approval> approvalList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBatchUpdateArgs(approvalList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitApprovalList(List<Approval> approvalList){
		
		List<Approval> approvalCreateList=new ArrayList<Approval>();
		List<Approval> approvalUpdateList=new ArrayList<Approval>();
		
		for(Approval approval: approvalList){
			if(isUpdateRequest(approval)){
				approvalUpdateList.add( approval);
				continue;
			}
			approvalCreateList.add(approval);
		}
		
		return new Object[]{approvalCreateList,approvalUpdateList};
	}
	
	protected boolean isUpdateRequest(Approval approval){
 		return approval.getVersion() > 0;
 	}
 	protected String getSaveApprovalSQL(Approval approval){
 		if(isUpdateRequest(approval)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveApprovalParameters(Approval approval){
 		if(isUpdateRequest(approval) ){
 			return prepareUpdateApprovalParameters(approval);
 		}
 		return prepareCreateApprovalParameters(approval);
 	}
 	protected Object[] prepareUpdateApprovalParameters(Approval approval){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = approval.getWho();
 		parameters[1] = approval.getApproveTime();		
 		parameters[2] = approval.getId();
 		parameters[3] = approval.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateApprovalParameters(Approval approval){
		Object[] parameters = new Object[3];
		String newApprovalId=getNextId();
		approval.setId(newApprovalId);
		parameters[0] =  approval.getId();
 
 		parameters[1] = approval.getWho();
 		parameters[2] = approval.getApproveTime();		
 				
 		return parameters;
 	}
 	
	protected Approval saveInternalApproval(Approval approval, Map<String,Object> options){
		
		saveApproval(approval);

		
		if(isSaveOrderListEnabled(options)){
	 		saveOrderList(approval, options);
 		}		
		
		return approval;
		
	}
	
	
	
	//======================================================================================
	
		
	protected Approval saveOrderList(Approval approval, Map<String,Object> options){
		List<Order> orderList = approval.getOrderList();
		if(orderList == null){
			return approval;
		}
		if(orderList.isEmpty()){
			return approval;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getOrderDAO().saveList(approval.getOrderList(),options);
		
		return approval;
	
	}
		

	
}


