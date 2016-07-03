
package com.terapico.b2b.runrecord;

import java.util.Date;
public class RunRecordManagerMock implements RunRecordManager {

	public RunRecord createRunRecord(String deviceId, String runDuration, String[] options) throws Exception
	{
		return new RunRecord();
	}
	public RunRecord updateRunRecord(String runRecordId, String property, Object newValue) throws Exception 
	{
		return new RunRecord();
	}
	
	public RunRecord transferToNewDevice(String runRecordId, String newDeviceId) throws Exception
 	{
 		return new RunRecord();
 
 	}
 

	public void delete(String runRecordId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}



}


