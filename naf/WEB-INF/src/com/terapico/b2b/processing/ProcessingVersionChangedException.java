
package com.terapico.b2b.processing;
import com.terapico.b2b.EntityNotFoundException;
public class ProcessingVersionChangedException extends EntityNotFoundException {

	public ProcessingVersionChangedException(String string) {
		super(string);
	}

}
