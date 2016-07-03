
package com.terapico.b2b.device;

import java.util.List;
import java.util.Set;
import java.util.Map;
public interface DeviceDAO{

	
	public Device load(String deviceId,Map<String,Object> options) throws Exception;
	public Device clone(String deviceId,Map<String,Object> options) throws Exception;
	
	public Device save(Device device,Map<String,Object> options);
	public List<Device> saveList(List<Device> deviceList,Map<String,Object> options);
	
	public void delete(String deviceId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


