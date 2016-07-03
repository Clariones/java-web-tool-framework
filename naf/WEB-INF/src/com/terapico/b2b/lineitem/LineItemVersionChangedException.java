
package com.terapico.b2b.lineitem;
import com.terapico.b2b.EntityNotFoundException;
public class LineItemVersionChangedException extends EntityNotFoundException {

	public LineItemVersionChangedException(String string) {
		super(string);
	}

}
