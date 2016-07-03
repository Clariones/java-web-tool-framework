
package com.terapico.b2b.profitcenter;
import com.terapico.b2b.CommonTokens;
import java.util.Map;
public class ProfitCenterTokens extends CommonTokens{

	
	public static ProfitCenterTokens start(){
		return new ProfitCenterTokens();
	}
	public static Map <String,Object> all(){
		return new ProfitCenterTokens()
			.withBelongsTo()
			.withOrderList()
			.done();
	}
	public static Map <String,Object> withOutLists(){
		return new ProfitCenterTokens()
			.withBelongsTo()
			.done();
	}
	public static Map <String,Object> empty(){
		return new ProfitCenterTokens()
			.done();
	}

	protected static final String BELONGSTO = "belongsTo";
	public String getBelongsTo(){
		return BELONGSTO;
	}
	public ProfitCenterTokens withBelongsTo(){		
		addSimpleOptions(BELONGSTO);
		return this;
	}
	
	
	protected static final String ORDER_LIST = "orderList";
	public String getOrderList(){
		return ORDER_LIST;
	}
	public ProfitCenterTokens withOrderList(){		
		addSimpleOptions(ORDER_LIST);
		return this;
	}	
		
}

