
package com.terapico.b2btemplate;
import java.util.ArrayList;
import java.util.List;

import java.sql.Date;
import org.xml.sax.Attributes;
public class BuyerCompany implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mName;
	protected		String	mPriceList;
	protected		int	mxVersion;
	
	
	protected		List<BillingAddress> mBillingAddressList;
	protected		List<Order> mOrderList;
	protected		List<Employee> mEmployeeList;
	
		
	public 	BuyerCompany(){

	}
	
	public 	BuyerCompany(String	id,String	name,String	price_list,int	version)
	{
		setId(id);
		setName(name);
		setPriceList(price_list);
		setVersion(version);
		this.mBillingAddressList = new ArrayList<BillingAddress>();
		this.mOrderList = new ArrayList<Order>();
		this.mEmployeeList = new ArrayList<Employee>();	
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
	
	public void setPriceList(String price_list){
		this.mPriceList = price_list;
	}
	public String getPriceList(){
		return this.mPriceList;
	}
	
	public void setVersion(int version){
		this.mxVersion = version;
	}
	public int getVersion(){
		return this.mxVersion;
	}
	
	public  List<BillingAddress> getBillingAddressList(){
		if(this.mBillingAddressList == null){
			this.mBillingAddressList = new ArrayList<BillingAddress>();
		}
		return this.mBillingAddressList;	
	}
	public  void setBillingAddressList(List<BillingAddress> BillingAddresses){
		this.mBillingAddressList=BillingAddresses;
		
	}
	
	public  void addBillingAddress(BillingAddress billing_address){
		getBillingAddressList().add(billing_address);
	}
	public  void addBillingAddresses(List<BillingAddress> billing_addresss){
		getBillingAddressList().addAll(billing_addresss);
	}
	
	public  void removeBillingAddress(BillingAddress billing_address){
		getBillingAddressList().remove(billing_address);
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
	
	
	
	
	
	public  List<Employee> getEmployeeList(){
		if(this.mEmployeeList == null){
			this.mEmployeeList = new ArrayList<Employee>();
		}
		return this.mEmployeeList;	
	}
	public  void setEmployeeList(List<Employee> Employees){
		this.mEmployeeList=Employees;
		
	}
	
	public  void addEmployee(Employee employee){
		getEmployeeList().add(employee);
	}
	public  void addEmployees(List<Employee> employees){
		getEmployeeList().addAll(employees);
	}
	
	public  void removeEmployee(Employee employee){
		getEmployeeList().remove(employee);
	}
	
	
	
	
	
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("buyer_company{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tprice_list='"+getPriceList()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

