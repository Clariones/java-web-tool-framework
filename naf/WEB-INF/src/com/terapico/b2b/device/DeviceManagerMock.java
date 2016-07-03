
package com.terapico.b2b.device;

import java.util.Date;
public class DeviceManagerMock implements DeviceManager {

	public Device createDevice(String passwrd, String[] options) throws Exception
	{
		return new Device();
	}
	public Device updateDevice(String deviceId, String property, Object newValue) throws Exception 
	{
		return new Device();
	}
	


	public void delete(String deviceId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  Device addRunRecord(String deviceId, String runDuration)
	{
		return new Device();
	}
	public  Device removeRunRecord(String deviceId, String runRecordId){
		return new Device();
	}
	public  Device updateRunRecord(String deviceId, String runRecordId, String property, Object newValue){
		return new Device();
	}




}


