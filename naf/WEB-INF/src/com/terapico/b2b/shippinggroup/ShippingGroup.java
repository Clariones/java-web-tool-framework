
package com.terapico.b2b.shippinggroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;



import com.terapico.b2b.order.Order;
import com.terapico.b2b.shippingaddress.ShippingAddress;


public class ShippingGroup implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mName;
	protected		Order	mBizOrder;
	protected		ShippingAddress	mAddress;
	protected		double	mAmount;
	protected		int	mVersion;
	
	
	
		
	public 	ShippingGroup(){

	}
	
	public 	ShippingGroup(String	id,String	name,Order	biz_order,ShippingAddress	address,double	amount,int	version)
	{
		setId(id);
		setName(name);
		setBizOrder(biz_order);
		setAddress(address);
		setAmount(amount);
		setVersion(version);	
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
	
	public void setBizOrder(Order biz_order){
		this.mBizOrder = biz_order;
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

