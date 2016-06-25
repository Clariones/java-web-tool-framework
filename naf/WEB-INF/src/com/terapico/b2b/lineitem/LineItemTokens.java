
package com.terapico.b2b.lineitem;
import com.terapico.b2b.CommonTokens;
import java.util.Map;
public class LineItemTokens extends CommonTokens{

	
	public static LineItemTokens start(){
		return new LineItemTokens();
	}
	public static Map <String,Object> all(){
		return new LineItemTokens()
			.withBizOrder()
			.done();
	}
	public static Map <String,Object> withOutLists(){
		return new LineItemTokens()
			.withBizOrder()
			.done();
	}
	public static Map <String,Object> empty(){
		return new LineItemTokens()
			.done();
	}

	protected static final String BIZORDER = "bizOrder";
	public String getBizOrder(){
		return BIZORDER;
	}
	public LineItemTokens withBizOrder(){		
		addSimpleOptions(BIZORDER);
		return this;
	}
	
	
}

