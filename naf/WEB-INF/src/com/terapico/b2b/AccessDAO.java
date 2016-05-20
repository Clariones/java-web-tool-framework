
package com.terapico.b2b;

import java.util.List;

public interface AccessDAO{

	
	public Access load(String accessId) throws AccessNotFoundException;
	public Access save(Access access);
	public void delete(String accessId) throws AccessNotFoundException;
 	public List<Access> findAccessByRole(String roleId);
 }


