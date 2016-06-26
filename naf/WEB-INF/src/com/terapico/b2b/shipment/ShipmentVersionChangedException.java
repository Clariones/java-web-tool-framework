
package com.terapico.b2b.shipment;
import com.terapico.b2b.EntityNotFoundException;
public class ShipmentVersionChangedException extends EntityNotFoundException {

	public ShipmentVersionChangedException(String string) {
		super(string);
	}

}
