
package com.terapico.b2b.billingaddress;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.paymentgroup.PaymentGroup;

public class BillingAddressMapper implements RowMapper<BillingAddress>{
	
	public BillingAddress mapRow(ResultSet rs, int rowNumber) throws SQLException{
		BillingAddress billingAddress =new BillingAddress();

		
		billingAddress.setId(rs.getString("id"));
		 		
 		billingAddress.setCompany(createEmptyCompany(rs.getString("company")));
 		billingAddress.setLine1(rs.getString("line1"));
		billingAddress.setLine2(rs.getString("line2"));
		billingAddress.setCity(rs.getString("city"));
		billingAddress.setState(rs.getString("state"));
		billingAddress.setCountry(rs.getString("country"));
		billingAddress.setVersion(rs.getInt("version"));
		

		return billingAddress;
	}
	


		

 	protected BuyerCompany  createEmptyCompany (String id){
 		BuyerCompany ret=new BuyerCompany ();
 		ret.setId(id);
 		return ret;
 
 
 	}

	
}

