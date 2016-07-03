
package com.terapico.b2b.profitcenter;

import java.util.List;
import java.util.Set;
import java.util.Map;
public interface ProfitCenterDAO{

	
	public ProfitCenter load(String profitCenterId,Map<String,Object> options) throws Exception;
	public ProfitCenter clone(String profitCenterId,Map<String,Object> options) throws Exception;
	
	public ProfitCenter save(ProfitCenter profitCenter,Map<String,Object> options);
	public List<ProfitCenter> saveList(List<ProfitCenter> profitCenterList,Map<String,Object> options);
	
	public void delete(String profitCenterId, int version) throws Exception;
	public int deleteAll() throws Exception;
 	public List<ProfitCenter> findProfitCenterByBelongsTo(String sellerCompanyId);
 }


