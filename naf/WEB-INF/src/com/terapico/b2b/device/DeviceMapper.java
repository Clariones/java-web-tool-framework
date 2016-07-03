
package com.terapico.b2b.device;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class DeviceMapper implements RowMapper<Device>{
	
	public Device mapRow(ResultSet rs, int rowNumber) throws SQLException{
		Device device = getDevice();		
		 		
 		setId(device, rs, rowNumber); 		
 		setPasswrd(device, rs, rowNumber); 		
 		setVersion(device, rs, rowNumber);

		return device;
	}
	
	protected Device getDevice(){
		return new Device();
	}		
		
	protected void setId(Device device, ResultSet rs, int rowNumber) throws SQLException{
		device.setId(rs.getString("id"));
	}
		
	protected void setPasswrd(Device device, ResultSet rs, int rowNumber) throws SQLException{
		device.setPasswrd(rs.getString("passwrd"));
	}
		
	protected void setVersion(Device device, ResultSet rs, int rowNumber) throws SQLException{
		device.setVersion(rs.getInt("version"));
	}
		
		

}


