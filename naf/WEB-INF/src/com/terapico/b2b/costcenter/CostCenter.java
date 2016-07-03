
package com.terapico.b2b.costcenter;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.b2b.order.Order;
import com.terapico.b2b.buyercompany.BuyerCompany;

@JsonSerialize(using = CostCenterSerializer.class)
public class CostCenter implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mName;
	protected		BuyerCompany	mBelongsTo;
	protected		int	mVersion;
	
	
	protected		List<Order> mOrderList;
	
		
	public 	CostCenter(){
		//lazy load for all the properties
	}
	
	public 	CostCenter(String name, BuyerCompany belongsTo)
	{
		setName(name);
		setBelongsTo(belongsTo);
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
	
	public void setBelongsTo(BuyerCompany belongsTo){
		this.mBelongsTo = belongsTo;
	}
	public BuyerCompany getBelongsTo(){
		return this.mBelongsTo;
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
			order.setCostCenter(this);
		}
		
		
		this.mOrderList = orderList;
		
	}
	
	public  void addOrder(Order order){
		order.setCostCenter(this);
		getOrderList().add(order);
	}
	public  void addOrders(List<Order> orderList){
		for( Order order:orderList){
			order.setCostCenter(this);
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

		stringBuilder.append("cost_center{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tbelongs_to='buyer_company("+getBelongsTo().getId()+")';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

