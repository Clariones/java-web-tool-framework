
package com.terapico.b2b.shipment;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.b2b.order.Order;

@JsonSerialize(using = ShipmentSerializer.class)
public class Shipment implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mWho;
	protected		Date	mShipTime;
	protected		int	mVersion;
	
	
	protected		List<Order> mOrderList;
	
		
	public 	Shipment(){
		//lazy load for all the properties
	}
	
	public 	Shipment(String who, Date shipTime)
	{
		setWho(who);
		setShipTime(shipTime);
		this.mOrderList = new ArrayList<Order>();	
	}
	

	
	public void setId(String id){
		this.mId = id;
	}
	public String getId(){
		return this.mId;
	}
	
	public void setWho(String who){
		this.mWho = who;
	}
	public String getWho(){
		return this.mWho;
	}
	
	public void setShipTime(Date shipTime){
		this.mShipTime = shipTime;
	}
	public Date getShipTime(){
		return this.mShipTime;
	}
	
	public void setVersion(int version){
		this.mVersion = version;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	public  List<Order> getOrderList(){
		if(this.mOrderList == null){
			this.mOrderList = new ArrayList<Order>();
		}
		return this.mOrderList;	
	}
	public  void setOrderList(List<Order> orderList){
		for( Order order:orderList){
			order.setShipment(this);
		}
		
		
		this.mOrderList = orderList;
		
	}
	
	public  void addOrder(Order order){
		order.setShipment(this);
		getOrderList().add(order);
	}
	public  void addOrders(List<Order> orderList){
		for( Order order:orderList){
			order.setShipment(this);
		}
		getOrderList().addAll(orderList);
	}
	
	public  void removeOrder(Order order){
		getOrderList().remove(order);
	}
	public  void cleanUpOrderList(){
		getOrderList().clear();
	}
	
	
	
	
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("shipment{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\twho='"+getWho()+"';");
		stringBuilder.append("\tship_time='"+getShipTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

