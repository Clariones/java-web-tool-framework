
package com.terapico.b2b.paymentgroup;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.order.Order;
import com.terapico.b2b.billingaddress.BillingAddress;

public class PaymentGroupMapper implements RowMapper<PaymentGroup>{
	
	public PaymentGroup mapRow(ResultSet rs, int rowNumber) throws SQLException{
		PaymentGroup paymentGroup = getPaymentGroup();		
		 		
 		setId(paymentGroup, rs, rowNumber); 		
 		setName(paymentGroup, rs, rowNumber); 		
 		setBizOrder(paymentGroup, rs, rowNumber); 		
 		setCardNumber(paymentGroup, rs, rowNumber); 		
 		setBillingAddress(paymentGroup, rs, rowNumber); 		
 		setVersion(paymentGroup, rs, rowNumber);

		return paymentGroup;
	}
	
	protected PaymentGroup getPaymentGroup(){
		return new PaymentGroup();
	}		
		
	protected void setId(PaymentGroup paymentGroup, ResultSet rs, int rowNumber) throws SQLException{
		paymentGroup.setId(rs.getString("id"));
	}
		
	protected void setName(PaymentGroup paymentGroup, ResultSet rs, int rowNumber) throws SQLException{
		paymentGroup.setName(rs.getString("name"));
	}
		 		
 	protected void setBizOrder(PaymentGroup paymentGroup, ResultSet rs, int rowNumber) throws SQLException{
 		String orderId = rs.getString("biz_order");
 		if( orderId == null){
 			return;
 		}
 		if( orderId.isEmpty()){
 			return;
 		}
 		Order order = paymentGroup.getBizOrder();
 		if( order != null ){
 			//if the root object 'paymentGroup' already have the property, just set the id for it;
 			order.setId(orderId);
 			return;
 		}
 		paymentGroup.setBizOrder(createEmptyBizOrder(orderId));
 	}
 	
	protected void setCardNumber(PaymentGroup paymentGroup, ResultSet rs, int rowNumber) throws SQLException{
		paymentGroup.setCardNumber(rs.getString("card_number"));
	}
		 		
 	protected void setBillingAddress(PaymentGroup paymentGroup, ResultSet rs, int rowNumber) throws SQLException{
 		String billingAddressId = rs.getString("billing_address");
 		if( billingAddressId == null){
 			return;
 		}
 		if( billingAddressId.isEmpty()){
 			return;
 		}
 		BillingAddress billingAddress = paymentGroup.getBillingAddress();
 		if( billingAddress != null ){
 			//if the root object 'paymentGroup' already have the property, just set the id for it;
 			billingAddress.setId(billingAddressId);
 			return;
 		}
 		paymentGroup.setBillingAddress(createEmptyBillingAddress(billingAddressId));
 	}
 	
	protected void setVersion(PaymentGroup paymentGroup, ResultSet rs, int rowNumber) throws SQLException{
		paymentGroup.setVersion(rs.getInt("version"));
	}
		
		

 	protected Order  createEmptyBizOrder(String orderId){
 		Order order = new Order();
 		order.setId(orderId);
 		return order;
 	}
 	
 	protected BillingAddress  createEmptyBillingAddress(String billingAddressId){
 		BillingAddress billingAddress = new BillingAddress();
 		billingAddress.setId(billingAddressId);
 		return billingAddress;
 	}
 	
}


