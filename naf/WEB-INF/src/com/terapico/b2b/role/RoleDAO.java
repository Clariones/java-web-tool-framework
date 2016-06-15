
package com.terapico.b2b.role;

import java.util.List;
import java.util.Set;
import java.util.Map;
public interface RoleDAO{

	
	public Role load(String roleId,Map<String,Object> options) throws Exception;
	public Role clone(String roleId,Map<String,Object> options) throws Exception;
	
	public Role save(Role role,Map<String,Object> options);
	public List<Role> saveList(List<Role> roleList,Map<String,Object> options);
	
	public void delete(String roleId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


