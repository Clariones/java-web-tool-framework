
package com.terapico.b2btemplate;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class LineItemMapper implements RowMapper<LineItem>{



	
	public LineItem mapRow(ResultSet rs, int rowNumber) throws SQLException{
		LineItem commerceItem =new LineItem();

		
		commerceItem.setId(rs.getString("id"));
		 		
 		commerceItem.setBizOrder(createEmptyBizOrder(rs.getString("biz_order")));commerceItem.setSkuId(rs.getString("sku_id"));
		commerceItem.setSkuName(rs.getString("sku_name"));
		commerceItem.setAmount(rs.getDouble("amount"));
		commerceItem.setQuantity(rs.getInt("quantity"));
		commerceItem.setVersion(rs.getInt("version"));
		

		return commerceItem;
	}
	


		

 	protected Order  createEmptyBizOrder (String id){
 		Order ret=new Order ();
 		ret.setId(id);
 		return ret;
 
 
 	}

	
}

