
package com.terapico.b2b.runrecord;

import java.util.Date;
public interface RunRecordManager{

	public RunRecord createRunRecord(String deviceId, String runDuration, String[] options) throws Exception;	
	public RunRecord updateRunRecord(String runRecordId, String property, Object newValue)  throws Exception;
	
	public RunRecord transferToNewDevice(String runRecordId, String newDeviceId)  throws Exception;
 

	public void delete(String runRecordId, int version) throws Exception;
	public int deleteAll() throws Exception;



}


