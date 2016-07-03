
package com.terapico.b2b.runrecord;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;



import com.terapico.b2b.device.Device;


public class RunRecord implements  java.io.Serializable{

	protected		String	mId;
	protected		Device	mDevice;
	protected		String	mRunDuration;
	protected		int	mVersion;
	
	
	
		
	public 	RunRecord(){
		//lazy load for all the properties
	}
	
	public 	RunRecord(Device device, String runDuration)
	{
		setDevice(device);
		setRunDuration(runDuration);	
	}
	

	
	public void setId(String id){
		this.mId = id;
	}
	public String getId(){
		return this.mId;
	}
	
	public void setDevice(Device device){
		this.mDevice = device;
	}
	public Device getDevice(){
		return this.mDevice;
	}
	
	public void setRunDuration(String runDuration){
		this.mRunDuration = runDuration;
	}
	public String getRunDuration(){
		return this.mRunDuration;
	}
	
	public void setVersion(int version){
		this.mVersion = version;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("run_record{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tdevice='device("+getDevice().getId()+")';");
		stringBuilder.append("\trun_duration='"+getRunDuration()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

