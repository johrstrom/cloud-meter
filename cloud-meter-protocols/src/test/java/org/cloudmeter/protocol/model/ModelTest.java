package org.cloudmeter.protocol.model;

import org.apache.jmeter.protocol.model.HTTPSamplerInitializer;
import org.apache.jmeter.testelement.TestElement;
import org.junit.Assert;
import org.junit.Test;

public class ModelTest {

	
	
	@Test
	public void testHTTPSamplerIniter() {
		HTTPSamplerInitializer initer = new HTTPSamplerInitializer();
		TestElement ele = initer.initilizeElement();
		
		Assert.assertTrue(ele != null);
		
	}

}
