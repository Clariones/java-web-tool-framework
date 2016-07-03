
package com.terapico.b2b.shippinggroup;
import com.terapico.b2b.EntityNotFoundException;
public class ShippingGroupVersionChangedException extends EntityNotFoundException {

	public ShippingGroupVersionChangedException(String string) {
		super(string);
	}

}
