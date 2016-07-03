
package com.terapico.b2b.order;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.approval.Approval;
import com.terapico.b2b.confirmation.Confirmation;
import com.terapico.b2b.recurringinfo.RecurringInfo;
import com.terapico.b2b.shipment.Shipment;
import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.processing.Processing;
import com.terapico.b2b.costcenter.CostCenter;
import com.terapico.b2b.profitcenter.ProfitCenter;
import com.terapico.b2b.delivery.Delivery;
import com.terapico.b2b.sellercompany.SellerCompany;

public class OrderMapper implements RowMapper<Order>{
	
	public Order mapRow(ResultSet rs, int rowNumber) throws SQLException{
		Order order = getOrder();		
		 		
 		setId(order, rs, rowNumber); 		
 		setBuyer(order, rs, rowNumber); 		
 		setSeller(order, rs, rowNumber); 		
 		setTitle(order, rs, rowNumber); 		
 		setCostCenter(order, rs, rowNumber); 		
 		setProfitCenter(order, rs, rowNumber); 		
 		setTotalAmount(order, rs, rowNumber); 		
 		setType(order, rs, rowNumber); 		
 		setMarkAsDelete(order, rs, rowNumber); 		
 		setConfirmation(order, rs, rowNumber); 		
 		setApproval(order, rs, rowNumber); 		
 		setProcessing(order, rs, rowNumber); 		
 		setShipment(order, rs, rowNumber); 		
 		setDelivery(order, rs, rowNumber); 		
 		setRecurringInfo(order, rs, rowNumber); 		
 		setStatus(order, rs, rowNumber); 		
 		setVersion(order, rs, rowNumber);

		return order;
	}
	
	protected Order getOrder(){
		return new Order();
	}		
		
	protected void setId(Order order, ResultSet rs, int rowNumber) throws SQLException{
		order.setId(rs.getString("id"));
	}
		 		
 	protected void setBuyer(Order order, ResultSet rs, int rowNumber) throws SQLException{
 		String buyerCompanyId = rs.getString("buyer");
 		if( buyerCompanyId == null){
 			return;
 		}
 		if( buyerCompanyId.isEmpty()){
 			return;
 		}
 		BuyerCompany buyerCompany = order.getBuyer();
 		if( buyerCompany != null ){
 			//if the root object 'order' already have the property, just set the id for it;
 			buyerCompany.setId(buyerCompanyId);
 			return;
 		}
 		order.setBuyer(createEmptyBuyer(buyerCompanyId));
 	}
 	 		
 	protected void setSeller(Order order, ResultSet rs, int rowNumber) throws SQLException{
 		String sellerCompanyId = rs.getString("seller");
 		if( sellerCompanyId == null){
 			return;
 		}
 		if( sellerCompanyId.isEmpty()){
 			return;
 		}
 		SellerCompany sellerCompany = order.getSeller();
 		if( sellerCompany != null ){
 			//if the root object 'order' already have the property, just set the id for it;
 			sellerCompany.setId(sellerCompanyId);
 			return;
 		}
 		order.setSeller(createEmptySeller(sellerCompanyId));
 	}
 	
	protected void setTitle(Order order, ResultSet rs, int rowNumber) throws SQLException{
		order.setTitle(rs.getString("title"));
	}
		 		
 	protected void setCostCenter(Order order, ResultSet rs, int rowNumber) throws SQLException{
 		String costCenterId = rs.getString("cost_center");
 		if( costCenterId == null){
 			return;
 		}
 		if( costCenterId.isEmpty()){
 			return;
 		}
 		CostCenter costCenter = order.getCostCenter();
 		if( costCenter != null ){
 			//if the root object 'order' already have the property, just set the id for it;
 			costCenter.setId(costCenterId);
 			return;
 		}
 		order.setCostCenter(createEmptyCostCenter(costCenterId));
 	}
 	 		
 	protected void setProfitCenter(Order order, ResultSet rs, int rowNumber) throws SQLException{
 		String profitCenterId = rs.getString("profit_center");
 		if( profitCenterId == null){
 			return;
 		}
 		if( profitCenterId.isEmpty()){
 			return;
 		}
 		ProfitCenter profitCenter = order.getProfitCenter();
 		if( profitCenter != null ){
 			//if the root object 'order' already have the property, just set the id for it;
 			profitCenter.setId(profitCenterId);
 			return;
 		}
 		order.setProfitCenter(createEmptyProfitCenter(profitCenterId));
 	}
 	
	protected void setTotalAmount(Order order, ResultSet rs, int rowNumber) throws SQLException{
		order.setTotalAmount(rs.getDouble("total_amount"));
	}
		
	protected void setType(Order order, ResultSet rs, int rowNumber) throws SQLException{
		order.setType(rs.getString("type"));
	}
		
	protected void setMarkAsDelete(Order order, ResultSet rs, int rowNumber) throws SQLException{
		order.setMarkAsDelete(rs.getBoolean("mark_as_delete"));
	}
		 		
