
package com.terapico.b2b.runrecord;
import com.terapico.b2b.CommonTokens;
import java.util.Map;
public class RunRecordTokens extends CommonTokens{

	
	public static RunRecordTokens start(){
		return new RunRecordTokens();
	}
	public static Map <String,Object> all(){
		return new RunRecordTokens()
			.withDevice()
			.done();
	}
	public static Map <String,Object> withOutLists(){
		return new RunRecordTokens()
			.withDevice()
			.done();
	}
	public static Map <String,Object> empty(){
		return new RunRecordTokens()
			.done();
	}

	protected static final String DEVICE = "device";
	public String getDevice(){
		return DEVICE;
	}
	public RunRecordTokens withDevice(){		
		addSimpleOptions(DEVICE);
		return this;
	}
	
	
}

