
package com.terapico.b2b.custsvcrep;
import com.terapico.b2b.CommonTokens;
import java.util.Map;
public class CustSvcRepTokens extends CommonTokens{

	
	public static CustSvcRepTokens start(){
		return new CustSvcRepTokens();
	}
	public static Map <String,Object> all(){
		return new CustSvcRepTokens()
			.withRole()
			.withCompany()
			.done();
	}
	public static Map <String,Object> withOutLists(){
		return new CustSvcRepTokens()
			.withRole()
			.withCompany()
			.done();
	}
	public static Map <String,Object> empty(){
		return new CustSvcRepTokens()
			.done();
	}

	protected static final String ROLE = "role";
	public String getRole(){
		return ROLE;
	}
	public CustSvcRepTokens withRole(){		
		addSimpleOptions(ROLE);
		return this;
	}
	
	
	protected static final String COMPANY = "company";
	public String getCompany(){
		return COMPANY;
	}
	public CustSvcRepTokens withCompany(){		
		addSimpleOptions(COMPANY);
		return this;
	}
	
	
}

