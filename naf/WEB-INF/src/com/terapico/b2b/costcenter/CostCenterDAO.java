
package com.terapico.b2b.costcenter;

import java.util.List;
import java.util.Set;
import java.util.Map;
public interface CostCenterDAO{

	
	public CostCenter load(String costCenterId,Map<String,Object> options) throws Exception;
	public CostCenter clone(String costCenterId,Map<String,Object> options) throws Exception;
	
	public CostCenter save(CostCenter costCenter,Map<String,Object> options);
	public List<CostCenter> saveList(List<CostCenter> costCenterList,Map<String,Object> options);
	
	public void delete(String costCenterId, int version) throws Exception;
	public int deleteAll() throws Exception;
 	public List<CostCenter> findCostCenterByBelongsTo(String buyerCompanyId);
 }


