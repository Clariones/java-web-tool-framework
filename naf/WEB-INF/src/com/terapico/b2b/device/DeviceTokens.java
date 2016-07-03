
package com.terapico.b2b.device;
import com.terapico.b2b.CommonTokens;
import java.util.Map;
public class DeviceTokens extends CommonTokens{

	
	public static DeviceTokens start(){
		return new DeviceTokens();
	}
	public static Map <String,Object> all(){
		return new DeviceTokens()
			.withRunRecordList()
			.done();
	}
	public static Map <String,Object> withOutLists(){
		return new DeviceTokens()
			.done();
	}
	public static Map <String,Object> empty(){
		return new DeviceTokens()
			.done();
	}

	protected static final String RUN_RECORD_LIST = "runRecordList";
	public String getRunRecordList(){
		return RUN_RECORD_LIST;
	}
	public DeviceTokens withRunRecordList(){		
		addSimpleOptions(RUN_RECORD_LIST);
		return this;
	}	
		
}

