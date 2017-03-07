package org.apache.jmeter.json.serializers;

import static org.apache.jmeter.json.serializers.SerializerConstants.TYPE;
import static org.apache.jmeter.json.serializers.SerializerConstants.VALUE;

import java.io.IOException;

import org.apache.jmeter.testelement.property.StringProperty;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class StringPropertySerializer extends JsonSerializer<StringProperty>{


	@Override
	public void serialize(StringProperty prop, JsonGenerator jsonGen, SerializerProvider serialProvider)
			throws IOException, JsonProcessingException {
		
		jsonGen.writeStartObject();
		
		jsonGen.writeStringField(TYPE, StringProperty.class.getName());
		jsonGen.writeStringField(VALUE, prop.getStringValue());
		
		jsonGen.writeEndObject();
		
	}

}
