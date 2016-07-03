
package com.terapico.b2b.buyercompany;
import com.terapico.b2b.CommonTokens;
import java.util.Map;
public class BuyerCompanyTokens extends CommonTokens{

	
	public static BuyerCompanyTokens start(){
		return new BuyerCompanyTokens();
	}
	public static Map <String,Object> all(){
		return new BuyerCompanyTokens()
			.withCostCenterList()
			.withCreditAccountList()
			.withBillingAddressList()
			.withEmployeeList()
			.withOrderList()
			.done();
	}
	public static Map <String,Object> withOutLists(){
		return new BuyerCompanyTokens()
			.done();
	}
	public static Map <String,Object> empty(){
		return new BuyerCompanyTokens()
			.done();
	}

	protected static final String COST_CENTER_LIST = "costCenterList";
	public String getCostCenterList(){
		return COST_CENTER_LIST;
	}
	public BuyerCompanyTokens withCostCenterList(){		
		addSimpleOptions(COST_CENTER_LIST);
		return this;
	}	
		
	protected static final String CREDIT_ACCOUNT_LIST = "creditAccountList";
	public String getCreditAccountList(){
		return CREDIT_ACCOUNT_LIST;
	}
	public BuyerCompanyTokens withCreditAccountList(){		
		addSimpleOptions(CREDIT_ACCOUNT_LIST);
		return this;
	}	
		
	protected static final String BILLING_ADDRESS_LIST = "billingAddressList";
	public String getBillingAddressList(){
		return BILLING_ADDRESS_LIST;
	}
	public BuyerCompanyTokens withBillingAddressList(){		
		addSimpleOptions(BILLING_ADDRESS_LIST);
		return this;
	}	
		
	protected static final String EMPLOYEE_LIST = "employeeList";
	public String getEmployeeList(){
		return EMPLOYEE_LIST;
	}
	public BuyerCompanyTokens withEmployeeList(){		
		addSimpleOptions(EMPLOYEE_LIST);
		return this;
	}	
		
	protected static final String ORDER_LIST = "orderList";
	public String getOrderList(){
		return ORDER_LIST;
	}
	public BuyerCompanyTokens withOrderList(){		
		addSimpleOptions(ORDER_LIST);
		return this;
	}	
		
}

