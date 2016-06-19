
package com.terapico.b2b.access;

import java.util.List;
import java.util.Set;
public interface AccessService{

	
	public Access createAccess(String accessId,String[] options) throws Exception;
	public Access clone(String accessId, String[] options) throws Exception;
	
	public Access save(Access access,String[] options);
	public List<Access> saveList(List<Access> accessList,String[] options);
	
	public void delete(String accessId, int version) throws Exception;
	public int deleteAll() throws Exception;
 	public List<Access> findAccessByRole(String roleId);
 }


