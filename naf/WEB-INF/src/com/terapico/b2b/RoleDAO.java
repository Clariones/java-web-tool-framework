
package com.terapico.b2b;

import java.util.List;

public interface RoleDAO{

	
	public Role load(String roleId) throws RoleNotFoundException;
	public Role save(Role role);
	public void delete(String roleId) throws RoleNotFoundException;
}


