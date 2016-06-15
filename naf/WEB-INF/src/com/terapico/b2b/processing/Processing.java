
package com.terapico.b2b.processing;
import java.util.ArrayList;
import java.util.List;

import java.sql.Date;
import org.xml.sax.Attributes;


import com.terapico.b2b.order.Order;


public class Processing implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mWho;
	protected		Date	mD;
	protected		int	mxVersion;
	
	
	protected		List<Order> mOrderList;
	
		
	public 	Processing(){

	}
	
	public 	Processing(String	id,String	who,Date	d,int	version)
	{
		setId(id);
		setWho(who);
		setD(d);
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
	
	public void setD(Date d){
		this.mD = d;
	}
	public Date getD(){
		return this.mD;
	}
	
	public void setVersion(int version){
		this.mxVersion = version;
	}
	public int getVersion(){
		return this.mxVersion;
	}
	
	public  List<Order> getOrderList(){
		if(this.mOrderList == null){
			this.mOrderList = new ArrayList<Order>();
		}
		return this.mOrderList;	
	}
	public  void setOrderList(List<Order> orderList){
		for( Order order:orderList){
			order.setProcessing(this);
		}
		
		
		this.mOrderList = orderList;
		
	}
	
	public  void addOrder(Order order){
		order.setProcessing(this);
		getOrderList().add(order);
	}
	public  void addOrders(List<Order> orderList){
		for( Order order:orderList){
			order.setProcessing(this);
		}
		getOrderList().addAll(orderList);
	}
	
	public  void removeOrder(Order order){
		getOrderList().remove(order);
	}
	
	
	
	
	
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("processing{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\twho='"+getWho()+"';");
		stringBuilder.append("\td='"+getD()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

