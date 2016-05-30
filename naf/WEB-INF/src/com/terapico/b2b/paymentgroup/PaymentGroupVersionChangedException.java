
package com.terapico.b2b.paymentgroup;
import com.terapico.b2b.EntityNotFoundException;
public class PaymentGroupVersionChangedException extends EntityNotFoundException {

	public PaymentGroupVersionChangedException(String string) {
		super(string);
	}

}


