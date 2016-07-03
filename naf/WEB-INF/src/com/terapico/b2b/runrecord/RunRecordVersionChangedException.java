
package com.terapico.b2b.runrecord;
import com.terapico.b2b.EntityNotFoundException;
public class RunRecordVersionChangedException extends EntityNotFoundException {

	public RunRecordVersionChangedException(String string) {
		super(string);
	}

}
