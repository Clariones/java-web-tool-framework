
package com.terapico.b2b.order;
import com.terapico.b2b.EntityNotFoundException;
public class OrderVersionChangedException extends EntityNotFoundException {

	public OrderVersionChangedException(String string) {
		super(string);
	}

}


