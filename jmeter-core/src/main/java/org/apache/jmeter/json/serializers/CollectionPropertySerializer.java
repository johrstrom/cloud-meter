package org.apache.jmeter.json.serializers;

import static org.apache.jmeter.json.serializers.SerializerConstants.TYPE;
import static org.apache.jmeter.json.serializers.SerializerConstants.VALUE;

import java.io.IOException;

import org.apache.jmeter.testelement.property.BooleanProperty;
import org.apache.jmeter.testelement.property.CollectionProperty;
import org.apache.jmeter.testelement.property.JMeterProperty;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CollectionPropertySerializer extends JsonSerializer<CollectionProperty> {

	@Override
	public void serialize(CollectionProperty prop, JsonGenerator jsonGen, SerializerProvider serialArg)
			throws IOException, JsonProcessingException {
		
		jsonGen.writeStartObject();
		jsonGen.writeStringField(TYPE, CollectionProperty.class.getName());
		jsonGen.writeArrayFieldStart(VALUE);
		
		for (int i = 0; i < prop.size(); i++){
			JMeterProperty loopProp = prop.get(i);
			jsonGen.writeStringField(loopProp.getName(), loopProp.getStringValue());
		}
		
		jsonGen.writeEndArray();	//array end
		jsonGen.writeEndObject();	//outer most class
		
	}

	
}
