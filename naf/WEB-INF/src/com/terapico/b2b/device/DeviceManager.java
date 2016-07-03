
package com.terapico.b2b.device;

import java.util.Date;
public interface DeviceManager{

	public Device createDevice(String passwrd, String[] options) throws Exception;	
	public Device updateDevice(String deviceId, String property, Object newValue)  throws Exception;
	


	public void delete(String deviceId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public  Device addRunRecord(String deviceId, String runDuration)  throws Exception;
	public  Device removeRunRecord(String deviceId, String runRecordId)  throws Exception;
	public  Device updateRunRecord(String deviceId, String runRecordId, String property, Object newValue)  throws Exception;




}


