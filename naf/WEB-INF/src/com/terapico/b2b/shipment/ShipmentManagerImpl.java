
package com.terapico.b2b.shipment;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import com.terapico.b2b.order.Order;

import com.terapico.b2b.order.OrderDAO;

import com.terapico.b2b.approval.Approval;
import com.terapico.b2b.confirmation.Confirmation;
import com.terapico.b2b.shipment.Shipment;
import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.processing.Processing;
import com.terapico.b2b.delivery.Delivery;
import com.terapico.b2b.sellercompany.SellerCompany;



public class ShipmentManagerImpl implements ShipmentManager {

	private  ShipmentDAO  shipmentDAO;
 	public void setShipmentDAO(ShipmentDAO  shipmentDAO){
 	
 		if(shipmentDAO == null){
 			throw new IllegalStateException("Do not try to set shipmentDAO to null.");
 		}
	 	this.shipmentDAO = shipmentDAO;
 	}
 	public ShipmentDAO getShipmentDAO(){
 		if(this.shipmentDAO == null){
 			throw new IllegalStateException("The ShipmentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.shipmentDAO;
 	}
 	
 	public Shipment saveShipment(Shipment shipment, Map<String,Object>options) throws Exception{	
 		return getShipmentDAO().save(shipment, options);
 	}
 	public Shipment loadShipment(String shipmentId, Map<String,Object>options) throws Exception{	
 		return getShipmentDAO().load(shipmentId, options);
 	}
 	
 	
 	
	public Shipment createShipment(String who, Date shipTime, String[] optionsExpr) throws Exception
	{
		
		
		Shipment shipment=createNewShipment(optionsExpr);	

		shipment.setWho(who);
		shipment.setShipTime(shipTime);
		//save for later setOrderValues(shipment);
		Map<String, Object> options = new HashMap<String, Object>();
		
		//return shipmentDAO.save(shipment, options);
		return saveShipment(shipment, options);
		

		
	}
	protected Shipment createNewShipment(String[] optionsExpr) throws Exception
	{
		
		return new Shipment();
		
	}
	public Shipment updateShipment(String shipmentId, String property, Object newValue) throws Exception 
	{
		return new Shipment();
	}
	protected Map<String,Object> emptyOptions(){
		return new HashMap<String,Object>();
	}
	
	protected ShipmentTokens tokens(){
		return ShipmentTokens.start();
	}
	protected Map<String,Object> allTokens(){
		return ShipmentTokens.all();
	}
	


	public void delete(String shipmentId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  Shipment addOrder(String shipmentId, String buyerId, String sellerId, String title, double totalAmount, String type, boolean markAsDelete) throws Exception
	{		
		Order order = createOrder(buyerId, sellerId, title, totalAmount, type, markAsDelete);
		
		Shipment shipment = loadShipment(shipmentId, allTokens());
		
		shipment.addOrder( order );
		
		return saveShipment(shipment, tokens().withOrderList().done());
	}
	protected Order createOrder(String buyerId, String sellerId, String title, double totalAmount, String type, boolean markAsDelete){

		Order order = new Order();
		
		
		BuyerCompany  buyer = new BuyerCompany();
		buyer.setId(buyerId);		
		order.setBuyer(buyer);		
		SellerCompany  seller = new SellerCompany();
		seller.setId(sellerId);		
		order.setSeller(seller);		
		order.setTitle(title);		
		order.setTotalAmount(totalAmount);		
		order.setType(type);		
		order.setMarkAsDelete(markAsDelete);
	
		
		return order;			
		
	}
	public  Shipment removeOrder(String shipmentId, String orderId){
		return new Shipment();
	}
	public  Shipment updateOrder(String shipmentId, String orderId, String property, Object newValue){
		return new Shipment();
	}



}


