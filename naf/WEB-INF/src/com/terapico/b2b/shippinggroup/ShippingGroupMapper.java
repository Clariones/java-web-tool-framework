
package com.terapico.b2b.shippinggroup;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.order.Order;
import com.terapico.b2b.shippingaddress.ShippingAddress;

public class ShippingGroupMapper implements RowMapper<ShippingGroup>{
	
	public ShippingGroup mapRow(ResultSet rs, int rowNumber) throws SQLException{
		ShippingGroup shippingGroup = getShippingGroup();		
		 		
 		setId(shippingGroup, rs, rowNumber); 		
 		setName(shippingGroup, rs, rowNumber); 		
 		setBizOrder(shippingGroup, rs, rowNumber); 		
 		setAddress(shippingGroup, rs, rowNumber); 		
 		setAmount(shippingGroup, rs, rowNumber); 		
 		setVersion(shippingGroup, rs, rowNumber);

		return shippingGroup;
	}
	
	protected ShippingGroup getShippingGroup(){
		return new ShippingGroup();
	}		
		
	protected void setId(ShippingGroup shippingGroup, ResultSet rs, int rowNumber) throws SQLException{
		shippingGroup.setId(rs.getString("id"));
	}
		
	protected void setName(ShippingGroup shippingGroup, ResultSet rs, int rowNumber) throws SQLException{
		shippingGroup.setName(rs.getString("name"));
	}
		 		
 	protected void setBizOrder(ShippingGroup shippingGroup, ResultSet rs, int rowNumber) throws SQLException{
 		String orderId = rs.getString("biz_order");
 		if( orderId == null){
 			return;
 		}
 		if( orderId.isEmpty()){
 			return;
 		}
 		Order order = shippingGroup.getBizOrder();
 		if( order != null ){
 			//if the root object 'shippingGroup' already have the property, just set the id for it;
 			order.setId(orderId);
 			return;
 		}
 		shippingGroup.setBizOrder(createEmptyBizOrder(orderId));
 	}
 	 		
 	protected void setAddress(ShippingGroup shippingGroup, ResultSet rs, int rowNumber) throws SQLException{
 		String shippingAddressId = rs.getString("address");
 		if( shippingAddressId == null){
 			return;
 		}
 		if( shippingAddressId.isEmpty()){
 			return;
 		}
 		ShippingAddress shippingAddress = shippingGroup.getAddress();
 		if( shippingAddress != null ){
 			//if the root object 'shippingGroup' already have the property, just set the id for it;
 			shippingAddress.setId(shippingAddressId);
 			return;
 		}
 		shippingGroup.setAddress(createEmptyAddress(shippingAddressId));
 	}
 	
	protected void setAmount(ShippingGroup shippingGroup, ResultSet rs, int rowNumber) throws SQLException{
		shippingGroup.setAmount(rs.getDouble("amount"));
	}
		
	protected void setVersion(ShippingGroup shippingGroup, ResultSet rs, int rowNumber) throws SQLException{
		shippingGroup.setVersion(rs.getInt("version"));
	}
		
		

 	protected Order  createEmptyBizOrder(String orderId){
 		Order order = new Order();
 		order.setId(orderId);
 		return order;
 	}
 	
 	protected ShippingAddress  createEmptyAddress(String shippingAddressId){
 		ShippingAddress shippingAddress = new ShippingAddress();
 		shippingAddress.setId(shippingAddressId);
 		return shippingAddress;
 	}
 	
}


