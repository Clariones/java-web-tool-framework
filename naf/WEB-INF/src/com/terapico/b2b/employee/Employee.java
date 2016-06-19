
package com.terapico.b2b.employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;



import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.assignment.Assignment;


public class Employee implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mName;
	protected		BuyerCompany	mCompany;
	protected		String	mEmail;
	protected		int	mVersion;
	
	
	protected		List<Assignment> mAssignmentList;
	
		
	public 	Employee(){

	}
	
	public 	Employee(String	id,String	name,BuyerCompany	company,String	email,int	version)
	{
		setId(id);
		setName(name);
		setCompany(company);
		setEmail(email);
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
	
	public void setEmail(String email){
		this.mEmail = email;
	}
	public String getEmail(){
		return this.mEmail;
	}
	
	public void setVersion(int version){
		this.mVersion = version;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	public  List<Assignment> getAssignmentList(){
		if(this.mAssignmentList == null){
			this.mAssignmentList = new ArrayList<Assignment>();
		}
		return this.mAssignmentList;	
	}
	public  void setAssignmentList(List<Assignment> assignmentList){
		for( Assignment assignment:assignmentList){
			assignment.setUser(this);
		}
		
		
		this.mAssignmentList = assignmentList;
		
	}
	
	public  void addAssignment(Assignment assignment){
		assignment.setUser(this);
		getAssignmentList().add(assignment);
	}
	public  void addAssignments(List<Assignment> assignmentList){
		for( Assignment assignment:assignmentList){
			assignment.setUser(this);
		}
		getAssignmentList().addAll(assignmentList);
	}
	
	public  void removeAssignment(Assignment assignment){
		getAssignmentList().remove(assignment);
	}
	public  void cleanUpAssignmentList(){
		getAssignmentList().clear();
	}
	
	
	
	
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("employee{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tcompany='buyer_company("+getCompany().getId()+")';");
		stringBuilder.append("\temail='"+getEmail()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

