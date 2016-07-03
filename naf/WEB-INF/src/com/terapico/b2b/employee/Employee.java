
package com.terapico.b2b.employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.assignment.Assignment;

@JsonSerialize(using = EmployeeSerializer.class)
public class Employee implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mName;
	protected		BuyerCompany	mCompany;
	protected		String	mEmail;
	protected		String	mPasswd;
	protected		String	mCellPhone;
	protected		int	mVersion;
	
	
	protected		List<Assignment> mAssignmentList;
	
		
	public 	Employee(){
		//lazy load for all the properties
	}
	
	public 	Employee(String name, BuyerCompany company, String email, String passwd, String cellPhone)
	{
		setName(name);
		setCompany(company);
		setEmail(email);
		setPasswd(passwd);
		setCellPhone(cellPhone);
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
	
	public void setPasswd(String passwd){
		this.mPasswd = passwd;
	}
	public String getPasswd(){
		return this.mPasswd;
	}
	
	public void setCellPhone(String cellPhone){
		this.mCellPhone = cellPhone;
	}
	public String getCellPhone(){
		return this.mCellPhone;
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
		stringBuilder.append("\tpasswd='"+getPasswd()+"';");
		stringBuilder.append("\tcell_phone='"+getCellPhone()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