 	protected void setConfirmation(Order order, ResultSet rs, int rowNumber) throws SQLException{
 		String confirmationId = rs.getString("confirmation");
 		if( confirmationId == null){
 			return;
 		}
 		if( confirmationId.isEmpty()){
 			return;
 		}
 		Confirmation confirmation = order.getConfirmation();
 		if( confirmation != null ){
 			//if the root object 'order' already have the property, just set the id for it;
 			confirmation.setId(confirmationId);
 			return;
 		}
 		order.setConfirmation(createEmptyConfirmation(confirmationId));
 	}
 	 		
 	protected void setApproval(Order order, ResultSet rs, int rowNumber) throws SQLException{
 		String approvalId = rs.getString("approval");
 		if( approvalId == null){
 			return;
 		}
 		if( approvalId.isEmpty()){
 			return;
 		}
 		Approval approval = order.getApproval();
 		if( approval != null ){
 			//if the root object 'order' already have the property, just set the id for it;
 			approval.setId(approvalId);
 			return;
 		}
 		order.setApproval(createEmptyApproval(approvalId));
 	}
 	 		
 	protected void setProcessing(Order order, ResultSet rs, int rowNumber) throws SQLException{
 		String processingId = rs.getString("processing");
 		if( processingId == null){
 			return;
 		}
 		if( processingId.isEmpty()){
 			return;
 		}
 		Processing processing = order.getProcessing();
 		if( processing != null ){
 			//if the root object 'order' already have the property, just set the id for it;
 			processing.setId(processingId);
 			return;
 		}
 		order.setProcessing(createEmptyProcessing(processingId));
 	}
 	 		
 	protected void setShipment(Order order, ResultSet rs, int rowNumber) throws SQLException{
 		String shipmentId = rs.getString("shipment");
 		if( shipmentId == null){
 			return;
 		}
 		if( shipmentId.isEmpty()){
 			return;
 		}
 		Shipment shipment = order.getShipment();
 		if( shipment != null ){
 			//if the root object 'order' already have the property, just set the id for it;
 			shipment.setId(shipmentId);
 			return;
 		}
 		order.setShipment(createEmptyShipment(shipmentId));
 	}
 	 		
 	protected void setDelivery(Order order, ResultSet rs, int rowNumber) throws SQLException{
 		String deliveryId = rs.getString("delivery");
 		if( deliveryId == null){
 			return;
 		}
 		if( deliveryId.isEmpty()){
 			return;
 		}
 		Delivery delivery = order.getDelivery();
 		if( delivery != null ){
 			//if the root object 'order' already have the property, just set the id for it;
 			delivery.setId(deliveryId);
 			return;
 		}
 		order.setDelivery(createEmptyDelivery(deliveryId));
 	}
 	 		
 	protected void setRecurringInfo(Order order, ResultSet rs, int rowNumber) throws SQLException{
 		String recurringInfoId = rs.getString("recurring_info");
 		if( recurringInfoId == null){
 			return;
 		}
 		if( recurringInfoId.isEmpty()){
 			return;
 		}
 		RecurringInfo recurringInfo = order.getRecurringInfo();
 		if( recurringInfo != null ){
 			//if the root object 'order' already have the property, just set the id for it;
 			recurringInfo.setId(recurringInfoId);
 			return;
 		}
 		order.setRecurringInfo(createEmptyRecurringInfo(recurringInfoId));
 	}
 	
	protected void setStatus(Order order, ResultSet rs, int rowNumber) throws SQLException{
		order.setStatus(rs.getString("status"));
	}
		
	protected void setVersion(Order order, ResultSet rs, int rowNumber) throws SQLException{
		order.setVersion(rs.getInt("version"));
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
 	
 	protected CostCenter  createEmptyCostCenter(String costCenterId){
 		CostCenter costCenter = new CostCenter();
 		costCenter.setId(costCenterId);
 		return costCenter;
 	}
 	
 	protected ProfitCenter  createEmptyProfitCenter(String profitCenterId){
 		ProfitCenter profitCenter = new ProfitCenter();
 		profitCenter.setId(profitCenterId);
 		return profitCenter;
 	}
 	
 	protected Confirmation  createEmptyConfirmation(String confirmationId){
 		Confirmation confirmation = new Confirmation();
 		confirmation.setId(confirmationId);
 		return confirmation;
 	}
 	
 	protected Approval  createEmptyApproval(String approvalId){
 		Approval approval = new Approval();
 		approval.setId(approvalId);
 		return approval;
 	}
 	
 	protected Processing  createEmptyProcessing(String processingId){
 		Processing processing = new Processing();
 		processing.setId(processingId);
 		return processing;
 	}
 	
 	protected Shipment  createEmptyShipment(String shipmentId){
 		Shipment shipment = new Shipment();
 		shipment.setId(shipmentId);
 		return shipment;
 	}
 	
 	protected Delivery  createEmptyDelivery(String deliveryId){
 		Delivery delivery = new Delivery();
 		delivery.setId(deliveryId);
 		return delivery;
 	}
 	
 	protected RecurringInfo  createEmptyRecurringInfo(String recurringInfoId){
 		RecurringInfo recurringInfo = new RecurringInfo();
 		recurringInfo.setId(recurringInfoId);
 		return recurringInfo;
 	}
 	
}


