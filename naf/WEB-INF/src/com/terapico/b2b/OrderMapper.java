
package com.terapico.b2b;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class OrderMapper implements RowMapper<Order>{



	
	public Order mapRow(ResultSet rs, int rowNumber) throws SQLException{
		Order order =new Order();

		
		order.setId(rs.getString("id"));
		 		
 		order.setBuyer(createEmptyBuyer(rs.getString("buyer"))); 		
 		order.setSeller(createEmptySeller(rs.getString("seller")));order.setTitle(rs.getString("title"));
		order.setTotalAmount(rs.getDouble("total_amount"));
		order.setType(rs.getString("type"));
		order.setVersion(rs.getInt("version"));
		

		return order;
	}
	


		

 	protected BuyerCompany  createEmptyBuyer (String id){
 		BuyerCompany ret=new BuyerCompany ();
 		ret.setId(id);
 		return ret;
 
 
 	}
 	protected SellerCompany  createEmptySeller (String id){
 		SellerCompany ret=new SellerCompany ();
 		ret.setId(id);
 		return ret;
 
 
 	}

	
}

