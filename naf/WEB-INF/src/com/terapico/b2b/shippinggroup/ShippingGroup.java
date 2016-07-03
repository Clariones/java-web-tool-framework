
package com.terapico.b2b.shippinggroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.b2b.order.Order;
import com.terapico.b2b.shippingaddress.ShippingAddress;

@JsonSerialize(using = ShippingGroupSerializer.class)
public class ShippingGroup implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mName;
	protected		Order	mBizOrder;
	protected		ShippingAddress	mAddress;
	protected		double	mAmount;
	protected		int	mVersion;
	
	
	
		
	public 	ShippingGroup(){
		//lazy load for all the properties
	}
	
	public 	ShippingGroup(String name, Order bizOrder, ShippingAddress address, double amount)
	{
		setName(name);
		setBizOrder(bizOrder);
		setAddress(address);
		setAmount(amount);	
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
	
	public void setBizOrder(Order bizOrder){
		this.mBizOrder = bizOrder;
	}
	public Order getBizOrder(){
		return this.mBizOrder;
	}
	
	public void setAddress(ShippingAddress address){
		this.mAddress = address;
	}
	public ShippingAddress getAddress(){
		return this.mAddress;
	}
	
	public void setAmount(double amount){
		this.mAmount = amount;
	}
	public double getAmount(){
		return this.mAmount;
	}
	
	public void setVersion(int version){
		this.mVersion = version;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("shipping_group{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tbiz_order='order("+getBizOrder().getId()+")';");
		stringBuilder.append("\taddress='shipping_address("+getAddress().getId()+")';");
		stringBuilder.append("\tamount='"+getAmount()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

