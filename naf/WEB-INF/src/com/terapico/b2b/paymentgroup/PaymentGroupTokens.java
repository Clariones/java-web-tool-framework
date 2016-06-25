
package com.terapico.b2b.paymentgroup;
import com.terapico.b2b.CommonTokens;
import java.util.Map;
public class PaymentGroupTokens extends CommonTokens{

	
	public static PaymentGroupTokens start(){
		return new PaymentGroupTokens();
	}
	public static Map <String,Object> all(){
		return new PaymentGroupTokens()
			.withBizOrder()
			.withBillingAddress()
			.done();
	}
	public static Map <String,Object> withOutLists(){
		return new PaymentGroupTokens()
			.withBizOrder()
			.withBillingAddress()
			.done();
	}
	public static Map <String,Object> empty(){
		return new PaymentGroupTokens()
			.done();
	}

	protected static final String BIZORDER = "bizOrder";
	public String getBizOrder(){
		return BIZORDER;
	}
	public PaymentGroupTokens withBizOrder(){		
		addSimpleOptions(BIZORDER);
		return this;
	}
	
	
	protected static final String BILLINGADDRESS = "billingAddress";
	public String getBillingAddress(){
		return BILLINGADDRESS;
	}
	public PaymentGroupTokens withBillingAddress(){		
		addSimpleOptions(BILLINGADDRESS);
		return this;
	}
	
	
}

