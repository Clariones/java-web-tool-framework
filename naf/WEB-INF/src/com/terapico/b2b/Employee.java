
package com.terapico.b2b;
import java.util.ArrayList;
import java.util.List;

import java.sql.Date;
import org.xml.sax.Attributes;
public class Employee implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mName;
	protected		BuyerCompany	mCompany;
	protected		int	mxVersion;
	
	
	protected		List<Assignment> mAssignmentList;
	
		
	public 	Employee(){

	}
	
	public 	Employee(String	id,String	name,BuyerCompany	company,int	version)
	{
		setId(id);
		setName(name);
		setCompany(company);
		setVersion(version);
		this.mAssignmentList = new ArrayList<Assignment>();	
	}
	

	
	public void setId(String id){
		this.mId = id;
	}
	public String getId(){
		return this.mId;
	}
	
	public void setName(String name){
		this.mName = name;
	}
	public String getName(){
		return this.mName;
	}
	
	public void setCompany(BuyerCompany company){
		this.mCompany = company;
	}
	public BuyerCompany getCompany(){
		return this.mCompany;
	}
	
	public void setVersion(int version){
		this.mxVersion = version;
	}
	public int getVersion(){
		return this.mxVersion;
	}
	
	public  List<Assignment> getAssignmentList(){
		if(this.mAssignmentList == null){
			this.mAssignmentList = new ArrayList<Assignment>();
		}
		return this.mAssignmentList;	
	}
	public  void setAssignmentList(List<Assignment> Assignments){
		this.mAssignmentList=Assignments;
		
	}
	
	public  void addAssignment(Assignment assignment){
		getAssignmentList().add(assignment);
	}
	public  void addAssignments(List<Assignment> assignments){
		getAssignmentList().addAll(assignments);
	}
	
	public  void removeAssignment(Assignment assignment){
		getAssignmentList().remove(assignment);
	}
	
	
	
	
	
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("employee{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tcompany='buyer_company("+getCompany().getId()+")';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

