
package com.terapico.b2b.employee;
import com.terapico.b2b.CommonTokens;
import java.util.Map;
public class EmployeeTokens extends CommonTokens{

	
	public static EmployeeTokens start(){
		return new EmployeeTokens();
	}
	public static Map <String,Object> all(){
		return new EmployeeTokens()
			.withCompany()
			.withAssignmentList()
			.done();
	}
	public static Map <String,Object> withOutLists(){
		return new EmployeeTokens()
			.withCompany()
			.done();
	}
	public static Map <String,Object> empty(){
		return new EmployeeTokens()
			.done();
	}

	protected static final String COMPANY = "company";
	public String getCompany(){
		return COMPANY;
	}
	public EmployeeTokens withCompany(){		
		addSimpleOptions(COMPANY);
		return this;
	}
	
	
	protected static final String ASSIGNMENT_LIST = "assignmentList";
	public String getAssignmentList(){
		return ASSIGNMENT_LIST;
	}
	public EmployeeTokens withAssignmentList(){		
		addSimpleOptions(ASSIGNMENT_LIST);
		return this;
	}	
		
}

