
package com.terapico.b2b.runrecord;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.b2b.runrecord.RunRecord;

import com.terapico.b2b.device.Device;


public class RunRecordSerializer extends JsonSerializer<RunRecord>{



	@Override
	public void serialize(RunRecord runRecord, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		jgen.writeStartObject();
		
		jgen.writeStringField("id",runRecord.getId());
		writeDevice("device",runRecord,jgen,provider);
		jgen.writeStringField("runDuration",runRecord.getRunDuration());
		jgen.writeNumberField("version",runRecord.getVersion());
		
		jgen.writeEndObject();
	}
	
	protected void writeDevice(String fieldName, RunRecord runRecord, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Device device = runRecord.getDevice();
		if(device == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField("id",device.getId()); 
		jgen.writeStringField("passwrd",device.getPasswrd()); 
		jgen.writeNumberField("version",device.getVersion());
		jgen.writeEndObject();
		
	}
	
	
}


