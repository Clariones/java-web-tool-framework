
package com.terapico.b2b;

import java.util.List;

public interface ShippingAddressDAO{

	
	public ShippingAddress load(String shippingAddressId) throws ShippingAddressNotFoundException;
	public ShippingAddress save(ShippingAddress shippingAddress);
	public void delete(String shippingAddressId) throws ShippingAddressNotFoundException;
}


