
package com.terapico.b2b.access;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;



import com.terapico.b2b.role.Role;
import com.terapico.b2b.assignment.Assignment;


public class Access implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mRoleName;
	protected		Role	mRole;
	protected		int	mVersion;
	
	
	protected		List<Assignment> mAssignmentList;
	
		
	public 	Access(){
		//lazy load for all the properties
	}
	
	public 	Access(String roleName, Role role)
	{
		setRoleName(roleName);
		setRole(role);
		this.mAssignmentList = new ArrayList<Assignment>();	
	}
	

	
	public void setId(String id){
		this.mId = id;
	}
	public String getId(){
		return this.mId;
	}
	
	public void setRoleName(String roleName){
		this.mRoleName = roleName;
	}
	public String getRoleName(){
		return this.mRoleName;
	}
	
	public void setRole(Role role){
		this.mRole = role;
	}
	public Role getRole(){
		return this.mRole;
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
			assignment.setAccess(this);
		}
		
		
		this.mAssignmentList = assignmentList;
		
	}
	
	public  void addAssignment(Assignment assignment){
		assignment.setAccess(this);
		getAssignmentList().add(assignment);
	}
	public  void addAssignments(List<Assignment> assignmentList){
		for( Assignment assignment:assignmentList){
			assignment.setAccess(this);
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

		stringBuilder.append("access{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\trole_name='"+getRoleName()+"';");
		stringBuilder.append("\trole='role("+getRole().getId()+")';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

