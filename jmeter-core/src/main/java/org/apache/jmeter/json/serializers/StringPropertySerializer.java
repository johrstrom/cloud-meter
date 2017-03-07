package org.apache.jmeter.json.serializers;

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
		
//		jsonGen.writeObjectFieldStart("stringProp");
//		jsonGen.write
		jsonGen.writeStartObject();
		
//		jsonGen.writeStringField("name", prop.getName());
		jsonGen.writeStringField("value", prop.getStringValue());
		
		jsonGen.writeEndObject();
		
	}

}
