
package com.terapico.b2b.assignment;
import com.terapico.b2b.CommonTokens;
import java.util.Map;
public class AssignmentTokens extends CommonTokens{

	
	public static AssignmentTokens start(){
		return new AssignmentTokens();
	}
	public static Map <String,Object> all(){
		return new AssignmentTokens()
			.withUser()
			.withAccess()
			.done();
	}
	public static Map <String,Object> withOutLists(){
		return new AssignmentTokens()
			.withUser()
			.withAccess()
			.done();
	}
	public static Map <String,Object> empty(){
		return new AssignmentTokens()
			.done();
	}

	protected static final String USER = "user";
	public String getUser(){
		return USER;
	}
	public AssignmentTokens withUser(){		
		addSimpleOptions(USER);
		return this;
	}
	
	
	protected static final String ACCESS = "access";
	public String getAccess(){
		return ACCESS;
	}
	public AssignmentTokens withAccess(){		
		addSimpleOptions(ACCESS);
		return this;
	}
	
	
}

