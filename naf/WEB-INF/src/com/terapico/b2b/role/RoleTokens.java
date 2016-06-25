
package com.terapico.b2b.role;
import com.terapico.b2b.CommonTokens;
import java.util.Map;
public class RoleTokens extends CommonTokens{

	
	public static RoleTokens start(){
		return new RoleTokens();
	}
	public static Map <String,Object> all(){
		return new RoleTokens()
			.withAccessList()
			.withCustSvcRepList()
			.done();
	}
	public static Map <String,Object> withOutLists(){
		return new RoleTokens()
			.done();
	}
	public static Map <String,Object> empty(){
		return new RoleTokens()
			.done();
	}

	protected static final String ACCESS_LIST = "accessList";
	public String getAccessList(){
		return ACCESS_LIST;
	}
	public RoleTokens withAccessList(){		
		addSimpleOptions(ACCESS_LIST);
		return this;
	}	
		
	protected static final String CUST_SVC_REP_LIST = "custSvcRepList";
	public String getCustSvcRepList(){
		return CUST_SVC_REP_LIST;
	}
	public RoleTokens withCustSvcRepList(){		
		addSimpleOptions(CUST_SVC_REP_LIST);
		return this;
	}	
		
}

