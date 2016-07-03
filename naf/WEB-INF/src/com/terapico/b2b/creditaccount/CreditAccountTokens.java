
package com.terapico.b2b.creditaccount;
import com.terapico.b2b.CommonTokens;
import java.util.Map;
public class CreditAccountTokens extends CommonTokens{

	
	public static CreditAccountTokens start(){
		return new CreditAccountTokens();
	}
	public static Map <String,Object> all(){
		return new CreditAccountTokens()
			.withBuyer()
			.withSeller()
			.done();
	}
	public static Map <String,Object> withOutLists(){
		return new CreditAccountTokens()
			.withBuyer()
			.withSeller()
			.done();
	}
	public static Map <String,Object> empty(){
		return new CreditAccountTokens()
			.done();
	}

	protected static final String BUYER = "buyer";
	public String getBuyer(){
		return BUYER;
	}
	public CreditAccountTokens withBuyer(){		
		addSimpleOptions(BUYER);
		return this;
	}
	
	
	protected static final String SELLER = "seller";
	public String getSeller(){
		return SELLER;
	}
	public CreditAccountTokens withSeller(){		
		addSimpleOptions(SELLER);
		return this;
	}
	
	
}

