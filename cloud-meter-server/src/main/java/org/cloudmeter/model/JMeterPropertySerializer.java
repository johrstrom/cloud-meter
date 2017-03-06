package org.cloudmeter.model;

import java.io.IOException;

import org.apache.jmeter.testelement.property.JMeterProperty;
import org.apache.jorphan.collections.HashTree;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JMeterPropertySerializer extends JsonSerializer<JMeterProperty> {

	@Override
	public void serialize(JMeterProperty arg0, JsonGenerator arg1, SerializerProvider arg2)
			throws IOException, JsonProcessingException {
		
		
		
	}

}
