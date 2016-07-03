
package com.terapico.b2b.device;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.b2b.device.Device;

import com.terapico.b2b.runrecord.RunRecord;


public class DeviceSerializer extends JsonSerializer<Device>{



	@Override
	public void serialize(Device device, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		jgen.writeStartObject();
		
		jgen.writeStringField("id",device.getId());
		jgen.writeStringField("passwrd",device.getPasswrd());
		jgen.writeNumberField("version",device.getVersion());
		writeRunRecordList("runRecordList",device,jgen,provider);
		
		jgen.writeEndObject();
	}
	
	protected void writeRunRecordList(String fieldName, Device device, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<RunRecord> runRecordList = device.getRunRecordList();
		
		if(runRecordList == null){
			return;//do nothing when null found for this field.
		}
		if(runRecordList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(RunRecord runRecord: runRecordList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField("id",runRecord.getId());
			jgen.writeStringField("runDuration",runRecord.getRunDuration());
			jgen.writeNumberField("version",runRecord.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


