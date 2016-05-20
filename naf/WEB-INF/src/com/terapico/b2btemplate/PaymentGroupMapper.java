
package com.terapico.b2btemplate;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class PaymentGroupMapper implements RowMapper<PaymentGroup>{



	
	public PaymentGroup mapRow(ResultSet rs, int rowNumber) throws SQLException{
		PaymentGroup paymentGroup =new PaymentGroup();

		
		paymentGroup.setId(rs.getString("id"));
		paymentGroup.setName(rs.getString("name"));
		 		
 		paymentGroup.setBizOrder(createEmptyBizOrder(rs.getString("biz_order")));paymentGroup.setCardNumber(rs.getString("card_number"));
		 		
 		paymentGroup.setBillingAddress(createEmptyBillingAddress(rs.getString("billing_address")));paymentGroup.setVersion(rs.getInt("version"));
		

		return paymentGroup;
	}
	


		

 	protected Order  createEmptyBizOrder (String id){
 		Order ret=new Order ();
 		ret.setId(id);
 		return ret;
 
 
 	}
 	protected BillingAddress  createEmptyBillingAddress (String id){
 		BillingAddress ret=new BillingAddress ();
 		ret.setId(id);
 		return ret;
 
 
 	}

	
}

