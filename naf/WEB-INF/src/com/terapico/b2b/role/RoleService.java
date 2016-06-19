
package com.terapico.b2b.role;

import java.util.List;
import java.util.Set;
public interface RoleService{

	
	public Role createRole(String roleId,String[] options) throws Exception;
	public Role clone(String roleId, String[] options) throws Exception;
	
	public Role save(Role role,String[] options);
	public List<Role> saveList(List<Role> roleList,String[] options);
	
	public void delete(String roleId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


