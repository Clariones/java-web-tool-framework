
package com.terapico.b2b.order;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.approval.Approval;
import com.terapico.b2b.confirmation.Confirmation;
import com.terapico.b2b.shipment.Shipment;
import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.processing.Processing;
import com.terapico.b2b.lineitem.LineItem;
import com.terapico.b2b.paymentgroup.PaymentGroup;
import com.terapico.b2b.action.Action;
import com.terapico.b2b.delivery.Delivery;
import com.terapico.b2b.sellercompany.SellerCompany;
import com.terapico.b2b.shippinggroup.ShippingGroup;

public class OrderMapper implements RowMapper<Order>{
	
	public Order mapRow(ResultSet rs, int rowNumber) throws SQLException{
		Order order =new Order();

		
		order.setId(rs.getString("id"));
		 		
 		order.setBuyer(createEmptyBuyer(rs.getString("buyer")));
 		 		
 		order.setSeller(createEmptySeller(rs.getString("seller")));
 		order.setTitle(rs.getString("title"));
		order.setTotalAmount(rs.getDouble("total_amount"));
		order.setType(rs.getString("type"));
		order.setMarkAsDelete(rs.getBoolean("mark_as_delete"));
		 		
 		order.setConfirmation(createEmptyConfirmation(rs.getString("confirmation")));
 		 		
 		order.setApproval(createEmptyApproval(rs.getString("approval")));
 		 		
 		order.setProcessing(createEmptyProcessing(rs.getString("processing")));
 		 		
 		order.setShipment(createEmptyShipment(rs.getString("shipment")));
 		 		
 		order.setDelivery(createEmptyDelivery(rs.getString("delivery")));
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
 	protected Confirmation  createEmptyConfirmation (String id){
 		Confirmation ret=new Confirmation ();
 		ret.setId(id);
 		return ret;
 
 
 	}
 	protected Approval  createEmptyApproval (String id){
 		Approval ret=new Approval ();
 		ret.setId(id);
 		return ret;
 
 
 	}
 	protected Processing  createEmptyProcessing (String id){
 		Processing ret=new Processing ();
 		ret.setId(id);
 		return ret;
 
 
 	}
 	protected Shipment  createEmptyShipment (String id){
 		Shipment ret=new Shipment ();
 		ret.setId(id);
 		return ret;
 
 
 	}
 	protected Delivery  createEmptyDelivery (String id){
 		Delivery ret=new Delivery ();
 		ret.setId(id);
 		return ret;
 
 
 	}

	
}

