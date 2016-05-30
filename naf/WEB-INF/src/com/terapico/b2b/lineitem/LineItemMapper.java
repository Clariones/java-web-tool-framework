
package com.terapico.b2b.lineitem;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.order.Order;

public class LineItemMapper implements RowMapper<LineItem>{



	
	public LineItem mapRow(ResultSet rs, int rowNumber) throws SQLException{
		LineItem lineItem =new LineItem();

		
		lineItem.setId(rs.getString("id"));
		 		
 		lineItem.setBizOrder(createEmptyBizOrder(rs.getString("biz_order")));lineItem.setSkuId(rs.getString("sku_id"));
		lineItem.setSkuName(rs.getString("sku_name"));
		lineItem.setAmount(rs.getDouble("amount"));
		lineItem.setQuantity(rs.getInt("quantity"));
		lineItem.setVersion(rs.getInt("version"));
		

		return lineItem;
	}
	


		

 	protected Order  createEmptyBizOrder (String id){
 		Order ret=new Order ();
 		ret.setId(id);
 		return ret;
 
 
 	}

	
}

