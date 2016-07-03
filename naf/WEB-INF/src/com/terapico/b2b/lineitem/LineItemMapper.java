
package com.terapico.b2b.lineitem;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.order.Order;

public class LineItemMapper implements RowMapper<LineItem>{
	
	public LineItem mapRow(ResultSet rs, int rowNumber) throws SQLException{
		LineItem lineItem = getLineItem();		
		 		
 		setId(lineItem, rs, rowNumber); 		
 		setBizOrder(lineItem, rs, rowNumber); 		
 		setSkuId(lineItem, rs, rowNumber); 		
 		setSkuName(lineItem, rs, rowNumber); 		
 		setAmount(lineItem, rs, rowNumber); 		
 		setQuantity(lineItem, rs, rowNumber); 		
 		setActive(lineItem, rs, rowNumber); 		
 		setVersion(lineItem, rs, rowNumber);

		return lineItem;
	}
	
	protected LineItem getLineItem(){
		return new LineItem();
	}		
		
	protected void setId(LineItem lineItem, ResultSet rs, int rowNumber) throws SQLException{
		lineItem.setId(rs.getString("id"));
	}
		 		
 	protected void setBizOrder(LineItem lineItem, ResultSet rs, int rowNumber) throws SQLException{
 		String orderId = rs.getString("biz_order");
 		if( orderId == null){
 			return;
 		}
 		if( orderId.isEmpty()){
 			return;
 		}
 		Order order = lineItem.getBizOrder();
 		if( order != null ){
 			//if the root object 'lineItem' already have the property, just set the id for it;
 			order.setId(orderId);
 			return;
 		}
 		lineItem.setBizOrder(createEmptyBizOrder(orderId));
 	}
 	
	protected void setSkuId(LineItem lineItem, ResultSet rs, int rowNumber) throws SQLException{
		lineItem.setSkuId(rs.getString("sku_id"));
	}
		
	protected void setSkuName(LineItem lineItem, ResultSet rs, int rowNumber) throws SQLException{
		lineItem.setSkuName(rs.getString("sku_name"));
	}
		
	protected void setAmount(LineItem lineItem, ResultSet rs, int rowNumber) throws SQLException{
		lineItem.setAmount(rs.getDouble("amount"));
	}
		
	protected void setQuantity(LineItem lineItem, ResultSet rs, int rowNumber) throws SQLException{
		lineItem.setQuantity(rs.getInt("quantity"));
	}
		
	protected void setActive(LineItem lineItem, ResultSet rs, int rowNumber) throws SQLException{
		lineItem.setActive(rs.getBoolean("active"));
	}
		
	protected void setVersion(LineItem lineItem, ResultSet rs, int rowNumber) throws SQLException{
		lineItem.setVersion(rs.getInt("version"));
	}
		
		

 	protected Order  createEmptyBizOrder(String orderId){
 		Order order = new Order();
 		order.setId(orderId);
 		return order;
 	}
 	
}


