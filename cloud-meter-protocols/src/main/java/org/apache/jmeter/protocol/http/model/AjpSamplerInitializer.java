package org.apache.jmeter.protocol.http.model;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.config.model.ArgumentsInitializer;
import org.apache.jmeter.protocol.http.sampler.AjpSampler;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerBase;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitializer;

public class AjpSamplerInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		AjpSampler ele = new AjpSampler();
		this.baseElement(ele, "AJP/1.3 Sampler");
		
		ArgumentsInitializer initer = new ArgumentsInitializer();
		ele.setArguments((Arguments) initer.initilizeElement());
		
		ele.setFollowRedirects(true);
		ele.setMethod(HTTPSamplerBase.GET);
		ele.setDoMultipartPost(false);
		ele.setContentEncoding(EMPTY_STRING);
		ele.setDomain(EMPTY_STRING);
		ele.setEmbeddedUrlRE(EMPTY_STRING);
		ele.setPath(EMPTY_STRING);
		ele.setAutoRedirects(false);
		ele.setFollowRedirects(true);
		ele.setUseKeepAlive(true);
		ele.setPort(80);
		ele.setProtocol(EMPTY_STRING);
		
		return ele;
	}

}
