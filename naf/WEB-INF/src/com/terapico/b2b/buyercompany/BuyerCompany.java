
package com.terapico.b2b.buyercompany;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.b2b.order.Order;
import com.terapico.b2b.creditaccount.CreditAccount;
import com.terapico.b2b.billingaddress.BillingAddress;
import com.terapico.b2b.costcenter.CostCenter;
import com.terapico.b2b.employee.Employee;

@JsonSerialize(using = BuyerCompanySerializer.class)
public class BuyerCompany implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mName;
	protected		String	mPriceList;
	protected		int	mRating;
	protected		String	mLogo;
	protected		String	mOwner;
	protected		int	mVersion;
	
	
	protected		List<CostCenter> mCostCenterList;
	protected		List<CreditAccount> mCreditAccountList;
	protected		List<BillingAddress> mBillingAddressList;
	protected		List<Employee> mEmployeeList;
	protected		List<Order> mOrderList;
	
		
	public 	BuyerCompany(){
		//lazy load for all the properties
	}
	
	public 	BuyerCompany(String name, String priceList, int rating, String logo, String owner)
	{
		setName(name);
		setPriceList(priceList);
		setRating(rating);
		setLogo(logo);
		setOwner(owner);
		this.mCostCenterList = new ArrayList<CostCenter>();
		this.mCreditAccountList = new ArrayList<CreditAccount>();
		this.mBillingAddressList = new ArrayList<BillingAddress>();
		this.mEmployeeList = new ArrayList<Employee>();
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
	
	public void setPriceList(String priceList){
		this.mPriceList = priceList;
	}
	public String getPriceList(){
		return this.mPriceList;
	}
	
	public void setRating(int rating){
		this.mRating = rating;
	}
	public int getRating(){
		return this.mRating;
	}
	
	public void setLogo(String logo){
		this.mLogo = logo;
	}
	public String getLogo(){
		return this.mLogo;
	}
	
	public void setOwner(String owner){
		this.mOwner = owner;
	}
	public String getOwner(){
		return this.mOwner;
	}
	
	public void setVersion(int version){
		this.mVersion = version;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	public  List<CostCenter> getCostCenterList(){
		if(this.mCostCenterList == null){
			this.mCostCenterList = new ArrayList<CostCenter>();
		}
		return this.mCostCenterList;	
	}
	public  void setCostCenterList(List<CostCenter> costCenterList){
		for( CostCenter costCenter:costCenterList){
			costCenter.setBelongsTo(this);
		}
		
		
		this.mCostCenterList = costCenterList;
		
	}
	
	public  void addCostCenter(CostCenter costCenter){
		costCenter.setBelongsTo(this);
		getCostCenterList().add(costCenter);
	}
	public  void addCostCenters(List<CostCenter> costCenterList){
		for( CostCenter costCenter:costCenterList){
			costCenter.setBelongsTo(this);
		}
		getCostCenterList().addAll(costCenterList);
	}
	
	public  void removeCostCenter(CostCenter costCenter){
		getCostCenterList().remove(costCenter);
	}
	public  void cleanUpCostCenterList(){
		getCostCenterList().clear();
	}
	
	
	
	
	public  List<CreditAccount> getCreditAccountList(){
		if(this.mCreditAccountList == null){
			this.mCreditAccountList = new ArrayList<CreditAccount>();
		}
		return this.mCreditAccountList;	
	}
	public  void setCreditAccountList(List<CreditAccount> creditAccountList){
		for( CreditAccount creditAccount:creditAccountList){
			creditAccount.setBuyer(this);
		}
		
		
		this.mCreditAccountList = creditAccountList;
		
	}
	
	public  void addCreditAccount(CreditAccount creditAccount){
		creditAccount.setBuyer(this);
		getCreditAccountList().add(creditAccount);
	}
	public  void addCreditAccounts(List<CreditAccount> creditAccountList){
		for( CreditAccount creditAccount:creditAccountList){
			creditAccount.setBuyer(this);
		}
		getCreditAccountList().addAll(creditAccountList);
	}
	
	public  void removeCreditAccount(CreditAccount creditAccount){
		getCreditAccountList().remove(creditAccount);
	}
	public  void cleanUpCreditAccountList(){
		getCreditAccountList().clear();
	}
	
	
	
	
	public  List<BillingAddress> getBillingAddressList(){
		if(this.mBillingAddressList == null){
			this.mBillingAddressList = new ArrayList<BillingAddress>();
		}
		return this.mBillingAddressList;	
	}
	public  void setBillingAddressList(List<BillingAddress> billingAddressList){
		for( BillingAddress billingAddress:billingAddressList){
			billingAddress.setCompany(this);
		}
		
		
		this.mBillingAddressList = billingAddressList;
		
	}
	
	public  void addBillingAddress(BillingAddress billingAddress){
		billingAddress.setCompany(this);
		getBillingAddressList().add(billingAddress);
	}
	public  void addBillingAddresses(List<BillingAddress> billingAddressList){
		for( BillingAddress billingAddress:billingAddressList){
			billingAddress.setCompany(this);
		}
		getBillingAddressList().addAll(billingAddressList);
	}
	
	public  void removeBillingAddress(BillingAddress billingAddress){
		getBillingAddressList().remove(billingAddress);
	}
	public  void cleanUpBillingAddressList(){
		getBillingAddressList().clear();
	}
	
	
	
	
	public  List<Employee> getEmployeeList(){
		if(this.mEmployeeList == null){
			this.mEmployeeList = new ArrayList<Employee>();
		}
		return this.mEmployeeList;	
	}
	public  void setEmployeeList(List<Employee> employeeList){
		for( Employee employee:employeeList){
			employee.setCompany(this);
		}
		
		
		this.mEmployeeList = employeeList;
		
	}
	
	public  void addEmployee(Employee employee){
		employee.setCompany(this);
		getEmployeeList().add(employee);
	}
	public  void addEmployees(List<Employee> employeeList){
		for( Employee employee:employeeList){
			employee.setCompany(this);
		}
		getEmployeeList().addAll(employeeList);
	}
	
	public  void removeEmployee(Employee employee){
		getEmployeeList().remove(employee);
	}
	public  void cleanUpEmployeeList(){
		getEmployeeList().clear();
	}
	
	
	
	
	public  List<Order> getOrderList(){
		if(this.mOrderList == null){
			this.mOrderList = new ArrayList<Order>();
		}
		return this.mOrderList;	
	}
	public  void setOrderList(List<Order> orderList){
		for( Order order:orderList){
			order.setBuyer(this);
		}
		
		
		this.mOrderList = orderList;
		
	}
	
	public  void addOrder(Order order){
		order.setBuyer(this);
		getOrderList().add(order);
	}
	public  void addOrders(List<Order> orderList){
		for( Order order:orderList){
			order.setBuyer(this);
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

		stringBuilder.append("buyer_company{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tprice_list='"+getPriceList()+"';");
		stringBuilder.append("\trating='"+getRating()+"';");
		stringBuilder.append("\tlogo='"+getLogo()+"';");
		stringBuilder.append("\towner='"+getOwner()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

