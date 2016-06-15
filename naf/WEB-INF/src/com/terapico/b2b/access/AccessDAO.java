
package com.terapico.b2b.access;

import java.util.List;
import java.util.Set;
import java.util.Map;
public interface AccessDAO{

	
	public Access load(String accessId,Map<String,Object> options) throws Exception;
	public Access clone(String accessId,Map<String,Object> options) throws Exception;
	
	public Access save(Access access,Map<String,Object> options);
	public List<Access> saveList(List<Access> accessList,Map<String,Object> options);
	
	public void delete(String accessId, int version) throws Exception;
	public int deleteAll() throws Exception;
 	public List<Access> findAccessByRole(String roleId);
 }


