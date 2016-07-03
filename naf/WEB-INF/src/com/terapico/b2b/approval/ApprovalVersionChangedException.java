
package com.terapico.b2b.approval;
import com.terapico.b2b.EntityNotFoundException;
public class ApprovalVersionChangedException extends EntityNotFoundException {

	public ApprovalVersionChangedException(String string) {
		super(string);
	}

}
