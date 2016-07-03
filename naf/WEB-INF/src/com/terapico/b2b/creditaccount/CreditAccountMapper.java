
package com.terapico.b2b.creditaccount;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.sellercompany.SellerCompany;

public class CreditAccountMapper implements RowMapper<CreditAccount>{
	
	public CreditAccount mapRow(ResultSet rs, int rowNumber) throws SQLException{
		CreditAccount creditAccount = getCreditAccount();		
		 		
 		setId(creditAccount, rs, rowNumber); 		
 		setName(creditAccount, rs, rowNumber); 		
 		setBuyer(creditAccount, rs, rowNumber); 		
 		setSeller(creditAccount, rs, rowNumber); 		
 		setAuthorized(creditAccount, rs, rowNumber); 		
 		setRemain(creditAccount, rs, rowNumber); 		
 		setVersion(creditAccount, rs, rowNumber);

		return creditAccount;
	}
	
	protected CreditAccount getCreditAccount(){
		return new CreditAccount();
	}		
		
	protected void setId(CreditAccount creditAccount, ResultSet rs, int rowNumber) throws SQLException{
		creditAccount.setId(rs.getString("id"));
	}
		
	protected void setName(CreditAccount creditAccount, ResultSet rs, int rowNumber) throws SQLException{
		creditAccount.setName(rs.getString("name"));
	}
		 		
 	protected void setBuyer(CreditAccount creditAccount, ResultSet rs, int rowNumber) throws SQLException{
 		String buyerCompanyId = rs.getString("buyer");
 		if( buyerCompanyId == null){
 			return;
 		}
 		if( buyerCompanyId.isEmpty()){
 			return;
 		}
 		BuyerCompany buyerCompany = creditAccount.getBuyer();
 		if( buyerCompany != null ){
 			//if the root object 'creditAccount' already have the property, just set the id for it;
 			buyerCompany.setId(buyerCompanyId);
 			return;
 		}
 		creditAccount.setBuyer(createEmptyBuyer(buyerCompanyId));
 	}
 	 		
 	protected void setSeller(CreditAccount creditAccount, ResultSet rs, int rowNumber) throws SQLException{
 		String sellerCompanyId = rs.getString("seller");
 		if( sellerCompanyId == null){
 			return;
 		}
 		if( sellerCompanyId.isEmpty()){
 			return;
 		}
 		SellerCompany sellerCompany = creditAccount.getSeller();
 		if( sellerCompany != null ){
 			//if the root object 'creditAccount' already have the property, just set the id for it;
 			sellerCompany.setId(sellerCompanyId);
 			return;
 		}
 		creditAccount.setSeller(createEmptySeller(sellerCompanyId));
 	}
 	
	protected void setAuthorized(CreditAccount creditAccount, ResultSet rs, int rowNumber) throws SQLException{
		creditAccount.setAuthorized(rs.getDouble("authorized"));
	}
		
	protected void setRemain(CreditAccount creditAccount, ResultSet rs, int rowNumber) throws SQLException{
		creditAccount.setRemain(rs.getDouble("remain"));
	}
		
	protected void setVersion(CreditAccount creditAccount, ResultSet rs, int rowNumber) throws SQLException{
		creditAccount.setVersion(rs.getInt("version"));
	}
		
		

 	protected BuyerCompany  createEmptyBuyer(String buyerCompanyId){
 		BuyerCompany buyerCompany = new BuyerCompany();
 		buyerCompany.setId(buyerCompanyId);
 		return buyerCompany;
 	}
 	
 	protected SellerCompany  createEmptySeller(String sellerCompanyId){
 		SellerCompany sellerCompany = new SellerCompany();
 		sellerCompany.setId(sellerCompanyId);
 		return sellerCompany;
 	}
 	
}


