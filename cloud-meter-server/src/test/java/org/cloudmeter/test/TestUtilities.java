package org.cloudmeter.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;


import org.junit.Assert;

public class TestUtilities {
	
	
	public static JSONObject readObjectFromFile(String filename) {
		
		try {
            InputStream is = new FileInputStream(filename);
            String jsonString = IOUtils.toString(is);
            return new JSONObject(jsonString);
			
		} catch (IOException e) {
			Assert.fail(String.format("Couldn't read file because of %s with message %s", e.getClass().getName(), e.getMessage()));
			return null;
		}
		
	}
	
	

}
