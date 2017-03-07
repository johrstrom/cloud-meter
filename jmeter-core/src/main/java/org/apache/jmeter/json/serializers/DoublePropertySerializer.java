package org.apache.jmeter.json.serializers;

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
		jsonGen.writeNumber(prop.getDoubleValue());
		jsonGen.writeEndObject();
		
	}

}
