
package com.terapico.b2b.delivery;
import com.terapico.b2b.EntityNotFoundException;
public class DeliveryVersionChangedException extends EntityNotFoundException {

	public DeliveryVersionChangedException(String string) {
		super(string);
	}

}
