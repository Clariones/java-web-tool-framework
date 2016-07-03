
package com.terapico.b2b.costcenter;
import com.terapico.b2b.CommonTokens;
import java.util.Map;
public class CostCenterTokens extends CommonTokens{

	
	public static CostCenterTokens start(){
		return new CostCenterTokens();
	}
	public static Map <String,Object> all(){
		return new CostCenterTokens()
			.withBelongsTo()
			.withOrderList()
			.done();
	}
	public static Map <String,Object> withOutLists(){
		return new CostCenterTokens()
			.withBelongsTo()
			.done();
	}
	public static Map <String,Object> empty(){
		return new CostCenterTokens()
			.done();
	}

	protected static final String BELONGSTO = "belongsTo";
	public String getBelongsTo(){
		return BELONGSTO;
	}
	public CostCenterTokens withBelongsTo(){		
		addSimpleOptions(BELONGSTO);
		return this;
	}
	
	
	protected static final String ORDER_LIST = "orderList";
	public String getOrderList(){
		return ORDER_LIST;
	}
	public CostCenterTokens withOrderList(){		
		addSimpleOptions(ORDER_LIST);
		return this;
	}	
		
}

