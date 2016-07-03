
package com.terapico.b2b.runrecord;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.device.Device;

public class RunRecordMapper implements RowMapper<RunRecord>{
	
	public RunRecord mapRow(ResultSet rs, int rowNumber) throws SQLException{
		RunRecord runRecord = getRunRecord();		
		 		
 		setId(runRecord, rs, rowNumber); 		
 		setDevice(runRecord, rs, rowNumber); 		
 		setRunDuration(runRecord, rs, rowNumber); 		
 		setVersion(runRecord, rs, rowNumber);

		return runRecord;
	}
	
	protected RunRecord getRunRecord(){
		return new RunRecord();
	}		
		
	protected void setId(RunRecord runRecord, ResultSet rs, int rowNumber) throws SQLException{
		runRecord.setId(rs.getString("id"));
	}
		 		
 	protected void setDevice(RunRecord runRecord, ResultSet rs, int rowNumber) throws SQLException{
 		String deviceId = rs.getString("device");
 		if( deviceId == null){
 			return;
 		}
 		if( deviceId.isEmpty()){
 			return;
 		}
 		Device device = runRecord.getDevice();
 		if( device != null ){
 			//if the root object 'runRecord' already have the property, just set the id for it;
 			device.setId(deviceId);
 			return;
 		}
 		runRecord.setDevice(createEmptyDevice(deviceId));
 	}
 	
	protected void setRunDuration(RunRecord runRecord, ResultSet rs, int rowNumber) throws SQLException{
		runRecord.setRunDuration(rs.getString("run_duration"));
	}
		
	protected void setVersion(RunRecord runRecord, ResultSet rs, int rowNumber) throws SQLException{
		runRecord.setVersion(rs.getInt("version"));
	}
		
		

 	protected Device  createEmptyDevice(String deviceId){
 		Device device = new Device();
 		device.setId(deviceId);
 		return device;
 	}
 	
}


