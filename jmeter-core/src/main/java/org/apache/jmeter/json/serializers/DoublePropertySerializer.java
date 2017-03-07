package org.apache.jmeter.json.serializers;

import static org.apache.jmeter.json.serializers.SerializerConstants.TYPE;
import static org.apache.jmeter.json.serializers.SerializerConstants.VALUE;

import java.io.IOException;

import org.apache.jmeter.testelement.property.DoubleProperty;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DoublePropertySerializer  extends JsonSerializer<DoubleProperty>{

	@Override
	public void serialize(DoubleProperty prop, JsonGenerator jsonGen, SerializerProvider serialProvider)
			throws IOException, JsonProcessingException {
		
		jsonGen.writeStartObject();
		jsonGen.writeStringField(TYPE, DoubleProperty.class.getName());
		jsonGen.writeNumberField(VALUE, prop.getDoubleValue());
		jsonGen.writeEndObject();
		
	}

}
