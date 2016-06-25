
package com.terapico.b2b.billingaddress;
import com.terapico.b2b.CommonTokens;
import java.util.Map;
public class BillingAddressTokens extends CommonTokens{

	
	public static BillingAddressTokens start(){
		return new BillingAddressTokens();
	}
	public static Map <String,Object> all(){
		return new BillingAddressTokens()
			.withCompany()
			.withPaymentGroupList()
			.done();
	}
	public static Map <String,Object> withOutLists(){
		return new BillingAddressTokens()
			.withCompany()
			.done();
	}
	public static Map <String,Object> empty(){
		return new BillingAddressTokens()
			.done();
	}

	protected static final String COMPANY = "company";
	public String getCompany(){
		return COMPANY;
	}
	public BillingAddressTokens withCompany(){		
		addSimpleOptions(COMPANY);
		return this;
	}
	
	
	protected static final String PAYMENT_GROUP_LIST = "paymentGroupList";
	public String getPaymentGroupList(){
		return PAYMENT_GROUP_LIST;
	}
	public BillingAddressTokens withPaymentGroupList(){		
		addSimpleOptions(PAYMENT_GROUP_LIST);
		return this;
	}	
		
}

