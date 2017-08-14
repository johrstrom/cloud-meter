package org.apache.jmeter.protocol.model;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.config.model.ArgumentsInitializer;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitialzer;

public class HTTPSamplerInitializer extends AbstractInitialzer {
	
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
	

//    <HTTPSamplerProxy guiclass="HttpTestSampleGui" testclass="HTTPSamplerProxy" testname="HTTP Request" enabled="true">
//    <elementProp name="HTTPsampler.Arguments" elementType="Arguments" guiclass="HTTPArgumentsPanel" testclass="Arguments" testname="User Defined Variables" enabled="true">
//      <collectionProp name="Arguments.arguments"/>
//    </elementProp>
//    <stringProp name="HTTPSampler.domain"></stringProp>
//    <stringProp name="HTTPSampler.port"></stringProp>
//    <stringProp name="HTTPSampler.protocol"></stringProp>
//    <stringProp name="HTTPSampler.contentEncoding"></stringProp>
//    <stringProp name="HTTPSampler.path"></stringProp>
//    <stringProp name="HTTPSampler.method">GET</stringProp>
//    <boolProp name="HTTPSampler.follow_redirects">true</boolProp>
//    <boolProp name="HTTPSampler.auto_redirects">false</boolProp>
//    <boolProp name="HTTPSampler.use_keepalive">true</boolProp>
//    <boolProp name="HTTPSampler.DO_MULTIPART_POST">false</boolProp>
//    <stringProp name="HTTPSampler.embedded_url_re"></stringProp>
//    <stringProp name="HTTPSampler.connect_timeout"></stringProp>
//    <stringProp name="HTTPSampler.response_timeout"></stringProp>
//  </HTTPSamplerProxy>


}
