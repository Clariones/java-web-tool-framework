
package com.terapico.b2b.billingaddress;
import com.terapico.b2b.EntityNotFoundException;
public class BillingAddressVersionChangedException extends EntityNotFoundException {

	public BillingAddressVersionChangedException(String string) {
		super(string);
	}

}


