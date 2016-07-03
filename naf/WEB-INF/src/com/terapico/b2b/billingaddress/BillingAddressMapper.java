
package com.terapico.b2b.billingaddress;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.buyercompany.BuyerCompany;

public class BillingAddressMapper implements RowMapper<BillingAddress>{
	
	public BillingAddress mapRow(ResultSet rs, int rowNumber) throws SQLException{
		BillingAddress billingAddress = getBillingAddress();		
		 		
 		setId(billingAddress, rs, rowNumber); 		
 		setCompany(billingAddress, rs, rowNumber); 		
 		setLine1(billingAddress, rs, rowNumber); 		
 		setLine2(billingAddress, rs, rowNumber); 		
 		setCity(billingAddress, rs, rowNumber); 		
 		setState(billingAddress, rs, rowNumber); 		
 		setCountry(billingAddress, rs, rowNumber); 		
 		setVersion(billingAddress, rs, rowNumber);

		return billingAddress;
	}
	
	protected BillingAddress getBillingAddress(){
		return new BillingAddress();
	}		
		
	protected void setId(BillingAddress billingAddress, ResultSet rs, int rowNumber) throws SQLException{
		billingAddress.setId(rs.getString("id"));
	}
		 		
 	protected void setCompany(BillingAddress billingAddress, ResultSet rs, int rowNumber) throws SQLException{
 		String buyerCompanyId = rs.getString("company");
 		if( buyerCompanyId == null){
 			return;
 		}
 		if( buyerCompanyId.isEmpty()){
 			return;
 		}
 		BuyerCompany buyerCompany = billingAddress.getCompany();
 		if( buyerCompany != null ){
 			//if the root object 'billingAddress' already have the property, just set the id for it;
 			buyerCompany.setId(buyerCompanyId);
 			return;
 		}
 		billingAddress.setCompany(createEmptyCompany(buyerCompanyId));
 	}
 	
	protected void setLine1(BillingAddress billingAddress, ResultSet rs, int rowNumber) throws SQLException{
		billingAddress.setLine1(rs.getString("line1"));
	}
		
	protected void setLine2(BillingAddress billingAddress, ResultSet rs, int rowNumber) throws SQLException{
		billingAddress.setLine2(rs.getString("line2"));
	}
		
	protected void setCity(BillingAddress billingAddress, ResultSet rs, int rowNumber) throws SQLException{
		billingAddress.setCity(rs.getString("city"));
	}
		
	protected void setState(BillingAddress billingAddress, ResultSet rs, int rowNumber) throws SQLException{
		billingAddress.setState(rs.getString("state"));
	}
		
	protected void setCountry(BillingAddress billingAddress, ResultSet rs, int rowNumber) throws SQLException{
		billingAddress.setCountry(rs.getString("country"));
	}
		
	protected void setVersion(BillingAddress billingAddress, ResultSet rs, int rowNumber) throws SQLException{
		billingAddress.setVersion(rs.getInt("version"));
	}
		
		

 	protected BuyerCompany  createEmptyCompany(String buyerCompanyId){
 		BuyerCompany buyerCompany = new BuyerCompany();
 		buyerCompany.setId(buyerCompanyId);
 		return buyerCompany;
 	}
 	
}


