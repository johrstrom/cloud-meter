package org.apache.jmeter.protocol.http.model;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.config.model.ArgumentsInitializer;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitializer;

public class HTTPSamplerInitializer extends AbstractInitializer {
	
	public static final String DEFAULT_NAME = "HTTP Request";
	
	private static final String EMPTY_STRING = "";

	@Override
	public TestElement initilizeElement() {
		HTTPSamplerProxy ele = new HTTPSamplerProxy();
		this.baseElement(ele, DEFAULT_NAME);
		
		ArgumentsInitializer initer = new ArgumentsInitializer();
		ele.setArguments((Arguments) initer.initilizeElement());
		
		ele.setProperty(HTTPSamplerProxy.DOMAIN, EMPTY_STRING);
		ele.setProperty(HTTPSamplerProxy.PORT, EMPTY_STRING);
		ele.setProperty(HTTPSamplerProxy.PROTOCOL, EMPTY_STRING);
		ele.setProperty(HTTPSamplerProxy.CONTENT_ENCODING, EMPTY_STRING);
		ele.setProperty(HTTPSamplerProxy.PATH, EMPTY_STRING);
		ele.setProperty(HTTPSamplerProxy.METHOD, EMPTY_STRING);
		ele.setProperty(HTTPSamplerProxy.FOLLOW_REDIRECTS, true);
		ele.setProperty(HTTPSamplerProxy.AUTO_REDIRECTS, false);
		ele.setProperty(HTTPSamplerProxy.USE_KEEPALIVE, true);
		ele.setProperty(HTTPSamplerProxy.DO_MULTIPART_POST, false);
		ele.setProperty(HTTPSamplerProxy.EMBEDDED_URL_RE, EMPTY_STRING);
		ele.setProperty(HTTPSamplerProxy.CONNECT_TIMEOUT, EMPTY_STRING);
		ele.setProperty(HTTPSamplerProxy.RESPONSE_TIMEOUT, EMPTY_STRING);
		ele.setProperty(HTTPSamplerProxy.METHOD , HTTPSamplerProxy.DEFAULT_METHOD);
		
		return ele;
		
	}
	

}
