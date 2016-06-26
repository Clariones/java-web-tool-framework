
package com.terapico.b2b.access;
import com.terapico.b2b.EntityNotFoundException;
public class AccessVersionChangedException extends EntityNotFoundException {

	public AccessVersionChangedException(String string) {
		super(string);
	}

}
