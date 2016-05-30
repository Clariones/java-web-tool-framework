
package com.terapico.b2b.assignment;
import java.util.ArrayList;
import java.util.List;

import java.sql.Date;
import org.xml.sax.Attributes;


import com.terapico.b2b.access.Access;
import com.terapico.b2b.employee.Employee;


public class Assignment implements  java.io.Serializable{

	protected		String	mId;
	protected		Employee	mUser;
	protected		Access	mAccess;
	protected		Date	mAssignedDate;
	protected		int	mxVersion;
	
	
	
		
	public 	Assignment(){

	}
	
	public 	Assignment(String	id,Employee	user,Access	access,Date	assigned_date,int	version)
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
	
	public void setUser(Employee user){
		this.mUser = user;
	}
	public Employee getUser(){
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
		stringBuilder.append("\tuser='employee("+getUser().getId()+")';");
		stringBuilder.append("\taccess='access("+getAccess().getId()+")';");
		stringBuilder.append("\tassigned_date='"+getAssignedDate()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

