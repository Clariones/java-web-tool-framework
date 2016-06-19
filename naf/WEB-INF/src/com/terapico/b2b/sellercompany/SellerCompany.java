
package com.terapico.b2b.sellercompany;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;



import com.terapico.b2b.order.Order;
import com.terapico.b2b.custsvcrep.CustSvcRep;


public class SellerCompany implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mName;
	protected		String	mOwner;
	protected		String	mLogo;
	protected		String	mContractText;
	protected		int	mVersion;
	
	
	protected		List<Order> mOrderList;
	protected		List<CustSvcRep> mCustSvcRepList;
	
		
	public 	SellerCompany(){

	}
	
	public 	SellerCompany(String	id,String	name,String	owner,String	logo,String	contract_text,int	version)
	{
		setId(id);
		setName(name);
		setOwner(owner);
		setLogo(logo);
		setContractText(contract_text);
		setVersion(version);
		this.mOrderList = new ArrayList<Order>();
		this.mCustSvcRepList = new ArrayList<CustSvcRep>();	
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
	
	public void setOwner(String owner){
		this.mOwner = owner;
	}
	public String getOwner(){
		return this.mOwner;
	}
	
	public void setLogo(String logo){
		this.mLogo = logo;
	}
	public String getLogo(){
		return this.mLogo;
	}
	
	public void setContractText(String contract_text){
		this.mContractText = contract_text;
	}
	public String getContractText(){
		return this.mContractText;
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
			order.setSeller(this);
		}
		
		
		this.mOrderList = orderList;
		
	}
	
	public  void addOrder(Order order){
		order.setSeller(this);
		getOrderList().add(order);
	}
	public  void addOrders(List<Order> orderList){
		for( Order order:orderList){
			order.setSeller(this);
		}
		getOrderList().addAll(orderList);
	}
	
	public  void removeOrder(Order order){
		getOrderList().remove(order);
	}
	public  void cleanUpOrderList(){
		getOrderList().clear();
	}
	
	
	
	
	public  List<CustSvcRep> getCustSvcRepList(){
		if(this.mCustSvcRepList == null){
			this.mCustSvcRepList = new ArrayList<CustSvcRep>();
		}
		return this.mCustSvcRepList;	
	}
	public  void setCustSvcRepList(List<CustSvcRep> custSvcRepList){
		for( CustSvcRep custSvcRep:custSvcRepList){
			custSvcRep.setCompany(this);
		}
		
		
		this.mCustSvcRepList = custSvcRepList;
		
	}
	
	public  void addCustSvcRep(CustSvcRep cust_svc_rep){
		cust_svc_rep.setCompany(this);
		getCustSvcRepList().add(cust_svc_rep);
	}
	public  void addCustSvcReps(List<CustSvcRep> custSvcRepList){
		for( CustSvcRep custSvcRep:custSvcRepList){
			custSvcRep.setCompany(this);
		}
		getCustSvcRepList().addAll(custSvcRepList);
	}
	
	public  void removeCustSvcRep(CustSvcRep cust_svc_rep){
		getCustSvcRepList().remove(cust_svc_rep);
	}
	public  void cleanUpCustSvcRepList(){
		getCustSvcRepList().clear();
	}
	
	
	
	
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("seller_company{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\towner='"+getOwner()+"';");
		stringBuilder.append("\tlogo='"+getLogo()+"';");
		stringBuilder.append("\tcontract_text='"+getContractText()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

