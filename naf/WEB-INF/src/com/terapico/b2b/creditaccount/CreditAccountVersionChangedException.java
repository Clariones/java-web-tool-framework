
package com.terapico.b2b.creditaccount;
import com.terapico.b2b.EntityNotFoundException;
public class CreditAccountVersionChangedException extends EntityNotFoundException {

	public CreditAccountVersionChangedException(String string) {
		super(string);
	}

}
