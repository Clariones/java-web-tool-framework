
package com.terapico.b2b.shippinggroup;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.order.Order;
import com.terapico.b2b.shippingaddress.ShippingAddress;

public class ShippingGroupMapper implements RowMapper<ShippingGroup>{



	
	public ShippingGroup mapRow(ResultSet rs, int rowNumber) throws SQLException{
		ShippingGroup shippingGroup =new ShippingGroup();

		
		shippingGroup.setId(rs.getString("id"));
		shippingGroup.setName(rs.getString("name"));
		 		
 		shippingGroup.setBizOrder(createEmptyBizOrder(rs.getString("biz_order"))); 		
 		shippingGroup.setAddress(createEmptyAddress(rs.getString("address")));shippingGroup.setAmount(rs.getDouble("amount"));
		shippingGroup.setVersion(rs.getInt("version"));
		

		return shippingGroup;
	}
	


		

 	protected Order  createEmptyBizOrder (String id){
 		Order ret=new Order ();
 		ret.setId(id);
 		return ret;
 
 
 	}
 	protected ShippingAddress  createEmptyAddress (String id){
 		ShippingAddress ret=new ShippingAddress ();
 		ret.setId(id);
 		return ret;
 
 
 	}

	
}

