
package com.terapico.b2b.lineitem;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.b2b.order.Order;

@JsonSerialize(using = LineItemSerializer.class)
public class LineItem implements  java.io.Serializable{

	protected		String	mId;
	protected		Order	mBizOrder;
	protected		String	mSkuId;
	protected		String	mSkuName;
	protected		double	mAmount;
	protected		int	mQuantity;
	protected		boolean	mActive;
	protected		int	mVersion;
	
	
	
		
	public 	LineItem(){
		//lazy load for all the properties
	}
	
	public 	LineItem(Order bizOrder, String skuId, String skuName, double amount, int quantity, boolean active)
	{
		setBizOrder(bizOrder);
		setSkuId(skuId);
		setSkuName(skuName);
		setAmount(amount);
		setQuantity(quantity);
		setActive(active);	
	}
	

	
	public void setId(String id){
		this.mId = id;
	}
	public String getId(){
		return this.mId;
	}
	
	public void setBizOrder(Order bizOrder){
		this.mBizOrder = bizOrder;
	}
	public Order getBizOrder(){
		return this.mBizOrder;
	}
	
	public void setSkuId(String skuId){
		this.mSkuId = skuId;
	}
	public String getSkuId(){
		return this.mSkuId;
	}
	
	public void setSkuName(String skuName){
		this.mSkuName = skuName;
	}
	public String getSkuName(){
		return this.mSkuName;
	}
	
	public void setAmount(double amount){
		this.mAmount = amount;
	}
	public double getAmount(){
		return this.mAmount;
	}
	
	public void setQuantity(int quantity){
		this.mQuantity = quantity;
	}
	public int getQuantity(){
		return this.mQuantity;
	}
	
	public void setActive(boolean active){
		this.mActive = active;
	}
	public boolean getActive(){
		return this.mActive;
	}
	
	public void setVersion(int version){
		this.mVersion = version;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("line_item{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tbiz_order='order("+getBizOrder().getId()+")';");
		stringBuilder.append("\tsku_id='"+getSkuId()+"';");
		stringBuilder.append("\tsku_name='"+getSkuName()+"';");
		stringBuilder.append("\tamount='"+getAmount()+"';");
		stringBuilder.append("\tquantity='"+getQuantity()+"';");
		stringBuilder.append("\tactive='"+getActive()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

