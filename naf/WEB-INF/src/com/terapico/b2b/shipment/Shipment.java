
package com.terapico.b2b.shipment;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;



import com.terapico.b2b.order.Order;


public class Shipment implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mWho;
	protected		Date	mShupTime;
	protected		int	mVersion;
	
	
	protected		List<Order> mOrderList;
	
		
	public 	Shipment(){

	}
	
	public 	Shipment(String	id,String	who,Date	shup_time,int	version)
	{
		setId(id);
		setWho(who);
		setShupTime(shup_time);
		setVersion(version);
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
	
	public void setShupTime(Date shup_time){
		this.mShupTime = shup_time;
	}
	public Date getShupTime(){
		return this.mShupTime;
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
		stringBuilder.append("\tshup_time='"+getShupTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

