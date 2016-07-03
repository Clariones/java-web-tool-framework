
package com.terapico.b2b.approval;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.b2b.order.Order;

@JsonSerialize(using = ApprovalSerializer.class)
public class Approval implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mWho;
	protected		Date	mApproveTime;
	protected		int	mVersion;
	
	
	protected		List<Order> mOrderList;
	
		
	public 	Approval(){
		//lazy load for all the properties
	}
	
	public 	Approval(String who, Date approveTime)
	{
		setWho(who);
		setApproveTime(approveTime);
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
	
	public void setApproveTime(Date approveTime){
		this.mApproveTime = approveTime;
	}
	public Date getApproveTime(){
		return this.mApproveTime;
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
			order.setApproval(this);
		}
		
		
		this.mOrderList = orderList;
		
	}
	
	public  void addOrder(Order order){
		order.setApproval(this);
		getOrderList().add(order);
	}
	public  void addOrders(List<Order> orderList){
		for( Order order:orderList){
			order.setApproval(this);
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

		stringBuilder.append("approval{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\twho='"+getWho()+"';");
		stringBuilder.append("\tapprove_time='"+getApproveTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

