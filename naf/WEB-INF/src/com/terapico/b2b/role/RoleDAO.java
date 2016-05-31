
package com.terapico.b2b.role;

import java.util.List;
import java.util.Set;
public interface RoleDAO{

	
	public Role load(String roleId,Set<String> options) throws Exception;
	public Role clone(String roleId,Set<String> options) throws Exception;
	
	public Role save(Role role,Set<String> options);
	public List<Role> saveList(List<Role> roleList,Set<String> options);
	
	public void delete(String roleId, int version) throws Exception;
}


