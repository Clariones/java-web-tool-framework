
package com.terapico.b2b.runrecord;

import java.util.List;
import java.util.Set;
import java.util.Map;
public interface RunRecordDAO{

	
	public RunRecord load(String runRecordId,Map<String,Object> options) throws Exception;
	public RunRecord clone(String runRecordId,Map<String,Object> options) throws Exception;
	
	public RunRecord save(RunRecord runRecord,Map<String,Object> options);
	public List<RunRecord> saveList(List<RunRecord> runRecordList,Map<String,Object> options);
	
	public void delete(String runRecordId, int version) throws Exception;
	public int deleteAll() throws Exception;
 	public List<RunRecord> findRunRecordByDevice(String deviceId);
 }


