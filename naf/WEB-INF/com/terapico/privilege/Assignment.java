
package com.terapico.privilege;
import java.util.Vector;
import java.util.LinkedList;
import java.util.Collection;
import java.util.Map;
import java.util.Hashtable;
import java.sql.Date;
import org.xml.sax.Attributes;
public class Assignment implements  java.io.Serializable{

	protected		String	mId;
	protected		User	mUser;
	protected		Access	mAccess;
	protected		Date	mAssignedDate;
	protected		int	mxVersion;
	
		
	public 	Assignment(){

	}
	
	public 	Assignment(String	id,User	user,Access	access,Date	assigned_date,int	version)
	{
		setId(id);
		setUser(user);
		setAccess(access);
		setAssignedDate(assigned_date);
		setVersion(version);	
	}
	

	
	public void setId(String id){
		this.mId = id;
	}
	public String getId(){
		return this.mId;
	}
	
	public void setUser(User user){
		this.mUser = user;
	}
	public User getUser(){
		return this.mUser;
	}
	
	public void setAccess(Access access){
		this.mAccess = access;
	}
	public Access getAccess(){
		return this.mAccess;
	}
	
	public void setAssignedDate(Date assigned_date){
		this.mAssignedDate = assigned_date;
	}
	public Date getAssignedDate(){
		return this.mAssignedDate;
	}
	
	public void setVersion(int version){
		this.mxVersion = version;
	}
	public int getVersion(){
		return this.mxVersion;
	}
	
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("assignment{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tuser='user("+getUser().getId()+")';");
		stringBuilder.append("\taccess='access("+getAccess().getId()+")';");
		stringBuilder.append("\tassigned_date='"+getAssignedDate()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

