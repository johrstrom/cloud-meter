package org.apache.jmeter.json.serializers;

import static org.apache.jmeter.json.serializers.SerializerConstants.*;

import java.io.IOException;

import org.apache.jmeter.testelement.property.AbstractProperty;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class PropertySerializer extends JsonSerializer<AbstractProperty> {

	@Override
	public void serialize(AbstractProperty prop, JsonGenerator jsonGen, SerializerProvider serialArg) throws IOException{
		
		
		jsonGen.writeStringField(NAME, prop.getName());
		jsonGen.writeStringField(TYPE, prop.getClass().getSimpleName());
		
		
	}

}
