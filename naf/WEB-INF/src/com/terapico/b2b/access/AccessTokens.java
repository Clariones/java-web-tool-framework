
package com.terapico.b2b.access;
import com.terapico.b2b.CommonTokens;
import java.util.Map;
public class AccessTokens extends CommonTokens{

	
	public static AccessTokens start(){
		return new AccessTokens();
	}
	public static Map <String,Object> all(){
		return new AccessTokens()
			.withRole()
			.withAssignmentList()
			.done();
	}
	public static Map <String,Object> withOutLists(){
		return new AccessTokens()
			.withRole()
			.done();
	}
	public static Map <String,Object> empty(){
		return new AccessTokens()
			.done();
	}

	protected static final String ROLE = "role";
	public String getRole(){
		return ROLE;
	}
	public AccessTokens withRole(){		
		addSimpleOptions(ROLE);
		return this;
	}
	
	
	protected static final String ASSIGNMENT_LIST = "assignmentList";
	public String getAssignmentList(){
		return ASSIGNMENT_LIST;
	}
	public AccessTokens withAssignmentList(){		
		addSimpleOptions(ASSIGNMENT_LIST);
		return this;
	}	
		
}

