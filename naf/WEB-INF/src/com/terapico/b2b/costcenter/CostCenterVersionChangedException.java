
package com.terapico.b2b.costcenter;
import com.terapico.b2b.EntityNotFoundException;
public class CostCenterVersionChangedException extends EntityNotFoundException {

	public CostCenterVersionChangedException(String string) {
		super(string);
	}

}
