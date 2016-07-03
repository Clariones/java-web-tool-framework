
package com.terapico.b2b.runrecord;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import com.terapico.b2b.device.Device;

import com.terapico.b2b.device.DeviceDAO;




public class RunRecordManagerImpl implements RunRecordManager {

	private  RunRecordDAO  runRecordDAO;
 	public void setRunRecordDAO(RunRecordDAO  runRecordDAO){
 	
 		if(runRecordDAO == null){
 			throw new IllegalStateException("Do not try to set runRecordDAO to null.");
 		}
	 	this.runRecordDAO = runRecordDAO;
 	}
 	public RunRecordDAO getRunRecordDAO(){
 		if(this.runRecordDAO == null){
 			throw new IllegalStateException("The RunRecordDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.runRecordDAO;
 	}
 	
 	public RunRecord saveRunRecord(RunRecord runRecord, Map<String,Object>options) throws Exception{	
 		return getRunRecordDAO().save(runRecord, options);
 	}
 	public RunRecord loadRunRecord(String runRecordId, Map<String,Object>options) throws Exception{	
 		return getRunRecordDAO().load(runRecordId, options);
 	}
 	 
 	
 	private  DeviceDAO  deviceDAO;
 	public void setDeviceDAO(DeviceDAO deviceDAO){
	 	this.deviceDAO = deviceDAO;
 	}
 	public DeviceDAO getDeviceDAO(){
	 	return this.deviceDAO;
 	}

 	
 	
	public RunRecord createRunRecord(String deviceId, String runDuration, String[] optionsExpr) throws Exception
	{
		
		
		RunRecord runRecord=createNewRunRecord(optionsExpr);	

		Device device = loadDevice(deviceId,emptyOptions());
		runRecord.setDevice(device);
		runRecord.setRunDuration(runDuration);

		return saveRunRecord(runRecord, emptyOptions());
		

		
	}
	protected RunRecord createNewRunRecord(String[] optionsExpr) throws Exception
	{
		
		return new RunRecord();
		
	}
	public RunRecord updateRunRecord(String runRecordId, String property, Object newValue) throws Exception 
	{
		return new RunRecord();
	}
	protected Map<String,Object> emptyOptions(){
		return new HashMap<String,Object>();
	}
	
	protected RunRecordTokens tokens(){
		return RunRecordTokens.start();
	}
	protected Map<String,Object> allTokens(){
		return RunRecordTokens.all();
	}
	
	public RunRecord transferToNewDevice(String runRecordId, String newDeviceId) throws Exception
 	{
 
		RunRecord runRecord = loadRunRecord(runRecordId, allTokens());	
		synchronized(runRecord){
			//will be good when the runRecord loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			Device device = loadDevice(newDeviceId, emptyOptions());		
			runRecord.setDevice(device);		
			return saveRunRecord(runRecord, emptyOptions());
		}
 	}
 	
 	protected Device loadDevice(String newDeviceId, Map<String,Object> options) throws Exception
 	{
 		return getDeviceDAO().load(newDeviceId, options);
 	}
 	
 

	public void delete(String runRecordId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}


}


