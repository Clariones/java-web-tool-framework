
package com.terapico.b2b.sellercompany;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.b2b.order.Order;
import com.terapico.b2b.creditaccount.CreditAccount;
import com.terapico.b2b.custsvcrep.CustSvcRep;
import com.terapico.b2b.profitcenter.ProfitCenter;

@JsonSerialize(using = SellerCompanySerializer.class)
public class SellerCompany implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mName;
	protected		String	mOwner;
	protected		String	mLogo;
	protected		String	mContractText;
	protected		int	mVersion;
	
	
	protected		List<ProfitCenter> mProfitCenterList;
	protected		List<CreditAccount> mCreditAccountList;
	protected		List<Order> mOrderList;
	protected		List<CustSvcRep> mCustSvcRepList;
	
		
	public 	SellerCompany(){
		//lazy load for all the properties
	}
	
	public 	SellerCompany(String name, String owner, String logo, String contractText)
	{
		setName(name);
		setOwner(owner);
		setLogo(logo);
		setContractText(contractText);
		this.mProfitCenterList = new ArrayList<ProfitCenter>();
		this.mCreditAccountList = new ArrayList<CreditAccount>();
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
	
	public void setContractText(String contractText){
		this.mContractText = contractText;
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
	
	public  List<ProfitCenter> getProfitCenterList(){
		if(this.mProfitCenterList == null){
			this.mProfitCenterList = new ArrayList<ProfitCenter>();
		}
		return this.mProfitCenterList;	
	}
	public  void setProfitCenterList(List<ProfitCenter> profitCenterList){
		for( ProfitCenter profitCenter:profitCenterList){
			profitCenter.setBelongsTo(this);
		}
		
		
		this.mProfitCenterList = profitCenterList;
		
	}
	
	public  void addProfitCenter(ProfitCenter profitCenter){
		profitCenter.setBelongsTo(this);
		getProfitCenterList().add(profitCenter);
	}
	public  void addProfitCenters(List<ProfitCenter> profitCenterList){
		for( ProfitCenter profitCenter:profitCenterList){
			profitCenter.setBelongsTo(this);
		}
		getProfitCenterList().addAll(profitCenterList);
	}
	
	public  void removeProfitCenter(ProfitCenter profitCenter){
		getProfitCenterList().remove(profitCenter);
	}
	public  void cleanUpProfitCenterList(){
		getProfitCenterList().clear();
	}
	
	
	
	
	public  List<CreditAccount> getCreditAccountList(){
		if(this.mCreditAccountList == null){
			this.mCreditAccountList = new ArrayList<CreditAccount>();
		}
		return this.mCreditAccountList;	
	}
	public  void setCreditAccountList(List<CreditAccount> creditAccountList){
		for( CreditAccount creditAccount:creditAccountList){
			creditAccount.setSeller(this);
		}
		
		
		this.mCreditAccountList = creditAccountList;
		
	}
	
	public  void addCreditAccount(CreditAccount creditAccount){
		creditAccount.setSeller(this);
		getCreditAccountList().add(creditAccount);
	}
	public  void addCreditAccounts(List<CreditAccount> creditAccountList){
		for( CreditAccount creditAccount:creditAccountList){
			creditAccount.setSeller(this);
		}
		getCreditAccountList().addAll(creditAccountList);
	}
	
	public  void removeCreditAccount(CreditAccount creditAccount){
		getCreditAccountList().remove(creditAccount);
	}
	public  void cleanUpCreditAccountList(){
		getCreditAccountList().clear();
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
	
	public  void addCustSvcRep(CustSvcRep custSvcRep){
		custSvcRep.setCompany(this);
		getCustSvcRepList().add(custSvcRep);
	}
	public  void addCustSvcReps(List<CustSvcRep> custSvcRepList){
		for( CustSvcRep custSvcRep:custSvcRepList){
			custSvcRep.setCompany(this);
		}
		getCustSvcRepList().addAll(custSvcRepList);
	}
	
	public  void removeCustSvcRep(CustSvcRep custSvcRep){
		getCustSvcRepList().remove(custSvcRep);
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

