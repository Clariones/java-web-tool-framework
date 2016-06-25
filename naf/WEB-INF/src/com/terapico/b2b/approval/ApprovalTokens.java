
package com.terapico.b2b.approval;
import com.terapico.b2b.CommonTokens;
import java.util.Map;
public class ApprovalTokens extends CommonTokens{

	
	public static ApprovalTokens start(){
		return new ApprovalTokens();
	}
	public static Map <String,Object> all(){
		return new ApprovalTokens()
			.withOrderList()
			.done();
	}
	public static Map <String,Object> withOutLists(){
		return new ApprovalTokens()
			.done();
	}
	public static Map <String,Object> empty(){
		return new ApprovalTokens()
			.done();
	}

	protected static final String ORDER_LIST = "orderList";
	public String getOrderList(){
		return ORDER_LIST;
	}
	public ApprovalTokens withOrderList(){		
		addSimpleOptions(ORDER_LIST);
		return this;
	}	
		
}

