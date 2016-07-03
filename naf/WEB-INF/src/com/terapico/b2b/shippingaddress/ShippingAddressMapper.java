
package com.terapico.b2b.shippingaddress;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ShippingAddressMapper implements RowMapper<ShippingAddress>{
	
	public ShippingAddress mapRow(ResultSet rs, int rowNumber) throws SQLException{
		ShippingAddress shippingAddress = getShippingAddress();		
		 		
 		setId(shippingAddress, rs, rowNumber); 		
 		setLine1(shippingAddress, rs, rowNumber); 		
 		setLine2(shippingAddress, rs, rowNumber); 		
 		setCity(shippingAddress, rs, rowNumber); 		
 		setState(shippingAddress, rs, rowNumber); 		
 		setCountry(shippingAddress, rs, rowNumber); 		
 		setVersion(shippingAddress, rs, rowNumber);

		return shippingAddress;
	}
	
	protected ShippingAddress getShippingAddress(){
		return new ShippingAddress();
	}		
		
	protected void setId(ShippingAddress shippingAddress, ResultSet rs, int rowNumber) throws SQLException{
		shippingAddress.setId(rs.getString("id"));
	}
		
	protected void setLine1(ShippingAddress shippingAddress, ResultSet rs, int rowNumber) throws SQLException{
		shippingAddress.setLine1(rs.getString("line1"));
	}
		
	protected void setLine2(ShippingAddress shippingAddress, ResultSet rs, int rowNumber) throws SQLException{
		shippingAddress.setLine2(rs.getString("line2"));
	}
		
	protected void setCity(ShippingAddress shippingAddress, ResultSet rs, int rowNumber) throws SQLException{
		shippingAddress.setCity(rs.getString("city"));
	}
		
	protected void setState(ShippingAddress shippingAddress, ResultSet rs, int rowNumber) throws SQLException{
		shippingAddress.setState(rs.getString("state"));
	}
		
	protected void setCountry(ShippingAddress shippingAddress, ResultSet rs, int rowNumber) throws SQLException{
		shippingAddress.setCountry(rs.getString("country"));
	}
		
	protected void setVersion(ShippingAddress shippingAddress, ResultSet rs, int rowNumber) throws SQLException{
		shippingAddress.setVersion(rs.getInt("version"));
	}
		
		

}


