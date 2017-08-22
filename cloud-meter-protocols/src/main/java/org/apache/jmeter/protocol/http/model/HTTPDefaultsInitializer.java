package org.apache.jmeter.protocol.http.model;

import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.config.model.ArgumentsInitializer;
import org.apache.jmeter.protocol.http.sampler.HTTPSampler;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.property.TestElementProperty;
import org.cloudmeter.model.AbstractInitializer;

public class HTTPDefaultsInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		ConfigTestElement ele = new ConfigTestElement();
		this.baseElement(ele, "HTTP Request Defaults");
		ArgumentsInitializer argsIniter = new ArgumentsInitializer();
		
		ele.setProperty(HTTPSampler.CONCURRENT_POOL, "6");
		ele.setProperty(HTTPSampler.CONNECT_TIMEOUT, EMPTY_STRING);
		ele.setProperty(HTTPSampler.CONTENT_ENCODING, EMPTY_STRING);
		ele.setProperty(HTTPSampler.DOMAIN, EMPTY_STRING);
		ele.setProperty(HTTPSampler.PATH, EMPTY_STRING);
		ele.setProperty(HTTPSampler.PORT, EMPTY_STRING);
		ele.setProperty(HTTPSampler.PROTOCOL, EMPTY_STRING);
		ele.setProperty(HTTPSampler.RESPONSE_TIMEOUT, EMPTY_STRING);
		
	
		TestElementProperty argProp = new TestElementProperty(HTTPSampler.ARGUMENTS, argsIniter.initilizeElement());
		ele.setProperty(argProp);
		
		return ele;
	}

}
