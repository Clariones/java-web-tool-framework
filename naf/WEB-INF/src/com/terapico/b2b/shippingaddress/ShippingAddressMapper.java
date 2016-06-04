
package com.terapico.b2b.shippingaddress;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.shippinggroup.ShippingGroup;

public class ShippingAddressMapper implements RowMapper<ShippingAddress>{
	
	public ShippingAddress mapRow(ResultSet rs, int rowNumber) throws SQLException{
		ShippingAddress shippingAddress =new ShippingAddress();

		
		shippingAddress.setId(rs.getString("id"));
		shippingAddress.setLine1(rs.getString("line1"));
		shippingAddress.setLine2(rs.getString("line2"));
		shippingAddress.setCity(rs.getString("city"));
		shippingAddress.setState(rs.getString("state"));
		shippingAddress.setCountry(rs.getString("country"));
		shippingAddress.setVersion(rs.getInt("version"));
		

		return shippingAddress;
	}
	


		


	
}

