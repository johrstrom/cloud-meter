package org.cloudmeter.service;

import org.cloudmeter.CloudMeterApp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.cloudmeter.test.TestUtilities;
import org.json.JSONObject;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CloudMeterApp.class})
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class NewElementTest {

    @LocalServerPort
    private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	
	private static final String FILE_BASE = "target/test-classes/testelements";
	private static final String SAMPLER_BASE = FILE_BASE + "/samplers/";
	
	private static final String TEST_ELEMENT_API = "/api/v1/testelement";
	private String target;
	
	@Before
	public void setup() {
		target = "http://localhost:" + port + TEST_ELEMENT_API;
	}
	
	@Test
	public void HTTPSamplerTest() {
		this.validateFileAgainstAPI("http-sampler", SAMPLER_BASE + "http.json");
	}
	
	
	
	private void validateFileAgainstAPI(String type, String file) {
		
		JSONObject expectedJson = TestUtilities.readObjectFromFile(file);
		String actualString = restTemplate.getForObject(target + "?type=" + type, String.class);
		JSONObject actualJson = new JSONObject(actualString);
		
		JSONAssert.assertEquals(expectedJson, actualJson, true);	
	}
	
	
}
