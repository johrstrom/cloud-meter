package org.apache.jmeter.protocol.http.model;

import org.apache.jmeter.protocol.http.sampler.AccessLogSampler;
import org.apache.jmeter.protocol.http.util.accesslog.TCLogParser;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitializer;

public class AccessLogSamplerInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		AccessLogSampler ele = new AccessLogSampler();
		this.baseElement(ele, "Access Log Sampler");
		
		ele.setDomain(EMPTY_STRING);
		ele.setImageParser(false);
		ele.setImageParsing(false);
		ele.setLogFile(EMPTY_STRING);
		ele.setParserClassName(TCLogParser.class.getName());
		ele.setPort(80);
		ele.setFilterClassName(EMPTY_STRING);
		
		
		return ele;
	}

}
