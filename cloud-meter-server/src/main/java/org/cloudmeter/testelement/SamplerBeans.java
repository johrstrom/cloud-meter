package org.cloudmeter.testelement;

import org.apache.jmeter.protocol.http.sampler.*;
import org.apache.jmeter.protocol.http.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SamplerBeans {

	@Bean
	public HTTPSamplerInitializer HTTPSamplerInitializer() {
		return new HTTPSamplerInitializer();
	}
	
	@Bean
	@Autowired
	public HTTPSamplerProxy HTTPSamplerProxy(HTTPSamplerInitializer initer) {
		return (HTTPSamplerProxy) initer.initilizeElement();
	}
	
	@Bean
	public AccessLogSamplerInitializer AccessLogSamplerInitializer() {
		return new AccessLogSamplerInitializer();
	}
	
	@Bean
	@Autowired
	public AccessLogSampler AccessLogSampler(AccessLogSamplerInitializer initer) {
		return (AccessLogSampler) initer.initilizeElement();
	}
	
}
