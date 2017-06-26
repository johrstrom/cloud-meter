package org.cloudmeter.model;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.apache.jmeter.save.SaveService;
import org.apache.jorphan.collections.HashTree;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

public class HashTreeSerializerTest {

	private HashTree simpleTestPlan;
	private Writer jsonWriter;
	JsonGenerator jsonGenerator;
	SerializerProvider serializerProvider;
	
	@Before
	public void setup() throws IOException {
		File simpleTestPlanFile = new File("src/test/resources/cm-test-simple.jmx");
		simpleTestPlan = SaveService.loadTree(simpleTestPlanFile);
		
		jsonWriter = new StringWriter();
		jsonGenerator = new JsonFactory().createGenerator(jsonWriter);
		serializerProvider = new ObjectMapper().getSerializerProvider();
		
	}
	
	@Test
	public void testSerializeSimpleTestPlan() throws IOException {
		
		new HashTreeSerializer().serialize(simpleTestPlan, jsonGenerator, serializerProvider);
		
		jsonGenerator.flush();
		System.out.println(jsonWriter.toString());
		System.out.flush();
		
	}
	
	
}
