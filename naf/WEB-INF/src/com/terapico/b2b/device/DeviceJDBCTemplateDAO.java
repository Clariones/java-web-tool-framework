
package com.terapico.b2b.device;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.terapico.b2b.CommonJDBCTemplateDAO;
import com.terapico.b2b.runrecord.RunRecord;

import com.terapico.b2b.runrecord.RunRecordDAO;


import org.springframework.dao.EmptyResultDataAccessException;

public class DeviceJDBCTemplateDAO extends CommonJDBCTemplateDAO implements DeviceDAO{

		
	
  	private  RunRecordDAO  runRecordDAO;
 	public void setRunRecordDAO(RunRecordDAO pRunRecordDAO){
 	
 		if(pRunRecordDAO == null){
 			throw new IllegalStateException("Do not try to set runRecordDAO to null.");
 		}
	 	this.runRecordDAO = pRunRecordDAO;
 	}
 	public RunRecordDAO getRunRecordDAO(){
 		if(this.runRecordDAO == null){
 			throw new IllegalStateException("The runRecordDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.runRecordDAO;
 	}	
 	
			
		

	public Device load(String deviceId,Map<String,Object> options) throws Exception{
		return loadInternalDevice(deviceId, options);
	}
	public Device save(Device device,Map<String,Object> options){
		
		String methodName="save(Device device,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(device, methodName, "device");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalDevice(device,options);
	}
	public Device clone(String deviceId,Map<String,Object> options) throws Exception{
	
		String methodName="clone(String deviceId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(deviceId, methodName, "deviceId");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Device newDevice = load(deviceId, options);
		newDevice.setVersion(0);
		
		
 		
 		if(isSaveRunRecordListEnabled(options)){
 			for(RunRecord item: newDevice.getRunRecordList()){
 				item.setVersion(0);
 			}
 		}
		
		
		saveInternalDevice(newDevice,options);
		
		return newDevice;
	}
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = getJdbcTemplateObject().update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String deviceId, int version) throws  DeviceVersionChangedException,  DeviceNotFoundException {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{deviceId};
		int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new DeviceVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new DeviceNotFoundException(
					"The " + this.getTableName() + "(" + deviceId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String deviceId, int version) throws Exception{
	
		String methodName="delete(String deviceId, int version)";
		assertMethodArgumentNotNull(deviceId, methodName, "deviceId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{deviceId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(deviceId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"passwrd"};
	}
	@Override
	protected String getName() {
		
		return "device";
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


		
	//protected static final String RUN_RECORD_LIST = "runRecordList";
	
	protected boolean isExtractRunRecordListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,DeviceTokens.RUN_RECORD_LIST);
		
 	}

	protected boolean isSaveRunRecordListEnabled(Map<String,Object> options){
		return checkOptions(options, DeviceTokens.RUN_RECORD_LIST);
		
 	}
 	
 	
			
		
	

	protected DeviceMapper getMapper(){
		return new DeviceMapper();
	}
	protected Device extractDevice(String deviceId) throws Exception{
		String SQL = "select * from device_data where id=?";	
		try{
		
			Device device = getJdbcTemplateObject().queryForObject(SQL, new Object[]{deviceId}, getMapper());
			return device;
		}catch(EmptyResultDataAccessException e){
			throw new DeviceNotFoundException("Device("+deviceId+") is not found!");
		}
		
		
	}

	protected Device loadInternalDevice(String deviceId, Map<String,Object> loadOptions) throws Exception{
		
		Device device = extractDevice(deviceId);

		
		if(isExtractRunRecordListEnabled(loadOptions)){
	 		extractRunRecordList(device, loadOptions);
 		}		
		
		return device;
		
	}
	
	
	
		
	protected Device extractRunRecordList(Device device, Map<String,Object> options){
		
		List<RunRecord> runRecordList = getRunRecordDAO().findRunRecordByDevice(device.getId());
		if(runRecordList != null){
			device.setRunRecordList(runRecordList);
		}
		
		return device;
	
	}	
		
		
 	
		
		
		
	

	protected Device saveDevice(Device  device){
	
		String SQL=this.getSaveDeviceSQL(device);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveDeviceParameters(device);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		int newVersion = device.getVersion() + 1;
		device.setVersion(newVersion);
		return device;
	
	}
	public List<Device> saveList(List<Device> deviceList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitDeviceList(deviceList);
		
		batchCreate((List<Device>)lists[CREATE_LIST_INDEX]);
		
		batchUpdate((List<Device>)lists[UPDATE_LIST_INDEX]);

		return deviceList;
	}

	
	protected List<Object[]> prepareBatchCreateArgs(List<Device> deviceList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Device device:deviceList ){
			Object [] parameters = prepareCreateDeviceParameters(device);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBatchUpdateArgs(List<Device> deviceList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Device device:deviceList ){
			Object [] parameters = prepareUpdateDeviceParameters(device);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCreate(List<Device> deviceList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBatchCreateArgs(deviceList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUpdate(List<Device> deviceList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBatchUpdateArgs(deviceList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitDeviceList(List<Device> deviceList){
		
		List<Device> deviceCreateList=new ArrayList<Device>();
		List<Device> deviceUpdateList=new ArrayList<Device>();
		
		for(Device device: deviceList){
			if(isUpdateRequest(device)){
				deviceUpdateList.add( device);
				continue;
			}
			deviceCreateList.add(device);
		}
		
		return new Object[]{deviceCreateList,deviceUpdateList};
	}
	
	protected boolean isUpdateRequest(Device device){
 		return device.getVersion() > 0;
 	}
 	protected String getSaveDeviceSQL(Device device){
 		if(isUpdateRequest(device)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveDeviceParameters(Device device){
 		if(isUpdateRequest(device) ){
 			return prepareUpdateDeviceParameters(device);
 		}
 		return prepareCreateDeviceParameters(device);
 	}
 	protected Object[] prepareUpdateDeviceParameters(Device device){
 		Object[] parameters = new Object[3];
 
 		parameters[0] = device.getPasswrd();		
 		parameters[1] = device.getId();
 		parameters[2] = device.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateDeviceParameters(Device device){
		Object[] parameters = new Object[2];
		String newDeviceId=getNextId();
		device.setId(newDeviceId);
		parameters[0] =  device.getId();
 
 		parameters[1] = device.getPasswrd();		
 				
 		return parameters;
 	}
 	
	protected Device saveInternalDevice(Device device, Map<String,Object> options){
		
		saveDevice(device);

		
		if(isSaveRunRecordListEnabled(options)){
	 		saveRunRecordList(device, options);
 		}		
		
		return device;
		
	}
	
	
	
	//======================================================================================
	
		
	protected Device saveRunRecordList(Device device, Map<String,Object> options){
		List<RunRecord> runRecordList = device.getRunRecordList();
		if(runRecordList == null){
			return device;
		}
		if(runRecordList.isEmpty()){
			return device;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getRunRecordDAO().saveList(device.getRunRecordList(),options);
		
		return device;
	
	}
		

	
}


