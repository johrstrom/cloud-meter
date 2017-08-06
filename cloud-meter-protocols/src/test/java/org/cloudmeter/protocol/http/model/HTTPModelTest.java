package org.cloudmeter.protocol.http.model;

import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.protocol.test.ProtocolTestApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {ProtocolTestApp.class})
public class HTTPModelTest {
	
	@Autowired
	HTTPSamplerInitializer initer;
	
	@Test
	public void foo() {
		TestElement ele = initer.initilizeElement();
		
		
	}

}
