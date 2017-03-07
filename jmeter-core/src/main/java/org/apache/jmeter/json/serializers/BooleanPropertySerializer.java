package org.apache.jmeter.json.serializers;

import static org.apache.jmeter.json.serializers.SerializerConstants.TYPE;
import static org.apache.jmeter.json.serializers.SerializerConstants.VALUE;

import java.io.IOException;

import org.apache.jmeter.testelement.property.BooleanProperty;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class BooleanPropertySerializer extends JsonSerializer<BooleanProperty>{

	@Override
	public void serialize(BooleanProperty prop, JsonGenerator jsonGen, SerializerProvider serialProvider)
			throws IOException, JsonProcessingException {
		
		jsonGen.writeStartObject();
		jsonGen.writeStringField(TYPE, BooleanProperty.class.getName());
		jsonGen.writeBooleanField(VALUE, prop.getBooleanValue());
		jsonGen.writeEndObject();
		
	}
	

}

