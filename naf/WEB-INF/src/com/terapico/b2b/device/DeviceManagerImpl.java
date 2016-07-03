
package com.terapico.b2b.device;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import com.terapico.b2b.runrecord.RunRecord;


import com.terapico.b2b.device.Device;



public class DeviceManagerImpl implements DeviceManager {

	private  DeviceDAO  deviceDAO;
 	public void setDeviceDAO(DeviceDAO  deviceDAO){
 	
 		if(deviceDAO == null){
 			throw new IllegalStateException("Do not try to set deviceDAO to null.");
 		}
	 	this.deviceDAO = deviceDAO;
 	}
 	public DeviceDAO getDeviceDAO(){
 		if(this.deviceDAO == null){
 			throw new IllegalStateException("The DeviceDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.deviceDAO;
 	}
 	
 	public Device saveDevice(Device device, Map<String,Object>options) throws Exception{	
 		return getDeviceDAO().save(device, options);
 	}
 	public Device loadDevice(String deviceId, Map<String,Object>options) throws Exception{	
 		return getDeviceDAO().load(deviceId, options);
 	}
 	
 	
 	
	public Device createDevice(String passwrd, String[] optionsExpr) throws Exception
	{
		
		
		Device device=createNewDevice(optionsExpr);	

		device.setPasswrd(passwrd);

		return saveDevice(device, emptyOptions());
		

		
	}
	protected Device createNewDevice(String[] optionsExpr) throws Exception
	{
		
		return new Device();
		
	}
	public Device updateDevice(String deviceId, String property, Object newValue) throws Exception 
	{
		return new Device();
	}
	protected Map<String,Object> emptyOptions(){
		return new HashMap<String,Object>();
	}
	
	protected DeviceTokens tokens(){
		return DeviceTokens.start();
	}
	protected Map<String,Object> allTokens(){
		return DeviceTokens.all();
	}
	


	public void delete(String deviceId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  Device addRunRecord(String deviceId, String runDuration) throws Exception
	{		
		RunRecord runRecord = createRunRecord(runDuration);
		
		Device device = loadDevice(deviceId, allTokens());
		synchronized(device){ 
			//will be good when the device loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			device.addRunRecord( runRecord );		
			return saveDevice(device, tokens().withRunRecordList().done());
		}
	}
	protected RunRecord createRunRecord(String runDuration){

		RunRecord runRecord = new RunRecord();
		
		
		runRecord.setRunDuration(runDuration);
	
		
		return runRecord;			
		
	}
	public  Device removeRunRecord(String deviceId, String runRecordId){
		return new Device();
	}
	public  Device updateRunRecord(String deviceId, String runRecordId, String property, Object newValue){
		return new Device();
	}



}


