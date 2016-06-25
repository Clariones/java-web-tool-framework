package com.terapico.b2b;

import java.util.HashMap;
import java.util.Map;

public class CommonOptions {
	Map <String,Object> options;
	public Map <String,Object> done()
	{
		ensureOptions();
		return options;
	}
	
	protected void addSimpleOptions(String key){
		ensureOptions();
		options.put(key, key);
	}
	protected void addMapOptions(String key, Object value){
		ensureOptions();
		options.put(key, value);
		
	}
	protected void ensureOptions()
	{
		if(options == null){
			options = new HashMap<String,Object>();
		}
	}
	//the way to implement this is with withLineItemList().withShippingGroupList().
}
