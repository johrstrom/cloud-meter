package org.cloudmeter.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;


import org.junit.Assert;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.stereotype.Component;

@Component
public class TestUtilities {
	
	
	@Autowired
	private TestRestTemplate restTemplate;
    
    private String testElementTarget = "http://localhost" +  TEST_ELEMENT_API;
    private static final String TEST_ELEMENT_API = "/api/v1/testelement";
   
    
    public void setPort(int port) {
    	this.testElementTarget = "http://localhost:" + port + TEST_ELEMENT_API;
    }
	
	public JSONObject readObjectFromFile(String filename) {
		
		try {
            InputStream is = new FileInputStream(filename);
            String jsonString = IOUtils.toString(is);
            return new JSONObject(jsonString);
			
		} catch (IOException e) {
			Assert.fail(String.format("Couldn't read file because of %s with message %s", e.getClass().getName(), e.getMessage()));
			return null;
		}
		
	}
	
	
	public void validateFileAgainstAPI(String type, String file) {
		
		JSONObject expectedJson = this.readObjectFromFile(file);
		String actualString = restTemplate.getForObject(testElementTarget + "?type=" + type, String.class);
		Assert.assertTrue(actualString != null);
		JSONObject actualJson = new JSONObject(actualString);
		
		JSONAssert.assertEquals(expectedJson, actualJson, true);	
	}
	
	

}
