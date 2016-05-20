
package com.terapico.b2btemplate;
import java.util.ArrayList;
import java.util.List;

import java.sql.Date;
import org.xml.sax.Attributes;
public class SellerCompany implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mName;
	protected		int	mxVersion;
	
	
	protected		List<Order> mOrderList;
	protected		List<Csr> mCsrList;
	
		
	public 	SellerCompany(){

	}
	
	public 	SellerCompany(String	id,String	name,int	version)
	{
		setId(id);
		setName(name);
		setVersion(version);
		this.mOrderList = new ArrayList<Order>();
		this.mCsrList = new ArrayList<Csr>();	
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
	public  void setOrderList(List<Order> Orders){
		this.mOrderList=Orders;
		
	}
	
	public  void addOrder(Order order){
		getOrderList().add(order);
	}
	public  void addOrders(List<Order> orders){
		getOrderList().addAll(orders);
	}
	
	public  void removeOrder(Order order){
		getOrderList().remove(order);
	}
	
	
	
	
	
	public  List<Csr> getCsrList(){
		if(this.mCsrList == null){
			this.mCsrList = new ArrayList<Csr>();
		}
		return this.mCsrList;	
	}
	public  void setCsrList(List<Csr> Csrs){
		this.mCsrList=Csrs;
		
	}
	
	public  void addCsr(Csr csr){
		getCsrList().add(csr);
	}
	public  void addCsrs(List<Csr> csrs){
		getCsrList().addAll(csrs);
	}
	
	public  void removeCsr(Csr csr){
		getCsrList().remove(csr);
	}
	
	
	
	
	
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("seller_company{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

