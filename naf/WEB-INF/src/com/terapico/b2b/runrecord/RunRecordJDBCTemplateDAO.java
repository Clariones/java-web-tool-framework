
package com.terapico.b2b.runrecord;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.terapico.b2b.CommonJDBCTemplateDAO;
import com.terapico.b2b.device.Device;

import com.terapico.b2b.device.DeviceDAO;


import org.springframework.dao.EmptyResultDataAccessException;

public class RunRecordJDBCTemplateDAO extends CommonJDBCTemplateDAO implements RunRecordDAO{
 
 	
 	private  DeviceDAO  deviceDAO;
 	public void setDeviceDAO(DeviceDAO deviceDAO){
	 	this.deviceDAO = deviceDAO;
 	}
 	public DeviceDAO getDeviceDAO(){
	 	return this.deviceDAO;
 	}

		

	public RunRecord load(String runRecordId,Map<String,Object> options) throws Exception{
		return loadInternalRunRecord(runRecordId, options);
	}
	public RunRecord save(RunRecord runRecord,Map<String,Object> options){
		
		String methodName="save(RunRecord runRecord,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(runRecord, methodName, "runRecord");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRunRecord(runRecord,options);
	}
	public RunRecord clone(String runRecordId,Map<String,Object> options) throws Exception{
	
		String methodName="clone(String runRecordId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(runRecordId, methodName, "runRecordId");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RunRecord newRunRecord = load(runRecordId, options);
		newRunRecord.setVersion(0);
		
		
		
		saveInternalRunRecord(newRunRecord,options);
		
		return newRunRecord;
	}
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = getJdbcTemplateObject().update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String runRecordId, int version) throws  RunRecordVersionChangedException,  RunRecordNotFoundException {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{runRecordId};
		int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new RunRecordVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RunRecordNotFoundException(
					"The " + this.getTableName() + "(" + runRecordId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String runRecordId, int version) throws Exception{
	
		String methodName="delete(String runRecordId, int version)";
		assertMethodArgumentNotNull(runRecordId, methodName, "runRecordId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{runRecordId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(runRecordId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"device","run_duration"};
	}
	@Override
	protected String getName() {
		
		return "run_record";
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

 
 	//private boolean extractDeviceEnabled = true;
 	//private static final String DEVICE = "device";
 	protected boolean isExtractDeviceEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RunRecordTokens.DEVICE);
 	}
 	
 	
 	//private boolean saveDeviceEnabled = true;
 	protected boolean isSaveDeviceEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RunRecordTokens.DEVICE);
 	}
 	

 	
 
		
	

	protected RunRecordMapper getMapper(){
		return new RunRecordMapper();
	}
	protected RunRecord extractRunRecord(String runRecordId) throws Exception{
		String SQL = "select * from run_record_data where id=?";	
		try{
		
			RunRecord runRecord = getJdbcTemplateObject().queryForObject(SQL, new Object[]{runRecordId}, getMapper());
			return runRecord;
		}catch(EmptyResultDataAccessException e){
			throw new RunRecordNotFoundException("RunRecord("+runRecordId+") is not found!");
		}
		
		
	}

	protected RunRecord loadInternalRunRecord(String runRecordId, Map<String,Object> loadOptions) throws Exception{
		
		RunRecord runRecord = extractRunRecord(runRecordId);
 	
 		if(isExtractDeviceEnabled(loadOptions)){
	 		extractDevice(runRecord, loadOptions);
 		}
 
		
		return runRecord;
		
	}
	
	
	 

 	protected RunRecord extractDevice(RunRecord runRecord, Map<String,Object> options) throws Exception{

		if(runRecord.getDevice() == null){
			return runRecord;
		}
		String deviceId = runRecord.getDevice().getId();
		if( deviceId == null){
			return runRecord;
		}
		Device device = getDeviceDAO().load(deviceId,options);
		if(device != null){
			runRecord.setDevice(device);
		}
		
 		
 		return runRecord;
 	}
 		
 
		
		
  	
 	public List<RunRecord> findRunRecordByDevice(String deviceId){
 	
 		String SQL = "select * from "+this.getTableName()+" where device = ?";
		List<RunRecord> runRecordList = getJdbcTemplateObject().query(SQL, new Object[]{deviceId}, getMapper());
		
 	
 		return runRecordList;
 	}
 	
		
		
		
	

	protected RunRecord saveRunRecord(RunRecord  runRecord){
	
		String SQL=this.getSaveRunRecordSQL(runRecord);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRunRecordParameters(runRecord);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		int newVersion = runRecord.getVersion() + 1;
		runRecord.setVersion(newVersion);
		return runRecord;
	
	}
	public List<RunRecord> saveList(List<RunRecord> runRecordList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRunRecordList(runRecordList);
		
		batchCreate((List<RunRecord>)lists[CREATE_LIST_INDEX]);
		
		batchUpdate((List<RunRecord>)lists[UPDATE_LIST_INDEX]);

		return runRecordList;
	}

	
	protected List<Object[]> prepareBatchCreateArgs(List<RunRecord> runRecordList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RunRecord runRecord:runRecordList ){
			Object [] parameters = prepareCreateRunRecordParameters(runRecord);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBatchUpdateArgs(List<RunRecord> runRecordList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RunRecord runRecord:runRecordList ){
			Object [] parameters = prepareUpdateRunRecordParameters(runRecord);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCreate(List<RunRecord> runRecordList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBatchCreateArgs(runRecordList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUpdate(List<RunRecord> runRecordList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBatchUpdateArgs(runRecordList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRunRecordList(List<RunRecord> runRecordList){
		
		List<RunRecord> runRecordCreateList=new ArrayList<RunRecord>();
		List<RunRecord> runRecordUpdateList=new ArrayList<RunRecord>();
		
		for(RunRecord runRecord: runRecordList){
			if(isUpdateRequest(runRecord)){
				runRecordUpdateList.add( runRecord);
				continue;
			}
			runRecordCreateList.add(runRecord);
		}
		
		return new Object[]{runRecordCreateList,runRecordUpdateList};
	}
	
	protected boolean isUpdateRequest(RunRecord runRecord){
 		return runRecord.getVersion() > 0;
 	}
 	protected String getSaveRunRecordSQL(RunRecord runRecord){
 		if(isUpdateRequest(runRecord)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRunRecordParameters(RunRecord runRecord){
 		if(isUpdateRequest(runRecord) ){
 			return prepareUpdateRunRecordParameters(runRecord);
 		}
 		return prepareCreateRunRecordParameters(runRecord);
 	}
 	protected Object[] prepareUpdateRunRecordParameters(RunRecord runRecord){
 		Object[] parameters = new Object[4];
  	
 		if(runRecord.getDevice() != null){
 			parameters[0] = runRecord.getDevice().getId();
 		}
 
 		parameters[1] = runRecord.getRunDuration();		
 		parameters[2] = runRecord.getId();
 		parameters[3] = runRecord.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateRunRecordParameters(RunRecord runRecord){
		Object[] parameters = new Object[3];
		String newRunRecordId=getNextId();
		runRecord.setId(newRunRecordId);
		parameters[0] =  runRecord.getId();
  	
 		if(runRecord.getDevice() != null){
 			parameters[1] = runRecord.getDevice().getId();
 		
 		}
 		
 		parameters[2] = runRecord.getRunDuration();		
 				
 		return parameters;
 	}
 	
	protected RunRecord saveInternalRunRecord(RunRecord runRecord, Map<String,Object> options){
		
		saveRunRecord(runRecord);
 	
 		if(isSaveDeviceEnabled(options)){
	 		saveDevice(runRecord, options);
 		}
 
		
		return runRecord;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected RunRecord saveDevice(RunRecord runRecord, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		getDeviceDAO().save(runRecord.getDevice(),options);
 		return runRecord;
 		
 	}
	
 
		

	
}


