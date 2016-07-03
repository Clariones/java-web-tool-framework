
package com.terapico.b2b.device;
import com.terapico.b2b.EntityNotFoundException;
public class DeviceVersionChangedException extends EntityNotFoundException {

	public DeviceVersionChangedException(String string) {
		super(string);
	}

}
