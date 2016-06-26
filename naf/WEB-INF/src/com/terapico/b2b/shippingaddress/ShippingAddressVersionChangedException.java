
package com.terapico.b2b.shippingaddress;
import com.terapico.b2b.EntityNotFoundException;
public class ShippingAddressVersionChangedException extends EntityNotFoundException {

	public ShippingAddressVersionChangedException(String string) {
		super(string);
	}

}
