
package com.terapico.b2b.confirmation;
import com.terapico.b2b.EntityNotFoundException;
public class ConfirmationVersionChangedException extends EntityNotFoundException {

	public ConfirmationVersionChangedException(String string) {
		super(string);
	}

}
