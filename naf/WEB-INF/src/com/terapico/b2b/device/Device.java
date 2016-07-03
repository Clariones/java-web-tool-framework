
package com.terapico.b2b.device;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;



import com.terapico.b2b.runrecord.RunRecord;


public class Device implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mPasswrd;
	protected		int	mVersion;
	
	
	protected		List<RunRecord> mRunRecordList;
	
		
	public 	Device(){
		//lazy load for all the properties
	}
	
	public 	Device(String passwrd)
	{
		setPasswrd(passwrd);
		this.mRunRecordList = new ArrayList<RunRecord>();	
	}
	

	
	public void setId(String id){
		this.mId = id;
	}
	public String getId(){
		return this.mId;
	}
	
	public void setPasswrd(String passwrd){
		this.mPasswrd = passwrd;
	}
	public String getPasswrd(){
		return this.mPasswrd;
	}
	
	public void setVersion(int version){
		this.mVersion = version;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	public  List<RunRecord> getRunRecordList(){
		if(this.mRunRecordList == null){
			this.mRunRecordList = new ArrayList<RunRecord>();
		}
		return this.mRunRecordList;	
	}
	public  void setRunRecordList(List<RunRecord> runRecordList){
		for( RunRecord runRecord:runRecordList){
			runRecord.setDevice(this);
		}
		
		
		this.mRunRecordList = runRecordList;
		
	}
	
	public  void addRunRecord(RunRecord runRecord){
		runRecord.setDevice(this);
		getRunRecordList().add(runRecord);
	}
	public  void addRunRecords(List<RunRecord> runRecordList){
		for( RunRecord runRecord:runRecordList){
			runRecord.setDevice(this);
		}
		getRunRecordList().addAll(runRecordList);
	}
	
	public  void removeRunRecord(RunRecord runRecord){
		getRunRecordList().remove(runRecord);
	}
	public  void cleanUpRunRecordList(){
		getRunRecordList().clear();
	}
	
	
	
	
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("device{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tpasswrd='"+getPasswrd()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

