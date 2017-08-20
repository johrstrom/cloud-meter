package org.apache.jmeter.json.serializers;

import static org.apache.jmeter.json.serializers.SerializerConstants.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.jmeter.testelement.property.AbstractProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class PropertySerializer extends JsonSerializer<AbstractProperty> {
	
	private static final Logger log = LoggerFactory.getLogger(PropertySerializer.class);
	
	@Override
	public void serialize(AbstractProperty prop, JsonGenerator jsonGen, SerializerProvider serialArg) throws IOException{
		
		String propertyType = prop.getClass().getSimpleName();
		String writerFunctionName = "write" + propertyType;
		
		
		jsonGen.writeStartObject();
		jsonGen.writeStringField(TYPE, propertyType);
		
		try {
			Method writeMethod = PropertySerializer.class.getMethod(writerFunctionName, AbstractProperty.class, JsonGenerator.class);
			writeMethod.invoke(this,prop,jsonGen);
			
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException 
				| IllegalArgumentException | InvocationTargetException e) {
			log.error("problem during serialization of property. type:{}, messsage: {}, property: {}.", 
					e.getClass(), e.getMessage(), prop.toString());
		}
		
		jsonGen.writeEndObject();
		
	}
	
	public void writeBooleanProperty(AbstractProperty prop, JsonGenerator generator) throws IOException{
		generator.writeBooleanField(VALUE, prop.getBooleanValue());
	}
	
	public void writeCollectionProperty(AbstractProperty prop, JsonGenerator generator) throws IOException{
		//TODO
		generator.writeStringField(VALUE,"TODO");
	}
	
	public void writeDoubleProperty(AbstractProperty prop, JsonGenerator generator) throws IOException{
		generator.writeNumberField(VALUE, prop.getDoubleValue());		
	}
	
	public void writeFloatProperty(AbstractProperty prop, JsonGenerator generator) throws IOException{
		generator.writeNumberField(VALUE, prop.getFloatValue());		
	}
	
	public void writeFunctionProperty(AbstractProperty prop, JsonGenerator generator) throws IOException{
		//TODO
		generator.writeStringField(VALUE,"TODO");
	}
	
	public void writeIntegerProperty(AbstractProperty prop, JsonGenerator generator) throws IOException{
		generator.writeNumberField(VALUE, prop.getIntValue());		
	}
	
	public void writeLongProperty(AbstractProperty prop, JsonGenerator generator) throws IOException{
		generator.writeNumberField(VALUE, prop.getLongValue());
	}
	
	public void writeMapProperty(AbstractProperty prop, JsonGenerator generator) throws IOException{
		//TODO
		generator.writeStringField(VALUE,"TODO");
	}
	
	public void writeMultiProperty(AbstractProperty prop, JsonGenerator generator) throws IOException{
		//TODO
		generator.writeStringField(VALUE,"TODO");
	}
	
	public void writeNumberProperty(AbstractProperty prop, JsonGenerator generator) throws IOException{
		generator.writeNumberField(VALUE, prop.getDoubleValue());
	}
	
	public void writeNullProperty(AbstractProperty prop, JsonGenerator generator) throws IOException{
		//TODO
		generator.writeStringField(VALUE,"TODO");
	}
	
	public void writeObjectProperty(AbstractProperty prop, JsonGenerator generator) throws IOException{
		//TODO
		generator.writeStringField(VALUE,"TODO");
	}
	
	public void writeStringProperty(AbstractProperty prop, JsonGenerator generator) throws IOException{
		generator.writeStringField(VALUE, prop.getStringValue());
	}
	
	public void writeTestElementProperty(AbstractProperty prop, JsonGenerator generator) throws IOException{
		//TODO
		generator.writeStringField(VALUE,"TODO");
	}

	
	

}
