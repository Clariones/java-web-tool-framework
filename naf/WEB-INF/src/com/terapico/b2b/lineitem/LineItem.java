
package com.terapico.b2b.lineitem;
import java.util.ArrayList;
import java.util.List;

import java.sql.Date;
import org.xml.sax.Attributes;


import com.terapico.b2b.order.Order;


public class LineItem implements  java.io.Serializable{

	protected		String	mId;
	protected		Order	mBizOrder;
	protected		String	mSkuId;
	protected		String	mSkuName;
	protected		double	mAmount;
	protected		int	mxQuantity;
	protected		int	mxVersion;
	
	
	
		
	public 	LineItem(){

	}
	
	public 	LineItem(String	id,Order	biz_order,String	sku_id,String	sku_name,double	amount,int	quantity,int	version)
	{
		setId(id);
		setBizOrder(biz_order);
		setSkuId(sku_id);
		setSkuName(sku_name);
		setAmount(amount);
		setQuantity(quantity);
		setVersion(version);	
	}
	

	
	public void setId(String id){
		this.mId = id;
	}
	public String getId(){
		return this.mId;
	}
	
	public void setBizOrder(Order biz_order){
		this.mBizOrder = biz_order;
	}
	public Order getBizOrder(){
		return this.mBizOrder;
	}
	
	public void setSkuId(String sku_id){
		this.mSkuId = sku_id;
	}
	public String getSkuId(){
		return this.mSkuId;
	}
	
	public void setSkuName(String sku_name){
		this.mSkuName = sku_name;
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
		this.mxQuantity = quantity;
	}
	public int getQuantity(){
		return this.mxQuantity;
	}
	
	public void setVersion(int version){
		this.mxVersion = version;
	}
	public int getVersion(){
		return this.mxVersion;
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
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

