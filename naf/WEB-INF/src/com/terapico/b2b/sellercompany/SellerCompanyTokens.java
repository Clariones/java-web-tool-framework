
package com.terapico.b2b.sellercompany;
import com.terapico.b2b.CommonTokens;
import java.util.Map;
public class SellerCompanyTokens extends CommonTokens{

	
	public static SellerCompanyTokens start(){
		return new SellerCompanyTokens();
	}
	public static Map <String,Object> all(){
		return new SellerCompanyTokens()
			.withOrderList()
			.withCustSvcRepList()
			.done();
	}
	public static Map <String,Object> withOutLists(){
		return new SellerCompanyTokens()
			.done();
	}
	public static Map <String,Object> empty(){
		return new SellerCompanyTokens()
			.done();
	}

	protected static final String ORDER_LIST = "orderList";
	public String getOrderList(){
		return ORDER_LIST;
	}
	public SellerCompanyTokens withOrderList(){		
		addSimpleOptions(ORDER_LIST);
		return this;
	}	
		
	protected static final String CUST_SVC_REP_LIST = "custSvcRepList";
	public String getCustSvcRepList(){
		return CUST_SVC_REP_LIST;
	}
	public SellerCompanyTokens withCustSvcRepList(){		
		addSimpleOptions(CUST_SVC_REP_LIST);
		return this;
	}	
		
}

