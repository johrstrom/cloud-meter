package org.cloudmeter.model;

import java.io.IOException;

import org.apache.jmeter.testelement.AbstractTestElement;
import org.apache.jmeter.testelement.property.JMeterProperty;
import org.apache.jmeter.testelement.property.PropertyIterator;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class TestElementSerializer extends JsonSerializer<AbstractTestElement>  {

	public TestElementSerializer() { }
	
	@Override
	public void serialize(AbstractTestElement element, JsonGenerator generator, SerializerProvider serializer)
			throws IOException, JsonProcessingException {
		
		generator.writeStartObject();
		generator.writeBooleanField("enabled", element.isEnabled());

		generator.writeObjectFieldStart("properties");
		
		PropertyIterator iter = element.propertyIterator();
		while(iter.hasNext()) {
			JMeterProperty prop = iter.next();
			generator.writeObject(prop);
		}
		
		generator.writeEndObject();	//properties
		generator.writeEndObject();	//test element
		
	}
	
}
