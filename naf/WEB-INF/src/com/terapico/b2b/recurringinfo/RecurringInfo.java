
package com.terapico.b2b.recurringinfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.b2b.order.Order;

@JsonSerialize(using = RecurringInfoSerializer.class)
public class RecurringInfo implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mName;
	protected		Date	mNextTime;
	protected		String	mCronExpr;
	protected		int	mVersion;
	
	
	protected		List<Order> mOrderList;
	
		
	public 	RecurringInfo(){
		//lazy load for all the properties
	}
	
	public 	RecurringInfo(String name, Date nextTime, String cronExpr)
	{
		setName(name);
		setNextTime(nextTime);
		setCronExpr(cronExpr);
		this.mOrderList = new ArrayList<Order>();	
	}
	

	
	public void setId(String id){
		this.mId = id;
	}
	public String getId(){
		return this.mId;
	}
	
	public void setName(String name){
		this.mName = name;
	}
	public String getName(){
		return this.mName;
	}
	
	public void setNextTime(Date nextTime){
		this.mNextTime = nextTime;
	}
	public Date getNextTime(){
		return this.mNextTime;
	}
	
	public void setCronExpr(String cronExpr){
		this.mCronExpr = cronExpr;
	}
	public String getCronExpr(){
		return this.mCronExpr;
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
			order.setRecurringInfo(this);
		}
		
		
		this.mOrderList = orderList;
		
	}
	
	public  void addOrder(Order order){
		order.setRecurringInfo(this);
		getOrderList().add(order);
	}
	public  void addOrders(List<Order> orderList){
		for( Order order:orderList){
			order.setRecurringInfo(this);
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

		stringBuilder.append("recurring_info{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tnext_time='"+getNextTime()+"';");
		stringBuilder.append("\tcron_expr='"+getCronExpr()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

