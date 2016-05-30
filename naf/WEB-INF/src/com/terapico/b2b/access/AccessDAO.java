
package com.terapico.b2b.access;

import java.util.List;
import java.util.Set;
public interface AccessDAO{

	
	public Access load(String accessId,Set<String> options) throws AccessNotFoundException;
	public Access clone(String accessId,Set<String> options) throws AccessNotFoundException;
	
	public Access save(Access access,Set<String> options);
	public List<Access> saveList(List<Access> accessList,Set<String> options);
	
	public void delete(String accessId, int version) throws Exception;
 	public List<Access> findAccessByRole(String roleId);
 }


