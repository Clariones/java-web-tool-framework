
package com.terapico.b2b.role;
import com.terapico.b2b.EntityNotFoundException;
public class RoleVersionChangedException extends EntityNotFoundException {

	public RoleVersionChangedException(String string) {
		super(string);
	}

}


