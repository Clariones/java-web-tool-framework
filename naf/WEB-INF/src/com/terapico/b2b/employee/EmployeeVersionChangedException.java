
package com.terapico.b2b.employee;
import com.terapico.b2b.EntityNotFoundException;
public class EmployeeVersionChangedException extends EntityNotFoundException {

	public EmployeeVersionChangedException(String string) {
		super(string);
	}

}


